<template>
    <div class="time_main" :style="{ backgroundImage: 'url(' + imageUrl + ')' }">
        <div class="zlyj">
            <el-form-item>
                {{ context }}
            </el-form-item>
        </div>
        <div>
            <div class="mb">
                <el-form-item>
                    {{ goalName }}
                </el-form-item>
            </div>
            <div style="margin-top: 50px;display:inline-block;margin-left: 20px;">
                <el-form-item>
                    还剩<span class="sz">{{ Math.round((new Date(endTime) - new Date(Date.now())) / (1000 * 60 * 60 * 24))
                    }}</span>天
                </el-form-item>
            </div>
        </div>
        <div style="display: flex;align-items: center;">
            <!-- <div v-if="musicUrl !== ''"><audio :src="tuPianUrl + musicUrl" loop autoplay controls></audio></div> -->
            <div v-if="musicUrl !== ''"><audio :src="urls" loop autoplay controls></audio></div>
            <div class="quan">
                <div id="main" ref="time" v-if="timeTrend === '倒计时'">
                    {{ Math.floor(planTime / (60 * 1000)) }}:{{ parseInt(((planTime / 1000) % 60)) }}
                </div>
                <div id="main" v-else>
                    {{ Math.floor(time / (60 * 1000)) }}:{{ parseInt(((time / 1000) % 60)) }}
                </div>
            </div>
            <div v-if="musicUrl !== ''"><audio :src="urls" loop autoplay controls></audio></div>
            <!-- <div v-if="musicUrl !== ''"><audio :src="tuPianUrl + musicUrl"  loop autoplay controls></audio></div> -->
        </div>
        <div class="study">
            <el-form-item>
                {{ planName }}
            </el-form-item>
            <h4>进行中</h4>
        </div>
        <div style="margin-left: 390px;margin-top: 30px;">
            <el-button @click="centerDialogVisible = true" style="background-color: #fff;width: 120px;margin-left: 250px;">
                <h5>音乐</h5>
            </el-button>
            <!-- <el-button @click="dialogFormVisible = true"
                style="background-color: #fff;width: 120px;margin-right: 250px;">
                <h5>暂停</h5>
            </el-button> -->
            <el-button @click="quit()" style="background-color: #fff;width: 120px;margin-right: 250px">
                <h5>退出</h5>
            </el-button>
        </div>
        <!--对话框-->
        <el-dialog title="音乐" v-model="centerDialogVisible" width="30%" center>
            <el-scrollbar height="400px">
                <div class="jr" @click="noaudio()">无声<span v-if="musicUrl === ''">(当前)</span></div>
                <div class="jr" v-for="index in musicList" :key="index" @click="music(index)">{{ index.name }}<span
                        v-if="musicUrl === index.code">(当前)</span></div>
                <div class="jr">
                    <el-upload v-model:file-list="fileList" class="upload-demo" :show-file-list="false"
                        action="http://localhost:8080/upload/music" accept="audio/*">
                        <div @click="touxiang">自定义</div>
                    </el-upload>
                </div>
                <div class="jr" @click="centerDialogVisible = false">取消</div>
            </el-scrollbar>

        </el-dialog>
    </div>
</template>

<script>
import router from "../../router";
let username = sessionStorage.getItem("username")
export default {
    data() {
        return {
            studyPlanId: '',
            tuPianUrl: 'http://localhost:8080',
            context: '',
            endTime: '',
            goalName: '',
            planName: '',
            planTime: '',
            timeTrend: '',
            timer: null,
            startTime: '',
            time: 0,
            centerDialogVisible: false,
            images: [
                require('../../../public/time/1.jpg'),
                require('../../../public/time/2.jpg'),
                require('../../../public/time/3.jpg'),
                require('../../../public/time/4.jpg'),
                require('../../../public/time/5.jpg'),
                require('../../../public/time/6.jpg'),
            ],
            musicUrl: '',
            musicList: [],
            urls: '',
        }
    },
    methods: {
        xianshi() {
            this.axios.post("/studyPlan/selectplan", {
                studyPlanId: this.$route.query.studyPlanId,
                username: username
            }).then(res => res.data).then(res => {
                if (res.code == 200) {
                    // console.log(res.data);
                    this.context = res.token.replace("<p>", "").replace("</p>", "");
                    this.endTime = res.data[0]['endTime'];
                    this.goalName = res.data[0]['goalName'];
                    this.planName = res.data[0]['planName'];
                    this.timeTrend = res.data[0]['timeTrend'];
                    this.planTime = res.data[0]['planTime'] * 60 * 1000;
                    this.studyPlanId = res.data[0]['studyPlanId'];
                    this.startTime = new Date();
                }
                else {
                    return this.$message({
                        duration: 3000,
                        offset: 50,
                        message: "查询数据失败",
                        type: "error"
                    });
                }
            });
        }, quit() {
            clearInterval(this.timer);
            // console.log(Math.floor(this.time/(60*1000)));
            this.axios.post("/studyPlan/updateplan", {
                studyPlanId: this.$route.query.studyPlanId,
                username: username,
                time: Math.floor(this.time / (60 * 1000))
            }).then(res => res.data).then(res => {
                if (res.code == 200 || (211 <= res.code && res.code <= 220)) {
                    // console.log(res.data);
                    // return this.$message({
                    //     duration: 3000,
                    //     offset: 50,
                    //     message: "数据插入成功",
                    //     type: "success"
                    // });
                }
                else {
                    return this.$message({
                        duration: 3000,
                        offset: 50,
                        message: "数据插入失败",
                        type: "error"
                    });
                }
            });
            router.push({ path: "/time/view", query: { studyPlanId: this.studyPlanId, startTime: this.startTime } }).then(() => {
                setTimeout(router.go(0), 0);
            });
        }, noaudio() {
            this.musicUrl = '';
        }, touxiang() {
            this.axios.post('/upload/avatar1', {
                username: username,
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
        }, querymusic() {
            this.axios.post("/studyPlan/selectmusic", {
                username: username
            }).then(res => res.data).then(res => {
                if (res.code == 200) {
                    console.log(res.data);
                    this.musicList = res.data;
                }
                else {
                    return this.$message({
                        duration: 3000,
                        offset: 50,
                        message: "查询音乐失败",
                        type: "error"
                    });
                }
            });
        }, music(index) {
            let index1 = JSON.parse(JSON.stringify(index));
            this.musicUrl = index1.code;
            console.log(this.tuPianUrl + this.musicUrl)
            this.axios.post("/upload/audio", {
                code: this.musicUrl
            }, {responseType:'arraybuffer', headers: {'Accept': 'audio/mpeg'}}).then(res => {
                // console.log(res);
                // console.log(res.data);
                let blob = new Blob([res.data], { type: "audio/mpeg" }),
                    reader = new FileReader();
                reader.readAsDataURL(blob);
                reader.onload = () => {
                    // console.log(reader.result);
                    this.urls = reader.result;
                }
                reader.onerror = (e) => {
                    console.error("FileReader error:", e);
                }
            }).catch(error => {
                return this.$message({
                    duration: 3000,
                    offset: 50,
                    message: "查询音乐失败",
                    type: "error"
                });
            })
        }
    }, beforeMount() {
        this.xianshi();
        this.querymusic();
        this.timer = setInterval(() => {
            this.planTime -= 1000;
            this.time += 1000;
            if (this.planTime <= 0) {
                this.quit();
                clearInterval(this.timer);
            }
        }, 1000);
        // this.timer = setInterval(() => {
        //     this.time += 1000;
        //     if (this.time >= this.planTime) {
        //         clearInterval(this.timer);
        //     }
        // }, 1000);
        // console.log(this.length)
        // this.intervalId = setInterval(() => {
        //     this.length -= 1;
        //     if (this.length <= 0) {
        //         clearInterval(this.intervalId);
        //     }
        // }, 60000);
        // this.intervalId = setInterval(() => {
        //     this.length1 += 1;
        //     if (this.length >= this.planTime/(60*1000)) {
        //         clearInterval(this.intervalId);
        //     }
        // }, 60000);
    }, computed: {
        imageUrl() {
            return this.images[Math.floor(Math.random() * this.images.length)];
        }
    }
}
</script>

<style>
.time_main {
    /* background-color: #eeeeee !important; */
    width: 100%;
    height: 100vh;
    margin: 0 auto;
    background-repeat: no-repeat;
    background-size: 100% 100%;
}

#main {
    width: 1200px;
    height: 180px;
    color: #fff;
    text-align: center;
    /* margin: auto; */
    margin-top: 120px;
    margin-left: -450px;
    font-size: 50px;
}

.quan {
    width: 300px;
    height: 300px;
    border: 5px solid #fff;
    margin: 0 auto;
    border-radius: 50%;
    margin-bottom: 30px;
    margin-top: 30px;
}

.zlyj {
    /* margin-left:550px; */
    padding-top: 50px;
    /* background-color: black; */
    text-align: center;
    margin: 0 auto;
}

.mb {
    margin-left: 650px;
    margin-top: 50px;
    /* margin: auto; */
    display: inline-block
}

.el-form-item__content {
    font-size: 30px;
    display: block;
    text-align: center;
    /* margin: auto; */
    color: #fff;
}

.sz {
    font-size: 50px;
}

.study {
    margin-left: -80px;
    margin-top: 50px;
    margin: auto;
}

h4 {
    margin-left: 720px;
    color: #fff;
    font-size: 30px;
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