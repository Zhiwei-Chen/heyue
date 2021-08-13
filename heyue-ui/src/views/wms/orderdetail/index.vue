<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="订单编号" prop="userOrderId">
        <el-input
          v-model="queryParams.userOrderId"
          placeholder="请输入订单编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="同行单编号" prop="tmsOrderId">
        <el-input
          v-model="queryParams.tmsOrderId"
          placeholder="请输入同行单编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物料编号" prop="materialId">
        <el-input
          v-model="queryParams.materialId"
          placeholder="请输入物料编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['wms:orderdetail:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['wms:orderdetail:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['wms:orderdetail:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['wms:orderdetail:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="orderdetailList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="精确编码" align="center" prop="id" />
      <el-table-column label="订单编号" align="center" prop="userOrderId" />
      <el-table-column label="同行单编号" align="center" prop="tmsOrderId" />
      <el-table-column label="物料编号" align="center" prop="materialId" />
      <el-table-column label="物料名称" align="center" prop="materialName" />
      <el-table-column label="阳采编码" align="center" prop="yangcaiCode" />
      <el-table-column label="69码" align="center" prop="code69" />
      <el-table-column label="品名" align="center" prop="productName" />
      <el-table-column label="规格" align="center" prop="specs" />
      <el-table-column label="生产厂商" align="center" prop="manufacturer" />
      <el-table-column label="数量" align="center" prop="number" />
      <el-table-column label="单位" align="center" prop="unit" />
      <el-table-column label="单价" align="center" prop="unitPrice" />
      <el-table-column label="批号" align="center" prop="batchNumber" />
      <el-table-column label="生产日期" align="center" prop="manufactureDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.manufactureDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="有效期" align="center" prop="validityDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.validityDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="件数" align="center" prop="packagesNumber" />
      <el-table-column label="注册证号" align="center" prop="registCertificateNo" />
      <el-table-column label="运输方式" align="center" prop="transportType" :formatter="transportTypeFormat" />
      <el-table-column label="冷藏箱数量" align="center" prop="boxNumber" />
      <el-table-column label="仓储方式" align="center" prop="storageType" :formatter="storageTypeFormat" />
      <el-table-column label="物料分类名称" align="center" prop="materialClassName" />
      <el-table-column label="相关质量文件" align="center" prop="qualityFiles" />
      <el-table-column label="同行单子单编号" align="center" prop="tmsOrderDetailId" />
      <el-table-column label="配送状态" align="center" prop="tmsState" :formatter="tmsStateFormat" />
      <el-table-column label="入库状态" align="center" prop="wmsState" :formatter="wmsStateFormat" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="二维码" align="center" prop="qrcode" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['wms:orderdetail:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['wms:orderdetail:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改用户订单详情：（最小单位）对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="650px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="订单编号" prop="userOrderId">
          <el-input v-model="form.userOrderId" placeholder="请输入订单编号" />
        </el-form-item>
        <el-form-item label="同行单编号" prop="tmsOrderId">
          <el-input v-model="form.tmsOrderId" placeholder="请输入同行单编号" />
        </el-form-item>
        <el-form-item label="物料编号" prop="materialId">
          <el-input v-model="form.materialId" placeholder="请输入物料编号" />
        </el-form-item>
        <el-form-item label="物料名称" prop="materialName">
          <el-input v-model="form.materialName" placeholder="请输入物料名称" />
        </el-form-item>
        <el-form-item label="阳采编码" prop="yangcaiCode">
          <el-input v-model="form.yangcaiCode" placeholder="请输入阳采编码" />
        </el-form-item>
        <el-form-item label="69码" prop="code69">
          <el-input v-model="form.code69" placeholder="请输入69码" />
        </el-form-item>
        <el-form-item label="品名" prop="productName">
          <el-input v-model="form.productName" placeholder="请输入品名" />
        </el-form-item>
        <el-form-item label="规格" prop="specs">
          <el-input v-model="form.specs" placeholder="请输入规格" />
        </el-form-item>
        <el-form-item label="生产厂商" prop="manufacturer">
          <el-input v-model="form.manufacturer" placeholder="请输入生产厂商" />
        </el-form-item>
        <el-form-item label="数量" prop="number">
          <el-input v-model="form.number" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="单位" prop="unit">
          <el-input v-model="form.unit" placeholder="请输入单位" />
        </el-form-item>
        <el-form-item label="单价" prop="unitPrice">
          <el-input v-model="form.unitPrice" placeholder="请输入单价" />
        </el-form-item>
        <el-form-item label="批号" prop="batchNumber">
          <el-input v-model="form.batchNumber" placeholder="请输入批号" />
        </el-form-item>
        <el-form-item label="生产日期" prop="manufactureDate">
          <el-date-picker clearable size="small"
                          v-model="form.manufactureDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择生产日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="有效期" prop="validityDate">
          <el-date-picker clearable size="small"
                          v-model="form.validityDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择有效期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="件数" prop="packagesNumber">
          <el-input v-model="form.packagesNumber" placeholder="请输入件数" />
        </el-form-item>
        <el-form-item label="注册证号" prop="registCertificateNo">
          <el-input v-model="form.registCertificateNo" placeholder="请输入注册证号" />
        </el-form-item>
        <el-form-item label="运输方式" prop="transportType">
          <el-select v-model="form.transportType" placeholder="请选择运输方式">
            <el-option
              v-for="dict in transportTypeOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="冷藏箱数量" prop="boxNumber">
          <el-input v-model="form.boxNumber" placeholder="请输入冷藏箱数量" />
        </el-form-item>
        <el-form-item label="仓储方式" prop="storageType">
          <el-select v-model="form.storageType" placeholder="请选择仓储方式">
            <el-option
              v-for="dict in storageTypeOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="物料分类名称" prop="materialClassName">
          <el-input v-model="form.materialClassName" placeholder="请输入物料分类名称" />
        </el-form-item>
        <el-form-item label="同行单子单编号" prop="tmsOrderDetailId">
          <el-input v-model="form.tmsOrderDetailId" placeholder="请输入同行单子单编号" />
        </el-form-item>
        <el-form-item label="配送状态" prop="tmsState">
          <el-select v-model="form.tmsState" placeholder="请选择配送状态">
            <el-option
              v-for="dict in tmsStateOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="入库状态" prop="wmsState">
          <el-select v-model="form.wmsState" placeholder="请选择入库状态">
            <el-option
              v-for="dict in wmsStateOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="parseInt(dict.dictValue)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="二维码" prop="qrcode">
          <el-input v-model="form.qrcode" placeholder="请输入二维码" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import { listOrderdetail, getOrderdetail, delOrderdetail, addOrderdetail, updateOrderdetail } from "@/api/wms/orderdetail";

  export default {
    name: "Orderdetail",
    components: {
    },
    data() {
      return {
        // 遮罩层
        loading: true,
        // 选中数组
        ids: [],
        // 非单个禁用
        single: true,
        // 非多个禁用
        multiple: true,
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 用户订单详情：（最小单位）表格数据
        orderdetailList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 运输方式字典
        transportTypeOptions: [],
        // 仓储方式字典
        storageTypeOptions: [],
        // 配送状态字典
        tmsStateOptions: [],
        // 入库状态字典
        wmsStateOptions: [],
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          userOrderId: null,
          tmsOrderId: null,
          materialId: null,
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {
        }
      };
    },
    created() {
      const SensorCode = this.$route.params && this.$route.params.code;
      this.queryParams.sensorCode=SensorCode;
      console.log(SensorCode);
      this.getList();
      this.getDicts("tms_material_transport_type").then(response => {
        this.transportTypeOptions = response.data;
      });
      this.getDicts("tms_material_storage_type").then(response => {
        this.storageTypeOptions = response.data;
      });
      this.getDicts("tms_order_tms_state").then(response => {
        this.tmsStateOptions = response.data;
      });
      this.getDicts("wms_state").then(response => {
        this.wmsStateOptions = response.data;
      });
    },
    methods: {
      /** 查询用户订单详情：（最小单位）列表 */
      getList() {
        this.loading = true;
        listOrderdetail(this.queryParams).then(response => {
          this.orderdetailList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      // 运输方式字典翻译
      transportTypeFormat(row, column) {
        return this.selectDictLabel(this.transportTypeOptions, row.transportType);
      },
      // 仓储方式字典翻译
      storageTypeFormat(row, column) {
        return this.selectDictLabel(this.storageTypeOptions, row.storageType);
      },
      // 配送状态字典翻译
      tmsStateFormat(row, column) {
        return this.selectDictLabel(this.tmsStateOptions, row.tmsState);
      },
      // 入库状态字典翻译
      wmsStateFormat(row, column) {
        return this.selectDictLabel(this.wmsStateOptions, row.wmsState);
      },
      // 取消按钮
      cancel() {
        this.open = false;
        this.reset();
      },
      // 表单重置
      reset() {
        this.form = {
          id: null,
          userOrderId: null,
          tmsOrderId: null,
          materialId: null,
          materialName: null,
          yangcaiCode: null,
          code69: null,
          productName: null,
          specs: null,
          manufacturer: null,
          number: null,
          unit: null,
          unitPrice: null,
          batchNumber: null,
          manufactureDate: null,
          validityDate: null,
          packagesNumber: null,
          registCertificateNo: null,
          transportType: null,
          boxNumber: null,
          storageType: null,
          materialClassName: null,
          qualityFiles: null,
          tmsOrderDetailId: null,
          tmsState: null,
          wmsState: null,
          remark: null,
          qrcode: null
        };
        this.resetForm("form");
      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.pageNum = 1;
        this.getList();
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.resetForm("queryForm");
        this.handleQuery();
      },
      // 多选框选中数据
      handleSelectionChange(selection) {
        this.ids = selection.map(item => item.id)
        this.single = selection.length!==1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加用户订单详情：（最小单位）";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const id = row.id || this.ids
        getOrderdetail(id).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改用户订单详情：（最小单位）";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.id != null) {
              updateOrderdetail(this.form).then(response => {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addOrderdetail(this.form).then(response => {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            }
          }
        });
      },
      /** 删除按钮操作 */
      handleDelete(row) {
        const ids = row.id || this.ids;
        this.$confirm('是否确认删除用户订单详情：（最小单位）编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delOrderdetail(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('wms/orderdetail/export', {
          ...this.queryParams
        }, `wms_orderdetail.xlsx`)
      }
    }
  };
</script>
