<template>
    <ion-page>
        <ion-header>
            <ion-toolbar>
                <ion-buttons slot="start">
                    <ion-back-button defaultHref="/tabs/todo"></ion-back-button>
                </ion-buttons>
                <ion-title>Add New Gym Goal</ion-title>
            </ion-toolbar>
        </ion-header>
        <ion-content class="ion-padding">
            <p>{{ dailyQuote }}</p> <!-- Zeige das Tageszitat an, falls benötigt -->
            <ion-item>
                <ion-thumbnail slot="start">
                    <img :src="takenImageUrl" />
                </ion-thumbnail>
                <ion-button type="button" fill="clear" @click="takePhoto">
                    <ion-icon slot="start" :icon="cameraIcon"></ion-icon>
                    Upload your Gym Photo
                </ion-button>
            </ion-item>
            <ion-item>
                <ion-input type="text" placeholder="New Gym Goal" v-model="newTodo.title"></ion-input>
            </ion-item>
            <div class="ion-padding">
                <ion-button @click="handleAddTodo" expand="full">Add New Gym Goal</ion-button>
            </div>
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
    IonItem,
    IonInput,
    IonButton,
    IonButtons, IonList, IonLabel, IonTextarea, IonThumbnail, IonIcon
} from '@ionic/vue';
import { useTodos } from '@/composables/useTodos';
import { useDailyQuote } from '@/composables/useDailyQuote';
import { IonBackButton } from '@ionic/vue';
import { camera as cameraIcon } from 'ionicons/icons';
import { Camera, CameraResultType, CameraSource } from '@capacitor/camera';
import { ref, defineComponent } from 'vue';


// Verwende Composables
const { newTodo, addTodo } = useTodos();
const { dailyQuote } = useDailyQuote();

// Funktion zum Hinzufügen eines neuen Todos
const handleAddTodo = async () => {
    if (newTodo.value.title !== undefined) {
        await addTodo();
    } else {
        console.error("Das Todo muss einen Titel haben.");
    }
};

const takenImageUrl = ref('');

const takePhoto = async () => {
    const photo = await Camera.getPhoto({
        resultType: CameraResultType.Uri,
        source: CameraSource.Camera,
        quality: 60
    });
    takenImageUrl.value = photo.webPath ?? "";
};

</script>
  