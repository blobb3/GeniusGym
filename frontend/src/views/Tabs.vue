<template>
  <ion-page>
    <ion-tabs>
      <ion-router-outlet></ion-router-outlet>
      <ion-tab-bar slot="bottom">
        <ion-tab-button tab="todo" href="/tabs/todo">
          <ion-icon :icon="accessibility"></ion-icon>
          <ion-label>Goals</ion-label>
        </ion-tab-button>

        <ion-tab-button tab="trainingseinheiten" href="/tabs/trainingseinheiten">
          <ion-icon :icon="barbell"></ion-icon>
          <ion-label>Training</ion-label>
        </ion-tab-button>

        <ion-tab-button tab="status" href="/tabs/status">
          <ion-icon :icon="home" />
          <ion-label>Status</ion-label>
        </ion-tab-button>

        <ion-tab-button tab="cloudyOutline" href="/tabs/memories">
          <ion-icon :icon="cloudySharp"></ion-icon>
          <ion-label>Memories</ion-label>
        </ion-tab-button>

        <ion-tab-button tab="dashboard" href="/tabs/dashboard">
          <ion-icon :icon="calendar" />
          <ion-label>Dasbhoard</ion-label>
        </ion-tab-button>
      </ion-tab-bar>
    </ion-tabs>
  </ion-page>
</template>

<script setup lang="ts">
import { IonTabBar, IonTabButton, IonTabs, IonLabel, IonIcon, IonPage, IonRouterOutlet } from '@ionic/vue';
import { accessibility, barbell, calendar, home, cloudySharp } from 'ionicons/icons';
</script>