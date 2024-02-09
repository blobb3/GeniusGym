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
    <p>{{ dailyQuote }}</p>
    <div class="death-star-container">
      <ion-thumbnail slot="start" class="photo-thumbnail">
        <img :src="takenImageUrl" class="photo-image" />
        <!-- Verschieben Sie den Kamera-Button hierhin -->
        <ion-button fill="clear" @click="takePhoto" class="take-photo-button">
          <ion-icon :icon="cameraIcon"></ion-icon>
        </ion-button>
      </ion-thumbnail>
      <ion-button fill="clear" @click="takePhoto" class="laser-cannon-button">
        <ion-icon :icon="cameraIcon"></ion-icon>
      </ion-button>
      <ion-item lines="none" class="death-star-input">
        <ion-input type="text" placeholder="Gym-Goal hinzufügen" v-model="newTodo.title"></ion-input>
      </ion-item>
      <div class="button-container">
        <ion-button @click="handleAddTodo" class="death-star-button">
          Hochladen
        </ion-button>
      </div>
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
<style scoped >

.death-star-container {
  border-radius: 50%;
  width: 300px; /* Größe des Todessterns */
  height: 300px; /* Größe des Todessterns */
  background-color: black;
  margin: 40px auto 20px; /* Vertikale Zentrierung */
  padding: 20px;
  box-shadow: 0 0 0 6px #ffe81f; /* Gelber Rand */
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around; 
  position: relative;
}

.laser-cannon-container {
  position: absolute;
  top: -15px; /* Position oberhalb des Kreises anpassen */
  left: 50%;
  transform: translateX(-50%);
  display: flex;
  flex-direction: column;
  align-items: center;
}

.photo-thumbnail {
  width: 60px; /* Größe des Vorschaubilds */
  height: 60px; /* Größe des Vorschaubilds */
  border-radius: 50%;
  overflow: hidden;
  background-color: #303030; /* Dunkles Eingabefeld */
  position: absolute;
  top: 0; /* Positioniert das Thumbnail oben im Kreis */
  transform: translate(-50%, 0%);
  left: 50%;
}

.photo-image {
  display: block;
  width: 100%;
  height: auto;
  border-radius: 50%;
}

.laser-cannon-button {
  --color: #000;
  width: 20px; /* Kleinerer Button für Laserstrahl-Effekt */
  border-radius: 10px 10px 0 0; /* Obere Kanten abrunden für Laserstrahl-Effekt */
  position: absolute;
  transform: translate(-100%, 50%);
}

.death-star-input {
  --background: transparent; /* Transparentes Eingabefeld */
  --placeholder-color: #ffe81f;
  --color: #ffe81f;
  border: 1px solid #ffe81f; /* Kontur hinzufügen */
  border-radius: 20px;
  width: 90%; /* Breite des Eingabefeldes */
  margin-top: 60px; /* Platz oberhalb des Eingabefeldes */
}
.button-container {
  position: absolute;
  bottom: 10px; /* Position unterhalb des Kreises anpassen */
  left: 50%;
  transform: translateX(-50%);
}

.death-star-button {
  --background: #ffe81f;
  --color: #000;
  --background-activated: #ffd700;
  --background-hover: #ffd700;
  border-radius: 20px;
  font-weight: bold;
  width: 90%; /* Breite des Hinzufügen-Buttons */
  height: auto; /* Höhe des Buttons basierend auf dem Inhalt */
  padding: 10px;
  text-transform: none;
}
</style>