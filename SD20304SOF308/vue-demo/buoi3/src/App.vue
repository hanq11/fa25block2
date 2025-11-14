<script setup>
import { ref } from 'vue'

let name = "Nguyen Van A"
let url = "https://google.com"

const print = () => {
  console.log(name)
}
const addChar = () => {
  name = name + 1;
}
// REF
let tenNhanVien = ref("Nhan vien")
let count = ref(0)
const tang1 = () => {
  count.value++
}

let thongTin = ref({
  ten: "Nguyen Van C",
  tuoi: 19
})

const thayDoiThongTin = () => {
  thongTin.value.ten += 'A'
  thongTin.value.tuoi++
}
</script>

<template>
  Name: <input type="text" :value="name">
  <br>
  <button><a :href="url">Click me</a></button>
  <button @click="print()">Print</button>
  <button @click="addChar()">Add char to name</button>
  <!-- REF -->
  <br>
  Nhan vien: <input type="text" v-model="tenNhanVien">
  <br>
  {{ tenNhanVien }}
  <br> 
  Bien dem: {{ count }}, <button @click="tang1()">Tang 1</button>
  <br>
  Ten nguoi dung: {{ thongTin.ten }} co tuoi la: {{ thongTin.tuoi }} <button @click="thayDoiThongTin()">Thay doi</button>
</template>