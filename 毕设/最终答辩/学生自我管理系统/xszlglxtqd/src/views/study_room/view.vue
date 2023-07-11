<template>
    <div class="room_view">
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
                <div class="zxsyou">
                    <el-button type="primary" style="margin-left: 180px;margin-top: -50px;" @click="fanhui()">返回</el-button>
                    <div>房主：{{ homeOwner }}</div>
                </div>
            </div>
        </el-card>
        <div class="cy">
            <div v-for="index in list" :key="index">
                <div v-for="index2 in index.list" :key="index2">
                    <div class="hang" @click="cyxx(index2)">
                        <div style="font-weight: 800;">{{ index2.ranking }}</div>
                        <div style="margin-left: 50px;">
                            <el-avatar style="overflow: hidden;">
                                <img v-if="index2.avatar" :src="tuPianUrl + index2.avatar" />
                                <img v-else src="/img/error.png" />
                            </el-avatar>
                            <span
                                style="margin-left: 60px;display: block;margin-top: -35px;font-weight: 800;font-size: 25px;">
                                {{ index2.username }}</span>
                            <div class="plnr">
                                <div v-if="index2.time != 0">今日已专注
                                    <span v-if="parseInt(index2.time / 60) != 0">
                                        {{ parseInt(index2.time / 60) }}小时
                                        {{ parseInt(index2.time % 60) }}分钟
                                    </span>
                                    <span v-else>{{ index2.time }}分钟</span>
                                </div>
                                <div v-else>今日还未专注</div>
                            </div>
                            <div style="margin-left: 60px;display: block;">
                                <el-button class="xymm" v-if="index2.continumDay != 0">连续专注{{ index2.continumDay
                                }}天</el-button>
                                <el-button class="jrrs" v-if="index2.continumDay != 0">共专注{{ index2.totalDay
                                }}天</el-button>
                                <el-button class="jrrs" v-if="index2.upTime != null">起床 {{ index2.upTime }}</el-button>
                                <div v-else style="height: 30px;"></div>
                            </div>
                        </div>
                        <div class="zzsc">
                            <div v-if="parseInt(index2.time / 60) != 0">
                                <span>{{ parseInt(index2.time / 60) }}</span>小时
                                <span>{{ parseInt(index2.time % 60) }}</span>分钟
                            </div>
                            <div v-else><span>{{ index2.time }}</span>分钟</div>
                        </div>
                        <div class="qizi" v-if="index2.username === username"><el-icon>
                                <Flag />
                            </el-icon></div>
                    </div>
                </div>
            </div>
        </div>
        <div v-for="index in list" :key="index">
            <div class="hua" v-if="index.list.length == 3" style="margin-top: 144px;">时长不代表全部收获，找到对的方向并持之以恒吧</div>
            <div class="hua" v-if="index.list.length == 2" style="margin-top: 266px;">时长不代表全部收获，找到对的方向并持之以恒吧</div>
            <div class="hua" v-if="index.list.length == 1" style="margin-top: 388px;">时长不代表全部收获，找到对的方向并持之以恒吧</div>
            <div class="hua" v-if="index.list.length == 4" style="margin-top: 22px;">时长不代表全部收获，找到对的方向并持之以恒吧</div>
            <div class="hua" v-if="index.list.length > 4">时长不代表全部收获，找到对的方向并持之以恒吧</div>
        </div>
        <!--对话框-->
        <el-dialog :title="cxusername" v-model="centerDialogVisible" width="50%" center>
            <div v-if="seen != 0">
                <div v-if="JSON.parse(JSON.stringify(this.data)).length !== 0">
                    <div style="text-align: center;" v-if="username === cxusername">
                        <el-switch v-model="value1" inactive-text="专注内容对自习室好友可见" @Click="seens()" />
                        <!-- <el-button type="danger" style="margin-left: 80px;" v-if="username===homeOwner" @Click="delpeople()">移除该成员</el-button> -->
                    </div>
                    <div style="text-align: center;" v-else><el-button type="danger" v-if="username === homeOwner"
                            @Click="delpeople()">移除该成员</el-button></div>
                    <div id="echarts1" style="width: 700px;height:400px;"></div>
                </div>
                <div v-else>
                    <div style="text-align: center;" v-if="cxusername === username">
                        <el-switch v-model="value1" inactive-text="专注内容对自习室好友可见" @Click="seens()" />
                        <!-- <el-button type="danger" style="margin-left: 80px;" v-if="username===homeOwner" @Click="delpeople()">移除该成员</el-button> -->
                    </div>
                    <div style="text-align: center;" v-else><el-button type="danger" v-if="username === homeOwner"
                            @Click="delpeople()">移除该成员</el-button></div>
                    <div class="data">无数据</div>
                </div>
            </div>
            <div v-else>
                <div style="text-align: center;" v-if="cxusername === username">
                    <el-switch v-model="value1" inactive-text="专注内容对自习室好友可见" @Click="seens()" />
                    <!-- <el-button type="danger" style="margin-left: 80px;" v-if="username===homeOwner" @Click="delpeople()">移除该成员</el-button> -->
                </div>
                <div style="text-align: center;" v-else><el-button type="danger" v-if="username === homeOwner"
                        @Click="delpeople()">移除该成员</el-button></div>
                <div class="data">该用户关闭了‘专注内容对自习室好友可见’开关</div>
            </div>
        </el-dialog>
    </div>
</template>

<script>
import { Flag } from '@element-plus/icons-vue';
import * as echarts from 'echarts';
import router from '../../router';
// let data = JSON.parse(sessionStorage.getItem("user"))
let username = sessionStorage.getItem("username");
// import { ElMessage, ElMessageBox } from 'element-plus';
export default {
    data() {
        return {
            list: [],
            username: username,
            tuPianUrl: "http://localhost:8080",
            centerDialogVisible: false,
            cxusername: '',
            seen: 0,
            homeOwner: '',
            options: [],
            //可见
            value1: true,
            data: [],
            data1: [],
            list_type: ['公开', '不公开'],
            form: {
                type: '公开',
                roomname: "",
                password: '',
                description: "",
                num: 50
            },
            form1: {
                reusername: ''
            }
        };
    },
    methods: {
        xianshi() {
            this.axios.post("/studyRoom/selectRoomId3", {
                id: this.$route.query.studyRoomId,
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
        }, cyxx(index2) {
            let index1 = JSON.parse(JSON.stringify(index2));
            this.cxusername = index1.username;
            this.seen = index1.seen;
            if (this.seen == 0) {
                this.value1 = false;
            } else {
                this.value1 = true;
            }
            this.centerDialogVisible = true;
            this.xianshi1();
        }, xianshi1() {
            this.axios.post("/studyRoom/selectPie", {
                username: this.cxusername
            })
                .then(res => res.data).then(res => {
                    // console.log(res.data);
                    if (res.code == 200) {
                        this.data = res.data;
                    }
                    else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: "查询失败",
                            type: "error"
                        });
                    }
                });
            var charts1 = echarts.init(document.getElementById('echarts1'))
            var option = {
                legend: {
                    bottom: 10,
                    left: 'center',
                    // 重写legend显示样式
                    formatter: function (name) {
                        // 获取legend显示内容
                        let data = option.series[0].data;
                        let total = 0;
                        let tarValue = 0;
                        for (let i = 0, l = data.length; i < l; i++) {
                            total += data[i].value;
                            if (data[i].name == name) {
                                tarValue = data[i].value;
                            }
                        }
                        // let p = Math.round(tarValue / total * 100).toFixed(2);
                        let p = (tarValue / total * 100).toFixed(2);
                        return name + '-----' + p + '%';
                    },
                    data: this.data
                },
                series: [
                    {
                        type: 'pie',
                        data: this.data,
                        // hoverAnimation: false,
                        avoidLabelOverlap: true
                    }
                ]
            };
            charts1.setOption(option);
        }, fanhui() {
            router.push("/study_room/main").then(() => {
                setTimeout(router.go(0), 0);
            });
        }
    }, beforeMount() {
        this.xianshi();
    },
    components: { Flag }
}
</script>

<style>
.room_view {
    padding: 2rem 1rem;
    background-color: #eeeeee !important;
    width: 90%;
    margin: 0 auto;
    padding: 0;
}

.el-form-item__label {
    color: #00838F !important;
}

.el-dialog__title {
    color: #00838F !important;
}

.card {
    width: 1100px;
    margin: auto;
}

.zxskp {
    display: flex;
    align-items: center;
}

.zxsyou {
    margin-left: 20px;
    margin-top: 20px;
    color: dodgerblue;
    font-weight: 600;
    font-size: 20px;
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

.cy {
    width: 1100px;
    margin: auto;
    background-color: #ffffff;
}

.hua {
    width: 1100px;
    height: 30px;
    padding-top: 10px;
    margin: auto;
    background-color: #ffffff;
    text-align: center;
    border-top: solid 1px #eeeeee;
}

.plnr {
    width: 1000px;
    padding-right: 20px;
    margin-left: 60px;
    margin-top: 10px;
}

.plnr div {
    font-size: 14px;
    color: #575656;
}

.hang {
    padding-top: 10px;
    padding-left: 20px;
    padding-bottom: 10px;
    width: 1000px;
    border-bottom: solid 2px #eeeeee;
    display: flex;
    align-items: center;
}

.zzsc {
    margin-left: -250px;
    color: #009dff;
}

.zzsc span {
    font-size: 30px;
    font-weight: 600;
    color: #009dff;
}

.qizi {
    margin-left: 20px;
    margin-top: -50px;
    font-size: 50px;
    color: red;
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

.data {
    height: 200px;
    text-align: center;
    padding-top: 150px;
    font-weight: 600;
}

/* .lgcy:last-child {
    margin-bottom: 388px;
} */
</style>