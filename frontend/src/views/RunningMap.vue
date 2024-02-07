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
      <div id="map_canvas" style="height: 400px; width: 100%;"></div>


      <div class="timer-buttons">
        <ion-button @click="startTimer">Start</ion-button>
        <ion-button @click="stopTimer">Ziel</ion-button>
        <ion-button @click="resetTimer">Reset</ion-button>
      </div>

      <!-- Stoppuhr Anzeige -->
      <div class="timer-display">
        Zeit: {{ elapsedTime }}
      </div>

      <ion-item>
        <ion-label position="floating">Startpunkt</ion-label>
        <ion-input v-model="origin"></ion-input>
      </ion-item>
      <ion-item>
        <ion-label position="floating">Zielpunkt</ion-label>
        <ion-input v-model="destination"></ion-input>
      </ion-item>

      <ion-button @click="createRoute">Create Route</ion-button>

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



//Test Map
let origin = ref('');
let destination = ref('');

let map: google.maps.Map;
let clickCount = 0; // Zähler für Klicks, um zwischen Origin und Destination zu unterscheiden

const createMap = () => {
  const mapOptions = {
    center: new google.maps.LatLng(47.502, 8.726),
    zoom: 15,
  };
  const mapRef = document.getElementById('map_canvas')!;
  map = new google.maps.Map(mapRef, mapOptions);

  map.addListener('click', (e: google.maps.MapMouseEvent) => {
    // Extrahiere die Koordinaten des Klick-Events
    const latLng = e.latLng!;
    const lat = latLng.lat();
    const lng = latLng.lng();

    console.log(`Klick erkannt bei: ${lat}, ${lng}`); // Überprüfe, ob das Klick-Event ausgelöst wird

    // Entscheide, ob die Koordinaten in `origin` oder `destination` gesetzt werden
    if (clickCount % 2 === 0) {
      origin.value = `${lat}, ${lng}`;
      console.log(`Startpunkt gesetzt auf: ${origin.value}`); // Überprüfe den Wert von origin
    } else {
      destination.value = `${lat}, ${lng}`;
      console.log(`Zielpunkt gesetzt auf: ${destination.value}`); // Überprüfe den Wert von destination
    }
    clickCount++; // Erhöhe den Klickzähler nach jedem Klick
  });

  directionsService = new google.maps.DirectionsService();
  directionsRenderer = new google.maps.DirectionsRenderer();
  directionsRenderer.setMap(map); // Setze die Karte für den DirectionsRenderer
};

onMounted(() => {
  createMap();
});

let directionsService: google.maps.DirectionsService;
let directionsRenderer: google.maps.DirectionsRenderer;

const createRoute = () => {
  const request = {
    origin: origin.value, // Verwende die Werte von origin und destination
    destination: destination.value,
    travelMode: google.maps.TravelMode.DRIVING, // Oder jede andere verfügbare Reisemethode
  };

  directionsService.route(request, (result, status) => {
    if (status === google.maps.DirectionsStatus.OK) {
      directionsRenderer.setDirections(result); // Zeige die Route auf der Karte an
    } else {
      console.error(`Directions request failed due to ${status}`);
    }
  });
};

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
  --background: #fff;
  /* Setzt die Hintergrundfarbe auf Weiß */
}
</style>
  