<template>
  <ion-page>
    <ion-tabs>
      <ion-router-outlet></ion-router-outlet>
      <ion-tab-bar slot="bottom">
        <ion-tab-button tab="todo" href="/tabs/todo">
          <ion-icon :icon="accessibility"></ion-icon>
          <ion-label>You</ion-label>
        </ion-tab-button>

        <ion-tab-button tab="projects" href="/tabs/projects">
          <ion-icon :icon="barbell" />
          <ion-label>Training</ion-label>
        </ion-tab-button>

        <ion-tab-button tab="timerecord" href="/tabs/timerecord">
          <ion-icon :icon="calendar" />
          <ion-label>Historie</ion-label>
        </ion-tab-button>
      </ion-tab-bar>
    </ion-tabs>
  </ion-page>
</template>

<script setup lang="ts">
import { IonTabBar, IonTabButton, IonTabs, IonLabel, IonIcon, IonPage, IonRouterOutlet } from '@ionic/vue';
import { accessibility, barbell, calendar } from 'ionicons/icons';
</script>