<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="入库单" prop="inOrderId">
        <el-input
          v-model="queryParams.inOrderId"
          placeholder="请输入入库单"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="仓库" prop="warehouseId">
        <el-input
          v-model="queryParams.warehouseId"
          placeholder="请输入仓库"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="区域" prop="areaId">
        <el-input
          v-model="queryParams.areaId"
          placeholder="请输入区域"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="货架" prop="shelvesId">
        <el-input
          v-model="queryParams.shelvesId"
          placeholder="请输入货架"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="货位" prop="locationId">
        <el-input
          v-model="queryParams.locationId"
          placeholder="请输入货位"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="验货人" prop="checkUserId">
        <el-input
          v-model="queryParams.checkUserId"
          placeholder="请输入验货人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="核验时间" prop="checkTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.checkTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择核验时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="上货人" prop="transportUserId">
        <el-input
          v-model="queryParams.transportUserId"
          placeholder="请输入上货人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="上货时间" prop="transportTimeUp">
        <el-date-picker clearable size="small"
          v-model="queryParams.transportTimeUp"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择上货时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="生成时间" prop="creatTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.creatTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择生成时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="下货时间" prop="transportTimeDown">
        <el-date-picker clearable size="small"
          v-model="queryParams.transportTimeDown"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择下货时间">
        </el-date-picker>
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
          v-hasPermi="['wms:instore:add']"
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
          v-hasPermi="['wms:instore:edit']"
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
          v-hasPermi="['wms:instore:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['wms:instore:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="instoreList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="入库单" align="center" prop="inOrderId" />
      <el-table-column label="仓库" align="center" prop="warehouseId" />
      <el-table-column label="区域" align="center" prop="areaId" />
      <el-table-column label="货架" align="center" prop="shelvesId" />
      <el-table-column label="货位" align="center" prop="locationId" />
      <el-table-column label="验货人" align="center" prop="checkUserId" />
      <el-table-column label="核验时间" align="center" prop="checkTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.checkTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="上货人" align="center" prop="transportUserId" />
      <el-table-column label="上货时间" align="center" prop="transportTimeUp" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.transportTimeUp, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="下货时间" align="center" prop="transportTimeDown" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.transportTimeDown, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['wms:instore:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['wms:instore:remove']"
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

    <!-- 添加或修改入库单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="650px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="入库单" prop="inOrderId">
          <el-input v-model="form.inOrderId" placeholder="请输入入库单" />
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
        <el-form-item label="验货人" prop="checkUserId">
          <el-input v-model="form.checkUserId" placeholder="请输入验货人" />
        </el-form-item>
        <el-form-item label="核验时间" prop="checkTime">
          <el-date-picker clearable size="small"
            v-model="form.checkTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择核验时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="上货人" prop="transportUserId">
          <el-input v-model="form.transportUserId" placeholder="请输入上货人" />
        </el-form-item>
        <el-form-item label="上货时间" prop="transportTimeUp">
          <el-date-picker clearable size="small"
            v-model="form.transportTimeUp"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择上货时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="生成时间" prop="creatTime">
          <el-date-picker clearable size="small"
            v-model="form.creatTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择生成时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="下货时间" prop="transportTimeDown">
          <el-date-picker clearable size="small"
            v-model="form.transportTimeDown"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择下货时间">
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
import { listInstore, getInstore, delInstore, addInstore, updateInstore } from "@/api/wms/instore";

export default {
  name: "Instore",
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
      // 入库单表格数据
      instoreList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        inOrderId: null,
        warehouseId: null,
        areaId: null,
        shelvesId: null,
        locationId: null,
        checkUserId: null,
        checkTime: null,
        transportUserId: null,
        transportTimeUp: null,
        creatTime: null,
        transportTimeDown: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        inOrderId: [
          { required: true, message: "入库单不能为空", trigger: "blur" }
        ],
        warehouseId: [
          { required: true, message: "仓库不能为空", trigger: "blur" }
        ],
        areaId: [
          { required: true, message: "区域不能为空", trigger: "blur" }
        ],
        shelvesId: [
          { required: true, message: "货架不能为空", trigger: "blur" }
        ],
        locationId: [
          { required: true, message: "货位不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询入库单列表 */
    getList() {
      this.loading = true;
      listInstore(this.queryParams).then(response => {
        this.instoreList = response.rows;
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
        inOrderId: null,
        warehouseId: null,
        areaId: null,
        shelvesId: null,
        locationId: null,
        checkUserId: null,
        checkTime: null,
        transportUserId: null,
        transportTimeUp: null,
        creatTime: null,
        transportTimeDown: null,
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
      this.title = "添加入库单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getInstore(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改入库单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateInstore(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInstore(this.form).then(response => {
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
      this.$confirm('是否确认删除入库单编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delInstore(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('wms/instore/export', {
        ...this.queryParams
      }, `wms_instore.xlsx`)
    }
  }
};
</script>