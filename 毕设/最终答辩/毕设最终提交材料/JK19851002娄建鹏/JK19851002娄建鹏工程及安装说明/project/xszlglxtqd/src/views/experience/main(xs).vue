<template>
    <div class="xd">
        <div style="margin-top: -30px;">
            <el-button type="primary" style="margin-left: 500px;" @click="fhui()" v-if="planName!=undefined">返回</el-button>
            <el-calendar v-model="value" @Click="xianshi()" :time-zone="timeZone"/>
        </div>
        <div class="jhlb" v-if="JSON.parse(JSON.stringify(this.xdList)).length !== 0">
            <el-card class="box-card" shadow="hover" v-for="index in xdList" :key="index">
                <template #header>
                    <div class="card-header">
                        <span>{{ index.planName }}</span>
                        <div class="sangeann">
                            <el-button class="start" @click="fxxd(index)">分享</el-button>
                            <el-button class="start shanchu" @click="delxd(index)">删除</el-button>
                        </div>
                    </div>
                </template>
                <div class="minddle" @click="modxd(index)">
                    <div class="minddle1">
                        <div v-if="index.content != ''" style="text-align: center;">{{ index.content }}</div>
                        <div v-else style="text-align: center;">点击填写心得</div>
                    </div>
                </div>
                <div class="footer">
                    <div class="footer1">开始时间
                        <span class="footer2">{{ index.startTime }}</span>
                    </div>
                    <div class="footer1">结束时间
                        <span class="footer2">{{ index.endTime }}</span>
                    </div>
                    <div class="footer1">专注时长
                        <span class="footer2">
                            <div
                                v-if="parseInt((new Date(index.endTime) - new Date(index.startTime)) / (1000 * 60 * 60)) != 0">
                                {{ parseInt((new Date(index.endTime) - new Date(index.startTime)) / (1000 * 60 * 60)) }}小时
                                {{ parseInt((new Date(index.endTime) - new Date(index.startTime)) / (1000 * 60) % 60) }}分钟
                            </div>
                            <div v-else>{{ Math.round((new Date(index.endTime) - new Date(index.startTime)) / (1000 * 60))
                            }}分钟
                            </div>
                        </span>
                    </div>
                    <div class="footer1">计时状态
                        <span class="footer2">已完成</span>
                    </div>
                </div>
            </el-card>
        </div>
        <div v-else class="myxx">今日还没有学习</div>
        <!--对话框-->
        <el-dialog title="心得修改" v-model="centerDialogVisible" width="30%" center>
            <el-input v-model="textarea" :rows="15" type="textarea" placeholder="请输入心得" />
            <span style="margin-left: 120px;display: block;margin-top: 20px;">
                <el-button @click="centerDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="submit1()">确 定</el-button>
            </span>
        </el-dialog>
        <!-- --对话框-- -->
        <el-dialog title="心得分享" v-model="centerDialogVisible2" width="50%" center>
            <el-form ref="form1" :model="form1" :rules="rules" label-width="80px">
                <el-form-item label="接收方" prop="reusername">
                    <el-select v-model="form1.reusername" filterable placeholder="请选择或输入你想给谁分享的用户名" allow-create style="width: 1000px;">
                        <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                        </el-option>
                    </el-select>
                    <!-- <el-cascader :options="options" v-model="form1.reusername" :show-all-levels="false" placeholder="请选择接收方"
                        style="width: 1000px;" /> -->
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer" style="margin-left: 285px;">
                <el-button @click="centerDialogVisible2 = false">取 消</el-button>
                <el-button type="primary" @click="submit()">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import { ElMessage, ElMessageBox } from 'element-plus'
let username = sessionStorage.getItem("username")
let data = JSON.parse(sessionStorage.getItem("user"))
import router from "../../router"
// console.log(data)
export default{
    data() {
        return {
            planName: this.$route.query.planName,
            value: new Date(),
            xdList: [],
            centerDialogVisible: false,
            centerDialogVisible2: false,
            textarea: '',
            experienceId: '',
            //级联选择器
            options: [],
            form1: {
                planName: '',
                reusername: '',
                textarea: ''
            },
            timeZone: 'Asia/Shanghai', // 设置时区
        }
    }, methods: {
        xianshi() {
            if (this.planName===undefined) {
                this.axios.post("/experience/xdList", {
                    username: username,
                    value: this.value
                })
                    .then(res => res.data).then(res => {
                        if (res.code == 200) {
                            // console.log(res.data)
                            // console.log(JSON.parse(JSON.stringify(this.xdList)))
                            // console.log(this.value);
                            this.xdList = res.data;
                        } else {
                            this.$message({
                                duration: 3000,
                                offset: 50,
                                message: '数据查询失败',
                                type: 'error'
                            });
                        }
                    })
            }else{
                this.axios.post("/experience/xdList2", {
                username: username,
                value: this.value,
                planName:this.planName
            })
                .then(res => res.data).then(res => {
                    if (res.code == 200) {
                        this.xdList = res.data;
                    } else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '数据查询失败',
                            type: 'error'
                        });
                    }
                })
            }
        }, modxd(index) {
            let index1 = JSON.parse(JSON.stringify(index));
            this.textarea = index1.content;
            this.experienceId = index1.experienceId;
            this.centerDialogVisible = true;
        }, submit1() {
            this.axios.post('/experience/modxd', {
                experienceId: this.experienceId,
                textarea: this.textarea,
            })
                .then(res => res.data).then(res => {
                    // console.log(res);
                    if (res.code == 200) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '心得修改成功',
                            type: 'success'
                        });
                        this.centerDialogVisible = false;
                        this.xianshi();
                    } else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '心得修改失败',
                            type: 'error'
                        });
                        this.centerDialogVisible = false;
                    }
                })
        }, delxd(index) {
            let index1 = JSON.parse(JSON.stringify(index));
            this.experienceId = index1.experienceId;
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
                    this.axios.post('/experience/delxd', {
                        experienceId: this.experienceId,
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
        }, fxxd(index) {
            let index1 = JSON.parse(JSON.stringify(index));
            if (index1.content != "") {
                this.centerDialogVisible2 = true;
                this.form1.textarea = index1.content,
                this.form1.planName = index1.planName
                this.$nextTick(() => {
                    this.$refs.form1.resetFields(); //刷新
                })
            } else {
                this.$message({
                    duration: 3000,
                    offset: 50,
                    message: '请先填写心得在进行分享！',
                    type: 'error'
                });
            }
        }, xianshi1() {
            this.options = [
                {
                    value: data[0]['className'], label: data[0]['className']
                },
                {
                    value: data[0]['major'], label: data[0]['major']
                },
                {
                    value: data[0]['academy'], label: data[0]['academy']
                }, {
                    value: '学校', label: '学校'
                }
            ]
            // this.axios.get("/notice/username")
            //     .then(res => res.data).then(res => {
            //         if (res.code == 200) {
            //             // console.log(res.data)
            //             this.options = res.data;
            //             // console.log(this.options[0].children)
            //         } else {
            //             this.$message({
            //                 duration: 3000,
            //                 offset: 50,
            //                 message: '数据查询失败',
            //                 type: 'error'
            //             });
            //         }
            //     })
        }, submit() {
            this.axios.post('/experience/fxxd', {
                username: username,
                planName: this.form1.planName,
                reusername: this.form1.reusername,
                textarea: this.form1.textarea
            })
                .then(res => res.data).then(res => {
                    // console.log(res);
                    if (res.code == 200) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '心得分享成功',
                            type: 'success'
                        });
                        this.xianshi();
                        this.centerDialogVisible2 = false;
                    } else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '心得分享失败',
                            type: 'error'
                        });
                        this.centerDialogVisible2 = false;
                    }
                }
                )
        },fhui(){
            router.push("/study_plan/main1").then(() => {
                setTimeout(router.go(0), 0);
            });
        }
    }, beforeMount() {
        this.xianshi();
        this.xianshi1();
    }
}
</script>

<style>
.xd {
    padding: 2rem 1rem;
    background-color: #eeeeee !important;
    width: 70%;
    margin: 0 auto;
}

.jhlb {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-evenly;
    align-items: space-evenly;
}

.el-form-item__content {
    font-size: 20px;
}

.el-card {
    width: 1200px;
    margin-top: 20px;
    margin-bottom: 10px;
}

.myxx {
    text-align: center;
    margin-top: 10px;
    width: 100%;
    height: 100px;
    padding-top: 50px;
    font-size: 30px;
    background-color: #fff;
}

.start {
    margin-top: -60px;
    margin-left: 20px;
    border-radius: 30%;
    font-weight: 700;
    /* 字变斜 */
    font-style: oblique;
    color: #027cff;
    background-color: rgb(193, 231, 255);
}

.start:hover {
    margin-top: -60px;
    margin-left: 20px;
    border-radius: 30%;
    font-weight: 700;
    /* 字变斜 */
    font-style: oblique;
    color: #027cff;
    background-color: rgb(193, 231, 255);
}

.shanchu {
    font-weight: 700;
    color: #fb0000;
    background-color: rgb(247, 179, 179);
}

.shanchu:hover {
    font-weight: 700;
    color: #fb0000;
    background-color: rgb(247, 179, 179);
}

.sangeann {
    float: right;
    display: block;
    margin-top: 30px;
}

.minddle {
    width: 100%;
    border-radius: 20px 20px;
    color: #000000;
    background-color: rgb(193, 231, 255);
}

.minddle1 {
    margin-left: 20px;
    margin-right: 20px;
    padding-top: 7px;
    padding-bottom: 7px;
}

.footer {
    height: 120px;
    margin-top: 10px;
    border-radius: 20px 20px;
    color: #000000;
    background-color: rgb(193, 231, 255);
}

.footer1 {
    margin-left: 20px;
    padding-top: 7px;
}

.footer2 {
    float: right;
    margin-right: 20px;
}

.el-dialog__title {
    color: #00838F;
    /* margin-left: 300px; */
}
</style>