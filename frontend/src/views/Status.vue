<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Status</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true" class="ion-padding">
      <!-- Inputfelder für Nutzerdaten und Button zur Speicherung -->
      <div class="input-container">
        <ion-item>
          <ion-label position="floating">Größe (cm)</ion-label>
          <ion-input type="number" v-model="userData.groesse"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Gewicht (kg)</ion-label>
          <ion-input type="number" v-model="userData.gewicht"></ion-input>
        </ion-item>
        <ion-button @click="submitUserData">Daten speichern</ion-button>
      </div>
      <!-- Anzeige der Nutzerdaten, Größe und Gewicht -->
      <div class="container">
        <ion-card class="user-status-card">
          <ion-card-header>
            <ion-card-title class="card-title">Sei eins mit der Fitness, der Sweat ist mit dir!</ion-card-title>
          </ion-card-header>
          <ion-card-content class="ion-text-center">
            <ion-avatar class="custom-avatar">
              <ion-icon :icon="person" size="large"></ion-icon>
            </ion-avatar>
            <ion-list lines="none">
              <ion-item>
                <ion-label>Name: {{ userData.name }}</ion-label>
              </ion-item>
              <ion-item>
                <ion-label>Level: {{ userData.level }}</ion-label>
              </ion-item>
              <ion-item>
                <ion-label>Punkte: {{ userData.points }}</ion-label>
              </ion-item>
              <ion-item>
                <ion-label>Größe: {{ userData.groesse }} cm</ion-label>
              </ion-item>
              <ion-item>
                <ion-label>Gewicht: {{ userData.gewicht }} kg</ion-label>
              </ion-item>
            </ion-list>
            <ion-label class="progress-text">Punkte bis zum nächsten Level: {{ userData.points }} / {{ userData.pointsToNextLevel }}</ion-label>
          </ion-card-content>
        </ion-card>
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import axios from 'axios';
import { person } from 'ionicons/icons';

interface UserData {
  groesse?: string;
  gewicht?: string;
  name: string; // Optional, falls nicht immer gesetzt
  level?: number; // Optional, falls nicht immer gesetzt
  points?: number; // Optional, falls nicht immer gesetzt
  pointsToNextLevel?: number; // Optional, falls nicht immer gesetzt
}

// Initialisierung der userData mit reaktiven Properties für die Inputfelder
const userData = ref<UserData>({
  groesse: '',
  gewicht: '',
  name: '',
});

// Methode zum Senden der Nutzerdaten und Hinzufügen zur Liste
const submitUserData = async () => {
  try {
    await axios.post('http://localhost:8080/status', userData.value);
    // Optional: Benutzerdaten im Frontend zurücksetzen, falls gewünscht
    // userData.value = { groesse: '', gewicht: '' };
  } catch (error) {
    console.error('Fehler beim Senden der Nutzerdaten:', error);
  }
};
</script>

<style scoped>
.input-container, .container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.user-status-card, .ion-padding {
  --background: #fff; /* Setzt die Hintergrundfarbe auf Weiß */
}

.custom-avatar {
  margin: 0 auto;
}

.card-title, .progress-text {
  color: #000000;
}
</style>
