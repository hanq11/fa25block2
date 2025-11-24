<!-- Nhập vào điểm của học sinh và in ra xếp loại tương ứng: -->
<!-- + Nếu ĐTB < 5.0 thì xếp loại yếu -->
<!-- + Nếu 5.0 ≤ ĐTB < 6.5 thì xếp loại trung bình -->
<!-- + Nếu 6.5 ≤ ĐTB < 8.0 thì xếp loại khá -->
<!-- + Nếu ĐTB 8.0 ≤ ĐTB < 9 thì xếp loại giỏi -->
<!-- + Nếu ĐTB ≥ 9.0 thì xếp loại xuất sắc -->

<script setup>
import { ref } from 'vue';

const diem = ref(0)

const danhSach = ref([
  "Nguyễn Văn A",
  "Nguyễn Văn B",
  "Nguyễn Văn C",
])

const hoaQua = ref([
  { id: 1, name: 'Táo', price: '$10' },
  { id: 2, name: 'Chuối', price: '$15' },
  { id: 3, name: 'Dưa hấu', price: '$18' },
])
</script>

<template>
  Nhap diem: <input type="number" v-model="diem" min="0" max="10">
  <p v-if="diem < 5">Yếu</p>
  <p v-else-if="diem < 6.5">Trung bình</p>
  <p v-else-if="diem < 8">Khá</p>
  <p v-else-if="diem < 9">Giỏi</p>
  <p v-else>Xuất xắc</p>

  <h1>Demo v-for 1</h1>
  <ul>
    <li v-for="(ten, index) in danhSach">{{ ten + " index: " + index }}</li>
  </ul>
  <h1>Demo v-for 2: tên phải chứa chữ A</h1>
  <ul>
    <template v-for="ten in danhSach">
      <li v-if="ten.includes('A')">{{ ten }}</li>
    </template>
  </ul>
  <h1>Demo v-for 3: object</h1>
  <table class="table">
    <thead>
      <tr>
        <th scope="col">Id</th>
        <th scope="col">Ten</th>
        <th scope="col">Gia</th>
      </tr>
    </thead>
    <tbody>
      <template v-for="hq in hoaQua" :key="hq.id">
        <tr>
          <td>{{ hq.id }}</td>
          <td>{{ hq.name }}</td>
          <td>{{ hq.price }}</td>
        </tr>
      </template>
    </tbody>
  </table>
</template>
