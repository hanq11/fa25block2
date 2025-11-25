<script setup>
import { ref } from 'vue';


const name = 'Nguyen Van A'
// doi tuong sinh vien 
const sinhvien = ref({
  mssv: 'Ph54123',
  hoten: 'Dong Minh Thuy',
  diachi: 'Ha Noi',
  gioitinh: 'Nu',
  trangthai: 'Hoc lai'
})


const listString = ref(['Nguyen Van A', 'Tran Thi B'])

const listSinhVien = ref([
  {
    mssv: 'Ph54123',
    hoten: 'Dong Minh Thuy',
    diachi: 'Ha Noi',
    gioitinh: 'Nu',
    trangthai: 'Hoc lai'
  },
  {
    mssv: 'Ph54124',
    hoten: 'Nguyen Van A',
    diachi: 'Ha Noi',
    gioitinh: 'Nam',
    trangthai: 'Qua mon'
  },
  {
    mssv: 'Ph54133',
    hoten: 'Tran Thi B',
    diachi: 'Ha Noi',
    gioitinh: 'Nu',
    trangthai: 'Hoc lai'
  },
  {
    mssv: 'Ph54125',
    hoten: 'Tran Van X',
    diachi: 'Ha Noi',
    gioitinh: 'Nam',
    trangthai: 'Hoc lai'
  }
])

const newSinhVien = ref({
  mssv: '',
  hoten: '',
  diachi: '',
  gioitinh: '',
  trangthai: ''
})

const add = () => {
  listSinhVien.value.push({
    ...newSinhVien.value
  });
}
const updateIndex = ref(-1)

const detail = (index) => {
  updateIndex.value = index
  newSinhVien.value = {
    ...listSinhVien.value[index]
  }
}

const update = () => {
  listSinhVien.value[updateIndex.value] = {
    ...newSinhVien.value
  }
  updateIndex.value = -1
}

const deleteSinhVien = (index) => {
  listSinhVien.value.splice(index, 1)
}

</script>

<template>

  <form>
    <div class="mb-3">
      <label class="form-label">Ma sinh vien</label>
      <input type="text" class="form-control" name="masv" v-model="newSinhVien.mssv">
    </div>
    <div class="mb-3">
      <label class="form-label">Ho ten</label>
      <input type="text" class="form-control" name="hoTen" v-model="newSinhVien.hoten">
    </div>
    <div class="mb-3">
      <label class="form-label">Dia chi</label>
      <input type="text" class="form-control" name="diaChi" v-model="newSinhVien.diachi">
    </div>
    <div class="mb-3">
      <label class="form-label">Gioi tinh</label>
      <input type="radio" value="Nam" name="gioiTinh" v-model="newSinhVien.gioitinh"> Nam
      <input type="radio" value="Nu" name="gioiTinh" v-model="newSinhVien.gioitinh">Nu
    </div>
    <div class="mb-3">
      <label class="form-label">Trang thai</label>
      <input type="radio" value="Hoc lai" name="trangThai" v-model="newSinhVien.trangthai"> Hoc lai
      <input type="radio" value="Qua mon" name="trangThai" v-model="newSinhVien.trangthai">Qua mon
    </div>
    <button type="button" class="btn btn-primary" @click="add">Them</button>
    <button type="button" class="btn btn-primary" @click="update">Cap nhat</button>
  </form>

  <h3>Danh sach sinh vien la </h3>
  <table class="container table">
    <thead>
      <tr>
        <td>stt</td>
        <td>ma sinh vien</td>
        <td>ho ten</td>
        <td>dia chi</td>
        <td>gioi tinh</td>
        <td>trang thai</td>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(sinhvien, index) in listSinhVien">
        <td>{{ index + 1 }}</td>
        <td>{{ sinhvien.mssv }}</td>
        <td>{{ sinhvien.hoten }}</td>
        <td>{{ sinhvien.diachi }}</td>
        <td>{{ sinhvien.gioitinh }}</td>
        <td>{{ sinhvien.trangthai }}</td>
        <td><button class="btn btn-primary" @click="deleteSinhVien(index)">Xoa</button></td>
        <td><button class="btn btn-primary" @click="detail(index)">Chi tiet</button></td>
      </tr>
    </tbody>
  </table>


</template>

<style scoped></style>
