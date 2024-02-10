<template>
    <ion-page class="ion-padding">
        <ion-header class="ion-header-flex">
            <TheFooter />
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
            <transition name="fade" mode="out-in">
            <ion-button size="small">Training abschließen</ion-button></transition>
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
import TheFooter from '@/components/TheFooter.vue';

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
    transition: transform 0.3s ease;
}

ion-button:active {
  transform: scale(0.96);
} 

ion-title,
ion-card-content {
    color: #ffe81f;
}

p {
    color: #d0d0d0;
}

.ion-header-flex {
  display: flex;
  justify-content: center; /* Zentriert die Inhalte horizontal */
  align-items: center; /* Zentriert die Inhalte vertikal */
  flex-direction: column; /* Stapelt die Kinder vertikal */
  text-align: center; /* Zentriert den Text der direkten Kinder */
}

ion-header {
  --background: #000; 
}


/* Basis Animation für Karten */
@keyframes popIn {
  0% {
    transform: scale(0.95);
    opacity: 0.6;
  }
  100% {
    transform: scale(1);
    opacity: 1;
  }
}

/* Animation beim Hovern über die Karte */
ion-card:hover {
  animation: popIn 0.5s ease forwards;
}

/* Animation beim Fokussieren der Karte (z.B. bei Touch-Events) */
ion-card:focus-within {
  animation: popIn 0.5s ease forwards;
}

/* Fügen Sie diesen Code zu Ihrem <style> hininzu */

/* Vue-Übergänge */
.fade-enter-active, .fade-leave-active {
  transition: opacity 0.5s;
}
.fade-enter, .fade-leave-to /* .fade-leave-active in <2.1.8 */ {
  opacity: 0;
}

</style> 