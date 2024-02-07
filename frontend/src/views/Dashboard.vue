<template>
  <ion-page>
    <ion-header class="ion-padding">
      <ion-toolbar>
        <ion-title class="ion-padding">Dashboard</ion-title>
        <p class="ion-padding">{{ dailyQuote }}</p>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Dashboard</ion-title>
        </ion-toolbar>
      </ion-header>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent } from '@ionic/vue';
import { useDailyQuote } from '@/composables/useDailyQuote';
const { dailyQuote } = useDailyQuote();
</script>

<style>
/* Star Wars-Theme Anpassungen */
:root {
    --ion-color-primary: #000; /* Schwarz */
    --ion-color-secondary: #ffe81f; /* Gold */
    --ion-color-tertiary: #d0d0d0; /* Grau */
}

ion-title, ion-label, ion-button {
    color: #ffe81f;
}

.completed-button {
    --background: green;
}

ion-item[color="light"] {
    --background: rgba(0, 0, 0, 0.8);
    --color: #ffe81f;
    border: 1px solid #ffe81f;
}
.completed-button {
    --background: green;
}
</style>