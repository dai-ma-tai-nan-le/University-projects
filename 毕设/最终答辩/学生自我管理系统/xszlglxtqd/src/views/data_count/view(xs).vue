<template>
    <div id="data">
        <h1 v-if="studyPlanId === undefined">数据统计</h1>
        <h1 v-else>数据统计-{{ planName }}</h1>
        <el-button type="primary" v-if="studyPlanId != undefined" style="float: left;margin-top: -50px;margin-left: 980px;"
            @click="fhui()">返回</el-button>
        <div class="zz">
            <div>
                <h2>累计专注</h2>
            </div>
            <el-col>
                <el-form ref="form" :model="form">
                    <el-col class="el_form_item_warp">
                        <el-form-item label="次数:">
                            <span>{{ totalNum }}</span>
                        </el-form-item>
                    </el-col>
                    <el-col class="el_form_item_warp" style="margin-left: -80px;">
                        <el-form-item label="时长:">
                            <span>
                                <div v-if="parseInt(totalTime / 60) != 0">
                                    {{ parseInt(totalTime / 60)
                                    }}小时
                                    {{ parseInt(totalTime % 60)
                                    }}分钟
                                </div>
                                <div v-else>{{ Math.round(totalTime) }}分钟</div>
                            </span>
                        </el-form-item>
                    </el-col>
                    <el-col class="el_form_item_warp">
                        <el-form-item label="日均时长:">
                            <span>
                                <div v-if="parseInt(dayTime / 60) != 0">
                                    {{ parseInt(dayTime / 60)
                                    }}小时
                                    {{ parseInt(dayTime % 60)
                                    }}分钟
                                </div>
                                <div v-else>{{ Math.round(dayTime) }}分钟</div>
                            </span>
                        </el-form-item>
                    </el-col>
                </el-form>
            </el-col>
        </div>
        <div class="zz">
            <div>
                <h2>当日专注</h2>
                <el-button @click="phb()"
                    style="background-color: #fff;width: 120px;margin-right: 0px;float: right;margin-top: -30px;">
                    <h5>排行榜</h5>
                </el-button>
            </div>
            <el-col>
                <el-form ref="form" :model="form">
                    <el-col class="el_form_item_warp">
                        <el-form-item label="次数:">
                            <span>{{ todayNum }}</span>
                        </el-form-item>
                    </el-col>
                    <el-col class="el_form_item_warp">
                        <el-form-item label="时长:" style="margin-left: 250px;width: 300px;">
                            <span>
                                <div v-if="parseInt(todayTime / 60) != 0">
                                    {{ parseInt(todayTime / 60)
                                    }}小时
                                    {{ parseInt(todayTime % 60)
                                    }}分钟
                                </div>
                                <div v-else>{{ Math.round(todayTime) }}分钟</div>
                            </span>
                        </el-form-item>
                    </el-col>
                </el-form>
            </el-col>
        </div>
        <div class="zz">
            <div>
                <!-- <h2>专注时长分布 {{ String(Date1).split(' ')[3]+"-"+String(Date1).split(' ')[1]+"-"+String(Date1).split(' ')[2]}}</h2> -->
                <!-- <h2>专注时长分布 {{ String(Date1).replace(/(\w+)\s(\w+)\s(\d+)\s(\d+)\s(\d+):(\d+):(\d+)\sGMT\+(\d+)\s\(\w+\s(\w+)\s(\w+)\)/, '$3-$2-$1')}}</h2> -->
                <h2 v-if="activeName === '日'">专注时长分布 {{ new Date(Date.parse(new
                    Date(String(Date1)))).toISOString().substring(0, 10) }}</h2>
                <h2 v-else-if="activeName === '周'">专注时长分布 {{ new Date(Date.parse(new
                    Date(String(weekStart)))).toISOString().substring(0, 10) }}~{{ new Date(Date.parse(new
        Date(String(weekEnd)))).toISOString().substring(0, 10) }}</h2>
                <h2 v-else-if="activeName === '月'">专注时长分布 {{ new Date(Date.parse(new
                    Date(String(startDate)))).toISOString().substring(0, 10) }}~{{ new Date(Date.parse(new
        Date(String(endDate)))).toISOString().substring(0, 10) }}</h2>
                <h2 v-else>专注时长分布
                    {{ new Date(Date.parse(new Date(String(startYear)))).toISOString().substring(0, 10) }}~
                    {{ new Date(Date.parse(new Date(String(endYear)))).toISOString().substring(0, 10) }}
                </h2>
            </div>
            <!-- <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
                <el-tab-pane label="日" name="日"><div id="echars1" style="width: 940px;height:600px;"></div></el-tab-pane>
                <el-tab-pane label="周" name="周"><div id="echars1" style="width: 940px;height:600px;"></div></el-tab-pane>
                <el-tab-pane label="月" name="月"><div id="echars1" style="width: 940px;height:600px;"></div></el-tab-pane>
                <el-tab-pane label="年" name="年"><div id="echars1" style="width: 940px;height:600px;"></div></el-tab-pane>
            </el-tabs> -->
            <div style="margin-left: 360px;margin-top: 0px;">
                <el-tabs type="card" @tab-click="handleClick" v-model="activeName" v-if="studyPlanId === undefined">
                    <el-tab-pane label="日" name="日"></el-tab-pane>
                    <el-tab-pane label="周" name="周"></el-tab-pane>
                    <el-tab-pane label="月" name="月"></el-tab-pane>
                    <el-tab-pane label="年" name="年"></el-tab-pane>
                </el-tabs>
                <span style="float: right;margin-top: -50px;" v-if="studyPlanId === undefined">
                    <span class="jjrq" @click="jsyt()"><el-icon>
                            <ArrowLeftBold />
                        </el-icon></span>
                    <span class="jjrq" @click="zjyt()"><el-icon>
                            <ArrowRightBold />
                        </el-icon></span>
                </span>
            </div>
            <div id="echars1" style="width: 940px;height:550px;margin-top: -35px;" v-show="length > 0"></div>
            <div style="text-align: center;padding-top: 260px;padding-bottom: 260px;margin-top: -35px;font-weight: 600;"
                v-if="length == 0">
                暂无专注数据，点击学习计划中的开始按钮来专注计时吧</div>
            <div style="margin-left: 150px"><el-button @click="ckzzjl()" style="background-color: #fff;width: 620px;">
                    <h5>查看专注记录</h5>
                </el-button>
            </div>
        </div>
        <div class="zz">
            <div>
                <h2>月专注时长统计 {{ new Date(Date.parse(new Date(String(Date5)))).toISOString().substring(0, 7) }}</h2>
                <span style="float: right;margin-top: -30px;">
                    <span class="jjrq" @click="jsyt1()"><el-icon>
                            <ArrowLeftBold />
                        </el-icon></span>
                    <span class="jjrq" @click="zjyt1()"><el-icon>
                            <ArrowRightBold />
                        </el-icon></span>
                </span>
            </div>
            <div id="echart2" style="width: 1000px;height:500px;"></div>
        </div>
        <div class="zz">
            <div>
                <h2>起床打卡分布 {{ new Date(Date.parse(new Date(String(Date7)))).toISOString().substring(0, 7) }}</h2>
                <span style="float: right;margin-top: -30px;">
                    <span class="jjrq" @click="jsyt3()"><el-icon>
                            <ArrowLeftBold />
                        </el-icon></span>
                    <span class="jjrq" @click="zjyt3()"><el-icon>
                            <ArrowRightBold />
                        </el-icon></span>
                </span>
            </div>
            <div id="echart4" style="width: 1000px;height:500px;" v-show="uplength != 0"></div>
            <div style="margin-left: 380px;font-weight: 600;" v-show="uplength != 0">
                <el-form-item label="平均起床时间">
                    <sapn style="font-weight: 600;color: #00838F;font-size: 18px;">{{ upavg }}</sapn>
                </el-form-item>
            </div>
            <div v-if="uplength == 0" style="padding-top: 240px;text-align: center;height: 260px;font-weight: 600;">
                点击顶栏右边闹钟按钮可进行早起打卡</div>
        </div>
        <div class="zz">
            <div>
                <h2>睡眠打卡分布 {{ new Date(Date.parse(new Date(String(Date8)))).toISOString().substring(0, 7) }}</h2>
                <span style="float: right;margin-top: -30px;">
                    <span class="jjrq" @click="jsyt4()"><el-icon>
                            <ArrowLeftBold />
                        </el-icon></span>
                    <span class="jjrq" @click="zjyt4()"><el-icon>
                            <ArrowRightBold />
                        </el-icon></span>
                </span>
            </div>
            <div id="echart5" style="width: 1000px;height:500px;" v-show="sleeplength != 0"></div>
            <div style="margin-left: 380px;font-weight: 600;" v-show="sleeplength != 0">
                <el-form-item label="平均睡眠时间">
                    <sapn style="font-weight: 600;color: #00838F;font-size: 18px;">{{ sleepavg }}</sapn>
                </el-form-item>
            </div>
            <div v-if="sleeplength == 0" style="padding-top: 240px;text-align: center;height: 260px;font-weight: 600;">
                点击顶栏右边闹钟按钮可进行早起打卡</div>
        </div>
        <div class="zz">
            <div>
                <h2>年专注时长统计 {{ new Date(Date.parse(new Date(String(Date6)))).toISOString().substring(0, 4) }}年</h2>
                <span style="float: right;margin-top: -30px;">
                    <span class="jjrq" @click="jsyt2()"><el-icon>
                            <ArrowLeftBold />
                        </el-icon></span>
                    <span class="jjrq" @click="zjyt2()"><el-icon>
                            <ArrowRightBold />
                        </el-icon></span>
                </span>
            </div>
            <div id="echart3" style="width: 1000px;height:500px;"></div>
        </div>

    </div>
</template>

<script>
import * as echarts from 'echarts';
let username = sessionStorage.getItem("username");
import router from "../../router"
import { ArrowLeftBold, ArrowRightBold } from '@element-plus/icons-vue';
export default {
    data() {
        return {
            activeName: "日",
            studyPlanId: this.$route.query.studyPlanId,
            planName: this.$route.query.planName,
            totalNum: 0,
            todayNum: 0,
            todayTime: 0,
            totalTime: 0,
            dayTime: 0,
            data: [],
            length: 0,
            Date1: new Date(),
            Date2: new Date(),
            Date3: new Date(),
            Date4: new Date(),
            weekStart: this.Date2,
            weekEnd: this.Date2,
            startDate: this.Date3,
            endDate: this.Date3,
            startYear: this.Date4,
            endYear: this.Date4,
            Date5: new Date(),
            yuehang: [],
            yueStart: this.Date5,
            yueEnd: this.Date5,
            yueday: 0,
            yueList: [],
            Date6: new Date(),
            yearhang: [],
            yearStart: this.Date6,
            yearEnd: this.Date6,
            yearday: 12,
            yearList: [],
            Date7: new Date(),
            uphang: [],
            upStart: this.Date7,
            upEnd: this.Date7,
            uplength: 0,
            upday: 0,
            upList: [],
            type: '早起',
            types: '早睡',
            upavg: 0,
            sleepavg: 0,
            Date8: new Date(),
            sleephang: [],
            sleepStart: this.Date8,
            sleepEnd: this.Date8,
            sleeplength: 0,
            sleepday: 0,
            sleepList: [],
        };
    },
    methods: {
        getDay(day) {
            let oneDayTime = 24 * 60 * 60 * 1000
            let MondayTime = oneDayTime * (7 + day - (this.Date2.getDay() || 7))
            return new Date(this.Date2.getTime() - MondayTime)
        }, zhoujj() {
            const oneDayTime = 24 * 60 * 60 * 1000 // 一天的总ms
            const day = this.Date2.getDay() > 0 ? this.Date2.getDay() : 7 // 表示当前是周几
            this.weekStart = new Date(this.Date2.getTime()- (day - 1) * oneDayTime);
            this.weekEnd = new Date(this.Date2.getTime()+(7-day) * oneDayTime);;
        }, yuejj() {
            this.startDate = new Date(this.Date3.getFullYear(), this.Date3.getMonth(), 2);
            this.endDate = new Date(this.Date3.getFullYear(), this.Date3.getMonth() + 1, 2);
            // console.log(this.startDate);
            // console.log(this.endDate);
        }, nianjj() {
            this.startYear = new Date(this.Date4.getFullYear(), 0, 2);
            this.endYear = new Date(this.Date4.getFullYear() + 1, 0, 2);
        }, xianshi() {
            if (this.studyPlanId === undefined) {
                this.axios.post("/dataview/xxjhList", {
                    username: username,
                })
                    .then(res => res.data).then(res => {
                        if (res.code == 200) {
                            // console.log(res.data)
                            // console.log(this.studyPlanId)
                            this.totalNum = res.data[0]["totalNum"];
                            this.todayNum = res.data[0]["todayNum"];
                            this.todayTime = res.data[0]["todayTime"];
                            this.totalTime = res.data[0]["totalTime"];
                            this.dayTime = res.data[0]["dayTime"];
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
            }
            else {
                this.axios.post("/dataview/xxjhList1", {
                    username: username,
                    id: this.studyPlanId
                })
                    .then(res => res.data).then(res => {
                        if (res.code == 200) {
                            console.log(res.data);
                            this.totalNum = res.data[0]["totalNum"];
                            this.todayNum = res.data[0]["todayNum"];
                            this.todayTime = res.data[0]["todayTime"];
                            this.totalTime = res.data[0]["totalTime"];
                            this.dayTime = res.data[0]["dayTime"];
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
            }
        }, phb() {
            this.axios.post("/studyRoom/selectpeople", {
                username: username
            })
                .then(res => res.data).then(res => {
                    if (res.code == 200) {
                        router.push("/study_room/view1").then(() => {
                            setTimeout(router.go(0), 0);
                        });
                    }
                    else {
                        router.push("/study_room/main1").then(() => {
                            setTimeout(router.go(0), 0);
                        });
                    }
                });
        }, fhui() {
            router.push("/study_plan/main1").then(() => {
                setTimeout(router.go(0), 0);
            });
        }, jsyt() {
            if (this.activeName === "日") {
                this.Date1 = new Date(this.Date1.getTime() - 24 * 60 * 60 * 1000);
                this.xianshi1();
            }
            if (this.activeName === "周") {
                this.Date2 = new Date(this.Date2.getTime() - 7 * 24 * 60 * 60 * 1000);
                this.zhoujj();
                this.xianshi1();
            }
            if (this.activeName === "月") {
                this.Date3 = new Date(this.Date3.getFullYear(), this.Date3.getMonth() - 1, this.Date3.getDate());
                this.yuejj();
                this.xianshi1();
            }
            if (this.activeName === "年") {
                this.Date4 = new Date(this.Date4.getFullYear() - 1, this.Date4.getMonth(), this.Date4.getDate());
                this.nianjj();
                this.xianshi1();
            }
        }, zjyt() {
            if (this.activeName === "日") {
                this.Date1 = new Date(this.Date1.getTime() + 24 * 60 * 60 * 1000);
                this.xianshi1();
            }
            if (this.activeName === "周") {
                this.Date2 = new Date(this.Date2.getTime() + 7 * 24 * 60 * 60 * 1000);
                this.zhoujj();
                this.xianshi1();
            }
            if (this.activeName === "月") {
                this.Date3 = new Date(this.Date3.getFullYear(), this.Date3.getMonth() + 1, this.Date3.getDate());
                this.yuejj();
                this.xianshi1();
            }
            if (this.activeName === "年") {
                this.Date4 = new Date(this.Date4.getFullYear() + 1, this.Date4.getMonth(), this.Date4.getDate());
                this.nianjj();
                this.xianshi1();
            }
        }, xianshi1() {
            if (this.studyPlanId === undefined) {
                if (this.activeName === "日") {
                    if (new Date(String(this.Date1)).getTime() === new Date(String(new Date())).getTime()) {
                        this.axios.post("/studyRoom/selectPie", {
                            username: username
                        })
                            .then(res => res.data).then(res => {
                                console.log(res.data);
                                if (res.code == 200) {
                                    this.data = res.data;
                                    this.length = this.data.length;
                                    if (this.length != 0) {
                                        this.xianshi11();
                                    }
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
                    } else {
                        this.axios.post("/dataview/selectPie", {
                            username: username,
                            date: this.Date1
                        })
                            .then(res => res.data).then(res => {
                                console.log(res.data);
                                if (res.code == 200) {
                                    this.data = res.data;
                                    this.length = this.data.length;
                                    if (this.length != 0) {
                                        this.xianshi11();
                                    }
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
                    }
                }
                else if (this.activeName === "周") {
                    this.axios.post("/dataview/selectPie1", {
                        username: username,
                        date1: this.weekStart,
                        date2: this.weekEnd
                    })
                        .then(res => res.data).then(res => {
                            console.log(res.data);
                            if (res.code == 200) {
                                this.data = res.data;
                                this.length = this.data.length;
                                if (this.length != 0) {
                                    this.xianshi11();
                                }
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
                }
                else if (this.activeName === "月") {
                    this.axios.post("/dataview/selectPie1", {
                        username: username,
                        date1: this.startDate,
                        date2: this.endDate
                    })
                        .then(res => res.data).then(res => {
                            // console.log(res.data);
                            if (res.code == 200) {
                                this.data = res.data;
                                this.length = this.data.length;
                                if (this.length != 0) {
                                    this.xianshi11();
                                }
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
                }
                else {
                    this.axios.post("/dataview/selectPie1", {
                        username: username,
                        date1: this.startYear,
                        date2: this.endYear
                    })
                        .then(res => res.data).then(res => {
                            // console.log(res.data);
                            if (res.code == 200) {
                                this.data = res.data;
                                this.length = this.data.length;
                                if (this.length != 0) {
                                    this.xianshi11();
                                }
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
                }
            }
            else {
                this.axios.post("/dataview/selectPie2", {
                    // username: username,
                    id: this.studyPlanId
                })
                    .then(res => res.data).then(res => {
                        console.log(res.data);
                        if (res.code == 200) {
                            this.data = res.data;
                            this.length = this.data.length;
                            if (this.length != 0) {
                                this.xianshi11();
                            }
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
            }
        }, xianshi11() {
            var charts1 = echarts.init(document.getElementById("echars1"));
            var option = {
                legend: {
                    bottom: 10,
                    left: "center",
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
                        let p = (tarValue / total * 100).toFixed(2);
                        return name + "-----" + p + "%";
                    },
                    data: this.data
                },
                series: [
                    {
                        type: "pie",
                        data: this.data,
                    }
                ]
            };
            charts1.setOption(option);
        }, handleClick(tab) {
            this.activeName = tab.props.name;
            this.xianshi1();
        }, ckzzjl() {
            router.push("/experience/main1").then(() => {
                setTimeout(router.go(0), 0);
            });
        }, jsyt1() {
            this.Date5 = new Date(this.Date5.getFullYear(), this.Date5.getMonth() - 1, this.Date5.getDate());
            this.yuehang.splice(0, this.yuehang.length);////清空数组
            this.yuezzsc();
            this.mogyue();
            this.xianshi2();
        }, zjyt1() {
            this.Date5 = new Date(this.Date5.getFullYear(), this.Date5.getMonth() + 1, this.Date5.getDate());
            this.yuehang.splice(0, this.yuehang.length);
            this.yuezzsc();
            this.mogyue();
            this.xianshi2();
        }, yuezzsc() {
            this.yueStart = new Date(this.Date5.getFullYear(), this.Date5.getMonth(), 2);
            this.yueEnd = new Date(this.Date5.getFullYear(), this.Date5.getMonth() + 1, 2);
            this.yueday = (this.yueEnd - this.yueStart) / (24 * 60 * 60 * 1000);
            // console.log(this.yueStart);
            // console.log(this.yueEnd);
        }, mogyue() {
            // this.yuehang = {
            //     formatter: function () {
            //         let m = this.Date5.getMonth();
            //         let d = this.Date5.getDate();
            //         return m + "-" + d;
            //     }
            // }
            let m = this.Date5.getMonth() + 1;
            let nextMonth = new Date(this.Date5.getFullYear(), m, 0)
            for (let i = 1; i <= nextMonth.getDate(); i++) {
                this.yuehang.push(`${m}-${i}`);
            }
        }, xianshi2() {
            this.axios.post("/dataview/selectLine", {
                username: username,
                date1: this.yueStart,
                date2: this.yueEnd,
                day: this.yueday
            })
                .then(res => res.data).then(res => {
                    // console.log(res.data);
                    if (res.code == 200) {
                        this.yueList = res.data;
                        this.xianshi22();
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
        }, xianshi22() {
            var charts2 = echarts.init(document.getElementById("echart2"));
            var option = {
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        label: {
                            backgroundColor: '#6a7985'
                        }
                    }
                }, //鼠标上去有显示
                legend: {
                    data: this.yueList
                },
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: false,
                        data: this.yuehang
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        // name:'分钟',
                        axisLabel: {
                            formatter: '{value} 分钟'
                        }
                    }
                ],
                series: [
                    {
                        type: 'line',
                        smooth: true,  ///圆润
                        lineStyle: {
                            // width: 0
                        }, //隐藏线
                        // showSymbol: false, //隐藏点
                        areaStyle: {
                            opacity: 0.8,
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                {
                                    offset: 0,
                                    color: 'rgb(0, 221, 255)'
                                },
                                {
                                    offset: 1,
                                    color: 'rgb(77, 119, 255)'
                                }
                            ])
                        },  //渐变颜色
                        data: this.yueList,
                        itemStyle: {  //点上显示值+中文
                            normal: {
                                label: {
                                    show: true,
                                    formatter: function (params) {
                                        if (params.value / 60 < 1) {
                                            return params.value + '分钟';
                                        } else {
                                            return (params.value / 60).toFixed(0) + '小时' + params.value % 60 + '分钟';;
                                        }
                                    }
                                }
                            }
                        }
                    }
                ]
            };
            charts2.setOption(option);
        }, jsyt2() {
            this.Date6 = new Date(this.Date6.getFullYear() - 1, this.Date6.getMonth(), this.Date6.getDate());
            this.yearhang.splice(0, this.yearhang.length);////清空数组
            this.yearzzsc();
            this.mogyear();
            this.xianshi3();
        }, zjyt2() {
            this.Date6 = new Date(this.Date6.getFullYear() + 1, this.Date6.getMonth(), this.Date6.getDate());
            this.yearhang.splice(0, this.yearhang.length);
            this.yearzzsc();
            this.mogyear();
            this.xianshi3();
        }, yearzzsc() {
            this.yearStart = new Date(this.Date6.getFullYear(), 0, 2);
            this.yearEnd = new Date(this.Date6.getFullYear() + 1, 0, 2);
            // console.log(this.yearStart);
            // console.log(this.yearEnd);
        }, mogyear() {
            let m = this.Date6.getFullYear();
            for (let i = 1; i <= 12; i++) {
                this.yearhang.push(`${m}-${i}`);
            }
        }, xianshi3() {
            this.axios.post("/dataview/selectLine", {
                username: username,
                date1: this.yearStart,
                date2: this.yearEnd,
                day: this.yearday
            })
                .then(res => res.data).then(res => {
                    // console.log(res.data);
                    if (res.code == 200) {
                        this.yearList = res.data;
                        this.xianshi33();
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
        }, xianshi33() {
            var charts3 = echarts.init(document.getElementById("echart3"));
            var option = {
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        label: {
                            backgroundColor: '#6a7985'
                        }
                    }
                }, //鼠标上去有显示
                legend: {
                    data: this.yearList
                },
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: false,
                        data: this.yearhang
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        axisLabel: {
                            formatter: '{value} 分钟'
                        }
                    }
                ],
                series: [
                    {
                        type: 'line',
                        smooth: true,  ///圆润
                        areaStyle: {
                            opacity: 0.8,
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                {
                                    offset: 0,
                                    color: 'rgb(0, 221, 255)'
                                },
                                {
                                    offset: 1,
                                    color: 'rgb(77, 119, 255)'
                                }
                            ])
                        },  //渐变颜色
                        data: this.yearList,
                        itemStyle: {  //点上显示值+中文
                            normal: {
                                label: {
                                    show: true,
                                    formatter: function (params) {
                                        if (params.value / 60 < 1) {
                                            return params.value + '分钟';
                                        } else {
                                            return (params.value / 60).toFixed(0) + '小时' + params.value % 60 + '分钟';;
                                        }
                                    }
                                }
                            }
                        }
                    }
                ]
            };
            charts3.setOption(option);
        }, jsyt3() {
            this.Date7 = new Date(this.Date7.getFullYear(), this.Date7.getMonth() - 1, this.Date7.getDate());
            this.uphang.splice(0, this.uphang.length);////清空数组
            this.yuezzsc1();
            this.mogyue1();
            this.xianshi4();
        }, zjyt3() {
            this.Date7 = new Date(this.Date7.getFullYear(), this.Date7.getMonth() + 1, this.Date7.getDate());
            this.uphang.splice(0, this.uphang.length);
            this.yuezzsc1();
            this.mogyue1();
            this.xianshi4();
        }, yuezzsc1() {
            this.upStart = new Date(this.Date7.getFullYear(), this.Date7.getMonth(), 2);
            this.upEnd = new Date(this.Date7.getFullYear(), this.Date7.getMonth() + 1, 2);
            this.upday = (this.upEnd - this.upStart) / (24 * 60 * 60 * 1000);
            // console.log(this.upStart);
            // console.log(this.upEnd);
        }, mogyue1() {
            let m = this.Date7.getMonth() + 1;
            let nextMonth = new Date(this.Date7.getFullYear(), m, 0)
            for (let i = 1; i <= nextMonth.getDate(); i++) {
                this.uphang.push(`${m}-${i}`);
            }
        }, xianshi4() {
            this.axios.post("/dataview/selectLine2", {
                username: username,
                date1: this.upStart,
                date2: this.upEnd,
                day: this.upday,
                type: this.type
            })
                .then(res => res.data).then(res => {
                    console.log(res.data);
                    if (res.code == 200) {
                        this.upList = res.data;
                        // for(let item of res.data){
                        //     this.upList.push(Number(item).toFixed(2));
                        // }
                        // console.log(this.upList);
                        this.upavg = res.token;
                        this.uplength = this.upList.length;
                        this.xianshi44();
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
        }, xianshi44() {
            var charts4 = echarts.init(document.getElementById("echart4"));
            var option = {
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        label: {
                            backgroundColor: '#6a7985'
                        }
                    }
                }, //鼠标上去有显示
                legend: {
                    data: this.upList
                },
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: false,
                        data: this.uphang
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        axisLabel: {
                            formatter: '{value} 点'
                        }
                    }
                ],
                series: [
                    {
                        type: 'line',
                        yAxisIndex: 0,
                        smooth: true,  ///圆润
                        areaStyle: {
                            opacity: 0.8,
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                {
                                    offset: 0,
                                    color: 'rgb(0, 221, 255)'
                                },
                                {
                                    offset: 1,
                                    color: 'rgb(77, 119, 255)'
                                }
                            ])
                        },  //渐变颜色
                        data: this.upList,
                        itemStyle: {
                            normal: {
                                label: {
                                    show: true,
                                    formatter: function (params) {
                                        if (params.value !== 0.00) {
                                            return params.value;
                                        }
                                    }
                                }
                            }
                        }
                    }
                ]
            };
            charts4.setOption(option);
        }, jsyt4() {
            this.Date8 = new Date(this.Date8.getFullYear(), this.Date8.getMonth() - 1, this.Date8.getDate());
            this.sleephang.splice(0, this.sleephang.length);////清空数组
            this.yuezzsc2();
            this.mogyue2();
            this.xianshi5();
        }, zjyt4() {
            this.Date8 = new Date(this.Date8.getFullYear(), this.Date8.getMonth() + 1, this.Date8.getDate());
            this.sleephang.splice(0, this.sleephang.length);
            this.yuezzsc2();
            this.mogyue2();
            this.xianshi5();
        }, yuezzsc2() {
            this.sleepStart = new Date(this.Date8.getFullYear(), this.Date8.getMonth(), 2);
            this.sleepEnd = new Date(this.Date8.getFullYear(), this.Date8.getMonth() + 1, 2);
            this.sleepday = (this.sleepEnd - this.sleepStart) / (24 * 60 * 60 * 1000);
            // console.log(this.upStart);
            // console.log(this.upEnd);
        }, mogyue2() {
            let m = this.Date8.getMonth() + 1;
            let nextMonth = new Date(this.Date8.getFullYear(), m, 0)
            for (let i = 1; i <= nextMonth.getDate(); i++) {
                this.sleephang.push(`${m}-${i}`);
            }
        }, xianshi5() {
            this.axios.post("/dataview/selectLine2", {
                username: username,
                date1: this.sleepStart,
                date2: this.sleepEnd,
                day: this.sleepday,
                type: this.types
            })
                .then(res => res.data).then(res => {
                    console.log(res.data);
                    if (res.code == 200) {
                        this.sleepList = res.data;
                        this.sleepavg = res.token;
                        this.sleeplength = this.sleepList.length;
                        this.xianshi55();
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
        }, xianshi55() {
            var charts5 = echarts.init(document.getElementById("echart5"));
            var option = {
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        label: {
                            backgroundColor: '#6a7985'
                        }
                    }
                }, //鼠标上去有显示
                legend: {
                    data: this.sleepList
                },
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: false,
                        data: this.sleephang
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        axisLabel: {
                            formatter: '{value} 点'
                        }
                    }
                ],
                series: [
                    {
                        type: 'line',
                        yAxisIndex: 0,
                        smooth: true,  ///圆润
                        areaStyle: {
                            opacity: 0.8,
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                {
                                    offset: 0,
                                    color: 'rgb(0, 221, 255)'
                                },
                                {
                                    offset: 1,
                                    color: 'rgb(77, 119, 255)'
                                }
                            ])
                        },  //渐变颜色
                        data: this.sleepList,
                        itemStyle: {
                            normal: {
                                label: {
                                    show: true,
                                    formatter: function (params) {
                                        if (params.value !== 0.00) {
                                            return params.value;
                                        }
                                    }
                                }
                            }
                        }
                    }
                ]
            };
            charts5.setOption(option);
        }
    },
    beforeMount() {
        console.log(this.Date1+"================================")
        this.xianshi();
        this.xianshi1();
        this.zhoujj();
        this.yuejj();
        this.nianjj();
        this.yuezzsc();
        this.mogyue();
        this.xianshi2();
        this.yearzzsc();
        this.mogyear();
        this.xianshi3();
        this.yuezzsc1();
        this.mogyue1();
        this.xianshi4();
        this.yuezzsc2();
        this.mogyue2();
        this.xianshi5();
    },
    components: { ArrowLeftBold, ArrowRightBold }
}
</script>

<style>
#data {
    padding: 2rem 1rem;
    background-color: #eeeeee !important;
    width: 70%;
    margin: auto;
}

h1 {
    text-align: center;
    margin-top: -20px;
    margin-bottom: 20px;
    color: #00838F !important;
    font-weight: bold;
}

.el-form-item span {
    color: #00838F !important;
    font-size: 25px;
    font-weight: 800;
}

h2 {
    color: #00838F !important;
    margin-top: -20px;
}

.zz {
    padding: 1.8rem 0.9rem;
    background-color: #fff;
    margin: 0 auto;
    /* display: block; */
    margin-left: 30px;
    margin-right: 30px;
    margin-top: 20px;
}

.search_btn_wrap_1 {
    margin-left: 400px;
}

.el-form {
    margin-left: 50px;
}

.el_form_item_warp {
    margin-bottom: -20px;
    margin-top: 20px;
    padding-left: 50px;
    display: inline-block;
    width: 300px;
}

h5 {
    color: #00838F;
}

.el_form_btn_warp {
    display: inline-flex;
    margin-left: 180px;
}

.el-form-item__label {
    color: #00838F !important;
}

.el-tabs {
    width: 220px;
}

.jjrq {
    float: left;
    margin-right: 30px;
    cursor: pointer;
}
</style>