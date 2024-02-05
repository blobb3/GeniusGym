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
            <ion-card color="primary">
                <ion-card-content>Oberkörpertraining</ion-card-content>
            </ion-card>
            <ion-card color="secondary">
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


</script>

<style>
.button-container, p {
    padding: 20px;
    /* Fügt etwas Abstand um den Button herum hinzu */
}
</style>
  