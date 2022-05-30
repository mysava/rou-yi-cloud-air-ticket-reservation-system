<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="地区描述" prop="areaName">
        <el-input
          v-model="queryParams.areaName"
          placeholder="请输入地区描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="上级id" prop="parentId">
        <el-input
          v-model="queryParams.parentId"
          placeholder="请输入上级id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地区简称描述" prop="areaShortName">
        <el-input
          v-model="queryParams.areaShortName"
          placeholder="请输入地区简称描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="级别" prop="level">
        <el-input
          v-model="queryParams.level"
          placeholder="请输入级别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地区编码" prop="areaCode">
        <el-input
          v-model="queryParams.areaCode"
          placeholder="请输入地区编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地区邮编" prop="zipCode">
        <el-input
          v-model="queryParams.zipCode"
          placeholder="请输入地区邮编"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地区组合描述" prop="areaMergerName">
        <el-input
          v-model="queryParams.areaMergerName"
          placeholder="请输入地区组合描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="拼音" prop="pinyin">
        <el-input
          v-model="queryParams.pinyin"
          placeholder="请输入拼音"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="拼音首字母" prop="pinyinFirst">
        <el-input
          v-model="queryParams.pinyinFirst"
          placeholder="请输入拼音首字母"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="经度" prop="lng">
        <el-input
          v-model="queryParams.lng"
          placeholder="请输入经度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="纬度" prop="lat">
        <el-input
          v-model="queryParams.lat"
          placeholder="请输入纬度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建人id" prop="createUserId">
        <el-input
          v-model="queryParams.createUserId"
          placeholder="请输入创建人id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="修改人id" prop="modifyUserId">
        <el-input
          v-model="queryParams.modifyUserId"
          placeholder="请输入修改人id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="修改时间" prop="modifyTime">
        <el-date-picker clearable
          v-model="queryParams.modifyTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择修改时间">
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
          v-hasPermi="['system:city:add']"
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
          v-hasPermi="['system:city:edit']"
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
          v-hasPermi="['system:city:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:city:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="cityList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键id" align="center" prop="id" />
      <el-table-column label="地区描述" align="center" prop="areaName" />
      <el-table-column label="上级id" align="center" prop="parentId" />
      <el-table-column label="地区简称描述" align="center" prop="areaShortName" />
      <el-table-column label="级别" align="center" prop="level" />
      <el-table-column label="地区编码" align="center" prop="areaCode" />
      <el-table-column label="地区邮编" align="center" prop="zipCode" />
      <el-table-column label="地区组合描述" align="center" prop="areaMergerName" />
      <el-table-column label="拼音" align="center" prop="pinyin" />
      <el-table-column label="拼音首字母" align="center" prop="pinyinFirst" />
      <el-table-column label="经度" align="center" prop="lng" />
      <el-table-column label="纬度" align="center" prop="lat" />
      <el-table-column label="创建人id" align="center" prop="createUserId" />
      <el-table-column label="修改人id" align="center" prop="modifyUserId" />
      <el-table-column label="修改时间" align="center" prop="modifyTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.modifyTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:city:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:city:remove']"
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

    <!-- 添加或修改地区对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="地区描述" prop="areaName">
          <el-input v-model="form.areaName" placeholder="请输入地区描述" />
        </el-form-item>
        <el-form-item label="上级id" prop="parentId">
          <el-input v-model="form.parentId" placeholder="请输入上级id" />
        </el-form-item>
        <el-form-item label="地区简称描述" prop="areaShortName">
          <el-input v-model="form.areaShortName" placeholder="请输入地区简称描述" />
        </el-form-item>
        <el-form-item label="级别" prop="level">
          <el-input v-model="form.level" placeholder="请输入级别" />
        </el-form-item>
        <el-form-item label="地区编码" prop="areaCode">
          <el-input v-model="form.areaCode" placeholder="请输入地区编码" />
        </el-form-item>
        <el-form-item label="地区邮编" prop="zipCode">
          <el-input v-model="form.zipCode" placeholder="请输入地区邮编" />
        </el-form-item>
        <el-form-item label="地区组合描述" prop="areaMergerName">
          <el-input v-model="form.areaMergerName" placeholder="请输入地区组合描述" />
        </el-form-item>
        <el-form-item label="拼音" prop="pinyin">
          <el-input v-model="form.pinyin" placeholder="请输入拼音" />
        </el-form-item>
        <el-form-item label="拼音首字母" prop="pinyinFirst">
          <el-input v-model="form.pinyinFirst" placeholder="请输入拼音首字母" />
        </el-form-item>
        <el-form-item label="经度" prop="lng">
          <el-input v-model="form.lng" placeholder="请输入经度" />
        </el-form-item>
        <el-form-item label="纬度" prop="lat">
          <el-input v-model="form.lat" placeholder="请输入纬度" />
        </el-form-item>
        <el-form-item label="创建人id" prop="createUserId">
          <el-input v-model="form.createUserId" placeholder="请输入创建人id" />
        </el-form-item>
        <el-form-item label="修改人id" prop="modifyUserId">
          <el-input v-model="form.modifyUserId" placeholder="请输入修改人id" />
        </el-form-item>
        <el-form-item label="修改时间" prop="modifyTime">
          <el-date-picker clearable
            v-model="form.modifyTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择修改时间">
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
import { listCity, getCity, delCity, addCity, updateCity } from "@/api/system/city";

export default {
  name: "City",
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
      // 地区表格数据
      cityList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        areaName: null,
        parentId: null,
        areaShortName: null,
        level: null,
        areaCode: null,
        zipCode: null,
        areaMergerName: null,
        pinyin: null,
        pinyinFirst: null,
        lng: null,
        lat: null,
        createUserId: null,
        modifyUserId: null,
        modifyTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        areaName: [
          { required: true, message: "地区描述不能为空", trigger: "blur" }
        ],
        parentId: [
          { required: true, message: "上级id不能为空", trigger: "blur" }
        ],
        areaShortName: [
          { required: true, message: "地区简称描述不能为空", trigger: "blur" }
        ],
        level: [
          { required: true, message: "级别不能为空", trigger: "blur" }
        ],
        areaCode: [
          { required: true, message: "地区编码不能为空", trigger: "blur" }
        ],
        zipCode: [
          { required: true, message: "地区邮编不能为空", trigger: "blur" }
        ],
        areaMergerName: [
          { required: true, message: "地区组合描述不能为空", trigger: "blur" }
        ],
        pinyin: [
          { required: true, message: "拼音不能为空", trigger: "blur" }
        ],
        pinyinFirst: [
          { required: true, message: "拼音首字母不能为空", trigger: "blur" }
        ],
        lng: [
          { required: true, message: "经度不能为空", trigger: "blur" }
        ],
        lat: [
          { required: true, message: "纬度不能为空", trigger: "blur" }
        ],
        createUserId: [
          { required: true, message: "创建人id不能为空", trigger: "blur" }
        ],
        modifyUserId: [
          { required: true, message: "修改人id不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
        modifyTime: [
          { required: true, message: "修改时间不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询地区列表 */
    getList() {
      this.loading = true;
      listCity(this.queryParams).then(response => {
        this.cityList = response.rows;
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
        areaName: null,
        parentId: null,
        areaShortName: null,
        level: null,
        areaCode: null,
        zipCode: null,
        areaMergerName: null,
        pinyin: null,
        pinyinFirst: null,
        lng: null,
        lat: null,
        createUserId: null,
        modifyUserId: null,
        createTime: null,
        modifyTime: null
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
      this.title = "添加地区";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCity(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改地区";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCity(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCity(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
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
      this.$modal.confirm('是否确认删除地区编号为"' + ids + '"的数据项？').then(function() {
        return delCity(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/city/export', {
        ...this.queryParams
      }, `city_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
