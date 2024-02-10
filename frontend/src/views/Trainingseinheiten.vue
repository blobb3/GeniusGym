<template>
  <ion-page class="ion-padding">
    <ion-header class="ion-header-flex">
      <TheFooter />
      <ion-toolbar>
        <ion-title class="ion-padding">Trainingseinheiten</ion-title>
        <p class="ion-padding">{{ dailyQuote }}</p>
      </ion-toolbar>
    </ion-header>
    <ion-content class="ion-padding" :fullscreen="true">
      <!-- Farbige Container für die Trainingseinheiten -->

      <ion-card @click="navigateToOberkoerper" color="primary" class="ion-padding">
        <ion-card-content>Oberkörpertraining</ion-card-content>
      </ion-card>
      <ion-card @click="navigateToUnterkoerper" color="secondary" class="ion-padding">
        <ion-card-content>Unterkörpertraining</ion-card-content>
      </ion-card>
      <!--auch möglich durch - ion-item v-bind:router-link= ""'/tabs/tab2/' + task.id"-->
      <ion-card @click="navigateToRunningMap" color="tertiary" class="ion-padding">
        <ion-card-content>Running</ion-card-content>
      </ion-card>
      <!-- Anzeige der Punkte für Ober- und Unterkörper -->
      <div class="ion-padding">
        Punkte Oberkörper: {{ oberkoerperPunkte }}
      </div>
      <div class="ion-padding">
        Punkte Unterkörper: {{ unterkoerperPunkte }}
      </div>
      <div class="ion-padding">
        Gesamtpunkte: {{ gesamtPunkte }}
      </div>
      <!-- Button 'Für heute Fertig' -->
      <transition name="fade" mode="out-in">
        <ion-button @click="submitTrainingData" size="small">Training abschließen</ion-button>
      </transition>
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
  IonCard,
  IonCardContent,
  IonButton,
} from '@ionic/vue';
import { useRouter } from 'vue-router';
import { useDailyQuote } from '@/composables/useDailyQuote';
import { useState } from '@/store'; // useState anstatt useMethods
import TheFooter from '@/components/TheFooter.vue';
import { useStore } from '@/store';
import { watch } from 'vue';
import { computed } from 'vue';
import axios from 'axios';

const { dailyQuote } = useDailyQuote();
const { oberkoerperPunkte, unterkoerperPunkte } = useState(); // useState verwenden, um auf den globalen Zustand zuzugreifen

const store = useStore();
const router = useRouter()

// Funktion zum Navigieren zur Oberkoerper.vue-Seite
const navigateToOberkoerper = () => {
  console.log("Navigiere zu Oberkoerper.vue");
  router.push('/tabs/oberkoerper');
};

// Funktion zum Navigieren zur Unterkoerper.vue-Seite
const navigateToUnterkoerper = () => {
  console.log("Navigiere zu Unterkoerper.vue");
  router.push('/tabs/unterkoerper');
};
// Funktion zum Navigieren zur RunningMap.vue-Seite
const navigateToRunningMap = () => {
  console.log("Navigiere zu RunningMap.vue");
  router.push('/tabs/runningmap');
};

// Beobachten der Zustände
watch(oberkoerperPunkte, (neu, alt) => {
  console.log(`Oberkörperpunkte geändert: alt=${alt}, neu=${neu}`);
});

watch(unterkoerperPunkte, (neu, alt) => {
  console.log(`Unterkörperpunkte geändert: alt=${alt}, neu=${neu}`);
});

//Erstellen einer reaktiven Referenz für die Gesamtpunktzahl
const gesamtPunkte = computed(() => oberkoerperPunkte.value + unterkoerperPunkte.value);

// Backend-Teil (erstmal Punkte in Datenbank hochladen)

// Backend-Teil (Punkte in Datenbank hochladen)
const submitTrainingData = async () => {
  try {
    const token = localStorage.getItem('token');
    
    // Punkte aus den globalen Zuständen abrufen
    const oberkoerperPunkteValue = oberkoerperPunkte.value;
    const unterkoerperPunkteValue = unterkoerperPunkte.value;

    // Daten vorbereiten
    const punkteData = {
      oberkoerperPunkte: oberkoerperPunkteValue,
      unterkoerperPunkte: unterkoerperPunkteValue
    };

    console.log(`Bearer Token: ${token}`);

    // Daten an das Backend senden, einschließlich des Authorization-Headers
    await axios.post('http://localhost:8080/punkte', punkteData, {
      headers: {
        'Authorization': `Bearer ${token}`
      }
    });

    console.log('Punkte erfolgreich gespeichert');
  } catch (error) {
    console.error('Fehler beim Speichern der Punkte:', error);
  }
};


</script>

<style scoped>
/* Star Wars-Theme Farben */
:root {
  --ion-color-primary: #000;
  /* Schwarz für den Hintergrund */
  --ion-color-secondary: #ffe81f;
  /* Gold für wichtige Elemente */
  --ion-color-tertiary: #d0d0d0;
  /* Grau für Nebenelemente */
}

body, ion-page {
  margin: 0;
  padding: 0;
  font-family: 'Arial', sans-serif;
}

/* Anpassungen für Buttons und Cards */
ion-card {
  background: rgba(0, 0, 0, 0.8);
  color: #ffe81f;
  border: 1px solid #ffe81f;
}

ion-button {
  --background: #000;
  --color: #ffe81f;
  border: 1px solid #ffe81f;
  transition: transform 0.3s ease;
}

ion-button:active {
  transform: scale(0.96);
}

ion-title,
ion-card-content {
  color: #ffe81f;
}

p {
  color: #d0d0d0;
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
}

ion-header {
  --background: #000;
}

/* Inhaltsbereich */
ion-content {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  text-align: center;
  padding: 16px;
  box-sizing: border-box; /* Verhindert, dass Padding die Breite beeinflusst */
}

/* Basis Animation für Karten */
@keyframes popIn {
  0% {
    transform: scale(0.95);
    opacity: 0.6;
  }

  100% {
    transform: scale(1);
    opacity: 1;
  }
}

/* Animation beim Hovern über die Karte */
ion-card:hover {
  animation: popIn 0.5s ease forwards;
}

/* Animation beim Fokussieren der Karte (z.B. bei Touch-Events) */
ion-card:focus-within {
  animation: popIn 0.5s ease forwards;
}

/* Fügen Sie diesen Code zu Ihrem <style> hininzu */

/* Vue-Übergänge */
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s;
}

.fade-enter,
.fade-leave-to

/* .fade-leave-active in <2.1.8 */
  {
  opacity: 0;
}
/* Media Queries für Responsive Design */
@media (min-width: 768px) {
  ion-content {
    max-width: 600px; /* Begrenzt die Breite für größere Bildschirme */
    margin: auto; /* Zentriert den Inhaltsbereich horizontal */
  }

  ion-card {
    max-width: 80%; /* Karten sind auf größeren Bildschirmen schmaler */
  }

  .points-container {
    flex-direction: row;
    justify-content: space-between;
  }
}
</style> 

