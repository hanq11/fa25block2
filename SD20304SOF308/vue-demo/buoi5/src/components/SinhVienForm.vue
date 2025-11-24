<template>
    <h1 class="text-center">Sinh vien form</h1>
    <div class="container">
        <div class="row">
            <div class="col-6 mx-auto">
                <div class="mb-1">
                    <label for="id" class="form-label">Id</label>
                    <input type="text" class="form-control" id="id" v-model="sinhVienForm.id">
                </div>
                <div class="mb-1">
                    <label for="ten" class="form-label">Ten</label>
                    <input type="text" class="form-control" id="ten" v-model="sinhVienForm.ten">
                </div>
                <div class="mb-1">
                    <label for="tuoi" class="form-label">Tuoi</label>
                    <input type="text" class="form-control" id="tuoi" v-model="sinhVienForm.tuoi">
                </div>
                <div class="mb-1">
                    <label for="diaChi" class="form-label">Dia chi</label>
                    <input type="text" class="form-control" id="diaChi" v-model="sinhVienForm.diaChi">
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
defineModel("sinhVienForm", {
    default: {
        id: "",
        ten: "",
        tuoi: "",
        diaChi: ""
    }
})
</script>