<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="精确编码" prop="userOrderDetailId">
        <el-input
          v-model="queryParams.userOrderDetailId"
          placeholder="请输入精确编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入库单" prop="inOrderId">
        <el-input
          v-model="queryParams.inOrderId"
          placeholder="请输入入库单"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出库单" prop="outOrderId">
        <el-input
          v-model="queryParams.outOrderId"
          placeholder="请输入出库单"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="调拨单" prop="moveOrderId">
        <el-input
          v-model="queryParams.moveOrderId"
          placeholder="请输入调拨单"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="货主" prop="cargoOwnerUserId">
        <el-input
          v-model="queryParams.cargoOwnerUserId"
          placeholder="请输入货主"
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
          v-hasPermi="['wms:wmsorder:add']"
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
          v-hasPermi="['wms:wmsorder:edit']"
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
          v-hasPermi="['wms:wmsorder:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['wms:wmsorder:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="wmsorderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="精确编码" align="center" prop="userOrderDetailId" />
      <el-table-column label="入库单" align="center" prop="inOrderId" />
      <el-table-column label="出库单" align="center" prop="outOrderId" />
      <el-table-column label="调拨单" align="center" prop="moveOrderId" />
      <el-table-column label="货主" align="center" prop="cargoOwnerUserId" />
      <el-table-column label="仓储状态" align="center" prop="status" :formatter="statusFormat" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['wms:wmsorder:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['wms:wmsorder:remove']"
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

    <!-- 添加或修改仓储信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="650px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="精确编码" prop="userOrderDetailId">
          <el-input v-model="form.userOrderDetailId" placeholder="请输入精确编码" />
        </el-form-item>
        <el-form-item label="入库单" prop="inOrderId">
          <el-input v-model="form.inOrderId" placeholder="请输入入库单" />
        </el-form-item>
        <el-form-item label="出库单" prop="outOrderId">
          <el-input v-model="form.outOrderId" placeholder="请输入出库单" />
        </el-form-item>
        <el-form-item label="调拨单" prop="moveOrderId">
          <el-input v-model="form.moveOrderId" placeholder="请输入调拨单" />
        </el-form-item>
        <el-form-item label="货主" prop="cargoOwnerUserId">
          <el-input v-model="form.cargoOwnerUserId" placeholder="请输入货主" />
        </el-form-item>
        <el-form-item label="仓储状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择仓储状态">
            <el-option
              v-for="dict in statusOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
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
  import { listWmsorder, getWmsorder, delWmsorder, addWmsorder, updateWmsorder } from "@/api/wms/wmsorder";

  export default {
    name: "Wmsorder",
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
        // 仓储信息表格数据
        wmsorderList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 仓储状态字典
        statusOptions: [],
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          userOrderDetailId: null,
          inOrderId: null,
          outOrderId: null,
          moveOrderId: null,
          cargoOwnerUserId: null,
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {
          userOrderDetailId: [
            { required: true, message: "精确编码不能为空", trigger: "blur" }
          ],
        }
      };
    },
    created() {
      this.getList();
      this.getDicts("wms_order_status").then(response => {
        this.statusOptions = response.data;
      });
    },
    methods: {
      /** 查询仓储信息列表 */
      getList() {
        this.loading = true;
        listWmsorder(this.queryParams).then(response => {
          this.wmsorderList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      // 仓储状态字典翻译
      statusFormat(row, column) {
        return this.selectDictLabel(this.statusOptions, row.status);
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
          userOrderDetailId: null,
          inOrderId: null,
          outOrderId: null,
          moveOrderId: null,
          cargoOwnerUserId: null,
          status: null,
          updateTime: null
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
        this.title = "添加仓储信息";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const id = row.id || this.ids
        getWmsorder(id).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改仓储信息";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.id != null) {
              updateWmsorder(this.form).then(response => {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addWmsorder(this.form).then(response => {
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
        this.$confirm('是否确认删除仓储信息编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delWmsorder(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('wms/wmsorder/export', {
          ...this.queryParams
        }, `wms_wmsorder.xlsx`)
      }
    }
  };
</script>
