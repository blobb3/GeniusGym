<template>
    <ion-page class="ion-padding">
        <ion-header>
            <ion-toolbar>
                <ion-title class="ion-padding">Trainingseinheiten</ion-title>
                <p class="ion-padding">{{ dailyQuote }}</p>
            </ion-toolbar>
        </ion-header>
        <ion-content class="ion-padding" :fullscreen="true">
            <!-- Farbige Container für die Trainingseinheiten -->
            <ion-card @click="navigateToOberkoerper" color="primary" class="ion-padding">
                <ion-card-content>Oberkörpertraining</ion-card-content>
            </ion-card>
            <ion-card @click="navigateToUnterkoerper" color="secondary" class="ion-padding">
                <ion-card-content>Unterkörpertraining</ion-card-content>
            </ion-card>
            <br>
            <!--auch möglich durch - ion-item v-bind:router-link= ""'/tabs/tab2/' + task.id"-->
            <ion-card @click="navigateToRunningMap" color="tertiary" class="ion-padding">
                <ion-card-content>Running</ion-card-content>
            </ion-card>
            <!-- Anzeige der Punkte für Ober- und Unterkörper -->
            <div class="ion-padding">
                Punkte Oberkörper: {{ oberkoerperPunkte }}
            </div>
            <div class="ion-padding">
                Punkte Unterkörper: {{ unterkoerperPunkte }}
            </div>
            <!-- Button 'Für heute Fertig' -->
            <ion-button size="small">Training abschließen</ion-button>
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
import { useDailyQuote } from '@/composables/useDailyQuote';
import { useState } from '@/store'; // useState anstatt useMethods

const { dailyQuote } = useDailyQuote();
const { oberkoerperPunkte, unterkoerperPunkte } = useState(); // useState verwenden, um auf den globalen Zustand zuzugreifen

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
/* Star Wars-Theme Farben */
:root {
    --ion-color-primary: #000;
    /* Schwarz für den Hintergrund */
    --ion-color-secondary: #ffe81f;
    /* Gold für wichtige Elemente */
    --ion-color-tertiary: #d0d0d0;
    /* Grau für Nebenelemente */
}

/* Anpassungen für Buttons und Cards */
ion-card {
    background: rgba(0, 0, 0, 0.8);
    color: #ffe81f;
    border: 1px solid #ffe81f;
}

ion-button {
    --background: #000;
    --color: #ffe81f;
    border: 1px solid #ffe81f;
}

ion-title,
ion-card-content {
    color: #ffe81f;
}

p {
    color: #d0d0d0;
}
</style>
