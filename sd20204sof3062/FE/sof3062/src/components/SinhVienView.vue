<template>
    <h1 style="text-align: center;">Thông tin sinh viên</h1>
  <table class="table">
    <thead>
      <tr>
        <th scope="col">Id</th>
        <th scope="col">Tên</th>
        <th scope="col">Tuổi</th>
        <th scope="col">Ngày sinh</th>
        <th scope="col">Giới tinh</th>
        <th scope="col">Lớp học</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="sinhVien in data" :key="sinhVien.id">
        <td>{{ sinhVien.id }}</td>
        <td>{{ sinhVien.ten }}</td>
        <td>{{ sinhVien.tuoi }}</td>
        <td>{{ sinhVien.ngaySinh }}</td>
        <td>{{ sinhVien.gioiTinh == true ? "Nam" : "Nữ" }}</td>
        <td>{{ sinhVien.lopHoc.ten }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { getAll } from "@/service/SinhVienService";
let data = ref([]);

const getAllSinhVien = async () => {
  console.log("hello");
  try {
    data.value = await getAll();
    console.log(data.value);
  } catch (error) {
    console.log(error);
  }
};

onMounted(getAllSinhVien);
</script>
