<template>
  <ion-page>
    <ion-header class="ion-padding">
      <ion-toolbar>
        <ion-title class="ion-padding">Dashboard</ion-title>
        <p class="ion-padding">{{ dailyQuote }}</p>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-datetime :is-date-enabled="isWeekday"></ion-datetime>
      <div id="chart_div" style="width: 100%; height: 500px;"></div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonDatetime } from '@ionic/vue';
import { useDailyQuote } from '@/composables/useDailyQuote';
import { onMounted } from 'vue';

const { dailyQuote } = useDailyQuote();

// Funktion direkt im <script setup> definieren
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
    data.addColumn('number', 'Fortschritt');

    data.addRows([
      ['1. Jan', 1000],
      ['1. Feb', 1170],
      ['1. Mär', 660],
      ['1. Apr', 1030],
      // Fügen Sie hier Ihre Daten ein
    ]);

    const options: any = {
      title: 'Dein Fitness-Fortschritt',
      curveType: 'function',
      legend: { position: 'bottom' }
    };

    const chart = new google.visualization.LineChart(chartDiv);
    chart.draw(data, options);
  }
});
</script>

<style>
/* Deine vorhandenen Stilregeln */
</style>
