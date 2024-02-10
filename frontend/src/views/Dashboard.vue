<template>
  <ion-page>
    <ion-content class="content-center">
      <ion-header class="ion-header-flex">
        <ion-toolbar>
          <ion-title class="ion-padding">Dashboard</ion-title>
          <p class="ion-padding">{{ dailyQuote }}</p>
        </ion-toolbar>
      </ion-header>
      <br>
      <div class="centered-content">
        <div class="centered-container">
          <ion-datetime></ion-datetime>
        </div>
        <div ref="chartDiv" id="chartDiv" class="centered-container"></div>
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { IonPage, IonToolbar, IonTitle, IonContent, IonDatetime } from '@ionic/vue';
import { useDailyQuote } from '@/composables/useDailyQuote';

const { dailyQuote } = useDailyQuote();
const chartDiv = ref(null);

// Definieren Sie den Typ für Ihre Routendaten
interface Route {
  origin: string;
  destination: string;
  distance: string;
  duration: string;
  created: string;
}

const routesData = ref<Route[]>([]);

// Basic Auth Credentials
const username = 'user';
const password = 'user';
const basicAuth = 'Basic ' + btoa(username + ':' + password);

// Funktion zum Abrufen der Routendaten vom Server
async function fetchMaps() {
  try {
    const response = await axios.get<Route[]>('http://localhost:8080/api/routes', {
      headers: { Authorization: basicAuth },
    });
    routesData.value = response.data;
    console.log(response.data);
    google.charts.load('current', { packages: ['corechart', 'line'] });
    google.charts.setOnLoadCallback(drawChart);
  } catch (error) {
    console.error("Fehler beim Abrufen der Routendaten:", error);
  }
}

// Funktion zum Zeichnen des Diagramms mit den geladenen Daten
function drawChart() {
  if (!chartDiv.value || routesData.value.length === 0) {
    console.error('Das Diagramm-Element wurde nicht gefunden oder es gibt keine Daten.');
    return;
  }

  const data = new google.visualization.DataTable();
  data.addColumn('string', 'Datum');
  data.addColumn('number', 'Kilometer');

  const chartRows = routesData.value.map(route => {
    const date = new Date(route.created).toLocaleDateString();
    const distance = parseFloat(route.distance);
    return [date, distance];
  });

  data.addRows(chartRows);

  const options = {
    title: 'Dein Fitness-Fortschritt',
    curveType: 'function' as const,
    legend: { position: 'bottom' },
    hAxis: {
      title: 'Datum',
      slantedText: true,
      slantedTextAngle: 45
    },
    vAxis: {
      title: 'Kilometer',
      minValue: 0,
      gridlines: {
        count: -1,
        units: {
          kilometers: { format: ['10'] }
        }
      },
    },
    height: 200,
    colors: ['#1c91c0'],
    pointSize: 5,
    chartArea: { left: '10%', top: '10%', width: '85%', height: '40%' },
  } as google.visualization.LineChartOptions;

  const chart = new google.visualization.LineChart(chartDiv.value);
  chart.draw(data, options);
}

onMounted(fetchMaps);
</script>


<style scoped>
/* Ihr vorhandener Stil plus ggf. zusätzliche Stile */
.content-center {
  display: flex;
  justify-content: center;
  height: 100px;
}

.centered-content {
  max-width: 500px;
  width: 100%;
  margin: 0 auto;
}

.centered-container {
  display: flex;
  justify-content: center;
  width: 100%;
  margin-bottom: 50px;
}

#chartDiv {
  width: 100%;
  height: 300px;
  /* Höhe des Diagramms anpassen */
}
</style>
