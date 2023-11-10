import { createRouter, createWebHistory } from 'vue-router'
import login from '../views/Login.vue'
import signup from '../views/SignUp.vue'
import staticpage from '../views/staticpage.vue'
import home from '../views/Home.vue'
import about from '../views/about.vue'
import contact from '../views/contact.vue'
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
  },
  {
    path: '/home',
    name: 'home',
    component: home,
  },
  {
    path: '/about',
    name: 'about',
    component: about,
  },
  {
    path: '/contact',
    name: 'contact',
    component: contact,
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
