<template>
    <ion-page>
      <ion-header>
        <ion-toolbar>
          <ion-title>Oberkörpertraining</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-content :fullscreen="true">
        <ion-accordion-group :multiple="true">
          <ion-accordion value="first">
            <ion-item slot="header" color="light">
              <ion-label>Liegestütze</ion-label>
            </ion-item>
            <div class="ion-padding" slot="content">
              Stärkt Brust, Schultern und Trizeps. 2 Sätze von je 10-15 Wiederholungen.
            </div>
          </ion-accordion>
          <ion-accordion value="second">
            <ion-item slot="header" color="light">
              <ion-label>Klimmzüge</ion-label>
            </ion-item>
            <div class="ion-padding" slot="content">
              Zielt auf die Rückenmuskulatur und den Bizeps. 2 Sätze von je 8-12 Wiederholungen.
            </div>
          </ion-accordion>
          <ion-accordion value="third">
            <ion-item slot="header" color="light">
              <ion-label>Schulterdrücken</ion-label>
            </ion-item>
            <div class="ion-padding" slot="content">
              Kräftigt die Schultermuskulatur. 2 Sätze von je 10-15 Wiederholungen.
            </div>
          </ion-accordion>
        </ion-accordion-group>
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
    IonAccordionGroup,
    IonAccordion,
    IonItem,
    IonLabel,
  } from '@ionic/vue';
  </script>

  <style>
.ion-padding {
    color:black;
}
</style>
  