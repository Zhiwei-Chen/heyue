<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="物料编码" prop="materialId">
        <el-input
          v-model="queryParams.materialId"
          placeholder="请输入物料编码"
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
          v-hasPermi="['wms:check:add']"
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
          v-hasPermi="['wms:check:edit']"
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
          v-hasPermi="['wms:check:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['wms:check:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="checkList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="物料编码" align="center" prop="id" />
      <el-table-column label="物料编码" align="center" prop="materialId" />
      <el-table-column label="数量" align="center" prop="number" />
      <el-table-column label="仓库" align="center" prop="warehouseId" />
      <el-table-column label="区域" align="center" prop="areaId" />
      <el-table-column label="货架" align="center" prop="shelvesId" />
      <el-table-column label="货位" align="center" prop="locationId" />
      <el-table-column label="实际数量" align="center" prop="actNumber" />
      <el-table-column label="核验状态" align="center" prop="checkStatus" :formatter="checkStatusFormat" />
      <el-table-column label="核对结果" align="center" prop="result" :formatter="resultFormat" />
      <el-table-column label="入库单" align="center" prop="inOrderId" />
      <el-table-column label="出库单" align="center" prop="outOrderId" />
      <el-table-column label="核验人" align="center" prop="userId" />
      <el-table-column label="核验时间" align="center" prop="checkTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.checkTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['wms:check:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['wms:check:remove']"
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

    <!-- 添加或修改库存盘点对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="650px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="物料编码" prop="materialId">
          <el-input v-model="form.materialId" placeholder="请输入物料编码" />
        </el-form-item>
        <el-form-item label="数量" prop="number">
          <el-input v-model="form.number" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="仓库" prop="warehouseId">
          <el-input v-model="form.warehouseId" placeholder="请输入仓库" />
        </el-form-item>
        <el-form-item label="区域" prop="areaId">
          <el-input v-model="form.areaId" placeholder="请输入区域" />
        </el-form-item>
        <el-form-item label="货架" prop="shelvesId">
          <el-input v-model="form.shelvesId" placeholder="请输入货架" />
        </el-form-item>
        <el-form-item label="货位" prop="locationId">
          <el-input v-model="form.locationId" placeholder="请输入货位" />
        </el-form-item>
        <el-form-item label="实际数量" prop="actNumber">
          <el-input v-model="form.actNumber" placeholder="请输入实际数量" />
        </el-form-item>
        <el-form-item label="核验状态" prop="checkStatus">
          <el-select v-model="form.checkStatus" placeholder="请选择核验状态">
            <el-option
              v-for="dict in checkStatusOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="核对结果" prop="result">
          <el-select v-model="form.result" placeholder="请选择核对结果">
            <el-option
              v-for="dict in resultOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="入库单" prop="inOrderId">
          <el-input v-model="form.inOrderId" placeholder="请输入入库单" />
        </el-form-item>
        <el-form-item label="出库单" prop="outOrderId">
          <el-input v-model="form.outOrderId" placeholder="请输入出库单" />
        </el-form-item>
        <el-form-item label="核验人" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入核验人" />
        </el-form-item>
        <el-form-item label="核验时间" prop="checkTime">
          <el-date-picker clearable size="small"
                          v-model="form.checkTime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择核验时间">
          </el-date-picker>
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
  import { listCheck, getCheck, delCheck, addCheck, updateCheck } from "@/api/wms/check";

  export default {
    name: "Check",
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
        // 库存盘点表格数据
        checkList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 核验状态字典
        checkStatusOptions: [],
        // 核对结果字典
        resultOptions: [],
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
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
      this.getList();
      this.getDicts("check_status").then(response => {
        this.checkStatusOptions = response.data;
      });
      this.getDicts("check_result").then(response => {
        this.resultOptions = response.data;
      });
    },
    methods: {
      /** 查询库存盘点列表 */
      getList() {
        this.loading = true;
        listCheck(this.queryParams).then(response => {
          this.checkList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      // 核验状态字典翻译
      checkStatusFormat(row, column) {
        return this.selectDictLabel(this.checkStatusOptions, row.checkStatus);
      },
      // 核对结果字典翻译
      resultFormat(row, column) {
        return this.selectDictLabel(this.resultOptions, row.result);
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
          materialId: null,
          number: null,
          warehouseId: null,
          areaId: null,
          shelvesId: null,
          locationId: null,
          actNumber: null,
          checkStatus: null,
          result: null,
          inOrderId: null,
          outOrderId: null,
          userId: null,
          checkTime: null
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
        this.title = "添加库存盘点";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const id = row.id || this.ids
        getCheck(id).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改库存盘点";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.id != null) {
              updateCheck(this.form).then(response => {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addCheck(this.form).then(response => {
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
        this.$confirm('是否确认删除库存盘点编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delCheck(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('wms/check/export', {
          ...this.queryParams
        }, `wms_check.xlsx`)
      }
    }
  };
</script>
