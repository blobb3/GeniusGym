<template>
  <ion-page>
    <ion-header class="ion-header-flex">
      <TheFooter />
      <ion-toolbar>
        <ion-title class="ion-padding">Status</ion-title>
        <p class="ion-padding">{{ dailyQuote }}</p>
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
            <ion-card-title class="card-title ion-padding">Sei eins mit der Fitness, der Sweat ist mit
              dir!</ion-card-title>
          </ion-card-header>
          <ion-card-content class="ion-text-center">
            <ion-avatar class="custom-avatar">
              <ion-icon :icon="person" size="large"></ion-icon>
            </ion-avatar>
            <ion-list lines="none">
              <ion-item class="ion-padding">
                <ion-label>Name: {{ userData.name }}</ion-label>
              </ion-item>
              <ion-item class="ion-padding">
                <ion-label>Level: {{ userData.level }}</ion-label>
              </ion-item>
              <ion-item class="ion-padding">
                <ion-label>Punktestand: {{ gesamtPunkte }}</ion-label>
              </ion-item>

              <ion-item>
                <ion-label class="ion-padding">Grösse: {{ userData.groesse }} cm</ion-label>
              </ion-item>
              <ion-item class="ion-padding">
                <ion-label>Gewicht: {{ userData.gewicht }} kg</ion-label>
              </ion-item>
            </ion-list>
            <ion-label class="progress-text">Punkte bis zum nächsten Level: {{ userData.points }} / {{
              userData.pointsToNextLevel }}</ion-label>
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
  IonCardHeader,
  IonCard,
  IonCardTitle,
  IonCardContent,
  IonAvatar,
  IonIcon,
} from "@ionic/vue";
import { ref, computed, onMounted } from 'vue';
import axios from 'axios';
import { person } from 'ionicons/icons';
import { useStatus } from "@/composables/useStatus";
import { useDailyQuote } from '@/composables/useDailyQuote';
import TheFooter from '@/components/TheFooter.vue';

const { dailyQuote } = useDailyQuote();

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

//Backend-Teil (Levelsystem)
// Definieren Sie ein Interface für die Struktur einer Trainingseinheit
interface Trainingseinheit {
  id: number;
  name: string;
  punkte: number;
  // Fügen Sie hier weitere erforderliche Eigenschaften hinzu
}

// Verwenden Sie das Interface, um den Typ von trainingseinheiten festzulegen
const trainingseinheiten = ref<Trainingseinheit[]>([]);

const fetchTrainingData = async () => {
  try {
    const response = await axios.get('http://localhost:8080/trainingseinheit');
    trainingseinheiten.value = response.data;
  } catch (error) {
    console.error('Fehler beim Abrufen der Trainingseinheiten:', error);
  }
};

onMounted(() => {
  fetchTrainingData();
});

// Berechnete Eigenschaft für gesamtPunkte
const gesamtPunkte = computed(() => {
  return trainingseinheiten.value.reduce((sum, training) => sum + training.punkte, 0);
});
</script>

<style scoped>
.input-container,
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.custom-avatar {
  margin: 0 auto;
}

.testbutton {
  text-transform: none;
}

/* Star Wars-Theme Anpassungen */
:root {
  --ion-color-primary: #000;
  /* Schwarz */
  --ion-color-secondary: #ffe81f;
  /* Gold */
  --ion-color-tertiary: #d0d0d0;
  /* Grau */
}

ion-title,
ion-label,
ion-button {
  color: #ffe81f;
}

ion-item[color="light"] {
  --background: rgba(0, 0, 0, 0.8);
  --color: #ffe81f;
  border: 1px solid #ffe81f;
}

.ion-header-flex {
  display: flex;
  justify-content: center;
  /* Zentriert die Inhalte horizontal */
  align-items: center;
  /* Zentriert die Inhalte vertikal */
  flex-direction: column;
  /* Stapelt die Kinder vertikal */
  text-align: center;
  /* Zentriert den Text der direkten Kinder */
}</style>
