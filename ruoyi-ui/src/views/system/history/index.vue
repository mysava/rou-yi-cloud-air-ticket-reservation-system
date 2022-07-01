<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="乘客姓名" prop="pname">
        <el-input
          v-model="queryParams.pname"
          placeholder="请输入乘客姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="航班编号" prop="fno">
        <el-input
          v-model="queryParams.fno"
          placeholder="请输入航班编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="座舱等级" prop="level">
        <el-input
          v-model="queryParams.level"
          placeholder="请输入座舱等级"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出发时间" prop="dtime">
        <el-input
          v-model="queryParams.dtime"
          placeholder="请输入出发时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出发城市" prop="dcity">
        <el-input
          v-model="queryParams.dcity"
          placeholder="请输入出发城市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="到达时间" prop="atime">
        <el-input
          v-model="queryParams.atime"
          placeholder="请输入到达时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="到达城市" prop="acity">
        <el-input
          v-model="queryParams.acity"
          placeholder="请输入到达城市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="价格" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="座位号" prop="seat">
        <el-input
          v-model="queryParams.seat"
          placeholder="请输入座位号"
          clearable
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
          v-hasPermi="['system:history:add']"
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
          v-hasPermi="['system:history:edit']"
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
          v-hasPermi="['system:history:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:history:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="historyList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="机票编号" align="center" prop="ticketId" />
      <el-table-column label="乘客姓名" align="center" prop="pname" />
      <el-table-column label="航班编号" align="center" prop="fno" />
      <el-table-column label="座舱等级" align="center" prop="level" />
      <el-table-column label="出发时间" align="center" prop="dtime" />
      <el-table-column label="出发城市" align="center" prop="dcity" />
      <el-table-column label="到达时间" align="center" prop="atime" />
      <el-table-column label="到达城市" align="center" prop="acity" />
      <el-table-column label="价格" align="center" prop="price" />
      <el-table-column label="座位号" align="center" prop="seat" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:history:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:history:remove']"
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

    <!-- 添加或修改历史订单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="乘客姓名" prop="pname">
          <el-input v-model="form.pname" placeholder="请输入乘客姓名" />
        </el-form-item>
        <el-form-item label="航班编号" prop="fno">
          <el-input v-model="form.fno" placeholder="请输入航班编号" />
        </el-form-item>
        <el-form-item label="座舱等级" prop="level">
          <el-input v-model="form.level" placeholder="请输入座舱等级" />
        </el-form-item>
        <el-form-item label="出发时间" prop="dtime">
          <el-input v-model="form.dtime" placeholder="请输入出发时间" />
        </el-form-item>
        <el-form-item label="出发城市" prop="dcity">
          <el-input v-model="form.dcity" placeholder="请输入出发城市" />
        </el-form-item>
        <el-form-item label="到达时间" prop="atime">
          <el-input v-model="form.atime" placeholder="请输入到达时间" />
        </el-form-item>
        <el-form-item label="到达城市" prop="acity">
          <el-input v-model="form.acity" placeholder="请输入到达城市" />
        </el-form-item>
        <el-form-item label="价格" prop="price">
          <el-input v-model="form.price" placeholder="请输入价格" />
        </el-form-item>
        <el-form-item label="座位号" prop="seat">
          <el-input v-model="form.seat" placeholder="请输入座位号" />
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
import { listHistory, getHistory, delHistory, addHistory, updateHistory } from "@/api/system/history";

export default {
  name: "History",
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
      // 历史订单表格数据
      historyList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        pname: null,
        fno: null,
        level: null,
        dtime: null,
        dcity: null,
        atime: null,
        acity: null,
        price: null,
        seat: null
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
  },
  methods: {
    /** 查询历史订单列表 */
    getList() {
      this.loading = true;
      listHistory(this.queryParams).then(response => {
        this.historyList = response.rows;
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
        ticketId: null,
        pname: null,
        fno: null,
        level: null,
        dtime: null,
        dcity: null,
        atime: null,
        acity: null,
        price: null,
        seat: null
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
      this.ids = selection.map(item => item.ticketId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加历史订单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const ticketId = row.ticketId || this.ids
      getHistory(ticketId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改历史订单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.ticketId != null) {
            updateHistory(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addHistory(this.form).then(response => {
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
      const ticketIds = row.ticketId || this.ids;
      this.$modal.confirm('是否确认删除历史订单编号为"' + ticketIds + '"的数据项？').then(function() {
        return delHistory(ticketIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/history/export', {
        ...this.queryParams
      }, `history_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
