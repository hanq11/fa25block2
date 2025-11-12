<script setup>
 // Setup - compositon api
 // khong co chu setup - option api
 // var - khong nen dung
 // let - thay doi duoc
 // const - khong thay duoc hoan toan

 let message = "Hello world"

 const sayHi = () => { // arrow function
    return "<b>FPOLY Say hi</b>"
 }

 const content = "<b>Demo V-HTML</b>"
 let color = "color: red";

 let ten = "An"

 // kieu viet thuong - noi chuoi
 let gioiThieu = "Sinh vien " + ten + " dang hoc o FPOLY";
 // template literals
 let gioiThieu1 = `Sinh vien ${ten} dang hoc o FPOLY`;

 let thongBao = () => {
    alert('Hello from method handler!');
 }
</script>

<template>
    <!-- interpolation - noi suy -->
    <p>{{ message.split("").reverse().join("") }}</p> 
    <p>{{ sayHi()  }}</p>
    <p :style="color" v-html="content"></p>
    <p v-if="1 == 2">Demo v-if</p>
    <p v-show="1 == 2">Demo v-show</p>
    <button @click="thongBao()">Alert</button>

    <table class="table">
  <thead>
    <tr>
      <th scope="col">@</th>
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Handle</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>John</td>
      <td>Doe</td>
      <td>@social</td>
    </tr>
  </tbody>
</table>
</template>