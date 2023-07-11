<template>
    <div class="book">
        <el-card class="card">
            <div class="zxskp" v-for="index in list" :key="index">
                <div>
                    <div style="font-size: 18px;width: 800px;font-weight: 600;">{{ index.roomName }}(加入码 {{ index.code }})
                    </div>
                    <div style="width: 800px;margin-top: 10px;">{{ index.roomIntroduce }}</div>
                    <el-button v-if="index.password != 'd41d8cd98f00b204e9800998ecf8427e'" class="xymm">需要密码</el-button>
                    <el-button class="jrrs">{{ index.joinNum }}人</el-button>
                    <el-button class="xdrs">限定{{ index.limitNum }}人</el-button>
                </div>
                <div style="font-size: 20px;font-weight: 600;">共{{length}}个文件</div>
            </div>
        </el-card>
        <div class="load">
            <div class="query">
                <el-form :inline="true" :model="form" class="demo-form-inline">
                    <el-form-item label="文件名称">
                        <el-input v-model="form.document" placeholder="请输入文件名称进行查询" @keyup.enter.native="query()" />
                    </el-form-item>
                    <el-form-item label="文件类型">
                        <el-input v-model="form.type" placeholder="请输入文件类型进行查询" @keyup.enter.native="query()" />
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="query()">查询</el-button>
                        <el-button type="primary" @click="shuaxin()">重置</el-button>
                    </el-form-item>
                    <el-form-item>
                        <el-upload v-model:file-list="fileList" class="upload-demo" :show-file-list="false"
                            action="http://localhost:8080/upload/document">
                            <template #trigger>
                                <el-button type="primary" @click="touxiang">+ 上传</el-button>
                            </template>
                        </el-upload>
                    </el-form-item>
                </el-form>
            </div>
            <el-table :data="tableData" style="width: 100%;">
                <el-table-column prop="name" label="文件" width="400"></el-table-column>
                <el-table-column prop="createTime" label="发布时间" width="120"></el-table-column>
                <el-table-column prop="time" label="过期时间" width="60">永久</el-table-column>
                <el-table-column prop="docSize" label="大小" width="80">
                    <template #default="scope">
                        <div v-if="(scope.row.docSize / 1024) < 1">{{ scope.row.docSize }}B</div>
                        <!-- <div v-else-if="(scope.row.docSize/(1024*1024))<1">{{ Math.ceil(scope.row.docSize/(1024)).toFixed(2) }}KB</div> -->
                        <div v-else-if="(scope.row.docSize / (1024 * 1024)) < 1">
                            {{ ((scope.row.docSize / (1024)) % 1024).toFixed(2) }}KB</div>
                        <div v-else-if="(scope.row.docSize / (1024 * 1024 * 1024)) < 1">{{
                            ((scope.row.docSize / (1024 * 1024)) % 1024).toFixed(2) }}MB</div>
                        <div v-else>{{ ((scope.row.docSize / (1024 * 1024 * 1024)) % 1024).toFixed(2) }}GB</div>
                    </template>
                </el-table-column>
                <el-table-column prop="username" label="上传者" width="110"></el-table-column>
                <el-table-column prop="downloadNum" label="下载次数" width="60"></el-table-column>
                <el-table-column prop="download" label="下载" width="84">
                    <template #default="scope">
                        <el-button type="primary" @click="download(scope.row)">下载</el-button>
                    </template>
                </el-table-column>
                <el-table-column prop="del" label="删除" width="84">
                    <template #default="scope">
                        <el-button type="danger" v-if="homeOwner === username || scope.row.username === username"
                            @click="delDoc(scope.row)">删除</el-button>
                        <el-button type="danger" v-else disabled>删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            
            <div v-if="length <= 1" style="height: 363px;"></div>
            <div v-else-if="length == 2" style="height: 325px;"></div>
            <div v-else-if="length == 3" style="height: 276px;"></div>
            <div v-else-if="length == 4" style="height: 227px;"></div>
            <div v-else-if="length == 5" style="height: 178px;"></div>
            <div v-else-if="length == 6" style="height: 130px;"></div>
            <div v-else-if="length == 7" style="height: 81px;"></div>
            <div v-else-if="length == 8" style="height: 32px;"></div>
        </div>
    </div>
</template>

<script>
let username = sessionStorage.getItem("username");
import { ElMessage, ElMessageBox } from 'element-plus';
export default {
    data() {
        return {
            list: [],
            homeOwner: '',
            username: username,
            length: 0,
            form: {
                type: '',
                document: ''
            },
            tuPianUrl: "http://localhost:8080",
            tableData: [],
        }
    },
    methods: {
        xianshi() {
            this.axios.post("/studyRoom/selectRoomId1", {
                username: username,
            })
                .then(res => res.data).then(res => {
                    console.log(res.data);
                    if (res.code == 200) {
                        this.list = res.data;
                        this.homeOwner = res.data[0]['homeowner'];
                    }
                    else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: "数据查询失败",
                            type: "error"
                        });
                        router.push("/study_room/main1").then(() => {
                            setTimeout(router.go(0), 0);
                        });
                    }
                });
        }, touxiang() {
            this.axios.post('/upload/avatar1', {
                username: username,
                id: this.list[0]['studyRoomId']
            })
                .then(res => res.data).then(res => {
                    if (res.code === 200) {
                        let time = 0;
                        const aaa = setInterval(() => {
                            time++;
                            if (time === 5) {
                                router.go(0)
                                clearInterval(aaa);
                            }
                        }, 2000);
                    }
                }
                )
        }, query() {
            this.axios.post("/studyRoom/selectDow", {
                type: this.form.type,
                document: this.form.document,
                username: username,
            })
                .then(res => res.data).then(res => {
                    console.log(res.data);
                    if (res.code == 200) {
                        this.tableData = res.data;
                        this.length = this.tableData.length
                        // console.log(this.tableData.length)
                    }
                    else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: "数据查询失败",
                            type: "error"
                        });
                    }
                });
        }, shuaxin() {
            this.form.type = '';
            this.form.document = '';
            this.axios.post("/studyRoom/selectDow", {
                type: this.form.type,
                document: this.form.document,
                username: username,
            })
                .then(res => res.data).then(res => {
                    console.log(res.data);
                    if (res.code == 200) {
                        this.tableData = res.data;
                        this.length = this.tableData.length
                    }
                    else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: "数据查询失败",
                            type: "error"
                        });
                    }
                });
        }, download(row) {
            let row1 = JSON.parse(JSON.stringify(row));
            window.open(this.tuPianUrl+"/upload/"+row1.uploadId);
        }, delDoc(row) {
            let row1 = JSON.parse(JSON.stringify(row));
            ElMessageBox.confirm(
                '是否确认删除该资料',
                '提示',
                {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning',
                }
            )
                .then(() => {
                    this.axios.post('/studyRoom/delDoc', {
                        id: row1.uploadId
                    })
                        .then(res => res.data).then(res => {
                            if (res.code === 200) {
                                this.$message({
                                    duration: 3000,
                                    offset: 50,
                                    message: "资料删除成功",
                                    type: "success"
                                });
                                this.query();
                            } else {
                                this.$message({
                                    duration: 3000,
                                    offset: 50,
                                    message: "资料删除失败",
                                    type: "error"
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
        }
    }, beforeMount() {
        this.xianshi();
        this.query();
    }
}
</script>

<style>
.book {
    padding: 2rem 1rem;
    background-color: #eeeeee !important;
    width: 70%;
    margin: 0 auto;
    padding: 0;
}

.el-form-item__label {
    color: #00838F !important;
}

.card {
    width: 1000px;
    margin: auto;
}

.zxskp {
    display: flex;
    align-items: center;
}

.xymm {
    /* width: 65px; */
    margin-top: 10px;
    height: 20px;
    font-size: 10px;
    background-color: rgb(231, 208, 253);
    color: #7b0490;
}

.jrrs {
    height: 20px;
    margin-top: 10px;
    font-size: 10px;
    background-color: rgb(253, 214, 187);
    color: #ff7300;
}

.xdrs {
    height: 20px;
    margin-top: 10px;
    font-size: 10px;
    background-color: rgb(255, 220, 195);
    color: #ff7300;
}

.load {
    width: 1000px;
    margin: auto;
    background-color: #ffffff;
}

.query {
    padding-top: 20px;
    padding-left: 20px;
    border-bottom: solid 2px #eee;
}</style>