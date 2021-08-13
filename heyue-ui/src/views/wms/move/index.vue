<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="调拨单" prop="moveOrderId">
        <el-input
          v-model="queryParams.moveOrderId"
          placeholder="请输入调拨单"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="原货主" prop="cargoOwnerUserIdBg">
        <el-input
          v-model="queryParams.cargoOwnerUserIdBg"
          placeholder="请输入原货主"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="拨入货主" prop="cargoOwnerUserIdEnd">
        <el-input
          v-model="queryParams.cargoOwnerUserIdEnd"
          placeholder="请输入拨入货主"
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
          v-hasPermi="['wms:move:add']"
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
          v-hasPermi="['wms:move:edit']"
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
          v-hasPermi="['wms:move:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['wms:move:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="moveList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="调拨单" align="center" prop="moveOrderId" />
      <el-table-column label="原仓库" align="center" prop="warehouseIdBg" />
      <el-table-column label="拨入仓库" align="center" prop="warehouseIdEnd" />
      <el-table-column label="原货架" align="center" prop="shelvesIdBg" />
      <el-table-column label="拨入货架" align="center" prop="shelvesIdEnd" />
      <el-table-column label="原货位" align="center" prop="locationIdBg" />
      <el-table-column label="拨入货位" align="center" prop="locationIdEnd" />
      <el-table-column label="原货主" align="center" prop="cargoOwnerUserIdBg" />
      <el-table-column label="拨入货主" align="center" prop="cargoOwnerUserIdEnd" />
      <el-table-column label="操作人" align="center" prop="userId" />
      <el-table-column label="原区域" align="center" prop="areaIdBg" />
      <el-table-column label="拨入区域" align="center" prop="areaIdEnd" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['wms:move:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['wms:move:remove']"
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

    <!-- 添加或修改调拨单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="650px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="调拨单" prop="moveOrderId">
          <el-input v-model="form.moveOrderId" placeholder="请输入调拨单" />
        </el-form-item>
        <el-form-item label="原仓库" prop="warehouseIdBg">
          <el-input v-model="form.warehouseIdBg" placeholder="请输入原仓库" />
        </el-form-item>
        <el-form-item label="拨入仓库" prop="warehouseIdEnd">
          <el-input v-model="form.warehouseIdEnd" placeholder="请输入拨入仓库" />
        </el-form-item>
        <el-form-item label="原货架" prop="shelvesIdBg">
          <el-input v-model="form.shelvesIdBg" placeholder="请输入原货架" />
        </el-form-item>
        <el-form-item label="拨入货架" prop="shelvesIdEnd">
          <el-input v-model="form.shelvesIdEnd" placeholder="请输入拨入货架" />
        </el-form-item>
        <el-form-item label="原货位" prop="locationIdBg">
          <el-input v-model="form.locationIdBg" placeholder="请输入原货位" />
        </el-form-item>
        <el-form-item label="拨入货位" prop="locationIdEnd">
          <el-input v-model="form.locationIdEnd" placeholder="请输入拨入货位" />
        </el-form-item>
        <el-form-item label="原货主" prop="cargoOwnerUserIdBg">
          <el-input v-model="form.cargoOwnerUserIdBg" placeholder="请输入原货主" />
        </el-form-item>
        <el-form-item label="拨入货主" prop="cargoOwnerUserIdEnd">
          <el-input v-model="form.cargoOwnerUserIdEnd" placeholder="请输入拨入货主" />
        </el-form-item>
        <el-form-item label="操作人" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入操作人" />
        </el-form-item>
        <el-form-item label="原区域" prop="areaIdBg">
          <el-input v-model="form.areaIdBg" placeholder="请输入原区域" />
        </el-form-item>
        <el-form-item label="拨入区域" prop="areaIdEnd">
          <el-input v-model="form.areaIdEnd" placeholder="请输入拨入区域" />
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
import { listMove, getMove, delMove, addMove, updateMove } from "@/api/wms/move";

export default {
  name: "Move",
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
      // 调拨单表格数据
      moveList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        moveOrderId: null,
        cargoOwnerUserIdBg: null,
        cargoOwnerUserIdEnd: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        moveOrderId: [
          { required: true, message: "调拨单不能为空", trigger: "blur" }
        ],
        warehouseIdBg: [
          { required: true, message: "原仓库不能为空", trigger: "blur" }
        ],
        warehouseIdEnd: [
          { required: true, message: "拨入仓库不能为空", trigger: "blur" }
        ],
        shelvesIdBg: [
          { required: true, message: "原货架不能为空", trigger: "blur" }
        ],
        shelvesIdEnd: [
          { required: true, message: "拨入货架不能为空", trigger: "blur" }
        ],
        locationIdBg: [
          { required: true, message: "原货位不能为空", trigger: "blur" }
        ],
        locationIdEnd: [
          { required: true, message: "拨入货位不能为空", trigger: "blur" }
        ],
        cargoOwnerUserIdBg: [
          { required: true, message: "原货主不能为空", trigger: "blur" }
        ],
        cargoOwnerUserIdEnd: [
          { required: true, message: "拨入货主不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "操作人不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询调拨单列表 */
    getList() {
      this.loading = true;
      listMove(this.queryParams).then(response => {
        this.moveList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
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
        moveOrderId: null,
        warehouseIdBg: null,
        warehouseIdEnd: null,
        shelvesIdBg: null,
        shelvesIdEnd: null,
        locationIdBg: null,
        locationIdEnd: null,
        cargoOwnerUserIdBg: null,
        cargoOwnerUserIdEnd: null,
        userId: null,
        areaIdBg: null,
        areaIdEnd: null,
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
      this.title = "添加调拨单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getMove(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改调拨单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMove(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMove(this.form).then(response => {
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
      this.$confirm('是否确认删除调拨单编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delMove(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('wms/move/export', {
        ...this.queryParams
      }, `wms_move.xlsx`)
    }
  }
};
</script>