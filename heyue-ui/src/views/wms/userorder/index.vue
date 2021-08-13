<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="编号" prop="code">
        <el-input
          v-model="queryParams.code"
          placeholder="请输入编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable size="small">
          <el-option
            v-for="dict in statusOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="预约取货时间" prop="bookingPickupTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.bookingPickupTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择预约取货时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="支付类型" prop="paymentClass">
        <el-select v-model="queryParams.paymentClass" placeholder="请选择支付类型" clearable size="small">
          <el-option
            v-for="dict in paymentClassOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="配送方式" prop="tmsType">
        <el-select v-model="queryParams.tmsType" placeholder="请选择配送方式" clearable size="small">
          <el-option
            v-for="dict in tmsTypeOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
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
          v-hasPermi="['wms:userorder:add']"
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
          v-hasPermi="['wms:userorder:edit']"
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
          v-hasPermi="['wms:userorder:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['wms:userorder:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="userorderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="编号" align="center" prop="code" >
        <template slot-scope="scope">
          <router-link :to="'/wms/orderdetail/index' + scope.row.code" class="link-type">
            <span>{{ scope.row.code }}</span>
          </router-link>
        </template>
      </el-table-column>
      <el-table-column label="类型" align="center" prop="type" :formatter="typeFormat" />
      <el-table-column label="状态" align="center" prop="status" :formatter="statusFormat" />
      <el-table-column label="总金额" align="center" prop="allPrice" />
      <el-table-column label="支付金额" align="center" prop="allPayPrice" />
      <el-table-column label="更新人" align="center" prop="updateBy" />
      <el-table-column label="下单时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="更新时间" align="center" prop="updateTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="预约取货时间" align="center" prop="bookingPickupTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.bookingPickupTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="下单客户编号" align="center" prop="userId" />
      <el-table-column label="下单客户姓名" align="center" prop="userName" />
      <el-table-column label="下单客户电话" align="center" prop="userPhone" />
      <el-table-column label="货主" align="center" prop="sendUserId" />
      <el-table-column label="发货公司编号" align="center" prop="sendCompanyId" />
      <el-table-column label="发货公司名称" align="center" prop="sendCompanyName" />
      <el-table-column label="发货联系人地址" align="center" prop="sendAddress" />
      <el-table-column label="收货公司编号" align="center" prop="customerCompanyId" />
      <el-table-column label="收货人编号" align="center" prop="customerUserId" />
      <el-table-column label="收货人公司名称" align="center" prop="customerCompanyName" />
      <el-table-column label="收货人地址" align="center" prop="customerAddress" />
      <el-table-column label="司机编号" align="center" prop="driverId" />
      <el-table-column label="司机电话" align="center" prop="driverPhone" />
      <el-table-column label="司机姓名" align="center" prop="driverName" />
      <el-table-column label="车辆编号" align="center" prop="vanId" />
      <el-table-column label="车辆车牌号" align="center" prop="vanNumber" />
      <el-table-column label="支付详情编号" align="center" prop="paymentId" />
      <el-table-column label="支付状态" align="center" prop="paymentState" :formatter="paymentStateFormat" />
      <el-table-column label="支付类型" align="center" prop="paymentClass" :formatter="paymentClassFormat" />
      <el-table-column label="支付完成时间" align="center" prop="paymentTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.paymentTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="仓储价格" align="center" prop="wmsPrice" />
      <el-table-column label="仓储成本" align="center" prop="wmsCost" />
      <el-table-column label="仓储方式" align="center" prop="wmsType" :formatter="wmsTypeFormat" />
      <el-table-column label="承运总价格" align="center" prop="tmsPrice" />
      <el-table-column label="承运总成本" align="center" prop="tmsCost" />
      <el-table-column label="配送方式" align="center" prop="tmsType" :formatter="tmsTypeFormat" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="二维码编码" align="center" prop="qrcode" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['wms:userorder:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['wms:userorder:remove']"
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

    <!-- 添加或修改用户订单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="650px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="编号" prop="code">
          <el-input v-model="form.code" placeholder="请输入编号" />
        </el-form-item>
        <el-form-item label="类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择类型">
            <el-option
              v-for="dict in typeOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择状态">
            <el-option
              v-for="dict in statusOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="总金额" prop="allPrice">
          <el-input v-model="form.allPrice" placeholder="请输入总金额" />
        </el-form-item>
        <el-form-item label="支付金额" prop="allPayPrice">
          <el-input v-model="form.allPayPrice" placeholder="请输入支付金额" />
        </el-form-item>
        <el-form-item label="预约取货时间" prop="bookingPickupTime">
          <el-date-picker clearable size="small"
            v-model="form.bookingPickupTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择预约取货时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="下单客户编号" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入下单客户编号" />
        </el-form-item>
        <el-form-item label="下单客户姓名" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入下单客户姓名" />
        </el-form-item>
        <el-form-item label="下单客户电话" prop="userPhone">
          <el-input v-model="form.userPhone" placeholder="请输入下单客户电话" />
        </el-form-item>
        <el-form-item label="货主" prop="sendUserId">
          <el-input v-model="form.sendUserId" placeholder="请输入货主" />
        </el-form-item>
        <el-form-item label="发货公司编号" prop="sendCompanyId">
          <el-input v-model="form.sendCompanyId" placeholder="请输入发货公司编号" />
        </el-form-item>
        <el-form-item label="发货公司名称" prop="sendCompanyName">
          <el-input v-model="form.sendCompanyName" placeholder="请输入发货公司名称" />
        </el-form-item>
        <el-form-item label="发货联系人地址" prop="sendAddress">
          <el-input v-model="form.sendAddress" placeholder="请输入发货联系人地址" />
        </el-form-item>
        <el-form-item label="收货公司编号" prop="customerCompanyId">
          <el-input v-model="form.customerCompanyId" placeholder="请输入收货公司编号" />
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
import { listUserorder, getUserorder, delUserorder, addUserorder, updateUserorder } from "@/api/wms/userorder";

export default {
  name: "Userorder",
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
      // 用户订单表格数据
      userorderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 类型字典
      typeOptions: [],
      // 状态字典
      statusOptions: [],
      // 支付状态字典
      paymentStateOptions: [],
      // 支付类型字典
      paymentClassOptions: [],
      // 仓储方式字典
      wmsTypeOptions: [],
      // 配送方式字典
      tmsTypeOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        code: null,
        status: null,
        bookingPickupTime: null,
        paymentClass: null,
        tmsType: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        code: [
          { required: true, message: "编号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.getDicts("user_order_type").then(response => {
      this.typeOptions = response.data;
    });
    this.getDicts("user_order_status").then(response => {
      this.statusOptions = response.data;
    });
    this.getDicts("tms_order_payment_state").then(response => {
      this.paymentStateOptions = response.data;
    });
    this.getDicts("user_order_payment_class").then(response => {
      this.paymentClassOptions = response.data;
    });
    this.getDicts("tms_material_storage_type").then(response => {
      this.wmsTypeOptions = response.data;
    });
    this.getDicts("user_order_tms_type").then(response => {
      this.tmsTypeOptions = response.data;
    });
  },
  methods: {
    /** 查询用户订单列表 */
    getList() {
      this.loading = true;
      listUserorder(this.queryParams).then(response => {
        this.userorderList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 类型字典翻译
    typeFormat(row, column) {
      return this.selectDictLabel(this.typeOptions, row.type);
    },
    // 状态字典翻译
    statusFormat(row, column) {
      return this.selectDictLabel(this.statusOptions, row.status);
    },
    // 支付状态字典翻译
    paymentStateFormat(row, column) {
      return this.selectDictLabel(this.paymentStateOptions, row.paymentState);
    },
    // 支付类型字典翻译
    paymentClassFormat(row, column) {
      return this.selectDictLabel(this.paymentClassOptions, row.paymentClass);
    },
    // 仓储方式字典翻译
    wmsTypeFormat(row, column) {
      return this.selectDictLabel(this.wmsTypeOptions, row.wmsType);
    },
    // 配送方式字典翻译
    tmsTypeFormat(row, column) {
      return this.selectDictLabel(this.tmsTypeOptions, row.tmsType);
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
        code: null,
        type: null,
        status: null,
        allPrice: null,
        allPayPrice: null,
        updateBy: null,
        createTime: null,
        updateTime: null,
        bookingPickupTime: null,
        userId: null,
        userName: null,
        userPhone: null,
        sendUserId: null,
        sendCompanyId: null,
        sendCompanyName: null,
        sendAddress: null,
        customerCompanyId: null,
        customerUserId: null,
        customerCompanyName: null,
        customerAddress: null,
        driverId: null,
        driverPhone: null,
        driverName: null,
        vanId: null,
        vanNumber: null,
        paymentId: null,
        paymentState: null,
        paymentClass: null,
        paymentTime: null,
        wmsPrice: null,
        wmsCost: null,
        wmsType: null,
        tmsPrice: null,
        tmsCost: null,
        tmsType: null,
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
      this.title = "添加用户订单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getUserorder(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改用户订单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateUserorder(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addUserorder(this.form).then(response => {
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
      this.$confirm('是否确认删除用户订单编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delUserorder(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('wms/userorder/export', {
        ...this.queryParams
      }, `wms_userorder.xlsx`)
    }
  }
};
</script>
