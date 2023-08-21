<template>
  <el-container class="layout-container-demo" style="height:  100%;width: 100%;box-shadow: 20px 0 6px rgb(0,21,22)">
    <el-aside :width="sidewidth + 'px'" style=" height: 100%;">
      <el-scrollbar style="  height:  100%;width: 100%;display: flex;overflow: hidden">
        <!--导航栏-->
        <el-menu :default-openeds="['1', '3']"
          style="flex :1; height: 961px;width :98%; border:0px solid #ccc;overflow-y: auto; box-shadow: 2px 0 6px rgb(0,21,22)"
          active-text-color="#ffd04b" background-color="#545c64" class="el-menu-vertical-demo" default-active="2"
          text-color="#fff" :collapse-transition="false" :collapse="isCollapse">
          <div style="height: 60px;line-height: 60px; text-align: center;color: #fff">
            <img src="./assets/logo.svg" alt="图片" style="width: 20px ;position: relative;top: 3px;margin-right: 5px;">
            <b v-show="logotextshow">餐饮管理系统</b>
          </div>
          <el-sub-menu index="1">
            <template #title>
              <el-icon>
                <message />
              </el-icon><span>Navigator One</span>
            </template>
            <el-menu-item-group>
              <template #title><span>Group 1</span></template>
              <el-menu-item index="1-1">Option 1</el-menu-item>
              <el-menu-item index="1-2">Option 2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="Group 2">
              <el-menu-item index="1-3">Option 3</el-menu-item>
            </el-menu-item-group>
            <el-sub-menu index="1-4">
              <template #title>Option4</template>
              <el-menu-item index="1-4-1">Option 4-1</el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
          <el-sub-menu index="2">
            <template #title>
              <el-icon><icon-menu /></el-icon><span>Navigator Two</span>
            </template>
            <el-menu-item-group>
              <template #title>Group 1</template>
              <el-menu-item index="2-1">Option 1</el-menu-item>
              <el-menu-item index="2-2">Option 2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="Group 2">
              <el-menu-item index="2-3">Option 3</el-menu-item>
            </el-menu-item-group>
            <el-sub-menu index="2-4">
              <template #title>Option 4</template>
              <el-menu-item index="2-4-1">Option 4-1</el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
          <el-sub-menu index="3">
            <template #title>
              <el-icon>
                <setting />
              </el-icon><span>Navigator Three</span>
            </template>
            <el-menu-item-group>
              <template #title>Group 1</template>
              <el-menu-item index="3-1">Option 1</el-menu-item>
              <el-menu-item index="3-2">Option 2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="Group 2">
              <el-menu-item index="3-3">Option 3</el-menu-item>
            </el-menu-item-group>
            <el-sub-menu index="3-4">
              <template #title>Option 4</template>
              <el-menu-item index="3-4-1">Option 4-1</el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
        </el-menu>
      </el-scrollbar>
    </el-aside>


    <!--内部容器-->
    <el-container style="border: 1px solid #ccc;">



      <el-header style="   font-size: 12px; border-bottom: 1px solid #ccc;line-height: 60px; display: flex;">
        <span style="flex: 1;cursor: pointer"><el-icon @click="btnClickIcon" v-model="isCollapse"
            style="margin-left: 10px; margin-top: 1px;" size="20">
            <Switch />
          </el-icon></span>
        <div class="toolbar">
          <el-dropdown>
            <el-icon style="margin-right: 10px; margin-top: 1px" size="20">
              <setting />
            </el-icon>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>个人信息</el-dropdown-item>
                <el-dropdown-item>设置</el-dropdown-item>
                <el-dropdown-item>退出</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
          <span style="margin-right:10px">姚逸童</span>
        </div>

      </el-header>

      <!--搜索框-->
      <div style="margin-left: 50px;padding: 10px 0;">
        <el-input v-model="username" style="width: 200px;" placeholder="Search" :suffix-icon="Search" ></el-input>
        <el-button
          style="margin-left: 50px; " type="primary" @click="load">搜索</el-button>
      </div>
      <!--新增-->
      <div style="margin-left: 50px; margin: 10px 0;">
        <el-button style="margin-left: 50px; " type="primary" icon="CirclePlusFilled">新增</el-button>
        <el-button style="margin-left: 50px; " type="danger" icon="MoreFilled">批量刪除</el-button>
        <el-button style="margin-left: 50px; " type="primary" icon="DocumentAdd">导入</el-button>
        <el-button style="margin-left: 50px; " type="primary" icon="Document">导出</el-button>
      </div>

      <el-main style="margin-left: 25px;margin-right: 25px;overflow: hidden">
        <!--页签 无法显示，未解决-->
        <div style="margin-bottom: 30px;">
          <template>
            <el-breadcrumb separator="/">
              <el-breadcrumb-item :to="{ path: '/' }">homepage</el-breadcrumb-item>
              <el-breadcrumb-item><a href="/">promotion management</a></el-breadcrumb-item>
              <el-breadcrumb-item>promotion list</el-breadcrumb-item>
              <el-breadcrumb-item>promotion detail</el-breadcrumb-item>
            </el-breadcrumb>
          </template>
        </div>


        <el-scrollbar style="overflow: hidden">
          <el-table :data="tableData" stripe border height="800" style="width: 100%; " table-layout="auto"
            :header-cell-style="HeaderStyle">
            <el-table-column prop="id" label="ID" />
            <el-table-column prop="username" label="用户名" />
            <el-table-column prop="nickname" label="昵称" />
            <el-table-column prop="email" label="邮箱" />
            <el-table-column prop="phone" label="电话" />
            <el-table-column prop="address" label="地址" />
            <el-table-column label="操作">
              <template #default="scope">
                <el-button size="small" type="success" @clicyk="handleEdit(scope.$index, scope.row)">编辑</el-button>
                <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-scrollbar>
      </el-main>>

      <!--分页-->
      <div class="demo-pagination-block">
        <div class="demonstration"></div>
        <el-pagination style="padding: 10px;" v-model:current-page="pageNum" v-model:page-size="pageSize"
          :page-sizes="[5, 10, 15, 20]" :small="small" :disabled="disabled" :background="background"
          layout="total,sizes,prev, pager, next, jumper" :total="total" @size-change="handleSizeChange"
          @current-change="handleCurrentChange" />
      </div>

    </el-container>

  </el-container>
</template>


<script lang="ts" setup>
import { ref } from 'vue'
import { Menu as IconMenu, Message, Setting, Document, Location, Fold, Search } from '@element-plus/icons-vue'
const username=ref("")
const pageNum=ref(2)
const pageSize=ref(10)
//实现分页功能
const total=ref(1000)
const currentPage3 = ref(5)
const pageSize3 = ref(10)
const small = ref(false)
const background = ref(true)
const disabled = ref(false)

const handleSizeChange = (val: number) => {
  console.log(`${val} items per page`)
  pageSize.value=val
  load()
}
const handleCurrentChange = (val: number) => {
  console.log(`current page: ${val}`)
  pageNum.value=val
  load()
}

function HeaderStyle(){
  return {
    background: '#f2f2f2',
    color: '#333',
    fontWeight: 'bold',
  };
}


//实现菜单收缩的js
const logotextshow = ref(true)
const isCollapse = ref(false)
const sidewidth = ref(200)
function btnClickIcon() {
  isCollapse.value = !isCollapse.value;
  if (isCollapse.value) {
    sidewidth.value = 70;
    logotextshow.value = false;
  }
  if (!isCollapse.value) {
    sidewidth.value = 200;
    logotextshow.value = true;

  }
}


// 初始数据
const item = {
  date: '2023-08-04',
  name: 'YYT',
  address: '南京信息工程大学',
};

// 生成一个随机字符串以使数据唯一
function generateRandomString(length = 5) {
  const characters = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
  let randomString = '';
  for (let i = 0; i < length; i++) {
    const randomIndex = Math.floor(Math.random() * characters.length);
    randomString += characters.charAt(randomIndex);
  }
  return randomString;
}

// 生成30条不同的数据项
const tableData = ref(Array.from({ length: 30 }, (_, index) => ({
  ...item,
  name: item.name + generateRandomString(), // 在名字后面附加一个随机字符串
  date: '2023-08-' + (index + 1).toString().padStart(2, '0'), // 将日期的日增加
})));


//请求分页查询数据
import { onMounted } from 'vue'

function load() {
  fetch("http://localhost:8080/user/page?pageNum="+pageNum.value.toString()+"&pageSize="+pageSize.value.toString()+"&username="+username.value.toString())
      .then(res => res.json())
      .then(res => {
        console.log(res);
        tableData.value=res.data;
        total.value=res.total;
      });
}
onMounted(load);
</script>

<style scoped>
.layout-container-demo .el-header {
  position: relative;
  background-color: var(--el-color-primary-light-7);
  color: var(--el-text-color-primary);
}

.layout-container-demo .el-aside {
  color: var(--el-text-color-primary);
  background: var(--el-color-primary-light-8);
}

.layout-container-demo .el-menu {
  border-right: none;
}

.layout-container-demo .el-main {
  padding: 0;
}

.layout-container-demo .toolbar {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  right: 20px;
}

.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}

.demo-pagination-block+.demo-pagination-block {
  margin-top: 10px;
}

.demo-pagination-block .demonstration {
  margin-bottom: 16px;
}
</style>




