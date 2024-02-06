<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title class="ion-padding">Wähle deine Joggingstrecke</ion-title>
        <ion-buttons slot="start">
          <ion-back-button defaultHref="/"></ion-back-button>
        </ion-buttons>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true" class="ion-padding">
      <ion-button expand="block" @click="generateRoute">Generiere eine Strecke in deiner Nähe</ion-button>

      <!-- Hier könnte ein Bild einer Karte eingefügt werden -->
      <div class="map-container">
        <img src="https://www.raonline.ch/images/hike/pic7/swisstopo_karten18005.jpg"
          style="max-width: 684px; height: 351px; margin: 0px; width: 437px;">
      </div>

      <div class="timer-buttons">
        <ion-button @click="startTimer">Start</ion-button>
        <ion-button @click="stopTimer">Ziel</ion-button>
        <ion-button @click="resetTimer">Reset</ion-button>
      </div>

      <!-- Stoppuhr Anzeige -->
      <div class="timer-display">
        Zeit: {{ elapsedTime }}
      </div>
    </ion-content>
  </ion-page>
</template>
<script setup lang="ts">
import { ref, onMounted } from 'vue';
import {
  IonPage,
  IonHeader,
  IonToolbar,
  IonTitle,
  IonContent,
  IonButton,
  IonButtons,
  IonBackButton,
} from '@ionic/vue';


// Verwenden refs für den Startzeitpunkt, die verstrichene Zeit und das Intervall
let startTime = ref<Date | null>(null);
let elapsedTime = ref('00:00:00');
let timerInterval: number | null = null;

// Formatierungsfunktion, um die verstrichene Zeit als String darzustellen
function formatElapsedTime(milliseconds: number): string {
  const totalSeconds = Math.floor(milliseconds / 1000);
  const hours = Math.floor(totalSeconds / 3600).toString().padStart(2, '0');
  const minutes = Math.floor((totalSeconds % 3600) / 60).toString().padStart(2, '0');
  const seconds = (totalSeconds % 60).toString().padStart(2, '0');
  return `${hours}:${minutes}:${seconds}`;
}

const generateRoute = () => {
  // Logik zum Generieren einer Route
};

const startTimer = () => {
  if (timerInterval !== null) return; // Verhindern, dass der Timer mehrfach gestartet wird
  startTime.value = new Date(); // Aktuelle Zeit speichern
  timerInterval = window.setInterval(() => {
    if (startTime.value) {
      const now = new Date();
      const diff = now.getTime() - startTime.value.getTime();
      elapsedTime.value = formatElapsedTime(diff);
    }
  }, 1000);
};

const stopTimer = () => {
  if (timerInterval !== null) {
    window.clearInterval(timerInterval);
    timerInterval = null;
  }
};

const resetTimer = () => {
  stopTimer();
  elapsedTime.value = '00:00:00';
  startTime.value = null; // Startzeit zurücksetzen
};

//Map
declare global {
  interface Window { initMap: () => void; }
}

window.initMap = function() {
  const mapElement = document.getElementById('map');
  if (mapElement) { // Überprüfe, ob mapElement nicht null ist
    const map = new google.maps.Map(mapElement as HTMLElement, {
      center: { lat: -34.397, lng: 150.644 }, // Beispielkoordinaten, anpassen nach Bedarf
      zoom: 8
    });
  } else {
    console.error('Map container not found');
  }
};

onMounted(() => {
  console.log(import.meta.env.VITE_GOOGLE_MAPS_API_KEY)
  const script = document.createElement('script');
  script.src = `https://maps.googleapis.com/maps/api/js?key=${import.meta.env.VITE_GOOGLE_MAPS_API_KEY}&callback=initMap`;
  script.async = true;
  script.defer = true;
  document.head.appendChild(script);
});
</script>

  
<style scoped>
.map-container img {
  width: 100%;
  margin: 16px 0;
}

.timer-buttons {
  display: flex;
  justify-content: space-around;
  margin: 16px 0;
}

.timer-display {
  text-align: center;
  margin-top: 16px;
  color: black;
}

.ion-padding {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
}
.ion-padding {
  --background: #fff; /* Setzt die Hintergrundfarbe auf Weiß */
}
</style>
  