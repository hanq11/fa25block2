<script setup>
 // Setup - compositon api
 // khong co chu setup - option api
 // var - khong nen dung
 // let - thay doi duoc
 // const - khong thay duoc hoan toan

 let message = "Hello world"

 const sayHi = () => { // arrow function
    return "FPOLY Say hi"
 }
</script>

<template>
    <p>{{ message }}</p>
    <p>{{ sayHi()  }}</p>
</template>