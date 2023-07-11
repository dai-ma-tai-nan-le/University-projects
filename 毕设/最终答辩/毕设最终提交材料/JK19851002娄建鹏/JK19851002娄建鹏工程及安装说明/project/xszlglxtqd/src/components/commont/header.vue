<template>
    <div class="header">
        <el-menu mode="horizontal" @select="handleSelect" style="background-color: #00838F;">
            <div class="action_center">学生自我管理系统后台</div>
            <div class="action_right">
                <el-dropdown @command="command">
                    <div class="el-dropdown-link" style="margin-right: 2rem;">
                        <el-avatar style="overflow: hidden;">
                            <img v-if="seen" :src="tuPianUrl + avatar" />
                            <img v-else src="/img/error.png" />
                            <!-- <img style="width: 2.3rem; overflow: hidden" src="../../../public/img/error.png" /> -->
                        </el-avatar>
                        <span style="font-size: 25px;color: #fff;margin-left: 10px;">
                            {{ username }}
                        </span>
                    </div>
                    <template #dropdown>
                        <el-dropdown-menu>
                            <el-dropdown-item command="user/info">个人信息</el-dropdown-item>
                            <el-dropdown-item command="user/password">修改密码</el-dropdown-item>
                            <el-dropdown-item command="/quit" divided>退出</el-dropdown-item>
                        </el-dropdown-menu>
                    </template>
                </el-dropdown>
            </div>
        </el-menu>
    </div>
</template>

<script setup>
import { ElMessage, ElMessageBox } from 'element-plus'
import router from "../../router";
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
            '是否确认退出登录吗',
            '注意',
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
    } else {
        router.push("/" + command).then(() => {
            setTimeout(router.go(0), 0);
        });
    }
}
</script>

<style>
.header {
    width: 90%;
    position: fixed;
    z-index: 9999;
}

.el-breadcrumb {
    display: inline-flex;
    margin-left: 30px;
}

.action_center {
    line-height: 51px;
    width: 700px;
    margin: auto;
    margin-left: 300px;
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
    margin-right: 100px;
    width: 30%;

}

.el-dropdown {
    color: #fff;
    border: none;
}
</style>