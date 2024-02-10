<!--Allgemeine Struktur für MemoriePage in App - zur Unterstützung-->
<template>
  <ion-page>
    <ion-content>
      <slot />
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import {
  IonPage,
  IonHeader,
  IonToolbar,
  IonTitle,
  IonContent,
  IonBackButton,
  IonButtons,
} from "@ionic/vue";

const props = defineProps({
  pageTitle: {
    type: String,
    default: ''
  },
  pageDefaultBackLink: {
    type: String,
    default: ''
  }
});
</script>
