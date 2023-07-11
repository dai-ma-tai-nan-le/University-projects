import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
//配置elementplus
import ElementPlus, { ElMessageBox } from 'element-plus';
import 'element-plus/dist/index.css';
//配置axios
import axios from 'axios';
import VueAxios from 'vue-axios'
axios.defaults.baseURL = "http://localhost:8080"

//请求拦截器
axios.interceptors.request.use(config => {
    var token = sessionStorage.getItem('token');
    var username = sessionStorage.getItem('username');
    config.headers['token'] = token
    config.headers['username'] = username
    return config;
}, error => {
    return Promise.reject(error);
})
//响应拦截器
axios.interceptors.response.use(response => {
    let res = response;
    // console.log(res)
    if (res.data.code === 410) {
        // // 如果响应失败，获取错误状态码和信息
        let message = res.data.mes;
        // 使用element-massage显示错误信息
        ElMessageBox.confirm(
            message,
            '错误',
            {
                confirmButtonText: '重新登陆',
                type: 'error',
            }
        ).then(() => {
            sessionStorage.clear();//清空信息
            router.push("/login").then(() => {
                setTimeout(router.go(0), 0);
            });
        })
    }
    else if (res.data.code === 201) {
        ElMessageBox.confirm(
            '解锁成就------小试牛刀',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    else if (res.data.code === 202) {
        ElMessageBox.confirm(
            '解锁成就------初有成效',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    else if (res.data.code === 203) {
        ElMessageBox.confirm(
            '解锁成就------100次的坚持',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    else if (res.data.code === 204) {
        ElMessageBox.confirm(
            '解锁成就------持之以恒',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    else if (res.data.code === 205) {
        ElMessageBox.confirm(
            '解锁成就------优秀是一种习惯',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    else if (res.data.code === 206) {
        ElMessageBox.confirm(
            '解锁成就------初出茅庐',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    else if (res.data.code === 207) {
        ElMessageBox.confirm(
            '解锁成就------水滴石穿',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    else if (res.data.code === 208) {
        ElMessageBox.confirm(
            '解锁成就------铁杵成针',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    else if (res.data.code === 209) {
        ElMessageBox.confirm(
            '解锁成就------运筹帷幄',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    else if (res.data.code === 210) {
        ElMessageBox.confirm(
            '解锁成就------人生赢家',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    else if (res.data.code === 211) {
        ElMessageBox.confirm(
            '解锁成就------有条不紊',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    else if (res.data.code === 212) {
        ElMessageBox.confirm(
            '解锁成就------牛刀小试',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    else if (res.data.code === 213) {
        ElMessageBox.confirm(
            '解锁成就------毅力超人',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    else if (res.data.code === 214) {
        ElMessageBox.confirm(
            '解锁成就------多一度热爱',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    else if (res.data.code === 215) {
        ElMessageBox.confirm(
            '解锁成就------习惯成自然',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    else if (res.data.code === 216) {
        ElMessageBox.confirm(
            '解锁成就------效果初显',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    else if (res.data.code === 217) {
        ElMessageBox.confirm(
            '解锁成就------乘风破浪',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    else if (res.data.code === 218) {
        ElMessageBox.confirm(
            '解锁成就------屹立不倒',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    else if (res.data.code === 219) {
        ElMessageBox.confirm(
            '解锁成就------冰冻三尺',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    else if (res.data.code === 220) {
        ElMessageBox.confirm(
            '解锁成就------沧海桑田',
            '提示',
            {
                confirmButtonText: '确定',
                type: 'success',
            }
        ).then(() => {
        })
    }
    return res;
}, error => {
    // 对响应错误做点什么
    return Promise.reject(error);
});

createApp(App).use(ElementPlus).use(store).use(router).use(VueAxios, axios).mount('#app')
