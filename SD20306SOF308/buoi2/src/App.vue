<script setup>
  import HelloSOF308 from './components/HelloSOF308.vue';

  // var -- khong dung
  // let
  // const
  let message = "Day la thong bao"
  let chuDo = "color:red"

  const printHello = () => { // es6
    alert("hello world")
  }
</script>

<template>
  <HelloSOF308></HelloSOF308>
  <span :style="chuDo">{{ message.split('').reverse().join('') }}</span>

  <button @click="printHello()">Console log</button>

  <p v-if="1 == 2">Day la v-if</p>
  <p v-show="1 == 2">Day la v-show</p>
</template>
