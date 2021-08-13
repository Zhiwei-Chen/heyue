<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="传感器类型" prop="sensorType">
        <el-select v-model="queryParams.sensorType" placeholder="请选择传感器类型" clearable size="small">
          <el-option
            v-for="dict in sensorTypeOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="冷藏车编号" prop="vanId">
        <el-input
          v-model="queryParams.vanId"
          placeholder="请输入冷藏车编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="冷藏箱编号" prop="refrigeratorId">
        <el-input
          v-model="queryParams.refrigeratorId"
          placeholder="请输入冷藏箱编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="传感器编号" prop="sensorCode">
        <el-input
          v-model="queryParams.sensorCode"
          placeholder="请输入传感器编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="生产商" prop="manufacturer">
        <el-input
          v-model="queryParams.manufacturer"
          placeholder="请输入生产商"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电量" prop="electricity">
        <el-input
          v-model="queryParams.electricity"
          placeholder="请输入电量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择设备状态" clearable size="small">
          <el-option
            v-for="dict in statusOptions"
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
          v-hasPermi="['tms:sensor:add']"
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
          v-hasPermi="['tms:sensor:edit']"
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
          v-hasPermi="['tms:sensor:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['tms:sensor:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="sensorList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="id" v-if="false" />
      <el-table-column label="传感器编号" align="center" prop="sensorCode" width="100" >
        <template slot-scope="scope">
          <router-link :to="'/tms/sensor/sensordetail/' + scope.row.sensorCode" class="link-type">
            <span>{{ scope.row.sensorCode }}</span>
          </router-link>
        </template>
      </el-table-column>
      <el-table-column label="传感器类型" align="center" prop="sensorType" :formatter="sensorTypeFormat" />
      <el-table-column label="冷藏车编号" align="center" prop="vanId" />
      <el-table-column label="冷藏箱编号" align="center" prop="refrigeratorId" />
      <el-table-column label="生产商" align="left" prop="manufacturer" />
      <el-table-column label="电量" align="center" prop="electricity" />
      <el-table-column label="设备状态" align="center" prop="status" :formatter="statusFormat" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['tms:sensor:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['tms:sensor:remove']"
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

    <!-- 添加或修改传感器管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="传感器编号" prop="sensorCode">
          <el-input v-model="form.sensorCode" placeholder="请输入传感器编号" />
        </el-form-item>
        <el-form-item label="传感器类型" prop="sensorType">
          <el-select v-model="form.sensorType" placeholder="请选择传感器类型" @change="currentSel">
            <el-option
              v-for="dict in sensorTypeOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="冷藏车编号" prop="vanId" v-show="vanflag">
          <el-input v-model="form.vanId" placeholder="请输入冷藏车编号" />
        </el-form-item>
        <el-form-item label="冷藏箱编号" prop="refrigeratorId" v-show="refrigeratorflag">
          <el-input v-model="form.refrigeratorId" placeholder="请输入冷藏箱编号" />
        </el-form-item>
        <el-form-item label="生产商" prop="manufacturer">
          <el-input v-model="form.manufacturer" placeholder="请输入生产商" />
        </el-form-item>
        <el-form-item label="电量" prop="electricity">
          <el-input v-model="form.electricity" placeholder="请输入电量" />
        </el-form-item>
        <el-form-item label="设备状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择设备状态">
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
import { listSensor, getSensor, delSensor, addSensor, updateSensor } from "@/api/tms/sensor";

export default {
  name: "Sensor",
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
      // 传感器管理表格数据
      sensorList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 传感器类型字典
      sensorTypeOptions: [],
      // 设备状态字典
      statusOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        sensorType: null,
        vanId: null,
        refrigeratorId: null,
        sensorCode: null,
        manufacturer: null,
        electricity: null,
        status: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      vanflag:false,
      refrigeratorflag:false

    };
  },
  created() {
    this.getList();
    this.getDicts("tms_sensor_type").then(response => {
      this.sensorTypeOptions = response.data;
    });
    this.getDicts("tms_sensor_status").then(response => {
      this.statusOptions = response.data;
    });
  },
  methods: {
    /** 查询传感器管理列表 */
    getList() {
      this.loading = true;
      listSensor(this.queryParams).then(response => {
        this.sensorList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 传感器类型字典翻译
    sensorTypeFormat(row, column) {
      return this.selectDictLabel(this.sensorTypeOptions, row.sensorType);
    },
    // 设备状态字典翻译
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
        sensorType: null,
        vanId: null,
        refrigeratorId: null,
        sensorCode: null,
        manufacturer: null,
        electricity: null,
        createBy: null,
        createTime: null,
        status: null
      };
      this.vanflag=false;
      this.refrigeratorflag=false;
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
    //传感器选择
    currentSel(selVal){
      this.vanflag=false;
      this.refrigeratorflag=false;
      if(selVal==1){
        this.refrigeratorflag=true;
      }
      if(selVal==2){
        this.vanflag=true;
      }
    }
    ,
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加传感器管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getSensor(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改传感器管理";
        this.currentSel(response.data.sensorType);
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateSensor(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSensor(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }fv
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除传感器管理编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delSensor(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('tms/sensor/export', {
        ...this.queryParams
      }, `tms_sensor.xlsx`)
    }
  }
};

</script>
