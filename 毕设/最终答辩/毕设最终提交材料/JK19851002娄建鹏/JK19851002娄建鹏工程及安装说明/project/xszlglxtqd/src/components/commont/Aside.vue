<template>
    <div class="aside">
        <el-row class="tac">
            <el-col :span="12">
                <el-menu class="side el-menu-vertical-demo" default-active="study_plan/main">
                    <h1>自律使你强大</h1>
                    <el-sub-menu index="1" v-if="seen">
                        <template #title><el-icon>
                                <User />
                            </el-icon>
                            <span>用户管理</span>
                        </template>
                        <el-menu-item index="user/main" @click="menu">管理员</el-menu-item>
                        <el-menu-item index="student/main" @click="menu">学生</el-menu-item>
                        <el-menu-item index="teacher/main" @click="menu">教师</el-menu-item>
                    </el-sub-menu>
                    <el-sub-menu index="2">
                        <template #title>
                            <el-icon>
                                <Location />
                            </el-icon>
                            <span>日常计划</span>
                        </template>
                        <el-menu-item index="study_plan/main" @click="menu">学习计划</el-menu-item>
                        <el-menu-item index="goal_plan/main" @click="menu">未来目标</el-menu-item>
                    </el-sub-menu>
                    <el-sub-menu index="3">
                        <template #title>
                            <el-icon>
                                <Document />
                            </el-icon>
                            <span>心得管理</span>
                        </template>
                        <el-menu-item index="experience/main" @click="menu">心得记录</el-menu-item>
                        <el-menu-item index="experience/view" @click="menu">心得社区</el-menu-item>
                    </el-sub-menu>
                    <el-menu-item index="notice/main" @click="menu">
                        <el-icon>
                            <Message />
                        </el-icon>我的通知
                    </el-menu-item>
                    <!-- <el-sub-menu index="5">
                        <template #title>
                            <el-icon>
                                <House />
                            </el-icon>
                            <span>自习教室</span>
                        </template>
                        <el-menu-item index="study_room/main" @click="menu">自习室</el-menu-item>
                        <el-menu-item index="study_room/book" @click="menu">资料分享</el-menu-item>
                        <el-menu-item index="study_room/question" @click="menu">问题解答</el-menu-item>
                    </el-sub-menu> -->
                    <el-menu-item index="study_room/main" @click="menu">
                        <el-icon>
                            <House />
                        </el-icon>自习教室
                    </el-menu-item>
                    <el-menu-item index="data_count/main" @click="menu">
                        <el-icon>
                            <PieChart />
                        </el-icon>数据统计
                    </el-menu-item>
                    <el-menu-item index="student/main" @click="menu" v-if="xsxx">
                        <el-icon>
                            <ChatLineSquare />
                        </el-icon>学生信息
                    </el-menu-item>
                </el-menu>
            </el-col>
        </el-row>
    </div>
</template>

<script setup>
import {
    Document,
    Location,
    PieChart,
    House,
    Message,
    User,
    ChatLineSquare
} from '@element-plus/icons-vue'

import router from "../../router";
let userGroup = sessionStorage.getItem("userGroup")
let seen = false;
let xsxx = true;
if (userGroup === "管理员") {
    seen = true;
    xsxx = false
}
const menu = (index) => {
    let ly = index.index;
    router.push('/' + ly).then(() => {
        setTimeout(router.go(0), 0);
    });
    // //触发面包屑更新
    // this.$store.commit('menuChange',index);
}
</script>


<style scoped="scoped">
.el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 100vh;
}

h1 {
    color: #00838F;
    text-align: center;
    margin-top: 10px;
    margin-left: 0px;
    margin-bottom: 10px;
    width: 200px;
}

.side span {
    color: #8f8a8a;
    font-weight: bolder;
}

.el-menu {
    position: fixed;
}

.el-menu .el-menu-item {
    color: #8f8a8a;
    font-weight: bolder;
}

.el-menu-item:hover {
    background-color: #59a8f7;
    color: #171616;
    font-weight: bolder;
}

.el-menu-item:focus {
    background-color: #59a8f7;
    color: #171616;
    font-weight: bolder;
}

.side {
    float: left;
    background: #feffff;
    color: #fff;
    overflow-y: scroll;
    height: 100vh;
}

.side::-webkit-scrollbar {
    display: none;
}</style>