<template>
    <el-main class="plan_main">
        <h1>学生目标信息页面</h1>
        <el-card class="box-card">
            <el-form :inline="true" :model="form" class="demo-form-inline">
                <el-form-item label="用户名">
                    <el-input v-model="form.username" placeholder="请输入用户名进行查询" @keyup.enter.native="query()" />
                </el-form-item>
                <el-form-item label="目标名称">
                    <el-input v-model="form.goal_name" placeholder="请输入计划名称进行查询" @keyup.enter.native="query()" />
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
                <el-table-column prop="goalName" label="未来目标名称" sortable width="150">
                </el-table-column>
                <el-table-column prop="goalDescribe" label="未来目标描述" sortable width="200">
                </el-table-column>
                <el-table-column prop="endTime" label="截止日期" sortable width="200">
                </el-table-column>
                <el-table-column prop="createTime" label="创建时间" min-width="200">
                </el-table-column>
                <el-table-column prop="updateTime" label="更新时间" min-width="200">
                </el-table-column>
                <!-- 操作 -->
                <el-table-column fixed="right" label="操作" width="156">
                    <template #default="scope">
                        <el-button type="danger" @click="delmb(scope.row)">删除</el-button>
                        <el-button type="primary" @click="jili(scope.row)">激励</el-button>
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
                goal_name: '',
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
            this.axios.post('/goalPlan/wlmbList1', {
                pageNum: this.pageNum,
                pageSize: this.pageSize,
                param: {
                    username: this.form.username,
                    goal_name: this.form.goal_name,
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
        }, shuaxin() {
            this.form.username = ''
            this.form.goal_name = ''
            this.axios.post('/goalPlan/wlmbList1', {
                pageNum: this.pageNum,
                pageSize: this.pageSize,
                param: {
                    username: this.form.username,
                    goal_name: this.form.goal_name,
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
        }, delmb(row) {
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
                    this.axios.post('/goalPlan/jsdelmb', {
                        goalPlanId: row1.goalPlanId,
                        username: username,
                        reusername: row1.username,
                        goalName: row1.goalName
                    })
                        .then(res => res.data).then(res => {
                            // console.log(res);
                            if (res.code == 200) {
                                this.$message({
                                    duration: 3000,
                                    offset: 50,
                                    message: '目标删除成功',
                                    type: 'success'
                                });
                                this.query();
                            } else {
                                this.$message({
                                    duration: 3000,
                                    offset: 50,
                                    message: '目标删除失败',
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
        }, jili(row) {
            let row1 = JSON.parse(JSON.stringify(row));
            this.axios.post('/goalPlan/jili', {
                username: username,
                reusername: row1.username,
                goalName: row1.goalName,
                endTime:row1.endTime
            })
                .then(res => res.data).then(res => {
                    // console.log(res);
                    if (res.code == 200) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '激励成功',
                            type: 'success'
                        });
                        this.query();
                    } else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '激励失败',
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
h1{
    text-align: center;
    margin-left: -100px;
    margin-top: -20px;
    margin-bottom: 20px;
    color: #00838F !important;
    font-weight:bold;
}
.plan_main {
    padding: 2rem 1rem;
    background-color: #eeeeee !important;
    width: 90%;
    margin: 0 auto;
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