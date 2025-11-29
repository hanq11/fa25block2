<script setup>
    import { RouterLink } from 'vue-router';
</script>

<template>
    <header class="d-flex justify-content-center py-3">
        <ul class="nav nav-pills">
            <li class="nav-item"><button class="btn"><RouterLink to="/">Hello World</RouterLink></button></li>
            <li class="nav-item"><button class="btn"><RouterLink to="/truyen-kieu">Truyen Kieu</RouterLink></button></li>
            <li class="nav-item"><a href="#" class="nav-link">Pricing</a></li>
            <li class="nav-item"><a href="#" class="nav-link">FAQs</a></li>
            <li class="nav-item"><a href="#" class="nav-link">About</a></li>
        </ul>
    </header>
</template>