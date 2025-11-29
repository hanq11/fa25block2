import HelloWorld from "@/view/HelloWorld.vue"
import TruyenKieu from "@/view/TruyenKieu.vue"
import { createRouter, createWebHistory } from "vue-router"


const routes = [
    {
        path: "/",
        name: "HelloWorld",
        component: HelloWorld
    },
    {
        path: "/truyen-kieu",
        name: "TruyenKieu",
        component: TruyenKieu
    }
]

const router = createRouter({
    history: createWebHistory(import.meta.env.VITE_BASE_URL),
    routes
})

export default router