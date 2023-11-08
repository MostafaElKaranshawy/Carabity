import { createRouter, createWebHistory } from 'vue-router'
import login from '../views/Login.vue'
import signup from '../views/SignUp.vue'

const routes = [
  {
    path: '/',
    name: 'login',
    component: login
  },
  {
    path: '/signup',
    name: 'signup',
    component: signup,
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
