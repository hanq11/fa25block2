<template>
    <div class="qlsv">
        <SinhVienForm v-model:sinhVienForm="sinhVien"></SinhVienForm>
        <div class="container text-center">
            <button class="btn btn-success" @click="themSinhVien()" v-if="updateIndex == -1">Them sinh vien</button>
            <button class="btn btn-warning" @click="updateSinhVien()" v-if="updateIndex != -1">Update sinh vien</button>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-10 mx-auto">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Ten</th>
                                <th scope="col">Tuoi</th>
                                <th scope="col">Dia chi</th>
                                <th scope="col">Hanh dong</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="(sv, index) in listSinhVien" :key="sv.id">
                                <td>{{ sv.id }}</td>
                                <td>{{ sv.ten }}</td>
                                <td>{{ sv.tuoi }}</td>
                                <td>{{ sv.diaChi }}</td>
                                <td>
                                    <button class="btn btn-success" @click="showDetail(index)">Chi tiet</button>
                                    <button class="btn btn-danger mx-3" @click="deleteSinhVien(index)">Xoa</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</template>
<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
<script setup>
import { ref } from 'vue';
import SinhVienForm from './SinhVienForm.vue';

const updateIndex = ref(-1)

const listSinhVien = ref([
    {
        id: 1,
        ten: "Nguyen Van A",
        tuoi: 19,
        diaChi: "Ha Noi"
    },
    {
        id: 2,
        ten: "Nguyen Van B",
        tuoi: 39,
        diaChi: "Bac Giang"
    },
    {
        id: 3,
        ten: "Nguyen Van C",
        tuoi: 29,
        diaChi: "Bac Ninh"
    }
])

const sinhVien = ref({
    id: "",
    ten: "",
    tuoi: "",
    diaChi: ""
})

const themSinhVien = () => {
    listSinhVien.value.push({
        ...sinhVien.value
    })
    clearForm()
}

const showDetail = (index) => {
    sinhVien.value = {
        ...listSinhVien.value[index]
    }
    updateIndex.value = index
}

const updateSinhVien = () => {
    listSinhVien.value[updateIndex.value] = {
        ...sinhVien.value
    }
    updateIndex.value = -1
    clearForm()
}

const deleteSinhVien = (index) => {
    listSinhVien.value.splice(index, 1)
}

const clearForm = () => {
    sinhVien.value = {
        id: "",
        ten: "",
        tuoi: "",
        diaChi: ""
    }
}
</script>
