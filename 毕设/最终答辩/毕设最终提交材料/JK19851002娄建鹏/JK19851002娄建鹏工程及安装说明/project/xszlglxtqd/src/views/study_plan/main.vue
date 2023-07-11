<template>
    <el-main class="plan_main">
        <h1>学生计划信息页面</h1>
        <el-card class="box-card">
            <el-form :inline="true" :model="form" class="demo-form-inline">
                <el-form-item label="用户名">
                    <el-input v-model="form.username" placeholder="请输入用户名进行查询" @keyup.enter.native="query()" />
                </el-form-item>
                <el-form-item label="计划名称">
                    <el-input v-model="form.plan_name" placeholder="请输入计划名称进行查询" @keyup.enter.native="query()" />
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="query()">查询</el-button>
                    <el-button type="primary" @click="shuaxin()">重置</el-button>
                </el-form-item>
            </el-form>

            <el-table border :data="list" @selection-change="selectionChange" @sort-change="$sortChange" style="width: 100%"
                stripe>
                <!-- <el-table-column fixed type="selection" tooltip-effect="dark" width="55"></el-table-column> -->
                <el-table-column prop="stuNumber" label="学号" sortable width="120">
                </el-table-column>
                <el-table-column prop="stuName" label="姓名" sortable width="120">
                </el-table-column>
                <el-table-column prop="username" label="用户名" sortable width="120">
                </el-table-column>
                <!-- <el-table-column prop="username" label="班级名称" sortable width="120">
                </el-table-column> -->
                <el-table-column prop="teaNumber" label="教师编号" sortable width="120">
                </el-table-column>
                <el-table-column prop="planName" label="计划名称" sortable width="150">
                </el-table-column>
                <el-table-column prop="timeTrend" label="类型" sortable width="150">
                </el-table-column>
                <el-table-column prop="planTime" label="计划时长" sortable width="120">
                </el-table-column>
                <el-table-column prop="todayNum" label="今日专注次数" sortable min-width="150">
                </el-table-column>
                <el-table-column prop="todayTime" label="今日专注时长" sortable min-width="180">
                </el-table-column>
                <el-table-column prop="totalNum" label="累计专注次数" sortable min-width="150">
                </el-table-column>
                <el-table-column prop="totalTime" label="累计专注时长" sortable min-width="180">
                </el-table-column>
                <el-table-column prop="createTime" label="创建时间" sortable min-width="200">
                </el-table-column>
                <el-table-column prop="updateTime" label="更新时间" sortable min-width="200">
                </el-table-column>
                <!-- <el-table-column prop="tx" label="是否提醒了" sortable width="120">
                </el-table-column> -->
                <!-- 操作 -->
                <el-table-column fixed="right" label="操作" width="156">
                    <template #default="scope">
                        <el-button type="danger" @click="deljh(scope.row)">删除</el-button>
                        <el-button type="primary" @click="tixing(scope.row)"
                            v-if="(scope.row.todayNum === 0 && 0 <= scope.row.todayTime <= 20) || 0 <= scope.row.todayTime <= 20">提醒</el-button>
                        <el-button type="primary" v-else disabled>提醒</el-button>
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
        </el-card>
    </el-main>
</template>

<script>
let userGroup = sessionStorage.getItem("userGroup")
let data = JSON.parse(sessionStorage.getItem("user"));
let seen = false;
if (userGroup === "管理员") {
    seen = true;
}
let username = sessionStorage.getItem("username")
import { ElMessage, ElMessageBox } from 'element-plus'
export default {
    data() {
        return {
            form: {
                username: '',
                plan_name: '',
            },
            list: [],
            count: '',
            pageNum: 1,
            pageSize: 5,
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
            this.axios.post('/studyPlan/xxjhList1', {
                pageNum: this.pageNum,
                pageSize: this.pageSize,
                param: {
                    username: this.form.username,
                    plan_name: this.form.plan_name,
                    userGroup:userGroup,
					academy:data[0]['faculties']
                }
            }).then(res => res.data).then(res => {
                console.log(res.data)
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
        }, shuaxin() {
            this.form.username = ''
            this.form.plan_name = ''
            this.axios.post('/studyPlan/xxjhList1', {
                pageNum: this.pageNum,
                pageSize: this.pageSize,
                param: {
                    username: this.form.username,
                    plan_name: this.form.plan_name,
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
        }, deljh(row) {
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
                    this.axios.post('/studyPlan/jsdeljh', {
                        studyPlanId: row1.studyPlanId,
                        username: username,
                        reusername: row1.username,
                        planName: row1.planName
                    })
                        .then(res => res.data).then(res => {
                            // console.log(res);
                            if (res.code == 200) {
                                this.$message({
                                    duration: 3000,
                                    offset: 50,
                                    message: '计划删除成功',
                                    type: 'success'
                                });
                                this.query();
                            } else {
                                this.$message({
                                    duration: 3000,
                                    offset: 50,
                                    message: '计划删除失败',
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
        }, tixing(row) {
            let row1 = JSON.parse(JSON.stringify(row));
            // setInterval(function () {
            //     row.tx= 0;
            // }, 1000*60*60*24);  
            // if (row.tx===0) {
            //     this.axios.post('/studyPlan/txxxjh', {
            //         username: username,
            //         reusername: row1.username,
            //         planName: row1.planName
            //     })
            //         .then(res => res.data).then(res => {
            //             console.log(res);
            //             if (res.code == 200) {
            //                 this.$message({
            //                     duration: 3000,
            //                     offset: 50,
            //                     message: '提醒成功',
            //                     type: 'success'
            //                 });
            //                 row.tx=1;
            //                 this.query();
            //             } else {
            //                 this.$message({
            //                     duration: 3000,
            //                     offset: 50,
            //                     message: '提醒失败',
            //                     type: 'error'
            //                 });
            //             }
            //         }
            //         )
            // } else {
            //     this.$message({
            //         duration: 3000,
            //         offset: 50,
            //         message: '提醒失败,一天只能提醒一次',
            //         type: 'error'
            //     });
            // }
            this.axios.post('/studyPlan/txxxjh', {
                username: username,
                reusername: row1.username,
                planName: row1.planName,
            })
                .then(res => res.data).then(res => {
                    console.log(res);
                    if (res.code == 200) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '提醒成功',
                            type: 'success'
                        });
                        this.query();
                    } else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '提醒失败',
                            type: 'error'
                        });
                    }
                })
        }
    }, beforeMount() {
        this.query()
    }
}
</script>

<style>
.el-pagination {
    margin-left: 230px;
    margin-top: 20px;
}

.plan_main {
    padding: 2rem 1rem;
    background-color: #eeeeee !important;
    width: 90%;
    margin: 0 auto;
}

h1 {
    text-align: center;
    margin-left: -100px;
    margin-top: -20px;
    margin-bottom: 20px;
    color: #00838F !important;
    font-weight: bold;
}

.search_btn_wrap {
    margin-bottom: 20px;
    /* padding-left: 100px; */
}

.el-form-item__label {
    color: #00838F !important;
}

.el-button--text {
    margin-right: 15px;
}

.el-input {
    width: 300px;
}

.dialog-footer button:first-child {
    margin-right: 10px;
}

.demo-date-picker {
    display: flex;
    width: 100%;
    padding: 0;
    flex-wrap: wrap;
}
</style>