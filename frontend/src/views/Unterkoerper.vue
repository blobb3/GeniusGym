<template>
    <ion-page>
        <ion-header class="ion-padding">
            <ion-toolbar>
                <ion-title class="ion-padding">Unterkörpertraining</ion-title>
                <p class="ion-padding">{{ dailyQuote }}</p>
                <ion-buttons slot="start">
                    <ion-back-button defaultHref="/"></ion-back-button>
                </ion-buttons>
            </ion-toolbar>
        </ion-header>
        <ion-content class="ion-padding" :fullscreen="true">
            <ion-accordion-group :multiple="true">
                <!-- Dynamische Generierung der Übungen und direkt darunter liegende Buttons -->
                <div v-for="(exercise, index) in exercises" :key="exercise.id">
                    <ion-accordion :value="exercise.id" class="ion-padding">
                        <ion-item slot="header" color="light">
                            <ion-label>{{ exercise.name }}</ion-label>
                        </ion-item>
                        <div class="ion-padding" slot="content">
                            {{ exercise.description }}
                            <div v-if="exercise.imageUrl">
                                <img :src="exercise.imageUrl" style="max-width: 360px; height: auto; margin: 0 auto; display: block;">
                            </div>
                        </div>
                    </ion-accordion>
                    <ion-button @click="completeExercise(index)" :disabled="exercise.completed" :class="{ 'completed-button': exercise.completed }" class="ion-padding">Erledigt</ion-button>
                </div>
            </ion-accordion-group>
            <!-- Anzeige der gesammelten Punkte -->
            <div class="ion-padding">
                Gesammelte Punkte: {{ collectedPoints }}
            </div>
        </ion-content>
    </ion-page>
</template>

<script setup lang="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonAccordionGroup, IonAccordion, IonItem, IonLabel, IonButtons, IonBackButton, IonButton } from '@ionic/vue';
import { ref } from 'vue';
import { useDailyQuote } from '@/composables/useDailyQuote';
const { dailyQuote } = useDailyQuote();

interface Exercise {
    id: string;
    name: string;
    description: string;
    imageUrl?: string;
    completed: boolean;
}

// Initialisiere die Übungen mit dem Status 'completed' als false
const exercises = ref<Exercise[]>([
    { id: 'squat', name: 'Kniebeugen', description: 'Stärkt Beine und Gesäss. 2 Sätze von je 10-15 Wiederholungen.', imageUrl: 'https://www.fitundattraktiv.de/wp-content/uploads/2018/01/kniebeugen_muskeln-breite_kniebeugen_langhantel.gif', completed: false },
    { id: 'lunges', name: 'Ausfallschritte', description: 'Trainiert Beine und Gesäss. Fördert die Stabilität. 3 Sätze von 10-12 Wiederholungen pro Bein.', imageUrl: 'https://www.fitundattraktiv.de/wp-content/uploads/2017/11/kurzhantel_ausfallschritte_nach_hinten.gif',completed: false },
    { id: 'deadlifts', name: 'Kreuzheben', description: 'Stärkt die hintere Beinmuskulatur und den unteren Rücken. 3 Sätze von 8-10 Wiederholungen.', imageUrl:'https://www.fitundattraktiv.de/wp-content/uploads/2018/01/kreuzheben_muskelgruppen-kreuzheben_mit_langhantel.gif', completed: false },
    { id: 'legpress', name: 'Beinpresse', description: 'Zielt auf Oberschenkel und Gesässmuskulatur. 3 Sätze von 10-15 Wiederholungen.', imageUrl:'https://www.fitundattraktiv.de/wp-content/uploads/2018/02/beinpresse_muskeln-45_grad_beinpresse.gif' ,completed: false },
    { id: 'calfRaises', name: 'Wadenheben', description: 'Isoliertes Training der Waden. 3 Sätze von 15-20 Wiederholungen.', imageUrl: 'https://modusx.de/wp-content/uploads/wadenheben-stehend-mit-eigenem-koerpergewicht.gif', completed: false },
    { id: 'hamstringCurls', name: 'Bein-Curls', description: 'Kräftigt die Beinrückseite. 3 Sätze von 10-15 Wiederholungen.', imageUrl: 'https://www.fitundattraktiv.de/wp-content/uploads/2018/02/beincurls_liegend.gif',completed: false },
    { id: 'stepUps', name: 'Step-Ups', description: 'Verbessert Kraft und Balance. 3 Sätze von 10 Wiederholungen pro Bein.', imageUrl: 'https://modusx.de/wp-content/uploads/side-step-ups.gif',completed: false },
]);

const collectedPoints = ref(0);

// Methode zum Abschliessen einer Übung und Hinzufügen von Punkten
const completeExercise = (index: number) => {
    if (!exercises.value[index].completed) {
        collectedPoints.value += 5;
        exercises.value[index].completed = true;
    }
}

/*
const globalState = inject('globalState');

const completeExercise = (index: number) => {
  if (!exercises.value[index].completed) {
    const pointsToAdd = 5;
    collectedPoints.value += pointsToAdd;
    exercises.value[index].completed = true;
    // Hier aktualisieren Sie den globalen Zustand je nach Komponente
    if () {
        globalState.oberkoerperPunkte += pointsToAdd;
    } else {
      globalState.unterkoerperPunkte += pointsToAdd;
    }
  }
};
*/
</script>

<style scoped>
.completed-button {
    --background: green;
}

/* Star Wars-Theme Farbschema und Schriftarten */
:root {
    --ion-color-primary: #000; /* Schwarz für den Hintergrund */
    --ion-color-secondary: #ffe81f; /* Gelb für wichtige Elemente, erinnert an C-3PO */
    --ion-color-tertiary: #d0d0d0; /* Grau für Nebenelemente */
}

ion-title, ion-label, ion-button, .ion-padding {
    color: #ffe81f; /* Gelbe Schriftfarbe für Text */
}

.completed-button, .incomplete-button {
    --background: #4CAF50; /* Grün für abgeschlossene Übungen */
    color: white; /* Weiße Textfarbe für Button-Text */
}

.incomplete-button {
    --background: #FFEB3B; /* Gelb für noch nicht abgeschlossene Übungen */
    --color: black; /* Schwarze Textfarbe für Button-Text */
}

ion-item[color="light"] {
    --background: rgba(0, 0, 0, 0.8); /* Dunkler Hintergrund für Items */
    --color: #ffe81f; /* Gelbe Schriftfarbe */
    border: 1px solid #ffe81f; /* Gelber Rand */
}
</style>
