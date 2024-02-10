<template>
    <ion-page>
        <ion-header class="ion-padding">
            <ion-toolbar>
                <ion-title class="ion-padding">Oberkörpertraining</ion-title>
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
                    <ion-accordion :value="exercise.id" class="ion-padding" >
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
import { ref } from 'vue';
import {
    IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonAccordionGroup, IonAccordion,
    IonItem, IonLabel, IonButtons, IonBackButton, IonButton
} from '@ionic/vue';
import { useDailyQuote } from '@/composables/useDailyQuote';
import { useMethods } from '@/store';

const { dailyQuote } = useDailyQuote();

interface Exercise {
    id: string;
    name: string;
    description: string;
    imageUrl: string;
    completed: boolean;
    punkte: number; 
}

// Übungen für das Oberkörpertraining
const exercises = ref<Exercise[]>([
    {
        id: 'pushups',
        name: 'Liegestütze',
        description: 'Stärkt Brust, Schultern und Trizeps. 2 Sätze von je 10-15 Wiederholungen.',
        imageUrl: 'https://www.fitundattraktiv.de/wp-content/uploads/2018/02/liegestuetze_muskelaufbau-liegestuetze_klassisch.gif',
        completed: false,
        punkte: 10 // Füge einen Wert für 'punkte' hinzu
    },
    {
        id: 'pullups',
        name: 'Klimmzüge',
        description: 'Zielt auf die Rückenmuskulatur und den Bizeps. 2 Sätze von 8-12 Wiederholungen.',
        imageUrl: 'https://homeworkouts.org/wp-content/uploads/anim-rear-pull-ups.gif',
        completed: false,
        punkte: 10 // Füge einen Wert für 'punkte' hinzu
    },
    {
        id: 'shoulderPress',
        name: 'Schulterdrücken',
        description: 'Kräftigt die Schultermuskulatur. 2 Sätze von je 10-15 Wiederholungen.',
        imageUrl: 'https://modusx.de/wp-content/uploads/schulterdruecken-kurzhanteln-sitzend.gif',
        completed: false,
        punkte: 10 // Füge einen Wert für 'punkte' hinzu
    },
]);


const collectedPoints = ref(0);

// Diese Funktion sollte innerhalb des `setup`-Blocks definiert sein.
const completeExercise = (index: number) => {
    const exercise = exercises.value[index];
    if (!exercise.completed) {
        collectedPoints.value += exercise.punkte; // Punkte zur gesammelten Punktzahl hinzufügen
        exercise.completed = true;
    }
};


/* Versuch 1 - Backup-Option

const collectedPoints = ref(0);

const { addPointsToOberkoerper } = useMethods(); // Verwende dies für Oberkoerper.vue

const completeExercise = (index: number) => {
    if (!exercises.value[index].completed) {
        collectedPoints.value += 5; // Lokale Punkte aktualisieren (optional, falls du lokale Punkte anzeigen möchtest)
        exercises.value[index].completed = true;
        addPointsToOberkoerper(5); // Korrekt für Oberkoerper.vue
    }
};  */
</script>



<style scoped>
/* Star Wars-Theme Anpassungen */
:root {
    --ion-color-primary: #000; /* Schwarz */
    --ion-color-secondary: #ffe81f; /* Gold */
    --ion-color-tertiary: #d0d0d0; /* Grau */
}

ion-title, ion-label, ion-button {
    color: #ffe81f;
}

.completed-button {
    --background: green;
}

ion-item[color="light"] {
    --background: rgba(0, 0, 0, 0.8);
    --color: #ffe81f;
    border: 1px solid #ffe81f;
}
.completed-button {
    --background: green;
}
</style>
