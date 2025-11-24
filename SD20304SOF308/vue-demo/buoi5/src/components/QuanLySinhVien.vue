<template>
    <SinhVienForm v-model:sinhVienForm="sinhVien"></SinhVienForm>
    <div class="container text-center">
        <button class="btn btn-success" @click="themSinhVien()">Them sinh vien</button>
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
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="sv in listSinhVien" :key="sv.id">
                            <td>{{ sv.id }}</td>
                            <td>{{ sv.ten }}</td>
                            <td>{{ sv.tuoi }}</td>
                            <td>{{ sv.diaChi }}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import SinhVienForm from './SinhVienForm.vue';
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
}
</script>
