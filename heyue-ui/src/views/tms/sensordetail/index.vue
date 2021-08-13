<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="80px">
      <el-form-item label="设备编号" prop="sensorCode">
        <el-input
          v-model="queryParams.sensorCode"
          placeholder="设备编号"
          clearable
          size="small"
          style="width: 100px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="检测时间">
        <el-date-picker
          v-model="daterangeDetectionTime"
          size="small"
          style="width: 350px"
          type="datetimerange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="温度 >" prop="temperature">
        <el-input
          v-model="queryParams.temperature"
          placeholder="温度"
          clearable
          size="small"
          style="width: 100px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="湿度 >" prop="humidity">
        <el-input
          v-model="queryParams.humidity"
          placeholder="湿度"
          clearable
          size="small"
          style="width: 100px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否开箱" prop="isOpen">
        <el-select v-model="queryParams.isOpen" placeholder="是否开箱" clearable size="small" 
          style="width: 100px">
          <el-option
            v-for="dict in isOpenOptions"
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
          v-hasPermi="['tms:sensordetail:add']"
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
          v-hasPermi="['tms:sensordetail:edit']"
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
          v-hasPermi="['tms:sensordetail:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['tms:sensordetail:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="sensordetailList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="id" v-if="false" />
      <el-table-column label="设备编号" align="center" prop="sensorCode" width="100" />
      <el-table-column label="检测时间" align="center" prop="detectionTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.detectionTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="温度" align="center" prop="temperature" />
      <el-table-column label="湿度" align="center" prop="humidity" />
      <el-table-column label="经度" align="center" prop="longitude" />
      <el-table-column label="纬度" align="center" prop="latitude" />
      <el-table-column label="是否开箱" align="center" prop="isOpen" :formatter="isOpenFormat" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['tms:sensordetail:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['tms:sensordetail:remove']"
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

    <!-- 添加或修改传感器明细对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="650px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="设备编号" prop="sensorCode">
          <el-input v-model="form.sensorCode" placeholder="请输入设备编号" />
        </el-form-item>
        <el-form-item label="检测时间" prop="detectionTime">
          <el-date-picker clearable size="small"
            v-model="form.detectionTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择检测时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="温度" prop="temperature">
          <el-input v-model="form.temperature" placeholder="请输入温度" />
        </el-form-item>
        <el-form-item label="湿度" prop="humidity">
          <el-input v-model="form.humidity" placeholder="请输入湿度" />
        </el-form-item>
        <el-form-item label="经度" prop="longitude">
          <el-input v-model="form.longitude" placeholder="请输入经度" />
        </el-form-item>
        <el-form-item label="纬度" prop="latitude">
          <el-input v-model="form.latitude" placeholder="请输入纬度" />
        </el-form-item>
        <el-form-item label="是否开箱" prop="isOpen">
          <el-select v-model="form.isOpen" placeholder="请选择是否开箱">
            <el-option
              v-for="dict in isOpenOptions"
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
import { listSensordetail, getSensordetail, delSensordetail, addSensordetail, updateSensordetail } from "@/api/tms/sensordetail";

export default {
  name: "Sensordetail",
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
      // 传感器明细表格数据
      sensordetailList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 检测时间时间范围
      daterangeDetectionTime: [],
      // 是否开箱字典
      isOpenOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        sensorCode: null,
        detectionTime: null,
        temperature: null,
        humidity: null,
        isOpen: null
      },
      defaultSensorCode: null,
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [
          { required: true, message: "主键不能为空", trigger: "blur" }
        ],
        sensorCode: [
          { required: true, message: "设备编号不能为空", trigger: "blur" }
        ],
        isOpen: [
          { required: true, message: "是否开箱不能为空", trigger: "change" }
        ]
      }
    };
  },
  created() {
    const SensorCode = this.$route.params && this.$route.params.sensorCode;
    this.queryParams.sensorCode=SensorCode;
    console.log(SensorCode);
    this.getList();
    this.getDicts("sys_yes_no").then(response => {
      this.isOpenOptions = response.data;
    });
  },
  methods: {
    /** 查询传感器明细列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeDetectionTime && '' != this.daterangeDetectionTime) {
        this.queryParams.params["beginDetectionTime"] = this.daterangeDetectionTime[0];
        this.queryParams.params["endDetectionTime"] = this.daterangeDetectionTime[1];
      }
      listSensordetail(this.queryParams).then(response => {
        this.sensordetailList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 是否开箱字典翻译
    isOpenFormat(row, column) {
      return this.selectDictLabel(this.isOpenOptions, row.isOpen);
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
        sensorCode: null,
        detectionTime: null,
        temperature: null,
        humidity: null,
        longitude: null,
        latitude: null,
        isOpen: null
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
      this.daterangeDetectionTime = [];
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
      this.title = "添加传感器明细";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getSensordetail(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改传感器明细";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateSensordetail(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSensordetail(this.form).then(response => {
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
      this.$confirm('是否确认删除传感器明细编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delSensordetail(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('tms/sensordetail/export', {
        ...this.queryParams
      }, `tms_sensordetail.xlsx`)
    }
  }
};
</script>