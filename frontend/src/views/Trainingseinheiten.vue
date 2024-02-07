<template>
    <ion-page class="ion-padding">
        <ion-header >
            <ion-toolbar>
                <ion-title class="ion-padding">Trainingseinheiten</ion-title>
                <p>Zähle die Tage, nicht die Sterne – Training führt zur Meisterschaft.</p>
            </ion-toolbar>
        </ion-header>
        <ion-content class="ion-padding" :fullscreen="true">
            <!-- Farbige Container für die Trainingseinheiten -->
            <ion-card @click="navigateToOberkoerper" color="primary">
                <ion-card-content>Oberkörpertraining</ion-card-content>
            </ion-card>
            <ion-card @click="navigateToUnterkoerper" color="secondary">
                <ion-card-content>Unterkörpertraining</ion-card-content>
            </ion-card>
            <!--auch möglich durch - ion-item v-bind:router-link= ""'/tabs/tab2/' + task.id"-->
            <ion-card @click="navigateToRunningMap" color="tertiary">
                <ion-card-content>Running</ion-card-content>
            </ion-card>

            <!-- Button 'Für heute Fertig' -->
            <ion-button size="small">Training abschliessen</ion-button>
        </ion-content>
    </ion-page>
    <!--<ion-card-content>Oberkörpertraining - Punkte: {{ globalState.oberkoerperPunkte }}</ion-card-content>
    <ion-card-content>Unterkörpertraining - Punkte: {{ globalState.unterkoerperPunkte }}</ion-card-content>-->
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

//für punktzahl von untertrainingseinheiten
import { inject } from 'vue';
const globalState = inject('globalState');

const router = useRouter()

// Funktion zum Navigieren zur Oberkoerper.vue-Seite
const navigateToOberkoerper = () => {
    router.push('/tabs/oberkoerper');
};

// Funktion zum Navigieren zur Unterkoerper.vue-Seite
const navigateToUnterkoerper = () => {
    router.push('/tabs/unterkoerper');
};
// Funktion zum Navigieren zur RunningMap.vue-Seite
const navigateToRunningMap = () => {
    router.push('/tabs/runningmap');
};
</script>

<style scoped>
.button-container,
p {
    padding: 20px;
}
.ion-padding {
  --background: #fff; /* Setzt die Hintergrundfarbe auf Weiss */
}
</style>