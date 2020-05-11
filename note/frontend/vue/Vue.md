# Vue

## 基础

### Vue组件的核心概念

#### 属性

##### 自定义属性props

组件props中声明的属性

##### 原生属性attrs

没有声明的属性，默认自动挂载到组件根元素上，设置inheritAttrs为fals可关闭自动挂载

##### 特殊属性class、style

挂载到组件根元素上，支持字符串、对象、数组等多种语法 

#### 事件

##### 普通事件

@click 、@input、@change、@xxx等事件，通过 `this.$emit('xxx',...)`触发

##### 修饰符事件

@input.trim, @click.stop, @submit.prevent等，一般用于元素HTML元素， 自定义组件需要自行开发支持

#### 插槽

##### 普通插槽

<template slot="xxx">...</template>
<template v-slot:xxx>...</template>
##### 作用域插槽

<template slot="xxx" slot-scope="props">...</template>
<template v-slot:xxx slot-scope="props">...</template>

### 双向绑定和单向数据流

#### 双向绑定

model的更新会触发view的更新，view的更新会触发model的更新。

#### 单向数据流

model的更新会触发view的更新。

#### Vue是单向数据流

- Vue是单向数据流，不是双向绑定
- Vue的双向绑定是语法糖
- Object.defineProperty是用来做响应式更新的，和双向绑定没关系

### 虚拟DOM及Key属性

### 如何触发组件的更新

#### 状态与属性

- 状态是组件自身的数据，属性是来自父组件的数据
- 状态的改变未必会触发更新，属性的改变也未必会触发更新

#### 响应式更新

### 计算属性和监听器

#### 计算属性computed

- 减少模板中计算逻辑
- 数据缓存
- 依赖固定的数据类型（响应式数据）

#### 监听器watch

- 灵活、通用
- watch中可以执行任何逻辑，入函数节流，Ajax异步获取数据，甚至操作Dom

#### 计算属性和监听器的区别

- computed能做的watch都能做，反之不行
- 能用computed的尽量用computed
  - watch操作相对于computed复杂，冗余

