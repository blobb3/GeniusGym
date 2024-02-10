<template>
  <ion-page>
    <ion-content class="content-center">
      <div class="centered-content">
        <ion-toolbar>
          <ion-title>Dashboard</ion-title>
        </ion-toolbar>
        <p style="margin-bottom: 50px;">{{ dailyQuote }}</p>
        <div class="centered-container">
          <ion-datetime :is-date-enabled="isWeekday"></ion-datetime>
        </div>
        <div ref="chartDiv" id="chartDiv" class="centered-container"></div>
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonPage, IonToolbar, IonTitle, IonContent, IonDatetime } from '@ionic/vue';
import { useDailyQuote } from '@/composables/useDailyQuote';
import { ref, onMounted } from 'vue';

const { dailyQuote } = useDailyQuote();

// Funktion direkt im <script setup> definieren
const isWeekday = (dateString: string) => {
  const date = new Date(dateString);
  const utcDay = date.getUTCDay();
  return utcDay !== 0 && utcDay !== 6;
};

const chartDiv = ref(null);

onMounted(() => {
  if (chartDiv.value) {
    google.charts.load('current', { packages: ['corechart', 'line'] });
    google.charts.setOnLoadCallback(drawChart);
  }
});

function drawChart() {
  if (!chartDiv.value) {
    console.error('Das Diagramm-Element wurde nicht gefunden.');
    return;
  }

  const data = new google.visualization.DataTable();
  data.addColumn('string', 'Datum');
  data.addColumn('number', 'Kilometer');

  data.addRows([
    ['12. Jan', 10],
    ['27. Jan', 8.5],
    ['30. Jan', 17.25],
    ['5. Feb', 8.25],
    ['14. Feb', 10.12],
    ['18. Feb', 16.35],
    ['9. Mär', 17.45],
    ['16. Mär', 22.23],
    ['23. Apr', 10.75],
    ['27. Apr', 7.64],
  ]);

  const options: google.visualization.LineChartOptions = {
    title: 'Dein Fitness-Fortschritt',
    curveType: 'function',
    legend: { position: 'bottom' },
    hAxis: {
      title: 'Datum',
      slantedText: true, // Wenn die Datenbeschriftungen schräg angezeigt werden sollen
      slantedTextAngle: 45 // Winkel der Schräge
    },
    vAxis: {
      title: 'Kilometer',
      minValue: 0, // Minimale Grenze der vertikalen Achse
      maxValue: 40, // Maximale Grenze der vertikalen Achse, falls gewünscht
      gridlines: {
        count: 11, // Dies erzeugt Linien für jeden 5er-Intervall bis 50
      },
      // Optional: Kleinere Gitterlinien für noch feinere Intervalle
      minorGridlines: {
        count: 4, // Dies würde zwischen den Hauptgitterlinien kleinere hinzufügen
      },
      format: '0', // Optional: Keine Dezimalstellen anzeigen
    },
    colors: ['#1c91c0'], // Farbe der Linie, passend zu deinem Bild
    pointSize: 5,
    chartArea: {
      left: '10%',
      top: '10%',
      width: '80%',
      height: '40%' // Evtl. die Höhe anpassen für eine bessere Darstellung
    },
  };


  const chart = new google.visualization.LineChart(chartDiv.value);
  chart.draw(data, options);
}
</script>

<style>
.content-center {
  display: flex;
  justify-content: center;
  height: 100%;
}

.centered-content {
  max-width: 500px;
  width: 100%;
  margin: 0 auto;
}

#chart_div {
  width: 100%;
  height: 400px;
  /* Angepasste Höhe für Gitterlinien */
}

.centered-content>* {
  text-align: center;
}

.centered-container {
  display: flex;
  justify-content: center;
  width: 100%;
  margin-bottom: 50px;
}

#chartDiv {
  width: 100%;
  height: 200px;
}
</style>
