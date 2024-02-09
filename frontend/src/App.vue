<template>
  <ion-app>
    <ion-router-outlet />
  </ion-app>
</template>

<script setup lang="ts">
import { IonApp, IonRouterOutlet } from '@ionic/vue';
import { useStore } from './store';
import { defineComponent, onMounted } from 'vue';
useStore();


</script>

<!-- Original von leantodo:
  <script setup lang="ts">
  import { IonApp, IonRouterOutlet } from '@ionic/vue';
</script>
-->
