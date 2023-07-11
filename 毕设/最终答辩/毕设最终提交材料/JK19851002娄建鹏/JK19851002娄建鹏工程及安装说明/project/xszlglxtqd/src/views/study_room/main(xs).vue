<template>
    <div class="room_main">
        <div class="quan">
            <span class="quan1" @click="cjzxs()">
                <h1>创建自习室</h1>
            </span>
            <span class="quan2" @click="jrzxs()">
                <h1>加入自习室</h1>
            </span>
        </div>
        <div class="zdmb" @click="smszxs()">什么是自习室？</div>
        <!--对话框-->
        <el-dialog title="提示" v-model="centerDialogVisible" width="50%" center>
            <el-collapse v-model="activeName" accordion>
                <el-collapse-item title="什么是自习室？" name="1">
                    <div>
                        你可以将自习窒看做是一个学习小组。
                    </div>
                    <div>
                        你可以创建一个自习室，让你的室友、同学等小伙伴加入，加入后你们可以互相看到对方当天的专注时间和专注状态。你也可以通过输入加入码的方式加入别人创建的自习室。
                    </div>
                    <div>
                        您可以查看到相同自习室好友的专注时长和专注状态。数据会在您专注计时结束后刷新。
                    </div>
                    <div>
                        我们专注于单个用户的专注体验，自习室功能支持查看专注时长，资料分享以及问题解答。
                    </div>
                </el-collapse-item>
                <el-collapse-item title="我该如何创建或加入自习室？" name="2">
                    <div>
                        创建:若您的专注时长到达了30分钟以上，点击自习室页面的创建按钮即可创建。创建完成后会生成加入码，其他用户可以通过输入加入码来加入。
                    </div>
                    <div>
                        加入:点击自习室页面的加入按钮，点击加入码加入即可。或者点击浏览或搜索自习室进行查看公开的自习室，喜欢哪个点击卡片右边的加入按钮即可。
                    </div>
                    <div>
                        注:若您已经创建过了自习室，需要退出并解散才可以加入别人的自习室。
                    </div>
                </el-collapse-item>
                <el-collapse-item title="如何查看自习室内成员的学习时间分布？" name="3">
                    <div>
                        点击成员的信息卡片即可直接查看成员的专注数据。
                    </div>
                    <div>
                        若您不想让别人查看您的专注数据，请点击"自习室自己那一行"，关闭专注内容对自习室好友可见开关。
                    </div>
                </el-collapse-item>
                <el-collapse-item title="如何移除不活跃的成员？" name="4">
                    <div>
                        创建者点击成员的信息卡片，点击移除即可直接移除成员。
                    </div>
                </el-collapse-item>
            </el-collapse>
        </el-dialog>
        <!--对话框-->
        <el-dialog title="加入方式" v-model="centerDialogVisible1" width="50%" center>
            <div class="jr" @click="llssjr()">浏览或搜索公开自习室加入</div>
            <div class="jr" @click="jrmjr()">通过加入码加入自习室</div>
        </el-dialog>
        <!--对话框-->
        <el-dialog title="通过加入码加入自习室" v-model="centerDialogVisible2" width="50%" center>
            <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                <el-form-item label="加入码" prop="code">
                    <el-input v-model="form.code" placeholder="请输入自习室加入码加入自习室" />
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer" style="margin-left: 285px;">
                <el-button @click="centerDialogVisible2 = false">取 消</el-button>
                <el-button type="primary" @click="submit()">加入</el-button>
            </span>
        </el-dialog>
        <el-dialog title="密码输入" v-model="centerDialogVisible4" width="50%" center>
            <el-form ref="form1" :model="form1" :rules="rules" label-width="80px">
                <el-form-item label="密码" prop="password">
                    <el-input v-model="form1.password" placeholder="请输入加入自习室所需的密码" />
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer" style="margin-left: 285px;">
                <el-button @click="centerDialogVisible4 = false">取 消</el-button>
                <el-button type="primary" @click="zxsadd()">加入</el-button>
            </span>
        </el-dialog>
        <!--对话框-->
        <el-dialog title="公开自习室" v-model="centerDialogVisible3" width="50%" center>
            <div>
                <el-form :inline="true" :model="form1">
                    <el-form-item label="自习室名称" prop="roomName">
                        <el-input v-model="form1.roomName" placeholder="请输入自习室名称关键词进行查询" style="width: 310px;" />
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="query()">查询</el-button>
                        <el-button type="primary" @click="shuaxin()">重置</el-button>
                    </el-form-item>
                </el-form>
            </div>
            <div>
                <el-card>
                    <div class="zxskp" v-for="index in list" :key="index">
                        <div>
                            <div style="font-size: 18px;width: 600px;font-weight: 600;">{{index.roomName}}</div>
                            <div style="width: 400px;">{{index.roomIntroduce}}</div>
                            <el-button v-if="index.password!='d41d8cd98f00b204e9800998ecf8427e'" class="xymm">需要密码</el-button>
                            <el-button class="jrrs">{{index.joinNum}}人</el-button>
                        </div>
                        <div class="zxsyou">
                            <div style="width: 200px;">{{index.createTime}}</div>
                            <el-button class="xdrs">限定{{ index.limitNum }}人</el-button>
                        </div>
                        <div class="jiaru" @click="addzxs(index)"><el-button>加入</el-button></div>
                    </div>
                </el-card>
            </div>
        </el-dialog>
    </div>
</template>
<script>
let username = sessionStorage.getItem("username");
import router from '../../router';
export default {
    data() {
        return {
            centerDialogVisible: false,
            centerDialogVisible1: false,
            centerDialogVisible2: false,
            centerDialogVisible3: false,
            centerDialogVisible4: false,
            form: {
                code: '',
            },
            form1: {
                roomName: '',
                password: '',
                id:''
            },
            rules: {
                code: [{ required: true, message: '自习室加入码不能为空！', trigger: 'blur' },],
                password: [{ required: true, message: '自习室加入所需密码不能为空！', trigger: 'blur' },],
            },
            list:[],
        }
    },
    methods: {
        smszxs() {
            this.centerDialogVisible = true;
        }, cjzxs() {
            this.axios.post('/studyRoom/cxzzsj', {
                username: username,
            })
                .then(res => res.data).then(res => {
                    // console.log(res);
                    if (res.code == 200) {
                        router.push("/study_room/create").then(() => {
                            setTimeout(router.go(0), 0);
                        });
                    } else if (res.code == 407) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '专注时长小于30分钟，自习室创建失败',
                            type: 'error'
                        });
                    }
                    else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '自习室创建失败',
                            type: 'error'
                        });
                    }
                }
                )
        }, jrzxs() {
            this.centerDialogVisible1 = true;
        }, jrmjr() {
            this.centerDialogVisible1 = false;
            this.centerDialogVisible2 = true;
            this.$nextTick(() => {
                this.$refs.form.resetFields(); //刷新
            })
        }, submit() {
            this.axios.post('/studyRoom/codeadd', {
                username: username,
                code: this.form.code
            })
                .then(res => res.data).then(res => {
                    // console.log(res);
                    if (res.code == 200) {
                        router.push("/study_room/view1").then(() => {
                            setTimeout(router.go(0), 0);
                        });
                    } else if (res.code == 411) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '加入失败：自习室不存在或已删除，请检查加入码',
                            type: 'error'
                        });
                    }
                    else if (res.code == 412) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '加入失败：自习室人数已超过人数上限',
                            type: 'error'
                        });
                    }
                    else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '自习室加入失败',
                            type: 'error'
                        });
                    }
                }
                )
        }, llssjr() {
            this.centerDialogVisible1 = false;
            this.centerDialogVisible3 = true;
        }, query() {
            this.axios.post('/studyRoom/zxslist', {
                roomName: this.form1.roomName,
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
        },shuaxin(){
            this.form1.roomName='';
            this.axios.post('/studyRoom/zxslist', {
                roomName: this.form1.roomName,
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
        },addzxs(index){
            let index1=JSON.parse(JSON.stringify(index));
            if (index1.password==='d41d8cd98f00b204e9800998ecf8427e') {
                this.axios.post('/studyRoom/llssadd', {
                username: username,
                id:index1.studyRoomId
            })
                .then(res => res.data).then(res => {
                    // console.log(res);
                    if (res.code == 200) {
                        router.push("/study_room/view1").then(() => {
                            setTimeout(router.go(0), 0);
                        });
                    } else if (res.code == 411) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '加入失败：自习室不存在或已删除',
                            type: 'error'
                        });
                    }
                    else if (res.code == 412) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '加入失败：自习室人数已超过人数上限',
                            type: 'error'
                        });
                    }
                    else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '自习室加入失败',
                            type: 'error'
                        });
                    }
                }
                )
            }else{
                this.centerDialogVisible4=true;
                this.form1.id=index1.studyRoomId
            }
        },zxsadd(){
        this.axios.post('/studyRoom/addxymm', {
                username: username,
                id:this.form1.id,
                password:this.form1.password
            })
                .then(res => res.data).then(res => {
                    // console.log(res);
                    if (res.code == 200) {
                        router.push("/study_room/view1").then(() => {
                            setTimeout(router.go(0), 0);
                        });
                    } else if (res.code == 411) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '加入失败：自习室不存在或已删除',
                            type: 'error'
                        });
                    }
                    else if (res.code == 412) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '加入失败：自习室人数已超过人数上限',
                            type: 'error'
                        });
                    }
                    else if (res.code == 413) {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '加入失败：密码错误',
                            type: 'error'
                        });
                    }
                    else {
                        this.$message({
                            duration: 3000,
                            offset: 50,
                            message: '自习室加入失败',
                            type: 'error'
                        });
                    }
                }
                )
        }
    }, beforeMount() {
        this.query();
    }
}
</script>

<style>
.room_main {
    padding: 2rem 1rem;
    background-color: #eeeeee !important;
    width: 70%;
    height: 92vh;
    margin: 0 auto;
    padding: 0;
}

.el-form-item__label {
    color: #00838F !important;
}

.el-dialog__title {
    color: #00838F !important;
}

.quan {
    width: 1000px;
    height: 400px;
    margin: auto;
    display: flex;
    align-items: center;
    padding-top: 100px;
    /* justify-content: center; */
}

.quan1 {
    width: 300px;
    height: 300px;
    display: block;
    border: solid 2px #eeeeee;
    border-radius: 50%;
    margin-left: 130px;
    background-color: rgb(55, 161, 253);
    cursor: pointer;
}

.quan1 h1 {
    text-align: center;
    color: #fff;
    font-size: 40px;
    margin-top: 120px;
    cursor: pointer;
}

.quan2 h1 {
    text-align: center;
    color: #fff;
    font-size: 40px;
    margin-top: 120px;
    cursor: pointer;
}

.quan2 {
    width: 300px;
    height: 300px;
    display: block;
    margin-left: 130px;
    border: solid 2px #eeeeee;
    border-radius: 50%;
    background-color: rgb(141, 141, 141);
    cursor: pointer;
}

.zdmb {
    /* width: 100%; */
    padding-top: 50px;
    margin: auto;
    text-align: center;
    font-size: 30px;
    cursor: pointer;
    padding-bottom: 40px;
}

.el-collapse-item__header {
    padding-left: 20px;
    font-weight: 600;
    color: #000000;
}

.el-collapse-item__content {
    padding-left: 40px;
    margin-top: 5px;
    font-size: 15px;
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

.zxskp {
    display: flex;
    align-items: center;
    margin-bottom: 5px;
    padding-bottom: 5px;
    border-bottom: solid 2px #eeeeee;
}
.zxsyou{
    margin-left: -200px;
    margin-top: 20px;
}
/* .jiaru{
    margin-left: 150px;
} */
.jiaru button{
    width: 50px;
    height: 30px;
    background-color: rgb(255, 159, 159);
    color: #ff0000;
}
.xymm{
    /* width: 65px; */
    height: 20px;
    font-size: 10px;
    background-color: rgb(231, 208, 253);
}
.jrrs{
    height: 20px;
    font-size: 10px;
    background-color: rgb(253, 214, 187);
    color: #ff7300;
}
.xdrs{
    height: 20px;
    font-size: 10px;
    background-color: rgb(255, 220, 195);
    color: #ff7300;
}
</style>