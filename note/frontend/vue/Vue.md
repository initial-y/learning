# Vue

## Vue组件的核心概念

### 属性

#### 自定义属性props

组件props中声明的属性

#### 原生属性attrs

没有声明的属性，默认自动挂载到组件根元素上，设置inheritAttrs为fals可关闭自动挂载

#### 特殊属性class、style

挂载到组件根元素上，支持字符串、对象、数组等多种语法 

### 事件

#### 普通事件

@click 、@input、@change、@xxx等事件，通过 `this.$emit('xxx',...)`触发

#### 修饰符事件

@input.trim, @click.stop, @submit.prevent等，一般用于元素HTML元素， 自定义组件需要自行开发支持

### 插槽

#### 普通插槽

<template slot="xxx">...</template>

<template v-slot:xxx>...</template>

#### 作用域插槽

<template slot="xxx" slot-scope="props">...</template>

<template v-slot:xxx slot-scope="props">...</template>

