<template>
    <ion-page>
      <ion-header>
        <ion-toolbar>
          <ion-title>Unterkörpertraining</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-content :fullscreen="true">
        <ion-accordion-group :multiple="true">
          <!-- Übung 1 -->
          <ion-accordion value="squats">
            <ion-item slot="header" color="light">
              <ion-label>Kniebeugen</ion-label>
            </ion-item>
            <div class="ion-padding" slot="content">
              Grundübung für die Bein- und Gesäßmuskulatur. 3 Sätze von 10-15 Wiederholungen.
            </div>
          </ion-accordion>
          <!-- Übung 2 -->
          <ion-accordion value="lunges">
            <ion-item slot="header" color="light">
              <ion-label>Ausfallschritte</ion-label>
            </ion-item>
            <div class="ion-padding" slot="content">
              Trainiert Beine und Gesäß. Fördert die Stabilität. 3 Sätze von 10-12 Wiederholungen pro Bein.
            </div>
          </ion-accordion>
          <!-- Übung 3 -->
          <ion-accordion value="deadlifts">
            <ion-item slot="header" color="light">
              <ion-label>Kreuzheben</ion-label>
            </ion-item>
            <div class="ion-padding" slot="content">
              Stärkt die hintere Beinmuskulatur und den unteren Rücken. 3 Sätze von 8-10 Wiederholungen.
            </div>
          </ion-accordion>
          <!-- Übung 4 -->
          <ion-accordion value="legpress">
            <ion-item slot="header" color="light">
              <ion-label>Beinpresse</ion-label>
            </ion-item>
            <div class="ion-padding" slot="content">
              Zielt auf Oberschenkel und Gesäßmuskulatur. 3 Sätze von 10-15 Wiederholungen.
            </div>
          </ion-accordion>
          <!-- Übung 5 -->
          <ion-accordion value="calfRaises">
            <ion-item slot="header" color="light">
              <ion-label>Wadenheben</ion-label>
            </ion-item>
            <div class="ion-padding" slot="content">
              Isoliertes Training der Waden. 3 Sätze von 15-20 Wiederholungen.
            </div>
          </ion-accordion>
          <!-- Übung 6 -->
          <ion-accordion value="hamstringCurls">
            <ion-item slot="header" color="light">
              <ion-label>Bein-Curls</ion-label>
            </ion-item>
            <div class="ion-padding" slot="content">
              Kräftigt die Beinrückseite. 3 Sätze von 10-15 Wiederholungen.
            </div>
          </ion-accordion>
          <!-- Übung 7 -->
          <ion-accordion value="stepUps">
            <ion-item slot="header" color="light">
              <ion-label>Step-Ups</ion-label>
            </ion-item>
            <div class="ion-padding" slot="content">
              Verbessert Kraft und Balance. 3 Sätze von 10 Wiederholungen pro Bein.
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
    color: black;
  }
  </style>
  