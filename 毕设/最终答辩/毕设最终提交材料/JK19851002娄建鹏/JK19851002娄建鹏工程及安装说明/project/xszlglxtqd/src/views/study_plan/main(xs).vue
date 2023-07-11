<template>
    <el-main class="plan_main">
        <!-- <div class="tjxxjh">
            <img class="xxjht" src="../../../public/img/xxjh.png" @click="tjxxjh" />
            <p>点击图片添加学习计划</p>
        </div> -->
        <div class="tjxxjh">
            <el-carousel :interval="4000" type="card" height="200px">
                <el-carousel-item v-for="item in list" :key="item">
                    <img class="xxjht" :src="item" @click="tjxxjh" />
                </el-carousel-item>
            </el-carousel>
            <p>点击图片添加学习计划</p>
        </div>
        <div class="jhlb">
            <el-card class="box-card" shadow="hover" v-for="index in xxjhList" :key="index">
                <template #header>
                    <div class="card-header">
                        <span>{{ index.planName }}</span>
                        <span style="display: block;margin-top: 10px;">{{ index.planTime }}分钟</span>
                        <div class="sangeann">
                            <el-button class="start" @click="modplan(index)">编辑</el-button>
                            <el-button class="start shanchu" @click="delplan(index)">删除</el-button>
                            <el-button class="start" @click="start(index)">开始</el-button>
                        </div>
                    </div>
                </template>
                <div>
                    <el-button class="minddle" @click="zzlsjl(index)"><el-icon>
                            <Document style="color:#027cff;" />
                        </el-icon>
                        <p style="margin-left: 10px;">专注历史记录</p>
                    </el-button>
                    <el-button class="minddle" @click="xjtj(index)"><el-icon>
                            <PieChart style="color:#027cff" />
                        </el-icon>
                        <p style="margin-left: 10px;">数据统计</p>
                    </el-button>
                </div>
                <div class="footer">
                    <div>
                        <h5>累计专注</h5>
                    </div>
                    <el-form>
                        <el-form-item label="次数:" prop="username">
                            {{ index.totalNum }}
                        </el-form-item>
                        <el-form-item label="时长:" prop="user_group" style="margin-left: 50px;">
                            {{ index.totalTime }}分钟
                        </el-form-item>
                    </el-form>
                </div>
            </el-card>
        </div>
        <!--对话框-->
        <el-dialog title="编辑学习计划" v-model="centerDialogVisible" width="30%" center>
            <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                <el-form-item prop="planName" label-width="120px" label="学习计划名称" style="margin-top: 0px;">
                    <el-input v-model="form.planName" style="width: 250px" placeholder="请输入学习计划名称"></el-input>
                </el-form-item>
                <el-form-item prop="timeTrend" label="类型" style="margin-top: 0px;margin-left: -60px;">
                    <!-- <el-input v-model="form.timeTrend" style="width: 80%"></el-input> -->
                    <el-select v-model="form.timeTrend" placeholder="请选择类型">
                        <el-option :key="1" :value="'倒计时'" :label="'倒计时'"></el-option>
                        <el-option :key="2" :value="'正向计时'" :label="'正向计时'"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item prop="planTime" label="计时时长" style="margin-top: 0px;margin-left: -60px;">
                    <el-input v-model="form.planTime" placeholder="请输入计时时长" style="width: 250px"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer" style="margin-left: 120px;">
                <el-button @click="centerDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="submit()">确 定</el-button>
            </span>
        </el-dialog>
    </el-main>
</template>

<script setup>
import { PieChart, Document } from "@element-plus/icons-vue";
import router from "../../router";
const tjxxjh = () => {
    router.push('/study_plan/view1').then(() => {
        setTimeout(router.go(0), 0);
    });
}
// const zzlsjl = () => {
//     router.push('/');
// }
// const xjtj = () => {
//     router.push( {path: "/data_count/view", query:{studyPlanId:this.studyPlanId} }).then(() => {
// 				setTimeout(router.go(0), 0);
// 			});
// }
</script>
<script>
let username = sessionStorage.getItem("username")
import { ElMessage, ElMessageBox } from 'element-plus';
export default {
    name: 'planMain',
    data() {
        //检查计划时长
        let checkTime = (rule, value, callback) => {
            if (this.form.planTime > 180) {
                callback(new Error('计划时间不能超过180分钟'));
            } else if (this.form.planTime <= 0) {
                callback(new Error('计划时间不能低于1分钟'));
            }
            else {
                callback();
            }
        };
        //查重名
        let checkplanname = (rule, value, callback) => {
            this.axios.get('/studyPlan/findplanname?username=' + username + '&planName=' + this.form.planName)
                .then(res => {
                    // console.log(res)
                    if (res.data.code == 200) {
                        callback();
                    } else {
                        callback(new Error('该计划名称已存在'));
                    }
                })
        };
        return {
            list: [],
            pg1: require("../../../public/img/xxjh.png"),
            pg2: require("../../../public/img/xxjh2.jpg"),
            pg3: require("../../../public/img/xxjh3.jpg"),
            pg4: require("../../../public/img/xxjh4.jpg"),
            xxjhList: [],
            centerDialogVisible: false,
            studyPlanId: '',
            form: {
                planName: '',
                timeTrend: '倒计时',
                planTime: '',
            },
            rules: {//校验
                planName: [{ required: true, message: '请输入学习计划名称', trigger: 'blur' },
                { validator: checkplanname, trigger: 'blur' }
                ],
                timeTrend: [{ required: true, message: '请输入计划方向类型', trigger: 'change' },
                ],
                planTime: [{ required: true, message: '请输入计时时长', trigger: 'blur' },
                { pattern: /^[0-9]+$/, message: '请输入数字', trigger: 'blur' },
                { validator: checkTime, trigger: 'blur' }
                ],
            },
        }
    }, methods: {
        getList() {
            this.list.push(this.pg1, this.pg2, this.pg3, this.pg4);
        }, xianshi() {
            this.axios.post("/studyPlan/xxjhList", {
                username: username
            })
                .then(res => res.data).then(res => {
                    if (200 <= res.code&& res.code<= 210) {
                        console.log(res.data)
                        this.xxjhList = res.data;
                    }
                    // if (res.code == 200) {
                    //     console.log(res.data)
                    //     this.xxjhList = res.data;
                    // }else if (res.code == 201) {
                    //     this.xxjhList = res.data;
                    // }else if (res.code == 202) {
                    //     this.xxjhList = res.data;
                    // }else if (res.code == 203) {
                    //     this.xxjhList = res.data;
                    // }else if (res.code == 204) {
                    //     this.xxjhList = res.data;
                    // }else if (res.code == 205) {
                    //     this.xxjhList = res.data;
                    // }else if (res.code == 206) {
                    //     this.xxjhList = res.data;
                    // }else if (res.code == 207) {
                    //     this.xxjhList = res.data;
                    // }else if (res.code == 208) {
                    //     this.xxjhList = res.data;
                    // }else if (res.code == 209) {
                    //     this.xxjhList = res.data;
                    // }else if (res.code == 210) {
                    //     this.xxjhList = res.data;
                    // }
                    else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '数据查询失败',
                            type: 'error'
                        });
                    }
                })
        }, submit() {
            this.axios.post('/studyPlan/modplan', {
                studyPlanId: this.studyPlanId,
                planName: this.form.planName,
                timeTrend: this.form.timeTrend,
                planTime: this.form.planTime
            })
                .then(res => res.data).then(res => {
                    // console.log(res);
                    if (res.code == 200) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '计划修改成功',
                            type: 'success'
                        });
                        this.centerDialogVisible = false;
                        this.xianshi();
                    } else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '计划修改失败',
                            type: 'error'
                        });
                        this.centerDialogVisible = false;
                    }
                }
                )
        }, modplan(index) {
            // console.log(index);
            let index1 = JSON.parse(JSON.stringify(index));
            // console.log(index1);
            this.form.planName = index1.planName;
            this.form.timeTrend = index1.timeTrend;
            this.form.planTime = index1.planTime;
            this.studyPlanId = index1.studyPlanId;
            this.centerDialogVisible = true;
        }, delplan(index) {
            let index1 = JSON.parse(JSON.stringify(index));
            this.studyPlanId = index1.studyPlanId;
            ElMessageBox.confirm(
                '是否确认删除该计划',
                '注意',
                {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning',
                }
            )
                .then(() => {
                    this.axios.post('/studyPlan/delplan', {
                        studyPlanId: this.studyPlanId,
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
                                this.xianshi();
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
        }, start(index) {
            let index1 = JSON.parse(JSON.stringify(index));
            this.studyPlanId = index1.studyPlanId;
            router.push({ path: "/time/main", query: { studyPlanId: this.studyPlanId } }).then(() => {
                setTimeout(router.go(0), 0);
            });
        }, xjtj(index) {
            let index1 = JSON.parse(JSON.stringify(index));
            this.studyPlanId = index1.studyPlanId;
            router.push({ path: "/data_count/view1", query: { studyPlanId: this.studyPlanId, planName: index1.planName } }).then(() => {
                setTimeout(router.go(0), 0);
            });
        },zzlsjl(index){
            let index1 = JSON.parse(JSON.stringify(index));
            this.planName = index1.planName;
            router.push({ path: "/experience/main1", query: {planName: index1.planName } }).then(() => {
                setTimeout(router.go(0), 0);
            });
        }
    }, beforeMount() {
        this.getList();
        this.xianshi();
    }
}
</script>
<style>
.jhlb {
    /* margin-left: 5px; */
    /* margin-right: 5px; */
    display: flex;
    flex-wrap: wrap;
    justify-content: space-evenly;
    align-items: space-evenly;
}

.el-form-item__content {
    font-size: 20px;
}

.el-card {
    width: 500px;
    margin-top: 20px;
    margin-bottom: 20px;
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
}

.minddle {
    width: 224px;
    height: 50px;
    font-weight: 700;
    border-radius: 20px 20px;
    color: #027cff;
    background-color: rgb(193, 231, 255);
}

.minddle:hover {
    color: #027cff;
    background-color: rgb(193, 231, 255);
}

.footer {
    height: 100px;
    margin-top: 10px;
    border-radius: 20px 20px;
    color: #027cff;
    background-color: rgb(193, 231, 255);
    display: flex;
}

h5 {
    padding-top: 10px;
    padding-left: 10px;
}

.el-form-item {
    float: left;
    margin-top: 50px;
    margin-left: -100px;
}

.el-form-item__label {
    color: #027cff;
    /* font-size: x-small; */
}

.el-dialog__title {
    color: #00838F;
    /* margin-left: 300px; */
}

.el-form {
    margin-left: 100px;
}

.el-input {
    width: 250px;
}

.plan_main {
    padding: 2rem 1rem;
    background-color: #eeeeee !important;
    width: 70%;
    margin: 0 auto;
    padding: 0;
}

.tjxxjh p {
    display: none;
    margin: auto;
    position: absolute;
    top: 208px;
    left: 493px;
    background-color: rgba(111, 109, 109, 0.5);
    width: 533px;
    height: 50px;
    text-align: center;
    padding-top: 3px;
    color: #fff;
    font-size: xx-large;
    z-index: 999;
}

.tjxxjh:hover p {
    display: block;
}

.xxjht {
    width: 600px;
    display: block;
    margin: auto;
    height: 200px;
    /* margin-top: -70px; */
}

.search_btn_wrap {
    margin-bottom: 20px;
    /* padding-left: 100px; */
}

.el-button--text {
    margin-right: 15px;
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