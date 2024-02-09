<!--Allgemeine Struktur für MemoriePage in App - zur Unterstützung-->
<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-back-button :default-href="pageDefaultBackLink"></ion-back-button>
        </ion-buttons>
        <ion-title>{{ pageTitle }}</ion-title>
        <ion-buttons slot="end">
          <slot name="actions-end"></slot>
        </ion-buttons>
      </ion-toolbar>
    </ion-header>
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
import { defineProps } from "vue";

// Definiere props für pageTitle und pageDefaultBackLink
const { pageTitle = '', pageDefaultBackLink = '' } = defineProps(['pageTitle', 'pageDefaultBackLink']);


</script>
