import { createRouter, createWebHistory } from 'vue-router'
import login from '../views/Login.vue'
import signup from '../views/SignUp.vue'
import staticpage from '../views/staticpage.vue'
const routes = [
  {
    path: '/login',
    name: 'login',
    component: login
  },
  {
    path: '/signup',
    name: 'signup',
    component: signup,
  },
  {
    path: '/',
    name: 'staticpage',
    component: staticpage,
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
