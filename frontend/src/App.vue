<template>
  <ion-app>
    <ion-router-outlet />
  </ion-app>
</template>

<script setup lang="ts">
import { IonApp, IonRouterOutlet } from '@ionic/vue';
import { createApp } from 'vue';
import App from './App.vue';
import { useStore } from './store';

const app = createApp(App);

// Bereitstellung des Stores für die gesamte App
useStore();

</script>

