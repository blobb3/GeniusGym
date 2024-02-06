<template>
    <ion-page>
        <ion-header>
            <ion-toolbar>
                <ion-title>Oberkörpertraining</ion-title>
            </ion-toolbar>
        </ion-header>
        <ion-content :fullscreen="true">
            <ion-accordion-group :multiple="true">
                <ion-accordion value="first">
                    <ion-item slot="header" color="light">
                        <ion-label>Liegestütze</ion-label>
                    </ion-item>
                    <div class="ion-padding" slot="content">
                        <img src="https://www.fitundattraktiv.de/wp-content/uploads/2018/02/liegestuetze_muskelaufbau-liegestuetze_klassisch.gif"
                            style="max-width: 360px; height: auto; margin: 0 auto; display: block;">
                        Stärkt Brust, Schultern und Trizeps. 2 Sätze von je 10-15 Wiederholungen.
                    </div>

                </ion-accordion>
                <ion-accordion value="second">
                    <ion-item slot="header" color="light">
                        <ion-label>Klimmzüge</ion-label>
                    </ion-item>
                    <div class="ion-padding" slot="content">
                        <img src="https://homeworkouts.org/wp-content/uploads/anim-rear-pull-ups.gif"
                            style="max-width: 360px; height: auto; margin: 0 auto; display: block;">
                        Zielt auf die Rückenmuskulatur und den Bizeps. 2 Sätze von
                    </div>
                </ion-accordion>

                <ion-accordion value="third">
                    <ion-item slot="header" color="light">
                        <ion-label>Schulterdrücken</ion-label>
                    </ion-item>
                    <div class="ion-padding" slot="content">
                        <img src="https://modusx.de/wp-content/uploads/schulterdruecken-kurzhanteln-sitzend.gif"
                            style="max-width: 360px; height: auto; margin: 0 auto; display: block;">
                        Kräftigt die Schultermuskulatur. 2 Sätze von je 10-15 Wiederholungen.
                    </div>
                </ion-accordion>

            </ion-accordion-group>
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
    IonAccordionGroup,
    IonAccordion,
    IonItem,
    IonLabel,
} from '@ionic/vue';
</script>

<style scoped>
.ion-padding {
    color: black;
}
</style>
  