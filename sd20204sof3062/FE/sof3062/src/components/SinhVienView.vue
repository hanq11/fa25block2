<template>
    <h1 style="text-align: center;">Thay đổi thông tin</h1>
    <div class="container">
        <div class="row">
            <div class="col-6">
                <div class="mb-3 mt-3">
                    <label for="id" class="form-label">Id</label>
                    <input type="text" class="form-control" id="id" v-model="sinhVienModel.id">
                </div>
                <div class="mb-3 mt-3">
                    <label for="ten" class="form-label">Tên</label>
                    <input type="text" class="form-control" id="ten" v-model="sinhVienModel.ten">
                </div>
                <div class="mb-3 mt-3">
                    <label for="tuoi" class="form-label">Tuổi</label>
                    <input type="text" class="form-control" id="tuoi" v-model="sinhVienModel.tuoi">
                </div>
            </div>
            <div class="col-6">
                <div class="mb-3 mt-3">
                    <label for="ngaySinh" class="form-label">Ngày sinh</label>
                    <VueDatePicker v-model="sinhVienModel.ngaySinh" id="ngaySinh" :formats="{ input: 'yyyy-MM-dd' }"></VueDatePicker>
                </div>
                <div class="mb-3 mt-3">
                    <label for="gioiTinh" class="form-label">Giới tính</label>
                    <div class="container">
                        <div class="row">
                            <div class="col-6">
                                <input type="radio" class="form-check-input" id="gioiTinhNam" 
                                    name="gioiTinh" value="true" v-model="sinhVienModel.gioiTinh">
                                <label class="form-check-label mx-2" for="gioiTinhNam">Nam</label>
                            </div>
                            <div class="col-6">
                                <input type="radio" class="form-check-input" id="gioiTinhNu"
                                    name="gioiTinh" value="false" v-model="sinhVienModel.gioiTinh">
                                <label class="form-check-label mx-2" for="gioiTinhNu">Nu</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="mb-3 mt-3">
                    <label for="lopHoc" class="form-label">Lớp học</label>
                    <select class="form-select" id="lopHoc" v-model="sinhVienModel.lopHoc.id">
                        <option v-for="lopHoc in listLopHoc" :value="lopHoc.id" :label="lopHoc.ten"></option>
                    </select>
                </div>
            </div>
        </div>
        <div class="text-center">
            <button class="btn btn-primary" v-if="!isUpdate" @click="handleAddSinhVien()">Add</button>
            <button class="btn btn-success" v-if="isUpdate" @click="handleUpdateSinhVien()">Update</button>
        </div>
    </div>
    <h1 style="text-align: center;">Thông tin sinh viên</h1>
    <div class="container">
        <div class="row">
            <div class="col-10 mx-auto">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Tên</th>
                            <th scope="col">Tuổi</th>
                            <th scope="col">Ngày sinh</th>
                            <th scope="col">Giới tính</th>
                            <th scope="col">Lớp học</th>
                            <th scope="col">Hành động</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="sinhVien in listSinhVien" :key="sinhVien.id">
                            <td>{{ sinhVien.id }}</td>
                            <td>{{ sinhVien.ten }}</td>
                            <td>{{ sinhVien.tuoi }}</td>
                            <td>{{ sinhVien.ngaySinh }}</td>
                            <td>{{ sinhVien.gioiTinh == true ? "Nam" : "Nữ" }}</td>
                            <td>{{ sinhVien.lopHoc.ten }}</td>
                            <td>
                                <button class="btn btn-primary" @click="handleGetDetail(sinhVien.id)">Detail</button>
                                <button class="btn btn-danger mx-3"
                                    @click="handleDeleteSinhVien(sinhVien.id)">Delete</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script setup>
import { VueDatePicker } from '@vuepic/vue-datepicker';
import { ref, onMounted } from "vue";
import {
    fetchAllSinhVien,
    fetchAllLopHoc,
    fetchSinhVienById,
    addSinhVien,
    updateSinhVien,
    deleteSinhVien
} from "@/service/SinhVienService";

const listSinhVien = ref([]);
const sinhVienModel = ref({
    id: "",
    ten: "",
    tuoi: "",
    ngaySinh: "",
    gioiTinh: "",
    lopHoc: {
        id: ""
    }
})
const listLopHoc = ref([])
const clearForm = () => {
    sinhVienModel.value = {
        id: "",
        ten: "",
        tuoi: "",
        ngaySinh: "",
        gioiTinh: "",
        lopHoc: {
            id: ""
        }
    }
}

const isUpdate = ref(false)

const handleFetchAllData = async () => {
    try {
        listSinhVien.value = await fetchAllSinhVien()
        listLopHoc.value = await fetchAllLopHoc()
    } catch (error) {
        console.log(error);
    }
};

onMounted(handleFetchAllData);

const handleAddSinhVien = async () => {
    try {
        await addSinhVien(sinhVienModel.value)
        await handleFetchAllData()
        clearForm()
    } catch (error) {
        console.log(error)
    }
}

const handleGetDetail = async (id) => {
    try {
        sinhVienModel.value = await fetchSinhVienById(id)
        isUpdate.value = true
    } catch (error) {
        console.log(error)
    }
}

const handleDeleteSinhVien = async (id) => {
    try {
        await deleteSinhVien(id)
        await handleFetchAllData()
    } catch (error) {
        console.log(error)
    }
}

const handleUpdateSinhVien = async () => {
    try {
        await updateSinhVien(sinhVienModel.value)
        await handleFetchAllData()
        isUpdate.value = false
        clearForm()
    } catch (error) {
        console.log(error)
    }
}
</script>
