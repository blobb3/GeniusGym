<template>
    <ion-page>
        <ion-header>
            <ion-toolbar>
                <ion-title>Trainingseinheiten</ion-title>
                <p>Zähle die Tage, nicht die Sterne – Training führt zur Meisterschaft.</p>
            </ion-toolbar>
        </ion-header>
        <ion-content :fullscreen="true">
            <!-- Farbige Container für die Trainingseinheiten -->
            <ion-card @click="navigateToOberkoerper" color="primary">
                <ion-card-content>Oberkörpertraining</ion-card-content>
            </ion-card>
            <ion-card @click="navigateToUnterkoerper" color="secondary">
                <ion-card-content>Unterkörpertraining</ion-card-content>
            </ion-card>
            <ion-card color="tertiary">
                <ion-card-content>Running</ion-card-content>
            </ion-card>

            <!-- Button 'Für heute Fertig' -->
            <ion-button size="small">Training abschliessen</ion-button>
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

const router = useRouter();

// Funktion zum Navigieren zur Oberkoerper.vue-Seite
const navigateToOberkoerper = () => {
    router.push('/tabs/oberkoerper');
};

// Funktion zum Navigieren zur Unterkoerper.vue-Seite
const navigateToUnterkoerper = () => {
    router.push('/tabs/unterkoerper');
};
</script>

<style>
.button-container,
p {
    padding: 20px;
}
</style>