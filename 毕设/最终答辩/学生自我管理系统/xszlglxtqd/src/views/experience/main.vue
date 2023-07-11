<template>
    <div class="xd">
        <h1>学生心得信息页面</h1>
        <el-card class="box-card">
            <el-form :inline="true" :model="form" class="demo-form-inline">
                <el-form-item label="用户名">
                    <el-input v-model="form.username" placeholder="请输入用户名进行查询" @keyup.enter.native="query()" />
                </el-form-item>
                <el-form-item label="日期">
                    <el-date-picker v-model="form.value1" type="date" placeholder="请选择日期进行查询" :size="size"
                        style="width: 200px;" value-format="YYYY-MM-DD" @keyup.enter.native="query()" />
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="query()">查询</el-button>
                    <el-button type="primary" @click="shuaxin()">重置</el-button>
                </el-form-item>
            </el-form>

            <el-table border :data="list" @selection-change="selectionChange" @sort-change="$sortChange" style="width: 100%"
                stripe>
                <!-- <el-table-column fixed type="selection" tooltip-effect="dark" width="55"></el-table-column> -->
                <el-table-column prop="stuName" label="姓名" sortable width="120">
                </el-table-column>
                <el-table-column prop="stuNumber" label="学号" sortable width="120">
                </el-table-column>
                <el-table-column prop="username" label="用户名" sortable width="120">
                </el-table-column>
                <el-table-column prop="gender" label="性别" sortable width="120">
                </el-table-column>
                <el-table-column prop="planName" label="计划名称" sortable width="150">
                </el-table-column>
                <el-table-column prop="content" label="心得内容" sortable width="250">
                    请点击详情查看心得内容
                </el-table-column>
                <el-table-column prop="startTime" label="开始时间" sortable min-width="180">
                </el-table-column>
                <el-table-column prop="endTime" label="结束时间" sortable min-width="180">
                </el-table-column>
                <!-- <el-table-column prop="time" label="专注时长" sortable min-width="180">
                    <div
                        v-if="parseInt((new Date(JSON.parse(JSON.stringify(index)).endTime) - new Date(JSON.parse(JSON.stringify(index)).startTime)) / (1000 * 60 * 60)) != 0">
                        {{ parseInt((new Date(JSON.parse(JSON.stringify(index)).endTime) - new
                            Date(JSON.parse(JSON.stringify(index)).startTime)) / (1000 * 60 * 60)) }}小时
                        {{ parseInt((new Date(JSON.parse(JSON.stringify(index)).endTime) - new
                            Date(JSON.parse(JSON.stringify(index)).startTime)) / (1000 * 60) % 60) }}分钟
                    </div>
                    <div v-else>{{ Math.round((new Date(JSON.parse(JSON.stringify(index)).endTime) - new
                        Date(JSON.parse(JSON.stringify(index)).startTime)) / (1000 * 60)) }}分钟</div>
                </el-table-column> -->
                <el-table-column prop="time" label="专注时长" min-width="180">
                    <template #default="scope">
                        <div
                            v-if="parseInt((new Date(scope.row.endTime) - new Date(scope.row.startTime)) / (1000 * 60 * 60)) != 0">
                            {{ parseInt((new Date(scope.row.endTime) - new Date(scope.row.startTime)) / (1000 * 60 * 60))
                            }}小时
                            {{ parseInt((new Date(scope.row.endTime) - new Date(scope.row.startTime)) / (1000 * 60) % 60)
                            }}分钟
                        </div>
                        <div v-else>{{ Math.round((new Date(scope.row.endTime) - new Date(scope.row.startTime)) / (1000 *
                            60)) }}分钟</div>
                    </template>
                </el-table-column>
                <el-table-column prop="status" label="计时状态" sortable min-width="120">
                    <span>{{ status }}</span>
                </el-table-column>
                <el-table-column sortable prop="createTime" label="创建时间" min-width="200">
                </el-table-column>
                <el-table-column sortable prop="updateTime" label="更新时间" min-width="200">
                </el-table-column>
                <!-- 操作 -->
                <el-table-column fixed="right" label="操作" width="156">
                    <template #default="scope">
                        <el-button type="primary" @click="xiangqing(scope.row)">详情</el-button>
                        <el-button type="danger" @click="delxd(scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <!-- 分页器 -->
            <div class="demo-pagination-block">
                <el-pagination v-model:current-page="pageNum" v-model:page-size="pageSize" :page-sizes="[5, 10, 15, 20]"
                    :small="small" :disabled="disabled" :background="background"
                    layout="total, sizes, prev, pager, next, jumper" :total="count" @size-change="handleSizeChange"
                    @current-change="handleCurrentChange" />
            </div>
            <!-- 对话框 -->
            <el-dialog title="心得详情" v-model="centerDialogVisible" width="50%" center style="height: 650px;">
                <el-form ref="form1" :model="form1" label-width="80px">
                    <el-form-item label="计划名称" prop="planName">
                        <el-input v-model="form1.planName" placeholder="请输入学习计划名称" />
                    </el-form-item>
                    <el-form-item label="用户名" prop="username">
                        <el-input v-model="form1.username" placeholder="请输入用户名" />
                    </el-form-item>
                    <el-col class="el_form_item_warp">
                        <el-form-item label="开始时间" prop="startTime">
                            {{form1.startTime}}
                        </el-form-item>
                    </el-col>
                    <el-col class="el_form_item_warp">
                        <el-form-item label="专注时长" prop="time">
                            <div
                            v-if="parseInt((new Date(form1.endTime) - new Date(form1.startTime)) / (1000 * 60 * 60)) != 0">
                            {{ parseInt((new Date(form1.endTime) - new Date(form1.startTime)) / (1000 * 60 * 60))
                            }}小时
                            {{ parseInt((new Date(form1.endTime) - new Date(form1.startTime)) / (1000 * 60) % 60)
                            }}分钟
                        </div>
                        <div v-else>{{ Math.round((new Date(form1.endTime) - new Date(form1.startTime)) / (1000 *
                            60)) }}分钟</div>
                        </el-form-item>
                    </el-col>
                    <el-col class="el_form_item_warp">
                        <el-form-item label="结束时间" prop="endTime">
                            {{form1.endTime}}
                        </el-form-item>
                    </el-col>
                    <el-col class="el_form_item_warp">
                        <el-form-item label="计时状态" prop="status">
                            {{status}}
                        </el-form-item>
                    </el-col>
                    <el-col class="el_form_item_warp" style="width: 1000px;">
                        <el-form-item label="心得内容" prop="textarea">
                            <el-input v-model="form1.textarea" :rows="15" type="textarea" placeholder="请输入心得内容" />
                        </el-form-item>
                    </el-col>
                </el-form>
            </el-dialog>
        </el-card>
    </div>
</template>

<script>
let data = JSON.parse(sessionStorage.getItem("user"));
let userGroup = sessionStorage.getItem("userGroup");
let username = sessionStorage.getItem("username")
import { ElMessage, ElMessageBox } from 'element-plus'
export default {
    data() {
        return {
            form: {
                username: '',
                value1: '',
            },
            list: [],
            count: '',
            pageNum: 1,
            pageSize: 5,
            status: '已完成',
            time: 0,
            centerDialogVisible: false,
            form1: {
                planName: '',
                content: '',
                startTime: '',
                endTime: '',
                username: '',
                textarea: '',
            },
        }
    },
    methods: {
        handleSizeChange(val) {
            console.log(`每页 ${val} 条`);
            this.pageNum = 1;
            this.pageSize = val;
            this.query();
        }, handleCurrentChange(val) {
            console.log(`当前页: ${val}`);
            this.pageNum = val;
            this.query();
        }, query() {
            this.axios.post('/experience/xdList1', {
                pageNum: this.pageNum,
                pageSize: this.pageSize,
                param: {
                    username: this.form.username,
                    value1: this.form.value1,
                    userGroup:userGroup,
					academy:data[0]['faculties']
                }
            }).then(res => res.data).then(res => {
                // console.log(res.data)
                if (res.code == 200) {
                    this.list = res.data;
                    // this.list.status = this.status;
                    this.list.time = res.data['endTime']
                    this.count = res.total;
                } else {
                    return this.$message({
                        duration: 3000,
                        offset: 50,
                        message: '数据获取失败',
                        type: 'error'
                    });
                }
            })
        }, shuaxin() {
            this.form.username = ''
            this.form.value1 = ''
            this.axios.post('/experience/xdList1', {
                pageNum: this.pageNum,
                pageSize: this.pageSize,
                param: {
                    username: this.form.username,
                    value1: this.form.value1,
                    userGroup:userGroup,
					academy:data[0]['faculties']
                }
            }).then(res => res.data).then(res => {
                // console.log(res.data)
                if (res.code == 200) {
                    this.list = res.data;
                    this.count = res.total;
                } else {
                    return this.$message({
                        duration: 3000,
                        offset: 50,
                        message: '数据获取失败',
                        type: 'error'
                    });
                }
            })
        }, xiangqing(row) {
            this.centerDialogVisible = true;
            let row1 = JSON.parse(JSON.stringify(row));
            // console.log(row1)
            this.form1.planName=row1.planName;
            this.form1.username=row1.username;
            this.form1.startTime=row1.startTime;
            this.form1.endTime=row1.endTime;                      
            this.form1.textarea=row1.content;
        }, delxd(row) {
            let row1 = JSON.parse(JSON.stringify(row));
            ElMessageBox.confirm(
            '是否确认删除该心得',
            '注意',
            {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning',
            }
        )
            .then(() => {
            this.axios.post('/experience/jsdelxd', {
                experienceId: row1.experienceId,
                username:username,
                reusername:row1.username,
                createTime:row1.createTime,
                planName:row1.planName
            })
                .then(res => res.data).then(res => {
                    // console.log(res);
                    if (res.code == 200) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '心得删除成功',
                            type: 'success'
                        });
                        this.xianshi();
                    } else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '心得删除失败',
                            type: 'error'
                        });
                    }
                }
                )
            })
            .catch(() => {
                ElMessage({
                    type: 'info',
                    message: '已取消删除',
                })
            })
        }
    }, beforeMount() {
        this.query()
    }
}
</script>

<style>
.xd {
    padding: 2rem 1rem;
    background-color: #eeeeee !important;
    width: 90%;
    margin: 0 auto;
}

.el-dialog__title {
    color: #00838F !important;
}

.el-pagination {
    margin-left: 230px;
    margin-top: 20px;
}

.el-form-item__label {
    color: #00838F !important;
}

.el_form_item_warp {
    float: left;
    width: 354px;
}

h1 {
    text-align: center;
    margin-left: -100px;
    margin-top: -20px;
    margin-bottom: 20px;
    color: #00838F !important;
    font-weight: bold;
}
</style>