<template>
  <ion-page>
    <ion-content class="content-center">
      <div class="centered-content">
        <ion-toolbar>
          <ion-title>Dashboard</ion-title>
        </ion-toolbar>
        <p>{{ dailyQuote }}</p>
        <div class="centered-container">
          <ion-datetime :is-date-enabled="isWeekday"></ion-datetime>
        </div>
        <div class="centered-container" id="chart_div"></div>
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonPage, IonToolbar, IonTitle, IonContent, IonDatetime } from '@ionic/vue';
import { useDailyQuote } from '@/composables/useDailyQuote';
import { onMounted } from 'vue';

const { dailyQuote } = useDailyQuote();

const isWeekday = (dateString: string) => {
  const date = new Date(dateString);
  const utcDay = date.getUTCDay();
  return utcDay !== 0 && utcDay !== 6;
};

onMounted(() => {
  google.charts.load('current', { packages: ['corechart', 'line'] });
  google.charts.setOnLoadCallback(() => {
    drawChart();
  });

  function drawChart() {
    const chartDiv = document.getElementById('chart_div');
    if (!chartDiv) {
      console.error('Das Diagramm-Element wurde nicht gefunden.');
      return;
    }

    const data = new google.visualization.DataTable();
    data.addColumn('string', 'Datum');
    data.addColumn('number', 'Kilometer');

    data.addRows([
      ['1. Jan', 10],
      ['1. Feb', 8.5],
      ['1. Mär', 17.25],
      ['1. Apr', 14.3],
      // ...weitere Datenpunkte...
    ]);

    const options = {
      title: 'Dein Fitness-Fortschritt',
      curveType: 'function',
      legend: { position: 'bottom' },
      hAxis: {
        title: 'Datum',
        titleTextStyle: { color: '#333' },
        slantedText: true,
        slantedTextAngle: 45,
      },
      vAxis: {
        title: 'Kilometer',
        gridlines: {
          color: '#e9e9e9',
          count: 4,
        },
        minValue: 0,
      },
      pointSize: 5,
      colors: ['#blue'],
    };

    const chart = new google.visualization.LineChart(chartDiv);
    chart.draw(data, options);
  }
});
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
  /* Größere Höhe für bessere Darstellung */
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

ion-title {
  text-align: center;
}
</style>
