<template>
    <div class="header">
        <el-menu :default-active="study_plan / main1" mode="horizontal" @select="handleSelect"
            style="background-color: #00838F;">
            <div class="action_center">欢迎使用学生自我管理系统</div>
            <div class="biaoti zuoyi">
                <el-menu-item index="study_plan/main1" @click="menu1"><el-icon>
                        <EditPen style="color:#fff" />
                    </el-icon>
                    <p>学习计划</p>
                </el-menu-item>
            </div>
            <div class="biaoti">
                <el-menu-item index="goal_plan/main1" @click="menu1"><el-icon>
                        <Flag style="color:#fff" />
                    </el-icon>
                    <p>未来目标</p>
                </el-menu-item>
            </div>
            <div class="biao">
                <el-dropdown @command="command">
                    <div>
                        <el-icon :size="20">
                            <Document />
                        </el-icon>
                        <p>心得管理</p>
                    </div>
                    <template #dropdown>
                        <el-dropdown-menu>
                            <el-dropdown-item command="experience/main1">心得记录</el-dropdown-item>
                            <el-dropdown-item command="experience/view1">心得社区</el-dropdown-item>
                        </el-dropdown-menu>
                    </template>
                </el-dropdown>
            </div>
            <div class="biaoti">
                <el-menu-item index="notice/main1" @click="menu1"><el-icon>
                        <Message style="color:#fff" />
                    </el-icon>
                    <p>我的通知</p>
                </el-menu-item>
            </div>
            <div class="biao">
                <el-dropdown @command="command">
                    <div>
                        <el-icon :size="20">
                            <House />
                        </el-icon>
                        <p>自习教室</p>
                    </div>
                    <template #dropdown>
                        <el-dropdown-menu>
                            <el-dropdown-item command="study_room/main1">自习室</el-dropdown-item>
                            <el-dropdown-item command="study_room/book1">资料分享</el-dropdown-item>
                            <el-dropdown-item command="study_room/question1">问题解答</el-dropdown-item>
                        </el-dropdown-menu>
                    </template>
                </el-dropdown>
            </div>
            <div class="biaoti">
                <el-menu-item index="data_count/view1" @click="menu1"><el-icon>
                        <PieChart style="color:#fff" />
                    </el-icon>
                    <p>数据统计</p>
                </el-menu-item>
            </div>
            <div class="daika">
                <el-dropdown>
                    <el-icon :size="30">
                        <AlarmClock />
                    </el-icon>
                    <template #dropdown>
                        <el-dropdown-menu>
                            <el-dropdown-item @click="upclock()">早起打卡</el-dropdown-item>
                            <el-dropdown-item @click="sleepclock()">睡觉打卡</el-dropdown-item>
                        </el-dropdown-menu>
                    </template>
                </el-dropdown>
            </div>
            <div class="cjan" @click="cjan">
                <el-icon :size="30">
                    <Trophy />
                </el-icon>
            </div>
            <div class="action_right">
                <el-dropdown index="5" @command="command">
                    <div class="el-dropdown-link" style="margin-right: 2rem;">
                        <el-avatar style="overflow: hidden;">
                            <img v-if="seen" :src="tuPianUrl + avatar" />
                            <img v-else src="/img/error.png" />
                            <!-- :src="$fullUrl(user.avatar)"
                            <img style="width: 2.3rem; overflow: hidden" src="../../../public/img/error.png" /> -->
                        </el-avatar>
                        <span style="font-size: 25px;color: #fff;margin-left: 10px;">
                            {{ username }}
                        </span>
                    </div>
                    <template #dropdown>
                        <el-dropdown-menu>
                            <el-dropdown-item command="user/info1">个人信息</el-dropdown-item>
                            <el-dropdown-item command="user/password1">修改密码</el-dropdown-item>
                            <el-dropdown-item command="/quit" divided>退出</el-dropdown-item>
                        </el-dropdown-menu>
                    </template>
                </el-dropdown>
            </div>
        </el-menu>
        <!--对话框-->
        <el-dialog title="起床打卡" v-model="centerDialogVisible1" width="30%" center>
            <el-form ref="form" label-width="80px">
                <div>
                    <el-form-item prop="avatar">
                        <img v-if="seen" :src="tuPianUrl + avatar"
                            style="width: 80px;height: 80px;margin-top: -50px;margin-left: -50px;" />
                        <img v-else src="/img/error.png"
                            style="width: 50px;height: 50px;margin-top: -50px;margin-left: -50px;" />
                    </el-form-item>
                    <span style="margin-left: 20px;font-size: 20px;">{{ new Date().toLocaleString().split(" ")[1] }}</span>
                    <span style="margin-left: 20px">{{ new Date().toLocaleString().split(" ")[0].replace('/','-').replace('/','-') }}</span>
                    <span class="span">早起</span>
                    <span class="span1">连续早起{{ num }}天</span>
                </div>
                <div style="height: 200px;display: block;margin-left: -100px;">
                    <span class="mryj">
                        {{ hrContent }}
                    </span>
                </div>
            </el-form>
        </el-dialog>
        <el-dialog title="睡眠打卡" v-model="centerDialogVisible2" width="30%" center>
            <el-form ref="form" label-width="80px">
                <el-form-item prop="avatar">
                    <img v-if="seen" :src="tuPianUrl + avatar"
                        style="width: 80px;height: 80px;margin-top: -50px;margin-left: -50px;" />
                    <img v-else src="/img/error.png"
                        style="width: 50px;height: 50px;margin-top: -50px;margin-left: -50px;" />
                </el-form-item>
                <span style="margin-left: 20px;font-size: 20px;">{{ new Date().toLocaleString().split(" ")[1] }}</span>
                <span style="margin-left: 20px">{{ new Date().toLocaleString().split(" ")[0].replace('/','-').replace('/','-') }}</span>
                <span class="span">早睡</span>
                <span class="span1">连续早睡{{ num }}天</span>
                <div style="height: 200px;display: block;margin-left: -100px;">
                    <span class="mryj">
                        {{ hrContent }}
                    </span>
                </div>
            </el-form>
        </el-dialog>
    </div>
</template>

<script setup>
import { ElMessage, ElMessageBox } from 'element-plus'
import { AlarmClock, Trophy, EditPen, PieChart, Flag, Message, Document, House } from '@element-plus/icons-vue'
import router from "../../router"
let seen = true;
let tuPianUrl = 'http://localhost:8080';
let username = sessionStorage.getItem("username")
let data = JSON.parse(sessionStorage.getItem("user"))
// console.log(data)
let avatar = data[0]["avatar"]
if (avatar === "") {
    seen = false;
}
const command = (command) => {
    if (command === "/quit") {
        ElMessageBox.confirm(
            '是否确认注销登录吗',
            'Warning',
            {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning',
            }
        )
            .then(() => {
                sessionStorage.clear();//清空token信息
                router.push("/login").then(() => {
                    setTimeout(router.go(0), 0);
                });
            })
            .catch(() => {
                ElMessage({
                    type: 'info',
                    message: '已取消注销',
                })
            })
    }
    // else if (command === "/upclock") {
    //     centerDialogVisible1 = true;
    // }
    // else if (command === "/sleepclock") {
    //     centerDialogVisible2 = true;
    // }
    else if (command === "study_room/main1") {
        axios.post("/studyRoom/selectpeople", {
            username: username
        })
            .then(res => res.data).then(res => {
                if (res.code == 200) {
                    router.push("/study_room/view1").then(() => {
                        setTimeout(router.go(0), 0);
                    });
                } else {
                    router.push("/study_room/main1").then(() => {
                        setTimeout(router.go(0), 0);
                    });
                }
            })
    }
    else if (command === "study_room/book1") {
        axios.post("/studyRoom/selectpeople", {
            username: username
        })
            .then(res => res.data).then(res => {
                if (res.code == 200) {
                    router.push("/study_room/book1").then(() => {
                        setTimeout(router.go(0), 0);
                    });
                } else {
                    ElMessageBox.confirm(
                        '请先加入一个自习室',
                        '提示',
                        {
                            confirmButtonText: '确定',
                            cancelButtonText: '取消',
                            type: 'warning',
                        }
                    )
                        .then(() => {
                            router.push("/study_room/main1").then(() => {
                                setTimeout(router.go(0), 0);
                            });
                        })
                        .catch(() => {
                            ElMessage({
                                type: 'info',
                                message: '已取消',
                            })
                        })
                }
            })
    }
    else if (command === "study_room/question1") {
        axios.post("/studyRoom/selectpeople", {
            username: username
        })
            .then(res => res.data).then(res => {
                if (res.code == 200) {
                    router.push("/study_room/question1").then(() => {
                        setTimeout(router.go(0), 0);
                    });
                } else {
                    ElMessageBox.confirm(
                        '请先加入一个自习室',
                        '提示',
                        {
                            confirmButtonText: '确定',
                            cancelButtonText: '取消',
                            type: 'warning',
                        }
                    )
                        .then(() => {
                            router.push("/study_room/main1").then(() => {
                                setTimeout(router.go(0), 0);
                            });
                        })
                        .catch(() => {
                            ElMessage({
                                type: 'info',
                                message: '已取消',
                            })
                        })
                }
            })
    }
    else {
        router.push("/" + command).then(() => {
            setTimeout(router.go(0), 0);
        });
    }
}
const menu1 = (index) => {
    router.push("/" + index.index).then(() => {
        setTimeout(router.go(0), 0);
    });
}
const cjan = () => {
    router.push("/accomplishment/cj1").then(() => {
        setTimeout(router.go(0), 0);
    });
}
// let centerDialogVisible1 = true;
// let centerDialogVisible2 = false;
// let upclock = () => {
//     centerDialogVisible1 = true;
// }
// let sleepclock = () => {
//     centerDialogVisible2 = true;
// }
</script>
<script>
let username1 = sessionStorage.getItem("username")
import { ElMessage, ElMessageBox } from 'element-plus'
import axios from 'axios'
export default {
    data() {
        return {
            centerDialogVisible2: false,
            centerDialogVisible1: false,
            hrContent: '',
            num: '',
            number: 0,
            number1: 0
        }
    }, methods: {
        upclock() {
            if (this.number < 1) {
                if (this.canCheckIn == true) {
                    this.centerDialogVisible1 = true;
                    this.axios.post("/upclock/daka", {
                        username: username1
                    })
                        .then(res => res.data).then(res => {
                            if (res.code == 200) {
                                // console.log(res)
                                this.num = res.total;
                                // console.log(this.num)
                                this.hrContent = res.token.replace("<p>", "").replace("</p>", "");
                                this.number++;
                            } else {
                                this.$message({
                                    duration: 3000,
                                    offset: 50,
                                    message: '打卡失败',
                                    type: 'error'
                                });
                            }
                        })
                } else {
                    ElMessageBox.confirm(
                        '太晚了，请在4点至12点早起打卡',
                        '提示',
                        {
                            confirmButtonText: '确定',
                            cancelButtonText: '取消',
                            type: 'warning',
                        })
                        .then(() => {
                            this.centerDialogVisible1 = false;
                        })
                }
            } else {
                ElMessageBox.confirm(
                    '你已打卡，请勿重复打卡',
                    '提示',
                    {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning',
                    })
                    .then(() => {
                        this.centerDialogVisible1 = false;
                    })
            }
            // this.centerDialogVisible1 = true;
            // axios.get("https://v.api.aa1.cn/api/yiyan/index.php").then(resp => {
            //     this.hrContent = resp.data.replace("<p>", "").replace("</p>", "");
            // })
        }, sleepclock() {
            if (this.number1 < 1) {
                if (this.canCheckIn1 == true) {
                    this.centerDialogVisible2 = true;
                    this.axios.post("/sleepclock/daka", {
                        username: username1
                    })
                        .then(res => res.data).then(res => {
                            if (res.code == 200) {
                                // console.log(res)
                                this.num = res.total;
                                // console.log(this.num)
                                this.hrContent = res.token.replace("<p>", "").replace("</p>", "");
                                this.number1++;
                            } else {
                                this.$message({
                                    duration: 3000,
                                    offset: 50,
                                    message: '打卡失败',
                                    type: 'error'
                                });
                            }
                        })
                } else {
                    ElMessageBox.confirm(
                        '太早了，请在18点至24点早起打卡',
                        '提示',
                        {
                            confirmButtonText: '确定',
                            cancelButtonText: '取消',
                            type: 'warning',
                        })
                        .then(() => {
                            this.centerDialogVisible1 = false;
                        })
                }
            } else {
                ElMessageBox.confirm(
                    '你已打卡，请勿重复打卡',
                    '提示',
                    {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning',

                    })
                    .then(() => {
                        this.centerDialogVisible1 = false;
                    })
            }
            // this.centerDialogVisible2 = true;
            // axios({
            //     method: "GET",
            //     url: "https://v.api.aa1.cn/api/yiyan/index.php"
            // }).then(resp => {
            //     this.hrContent = resp.data.replace("<p>", "").replace("</p>", "");
            // })
        }
    }, computed: {
        canCheckIn() {
            // get the current hour
            let hour = new Date().getHours();
            // return true if hour is between 4 and 12
            return hour >= 4 && hour < 12;
        },
        canCheckIn1() {
            let hour = new Date().getHours();
            return hour >= 18 && hour < 24;
        }
    }
}

</script>
<style>
.header {
    width: 100%;
    position: fixed;
    z-index: 9999;
}

/* .el-message { 
    z-index: 99999 !important;  
} */
/* .el-dialog { z-index: 10 !important; } */
.mryj {
    display: block;
    /* margin-left: -280px; */
    margin-top: 100px;
    text-align: center;
    font-size: 20px;
    /* margin: auto; */

}

.span {
    display: block;
    width: 50px;
    background-color: rgb(241, 167, 19);
    border-radius: 20px 20px;
    margin-left: 30px;
    text-align: center;
    margin-top: 20px;
    margin-bottom: 20px;
}

.span1 {
    display: block;
    width: 120px;
    background-color: rgb(241, 167, 19);
    border-radius: 20px 20px;
    margin-left: 90px;
    text-align: center;
    margin-top: -40px;
    margin-bottom: 20px;
}

.biao {
    width: 300px;
    margin-top: 10px;
    margin: auto;
    display: flex;
    justify-content: center;
}

.biao p {
    float: right;
    margin-top: 5px;
    margin-left: 5px;
}

.header .el-menu-item:hover {
    background-color: #00838F !important;
}

.header .el-menu-item:focus {
    background-color: #00838F !important;
}

.biaoti p {
    color: #ffffff;
}

.zuoyi {
    margin-left: 60px;
}

.daika {
    margin: auto;
    margin-top: 10px;
    margin-left: 100px;
}

.cjan {
    color: #ffffff;
    margin: auto;
    margin-top: 10px;
    margin-left: 30px;
    cursor: pointer;
}

.action_center {
    line-height: 51px;
    width: 600px;
    margin: auto;
    margin-left: 80px;
    font-style: oblique;
    text-align: center;
    color: #ffffff;
}

.el-dropdown-link {
    cursor: pointer;
    color: var(--el-color-primary);
    display: flex;
    justify-content: center;
    align-items: center;
}

.action_right {
    text-align: right;
    margin: auto;
    float: right;
    margin-left: 20px;
    margin-right: 30px;
    width: 30%;
}

.el-dropdown {
    color: #fff;
    border: none;
}
</style>