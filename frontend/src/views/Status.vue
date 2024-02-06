<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Status</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true" class="ion-padding">
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
            </ion-list>
            <ion-label class="progress-text">Punkte bis zum nächsten Level: {{ userData.points }} / {{
              userData.pointsToNextLevel }} </ion-label>
          </ion-card-content>
        </ion-card>
      </div>
    </ion-content>
  </ion-page>
</template>
  
<script setup lang="ts">
import { person } from 'ionicons/icons';

const userData = {
  name: 'Hanspeter Ueli Sepp',
  level: 5,
  points: 120,
  pointsToNextLevel: 200,
};
</script>
  
<style scoped>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.user-status-card {
  --background: #FFA500;
  width: 100%;
  max-width: 400px;
}

.custom-avatar {
  margin: 0 auto;
}

.card-title,
.progress-text {
  color: #000000;
}

.ion-padding {
  --background: #fff;
  /* Setzt die Hintergrundfarbe auf Weiß */
}
</style>
  