<template>
    <div class="room_main">
        <h1>自习室信息页面</h1>
        <el-form :inline="true" :model="form" class="demo-form-inline">
            <el-form-item label="自习室名称">
                <el-input v-model="form.roomName" placeholder="请输入自习室名称进行查询" @keyup.enter.native="query()" />
            </el-form-item>
            <el-form-item label="类型">
                <!-- <el-input v-model="form.type" placeholder="请选择类型进行查询" @keyup.enter.native="query()" /> -->
                <el-select v-model="form.type" placeholder="请选择类型进行查询">
                    <el-option v-for="o in list_type" :key="o" :label="o" :value="o">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="query()">查询</el-button>
                <el-button type="primary" @click="shuaxin()">重置</el-button>
            </el-form-item>
        </el-form>
        <el-table border :data="list" style="width: 100%" stripe>
            <el-table-column fixed prop="roomName" label="自习室名称" sortable width="180">
            </el-table-column>
            <el-table-column prop="roomIntroduce" label="自习室简介" sortable width="400">
            </el-table-column>
            <el-table-column prop="type" label="类型" sortable min-width="80">
            </el-table-column>
            <el-table-column prop="code" label="加入码" sortable min-width="100">
            </el-table-column>
            <el-table-column prop="password" label="是否要密码" sortable min-width="120">
                <template #default="scope">
                    <div v-if="scope.row.password != 'd41d8cd98f00b204e9800998ecf8427e'">是</div>
                    <div v-else>否</div>
                </template>
            </el-table-column>
            <el-table-column prop="joinNum" label="现有人数" sortable min-width="110">
            </el-table-column>
            <el-table-column prop="limitNum" label="限制人数" sortable min-width="110">
            </el-table-column>
            <el-table-column sortable prop="createTime" label="创建时间" min-width="180">
            </el-table-column>
            <el-table-column sortable prop="updateTime" label="更新时间" min-width="180">
            </el-table-column>
            <!-- 操作 -->
            <el-table-column fixed="right" label="操作" width="168">
                <template #default="scope">
                    <el-button type="primary" @click="xiangqing(scope.row)">详情</el-button>
                    <el-button type="danger" @click="delzxs(scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <!-- 分页器 -->
        <div>
            <el-pagination v-model:current-page="pageNum" v-model:page-size="pageSize" :page-sizes="[5, 10, 15, 20]"
                layout="total, sizes, prev, pager, next, jumper" :total="count" @size-change="handleSizeChange"
                @current-change="handleCurrentChange" />
        </div>
        <!--对话框-->
        <el-dialog title="选项" v-model="centerDialogVisible" width="50%" center>
            <div class="jr" @click="seenPeople()">查看该自习室成员</div>
            <div class="jr" @click="seenBook()">查看该自习室分享的资料</div>
            <div class="jr" @click="seenWt()">查看该自习室发布的问题</div>
            <div class="jr" @click="centerDialogVisible = false">取消</div>
        </el-dialog>
    </div>
</template>
<script>
let username = sessionStorage.getItem("username");
import { ElMessage, ElMessageBox } from 'element-plus';
import router from '../../router';
export default {
    data() {
        return {
            form: {
                roomName: '',
                type: ''
            },
            centerDialogVisible: false,
            studyRoomId: 0,
            list: [],
            list_type: ['公开', '不公开'],
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
            this.axios.post('/studyRoom/jszxslist', {
                pageNum: this.pageNum,
                pageSize: this.pageSize,
                param: {
                    type: this.form.type,
                    roomName: this.form.roomName,
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
            this.form.type = '';
            this.form.roomName = '';
            this.axios.post('/studyRoom/jszxslist', {
                pageNum: this.pageNum,
                pageSize: this.pageSize,
                param: {
                    type: this.form.type,
                    roomName: this.form.roomName,
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
        }, delzxs(row) {
            let row1 = JSON.parse(JSON.stringify(row));
            ElMessageBox.confirm(
                '是否确认删除该自习室',
                '提示',
                {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning',
                }
            )
                .then(() => {
                    this.axios.post('/studyRoom/jsjiesan', {
                        username: username,
                        id: row1.studyRoomId,
                        roomName: row1.roomName,
                    }).then(res => res.data).then(res => {
                        if (res.code == 200) {
                            this.$message({
                                duration: 3000,
                                offset: 50,
                                message: '自习室删除成功',
                                type: 'success'
                            });
                            this.query();
                        } else {
                            return this.$message({
                                duration: 3000,
                                offset: 50,
                                message: '自习室删除失败',
                                type: 'error'
                            });
                        }
                    })
                })
                .catch(() => {
                    ElMessage({
                        type: 'info',
                        duration: 3000,
                        offset: 50,
                        message: '已取消删除',
                    })
                })
        }, xiangqing(row) {
            let row1 = JSON.parse(JSON.stringify(row));
            this.studyRoomId = row1.studyRoomId;
            this.centerDialogVisible = true;
        }, seenPeople() {
            this.centerDialogVisible = false;
            router.push( {path: "/study_room/view", query:{studyRoomId:this.studyRoomId} }).then(() => {
				setTimeout(router.go(0), 0);
			});
        },seenBook(){
            this.centerDialogVisible = false;
            router.push( {path: "/study_room/book", query:{studyRoomId:this.studyRoomId} }).then(() => {
				setTimeout(router.go(0), 0);
			});
        },seenWt(){
            this.centerDialogVisible = false;
            router.push( {path: "/study_room/question", query:{studyRoomId:this.studyRoomId} }).then(() => {
				setTimeout(router.go(0), 0);
			});
        }
    }, beforeMount() {
        this.query()
    }
}
</script>

<style>
.room_main {
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
.el-pagination {
    margin-left: 330px;
    margin-top: 20px;
}

.el-form-item__label {
    color: #00838F !important;
}

.jr {
    text-align: center;
    font-size: 20px;
    font-weight: 800;
    margin-top: 10px;
    padding-top: 20px;
    width: 100%;
    height: 40px;
    cursor: pointer;
    background-color: #78dbf9;
}
</style>