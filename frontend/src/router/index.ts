import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import Tabs from '@/views/Tabs.vue';
import Login from '@/views/Login.vue';
import AddMemory from '@/views/AddMemory.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    component: Login,
  },
  {
    path: '/addmemory', 
    component: AddMemory, 
  },
  {
    path: '/memories/add', 
    component: () => import('@/pages/AddMemoryPage.vue')
  },
  {
    path: '/tabs/',
    component: Tabs,
    children: [
      {
        path: '',
        redirect: '/tabs/tab1'
      },
      {
        path: 'todo',
        component: () => import('@/views/Todo.vue')
      },
      {
        path: 'memories',
        component: () => import('@/pages/MemoriesPage.vue'),
        children: [
          {
            path: ':id', 
            component: () => import('@/pages/MemoryDetailsPage.vue')
          }
        ]
      },
      
      {
        path: 'projects',
        component: () => import('@/views/Projects.vue')
      },
      {
        path: 'dashboard',
        component: () => import('@/views/Dashboard.vue')
      },
      {
        path: 'status',
        component: () => import('@/views/Status.vue'),
      },
      {
        path: 'trainingseinheiten',
        component: () => import('@/views/Trainingseinheiten.vue'),
      },
      {
        path: 'oberkoerper',
        component: () => import('@/views/Oberkoerper.vue'),
      },
      {
        path: 'unterkoerper',
        component: () => import('@/views/Unterkoerper.vue'),
      },
      {
        path: 'runningmap',
        component: () => import('@/views/RunningMap.vue'),
      }, 
    ]
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
