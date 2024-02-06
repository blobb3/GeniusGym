<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title><h3 class="ion-text-center">Galactic Gains: Train Like a Jedi!</h3></ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <div class="container">
        <ion-grid class="ion-justify-content-center ion-align-items-center">
          <ion-row justify-content-center>
            <ion-col align-self-center size-md="6" size-lg="5" size-xs="12">
              <div class="ion-text-center">
                <h1>GeniusGym-App Login!</h1>
              </div>
              <div>
                <ion-item>
                  <ion-input type="text" placeholder="Login Name" v-model="username"></ion-input>
                </ion-item>
                <ion-item>
                  <ion-input type="password" placeholder="Password" v-model="password"></ion-input>
                </ion-item>
              </div>
              <div class="ion-padding">
                <ion-button size="large" @click="login" expand="block">Login</ion-button>
              </div>
            </ion-col>
          </ion-row>
        </ion-grid>
      </div>
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
  IonInput,
  IonRow,
  IonCol,
  IonGrid,
  IonButton,
  IonItem,
} from "@ionic/vue";
import { useLogin } from "../composables/useLogin";

const { username, password, login } = useLogin();
</script>

<style scoped>
.container {
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

ion-content {
  --ion-background-color: #ffffff;
}

/* Anpassung des Login-Button-Hintergrunds */
ion-button {
  --background: #FFA500;
  --background-hover: #E69500; /* Dunklerer Orange-Ton für Hover-Effekt */
  --background-activated: #CC8500; /* Noch dunklerer Orange-Ton für Aktiv-Effekt */
}
</style>
