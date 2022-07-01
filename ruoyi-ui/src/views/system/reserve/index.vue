<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="航班编号" prop="flightno">
        <el-input
          v-model="queryParams.flightno"
          placeholder="请输入航班编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出发日期" prop="departdate">
        <el-date-picker clearable
          v-model="queryParams.departdate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择出发日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="出发时间" prop="departtime">
        <el-input
          v-model="queryParams.departtime"
          placeholder="请输入出发时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="到达时间" prop="arrivetime">
        <el-input
          v-model="queryParams.arrivetime"
          placeholder="请输入到达时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出发城市" prop="departurecityname">
        <el-input
          v-model="queryParams.departurecityname"
          placeholder="请输入出发城市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="到达城市" prop="arrivecityname">
        <el-input
          v-model="queryParams.arrivecityname"
          placeholder="请输入到达城市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="商务舱数量" prop="vipNum">-->
<!--        <el-input-->
<!--          v-model="queryParams.vipNum"-->
<!--          placeholder="请输入商务舱数量"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="普通舱数量" prop="comNum">-->
<!--        <el-input-->
<!--          v-model="queryParams.comNum"-->
<!--          placeholder="请输入普通舱数量"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="商务舱价格" prop="vipPrice">-->
<!--        <el-input-->
<!--          v-model="queryParams.vipPrice"-->
<!--          placeholder="请输入商务舱价格"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="普通舱价格" prop="comPrice">-->
<!--        <el-input-->
<!--          v-model="queryParams.comPrice"-->
<!--          placeholder="请输入普通舱价格"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="剩余商务舱" prop="vipNumChange">-->
<!--        <el-input-->
<!--          v-model="queryParams.vipNumChange"-->
<!--          placeholder="请输入剩余商务舱"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="剩余普通舱" prop="comNumChange">-->
<!--        <el-input-->
<!--          v-model="queryParams.comNumChange"-->
<!--          placeholder="请输入剩余普通舱"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

<!--    <el-row :gutter="10" class="mb8">-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="primary"-->
<!--          plain-->
<!--          icon="el-icon-plus"-->
<!--          size="mini"-->
<!--          @click="handleAdd"-->
<!--          v-hasPermi="['system:reserve:add']"-->
<!--        >新增</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="success"-->
<!--          plain-->
<!--          icon="el-icon-edit"-->
<!--          size="mini"-->
<!--          :disabled="single"-->
<!--          @click="handleUpdate"-->
<!--          v-hasPermi="['system:reserve:edit']"-->
<!--        >修改</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="danger"-->
<!--          plain-->
<!--          icon="el-icon-delete"-->
<!--          size="mini"-->
<!--          :disabled="multiple"-->
<!--          @click="handleDelete"-->
<!--          v-hasPermi="['system:reserve:remove']"-->
<!--        >删除</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="warning"-->
<!--          plain-->
<!--          icon="el-icon-download"-->
<!--          size="mini"-->
<!--          @click="handleExport"-->
<!--          v-hasPermi="['system:reserve:export']"-->
<!--        >导出</el-button>-->
<!--      </el-col>-->
<!--      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>-->
<!--    </el-row>-->

    <el-table v-loading="loading" :data="reserveList" @selection-change="handleSelectionChange">
<!--      <el-table-column type="selection" width="55" align="center" />-->
<!--      <el-table-column label="编号" align="center" prop="flightid" />-->
      <el-table-column label="航班编号" align="center" prop="flightno" />
      <el-table-column label="飞机型号" align="center" prop="aircrafttype" />
      <el-table-column label="出发日期" align="center" prop="departdate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.departdate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="出发时间" align="center" prop="departtime" />
      <el-table-column label="到达时间" align="center" prop="arrivetime" />
      <el-table-column label="出发城市" align="center" prop="departurecityname" />
      <el-table-column label="到达城市" align="center" prop="arrivecityname" />
<!--      <el-table-column label="商务舱数量" align="center" prop="vipNum" />-->
<!--      <el-table-column label="普通舱数量" align="center" prop="comNum" />-->
      <el-table-column label="商务舱价格" align="center" prop="vipPrice" />
      <el-table-column label="普通舱价格" align="center" prop="comPrice" />
      <el-table-column label="剩余商务舱" align="center" prop="vipNumChange" />
      <el-table-column label="剩余普通舱" align="center" prop="comNumChange" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
<!--          <el-button-->
<!--            size="mini"-->
<!--            type="text"-->
<!--            icon="el-icon-edit"-->
<!--            @click="handleUpdate(scope.row)"-->
<!--            v-hasPermi="['system:reserve:edit']"-->
<!--          >修改</el-button>-->
<!--          <el-button-->
<!--            size="mini"-->
<!--            type="text"-->
<!--            icon="el-icon-delete"-->
<!--            @click="handleDelete(scope.row)"-->
<!--            v-hasPermi="['system:reserve:remove']"-->
<!--          >删除</el-button>-->
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="Orderdetail(scope.row)"
            v-hasPermi="['system:flight:order']"
          >预定</el-button>
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

    <!-- 添加或修改航班预定对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="编号" prop="flightid">
          <el-input v-model="form.flightid" placeholder="请输入乘客姓名" />
        </el-form-item>
        <el-form-item label="乘客姓名" prop="pname">
          <el-input v-model="form.pname" placeholder="请输入乘客姓名" />
        </el-form-item>
        <el-form-item label="航班编号" prop="fno">
          <el-input v-model="form.fno" placeholder="请输入航班编号" />
        </el-form-item>
        <el-form-item label="飞机舱" prop="level">
          <el-select v-model="form.level" placeholder="请选择飞机舱"  clearable :style="{width: '100%'}">
            <el-option v-for="(item, index) in levelOptions" :key="index" :label="item.label"
                       :value="item.value" :disabled="item.disabled"></el-option>
          </el-select>
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
          <el-input v-model="form.price"/>
        </el-form-item>
        <el-form-item label="剩余座位" prop="seat">
          <el-input v-model="form.seat"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="reserve">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listReserve, getReserve, delReserve, addReserve, updateReserve } from "@/api/system/reserve";
import {getFlight} from "@/api/system/flight";
import {addTickets} from "@/api/system/tickets";

export default {
  name: "Reserve",
  components: {},
  props: [],
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
      // 航班预定表格数据
      reserveList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        flightno: null,
        aircrafttype: null,
        departdate: null,
        departtime: null,
        arrivetime: null,
        departurecityname: null,
        arrivecityname: null,
        vipNum: null,
        comNum: null,
        vipPrice: null,
        comPrice: null,
        vipNumChange: null,
        comNumChange: null
      },
      // 表单参数
      form: {
        level:''
      },
      // 表单校验
      rules: {
        level: [{
          required: true,
          message: '请选择飞机舱',
          trigger: 'change'
        }],
      },
      levelOptions: [{
        "label": "商务舱",
        "value": "商务舱"
      }, {
        "label": "经济舱",
        "value": "经济舱"
      }]
    };
  },
  created() {
    this.getList();
  },
  computed: {},
  watch: {
    'form.level':function (val){
      if (val==="商务舱"){
        this.form.price=this.form.vipPrice
        this.form.seat=this.form.vipNumChange
      }else {
        this.form.price=this.form.comPrice
        this.form.seat=this.form.comNumChange
      }
    }
  },
  mounted() {},
  methods: {
    change(){
      this.$forceUpdate()
    },
    /** 查询航班预定列表 */
    getList() {
      this.loading = true;
      listReserve(this.queryParams).then(response => {
        this.reserveList = response.rows;
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
        flightid: null,
        flightno: null,
        aircrafttype: null,
        departdate: null,
        departtime: null,
        arrivetime: null,
        departurecityname: null,
        arrivecityname: null,
        vipNum: null,
        comNum: null,
        vipPrice: null,
        comPrice: null,
        vipNumChange: null,
        comNumChange: null
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
      this.ids = selection.map(item => item.flightid)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加航班预定";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const flightid = row.flightid || this.ids
      getReserve(flightid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改航班预定";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.flightid != null) {
            updateReserve(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addReserve(this.form).then(response => {
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
      const flightids = row.flightid || this.ids;
      this.$modal.confirm('是否确认删除航班预定编号为"' + flightids + '"的数据项？').then(function() {
        return delReserve(flightids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/reserve/export', {
        ...this.queryParams
      }, `reserve_${new Date().getTime()}.xlsx`)
    },

    Orderdetail(row) {
      this.reset();
      const flightid = row.flightid || this.ids
      getFlight(flightid).then(response => {
        this.form = response.data;
        this.id=this.form.flightid;
        this.form.pname=this.$store.state.user.name;
        this.form.fno=this.form.flightno;
        this.form.dtime=this.form.departtime;
        this.form.dcity=this.form.departurecityname;
        this.form.atime=this.form.arrivetime;
        this.form.acity=this.form.arrivecityname;
        this.open = true;
        this.title = "修改航班查询";
      });
    },
    reserve() {
      const flightid= this.id
      this.$refs["form"].validate(valid => {
        if (valid) {
          addTickets(this.form,flightid).then(response => {
            this.$modal.msgSuccess("预定成功");
            this.open = false;
            this.getList();
            return response;
          });
        }
      });
    }
  }
};
</script>
