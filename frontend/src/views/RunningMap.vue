<template>
  <ion-page>
    <ion-header class="ion-padding">
      <ion-toolbar>
        <ion-title class="ion-padding">Wähle deine Joggingstrecke</ion-title>
        <p class="ion-padding">{{ dailyQuote }}</p>
        <ion-buttons slot="start">
          <ion-back-button defaultHref="/"></ion-back-button>
        </ion-buttons>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true" class="ion-padding">

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
      <ion-button @click="resetMap">Reset Map</ion-button>
      <ion-button @click="saveRoute">Save Route</ion-button>

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
  IonInput,
  IonItem,
  IonLabel
} from '@ionic/vue';

import { useDailyQuote } from '@/composables/useDailyQuote';
const { dailyQuote } = useDailyQuote();

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

//Map erstellen
let origin = ref('');
let destination = ref('');
let map: google.maps.Map;
let clickCount = 0;
let isClickListenerActive = ref(true);

const createMap = () => {
  const mapOptions = {
    center: new google.maps.LatLng(47.502, 8.726),
    zoom: 15,
  };
  const mapRef = document.getElementById('map_canvas')!;
  map = new google.maps.Map(mapRef, mapOptions);

  map.addListener('click', (e: google.maps.MapMouseEvent) => {
    if (!isClickListenerActive.value) return;
    const latLng = e.latLng!;
    const lat = latLng.lat();
    const lng = latLng.lng();

    console.log(`Klick erkannt bei: ${lat}, ${lng}`);

    if (clickCount % 2 === 0) {
      origin.value = `${lat}, ${lng}`;
      console.log(`Startpunkt gesetzt auf: ${origin.value}`);
    } else {
      destination.value = `${lat}, ${lng}`;
      console.log(`Zielpunkt gesetzt auf: ${destination.value}`);
    }
    clickCount++;
  });

  directionsService = new google.maps.DirectionsService();
  directionsRenderer = new google.maps.DirectionsRenderer();
  directionsRenderer.setMap(map);
};

onMounted(() => {
  createMap();
});

//Route erstellen
let directionsService: google.maps.DirectionsService;
let directionsRenderer: google.maps.DirectionsRenderer;

const createRoute = () => {
  const request = {
    origin: origin.value,
    destination: destination.value,
    travelMode: google.maps.TravelMode.WALKING,
  };

  directionsService.route(request, (result, status) => {
    if (status === google.maps.DirectionsStatus.OK) {
      console.log(result)
      directionsRenderer.setDirections(result);
    } else {
      console.error(`Directions request failed due to ${status}`);
    }
  });
  isClickListenerActive.value = false;
};

//Route zurücksetzen
const resetMap = () => {
  directionsRenderer.setMap(null);

  directionsRenderer = new google.maps.DirectionsRenderer();
  directionsRenderer.setMap(map);

  origin.value = '';
  destination.value = '';
  clickCount = 0;
  isClickListenerActive.value = true;
};

//Route speichern
interface RouteSummary {
  origin: string;
  destination: string;
  distance: string;
  duration: string;
}

let savedRoutes = ref<RouteSummary[]>([]);

const saveRoute = () => {
  const lastResult = directionsRenderer.getDirections();
  if (!lastResult || lastResult.routes.length === 0 || lastResult.routes[0].legs.length === 0) {
    console.error("Keine Route zum Speichern vorhanden.");
    return;
  }

  const route = lastResult.routes[0];
  const leg = route.legs[0];

  if (!leg) {
    console.error("Die Route enthält keine Legs.");
    return;
  }

  const routeSummary = {
    origin: leg.start_address,
    destination: leg.end_address,
    distance: leg.distance ? leg.distance.text : 'Unbekannt',
    duration: leg.duration ? leg.duration.text : 'Unbekannt',
  };

  savedRoutes.value.push(routeSummary);
  console.log("Route gespeichert:", routeSummary);
  isClickListenerActive.value = false;
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

/* Star Wars-Theme Anpassungen */
:root {
  --ion-color-primary: #000;
  /* Schwarz */
  --ion-color-secondary: #ffe81f;
  /* Gold */
  --ion-color-tertiary: #d0d0d0;
  /* Grau */
}

ion-page {
  --background: url('path/to/your/starwars-background.jpg') no-repeat center center / cover;
  font-family: 'Star Jedi', sans-serif;
}

ion-title,
ion-label,
ion-button {
  color: #ffe81f;
}

.completed-button {
  --background: green;
}

ion-item[color="light"] {
  --background: rgba(0, 0, 0, 0.8);
  --color: #ffe81f;
  border: 1px solid #ffe81f;
}

.completed-button {
  --background: green;
}
</style>
  