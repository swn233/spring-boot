import './assets/main.css'


import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import ElementPlus from 'element-plus'


import { createApp } from 'vue'
import { createPinia } from 'pinia'

import qs from 'qs';

import axios from "@/utils/request.js"

import App from './App.vue'
import router from './router'


const app = createApp(App)
app.config.globalProperties.$axios = axios
app.config.globalProperties.$qs = qs
app.provide('$axios', axios)
app.use(ElementPlus)
app.use(createPinia())
app.use(router)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
  }

app.mount('#app')
