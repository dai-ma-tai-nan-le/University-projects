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
                <div class="jiaru" @click="xuanxiang()"><el-button>选项</el-button></div>
                <div class="zxsyou">
                    <div>您当前的排名：<span>{{ index.ranking }}</span></div>
                </div>
            </div>
        </el-card>
        <div class="cy">
            <div v-for="index in list" :key="index">
                <div v-for="index2 in index.list" :key="index2">
                    <div v-if="index.list.length >= 4">
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
                    <div v-else-if="index.list.length == 3">
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
                    <div v-else-if="index.list.length == 2">
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
                    <div v-else-if="index.list.length == 1">
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
        </div>
        <div v-for="index in list" :key="index">
            <div class="hua" v-if="index.list.length == 3" style="margin-top: 144px;">时长不代表全部收获，找到对的方向并持之以恒吧</div>
            <div class="hua" v-if="index.list.length == 2" style="margin-top: 266px;">时长不代表全部收获，找到对的方向并持之以恒吧</div>
            <div class="hua" v-if="index.list.length == 1" style="margin-top: 388px;">时长不代表全部收获，找到对的方向并持之以恒吧</div>
            <div class="hua" v-if="index.list.length == 4" style="margin-top: 22px;">时长不代表全部收获，找到对的方向并持之以恒吧</div>
            <div class="hua" v-if="index.list.length > 4">时长不代表全部收获，找到对的方向并持之以恒吧</div>
        </div>
        <!--对话框-->
        <el-dialog title="选项" v-model="centerDialogVisible1" width="50%" center>
            <div class="jr" @click="fxzxs()">分享自习室给好友</div>
            <div class="jr" @click="bianji()" v-if="homeOwner == username">编辑自习室资料</div>
            <div class="jr" @click="jiesan()" v-if="homeOwner == username">退出并解散自习室</div>
            <div class="jr" @click="tuichu()" v-else>退出这个自习室</div>
            <div class="jr" @click="centerDialogVisible1 = false">取消</div>
        </el-dialog>
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
        <!--对话框-->
        <el-dialog title="编辑自习室信息" v-model="centerDialogVisible2" width="50%" center>
            <el-form ref="form" :rules="rules" :model="form" label-width="100px"
                style="width: 500px; margin: auto;margin-top: 20px;">
                <el-col class="el_form_item_warp">
                    <el-form-item label="自习室名称" prop="roomname">
                        <el-input v-model="form.roomname" placeholder="如:考研" />
                    </el-form-item>
                </el-col>
                <el-col class="el_form_item_warp">
                    <el-form-item prop="description" label="自习室简介">
                        <el-input v-model="form.description" placeholder="如:上岸" />
                    </el-form-item>
                </el-col>
                <el-col class="el_form_item_warp">
                    <el-form-item label="加入所需密码" prop="password">
                        <el-input v-model="form.password" placeholder="您可以设置加入自习室所需的密码，也可以不设置" />
                    </el-form-item>
                </el-col>
                <el-col class="el_form_item_warp">
                    <el-form-item label="公开自习室否">
                        <el-select v-model="form.type" style="width: 400px;">
                            <el-option v-for="o in list_type" :key="o" :label="o" :value="o">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-col class="el_form_item_warp">
                        <el-form-item label="自定义人数上限" label-width="120" prop="num" style="margin-left: -20px;">
                            <el-input v-model="form.num" placeholder="默认人数上限为50人。可自定义范围2-300" />
                        </el-form-item>
                    </el-col>
                </el-col>
                <el-form-item style="margin-left: 80px;margin-top: 50px;">
                    <el-button type="primary" @click="upzxs()" class="search_btn_find">确定</el-button>
                    <el-button @click="centerDialogVisible2 = false" class="search_btn_reset">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
        <!-- --对话框-- -->
        <el-dialog title="自习室分享" v-model="centerDialogVisible3" width="50%" center>
            <el-form ref="form1" :model="form1" :rules="rules" label-width="80px">
                <el-form-item label="接收方" prop="reusername">
                    <el-select v-model="form1.reusername" filterable placeholder="请选择或输入你想给谁分享的用户名" allow-create
                        style="width: 1000px;">
                        <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                        </el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer" style="margin-left: 285px;">
                <el-button @click="centerDialogVisible3 = false">取 消</el-button>
                <el-button type="primary" @click="submit()">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import { Flag } from '@element-plus/icons-vue';
import * as echarts from 'echarts';
import router from '../../router';
let data = JSON.parse(sessionStorage.getItem("user"))
let username = sessionStorage.getItem("username");
import { ElMessage, ElMessageBox } from 'element-plus';
export default {
    data() {
        //检查自定义人数上限
        let checkNum = (rule, value, callback) => {
            if (this.form.num > 300) {
                callback(new Error('自定义人数上限不能超过300人'));
            } else if (this.form.num < 2) {
                callback(new Error('自定义人数上限不能低于2人'));
            }
            else {
                callback();
            }
        };
        return {
            list: [],
            username: username,
            tuPianUrl: "http://localhost:8080",
            centerDialogVisible: false,
            centerDialogVisible1: false,
            centerDialogVisible2: false,
            centerDialogVisible3: false,
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
            rules: {
                roomname: [{ required: true, message: '自习室名称不能为空！', trigger: 'blur' },
                { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' },
                ],
                description: [{ required: true, message: '描述不能为空！', trigger: 'blur' },
                { min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur' }
                ],
                num: [{ validator: checkNum, trigger: 'blur' }]
            },
            form1: {
                reusername: ''
            }
        };
    },
    methods: {
        xianshi() {
            this.axios.post("/studyRoom/selectRoomId", {
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
        }, seens() {
            // console.log(this.value1);
            this.axios.post("/studyRoom/updateSeen", {
                username: username,
                value: this.value1
            })
                .then(res => res.data).then(res => {
                    console.log(res.data);
                    if (res.code == 200) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: "修改成功",
                            type: "success"
                        });
                        this.xianshi();
                        this.centerDialogVisible = false
                    }
                    else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: "修改失败",
                            type: "error"
                        });
                        this.centerDialogVisible = false
                    }
                });
        }, delpeople() {
            this.axios.post("/studyRoom/delpeople", {
                cxusername: this.cxusername,
                username: username,
                roomName: this.list[0]['roomName'],
                id: this.list[0]['studyRoomId'],
            })
                .then(res => res.data).then(res => {
                    console.log(res.data);
                    if (res.code == 200) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: "成员移除成功",
                            type: "success"
                        });
                        this.xianshi();
                        this.centerDialogVisible = false
                    }
                    else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: "成员移除失败",
                            type: "error"
                        });
                        this.centerDialogVisible = false
                    }
                });
        }, xuanxiang() {
            this.centerDialogVisible1 = true;
        }, bianji() {
            this.centerDialogVisible1 = false;
            this.form.num = this.list[0]['limitNum'];
            this.form.roomname = this.list[0]['roomName'];
            this.form.type = this.list[0]['type'];
            this.form.description = this.list[0]['roomIntroduce'];
            if (this.list[0]['password'] === "d41d8cd98f00b204e9800998ecf8427e") {
                this.form.password = '';
            } else {
                this.form.password = '******';
            }
            this.centerDialogVisible2 = true;
        }, upzxs() {
            this.axios.post("/studyRoom/upzxs", {
                id: this.list[0]['studyRoomId'],
                num: this.form.num,
                roomname: this.form.roomname,
                type: this.form.type,
                description: this.form.description,
                password: this.form.password
            })
                .then(res => res.data).then(res => {
                    // console.log(res.data);
                    if (res.code == 200) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: "数据修改成功",
                            type: "success"
                        });
                        this.xianshi();
                        this.centerDialogVisible2 = false
                    }
                    else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: "数据修改失败",
                            type: "error"
                        });
                        this.centerDialogVisible2 = false
                    }
                });
        }, fxzxs() {
            this.centerDialogVisible1 = false;
            this.centerDialogVisible3 = true;
        }, xianshi2() {
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
        }, submit() {
            this.axios.post("/studyRoom/fxzxs", {
                id: this.list[0]['studyRoomId'],
                username: username,
                reusername: this.form1.reusername,
                roomName: this.list[0]['roomName'],
                homeOwner: this.homeOwner,
            })
                .then(res => res.data).then(res => {
                    // console.log(res.data);
                    if (res.code == 200) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: "分享成功",
                            type: "success"
                        });
                        this.xianshi();
                        this.centerDialogVisible3 = false
                    }
                    else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: "分享失败",
                            type: "error"
                        });
                        this.centerDialogVisible3 = false
                    }
                });
        }, tuichu() {
            this.centerDialogVisible1 = false;
            ElMessageBox.confirm(
                '是否确认退出该自习室',
                '提示',
                {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning',
                }
            )
                .then(() => {
                    this.axios.post("/studyRoom/tuichu", {
                        id: this.list[0]['studyRoomId'],
                        username: username,
                    })
                        .then(res => res.data).then(res => {
                            // console.log(res.data);
                            if (res.code == 200) {
                                this.$message({
                                    duration: 3000,
                                    offset: 50,
                                    message: "退出自习室成功",
                                    type: "success"
                                });
                                router.push("/study_room/main1").then(() => {
                                    setTimeout(router.go(0), 0);
                                });
                            }
                            else {
                                this.$message({
                                    duration: 3000,
                                    offset: 50,
                                    message: "退出自习室失败",
                                    type: "error"
                                });
                            }
                        });
                })
                .catch(() => {
                    ElMessage({
                        type: 'info',
                        duration: 3000,
                        offset: 50,
                        message: '已取消退出',
                    })
                })
        }, jiesan() {
            this.centerDialogVisible1 = false;
            ElMessageBox.confirm(
                '是否确认解散并退出该自习室',
                '提示',
                {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning',
                }
            )
                .then(() => {
                    this.axios.post("/studyRoom/jiesan", {
                        id: this.list[0]['studyRoomId'],
                        username: username,
                        roomName: this.list[0]['roomName'],
                    })
                        .then(res => res.data).then(res => {
                            // console.log(res.data);
                            if (res.code == 200) {
                                this.$message({
                                    duration: 3000,
                                    offset: 50,
                                    message: "解散并退出自习室成功",
                                    type: "success"
                                });
                                router.push("/study_room/main1").then(() => {
                                    setTimeout(router.go(0), 0);
                                });
                            }
                            else {
                                this.$message({
                                    duration: 3000,
                                    offset: 50,
                                    message: "解散并退出自习室失败",
                                    type: "error"
                                });
                            }
                        });
                })
                .catch(() => {
                    ElMessage({
                        type: 'info',
                        duration: 3000,
                        offset: 50,
                        message: '已取消解散自习室',
                    })
                })
        }
    },beforeMount() {
        this.xianshi();
        this.xianshi2();
    },
    components: { Flag }
}
</script>

<style>
.room_view {
    padding: 2rem 1rem;
    background-color: #eeeeee !important;
    width: 70%;
    margin: 0 auto;
    padding: 0;
    height: 100%;
}

.el-form-item__label {
    color: #00838F !important;
}

.el-dialog__title {
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

.zxsyou {
    margin-left: -100px;
    margin-top: 50px;
    color: dodgerblue;
    font-weight: 600;
}

.zxsyou span {
    font-size: 30px;
}

.jiaru button {
    width: 100px;
    height: 30px;
    margin-top: -50px;
    margin-left: -30px;
    background-color: rgb(181, 227, 254);
    color: #009dff;
    font-weight: 600;
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
    width: 1000px;
    margin: auto;
    background-color: #ffffff;
}

.hua {
    width: 1000px;
    height: 30px;
    padding-top: 10px;
    margin: auto;
    background-color: #ffffff;
    text-align: center;
    border-top: solid 1px #eeeeee;
}

.plnr {
    width: 900px;
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