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
          <ion-label position="floating">Grösse (cm)</ion-label>
          <ion-input type="number" v-model="userData.groesse"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Gewicht (kg)</ion-label>
          <ion-input type="number" v-model="userData.gewicht"></ion-input>
        </ion-item>
        <ion-button @click="submitUserData" class="testbutton">Daten speichern</ion-button>
        <br>
      </div>
      <!-- Anzeige der Nutzerdaten, Grösse und Gewicht -->
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
                <ion-label>Grösse: {{ userData.groesse }} cm</ion-label>
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
import {
  IonPage,
  IonHeader,
  IonToolbar,
  IonTitle,
  IonContent,
  IonInput,
  IonButton,
  IonLabel,
  IonList,
  IonItem,
} from "@ionic/vue";
import { onMounted, ref } from 'vue';
import axios from 'axios';
import { person } from 'ionicons/icons';
import { useStatus } from "@/composables/useStatus";

// Definiert das Datenobjekt für die Benutzerdaten
interface UserData {
  groesse?: number;
  gewicht?: number;
  name?: string; // Optional
  level?: number; 
  points?: number; 
  pointsToNextLevel?: number; 
}


// Initialisierung der userData mit reaktiven Properties für die Inputfelder
const userData = ref<UserData>({
name: ""
});



const { status, getStatusData, updateStatusData, addNewStatus } = useStatus();

onMounted(async () => {
  await getStatusData(); // Holt den aktuellen Status beim Laden
  if (status.value) {
    userData.value = status.value; // Aktualisiert userData mit den geholten Daten
  }
});


// Methode zum Senden der Nutzerdaten und Hinzufügen zur Liste
const submitUserData = async () => {
  try {
    // Extrahieren Sie die Daten aus dem userData-Reaktivitätsobjekt
    const dataToSave = {
      groesse: userData.value.groesse,
      gewicht: userData.value.gewicht,
      name: userData.value.name,
      level: userData.value.level,
      points: userData.value.points,
      pointsToNextLevel: userData.value.pointsToNextLevel
    };

    // Aufruf der API-Funktion, um die Daten in die Datenbank zu speichern
    await addNewStatus(dataToSave);

    // Aktualisieren Sie den lokalen Status nach dem Senden
    await getStatusData();
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
  --background: #fff; /* Setzt die Hintergrundfarbe auf Weiss */
}

.custom-avatar {
  margin: 0 auto;
}

.card-title, .progress-text {
  color: #000000;
}

.testbutton {
  text-transform: none;
}

</style>
