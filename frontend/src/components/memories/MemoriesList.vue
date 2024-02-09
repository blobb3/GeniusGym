<!--Ermöglicht das Hinzufügen von erinerungen, wobei die Eingaben in einem Formular erfasst werden-->
<template>
  <form class="ion-padding" @submit.prevent="submitForm">
    <ion-list>
      <ion-item>
        <ion-label position="floating" label="Title">Title</ion-label>
        <ion-input type="text" required v-model="enteredTitle" />
      </ion-item>
      <ion-item>
        <ion-thumbnail slot="start">
          <img :src="takenImageUrl" />
        </ion-thumbnail>
        <ion-button type="button" fill="clear" @click="takePhoto">
          <ion-icon slot="start" :icon="camera"></ion-icon>
          Take Photo
        </ion-button>
      </ion-item>

      <ion-item>
        <ion-label position="floating" label="Description">Description</ion-label>
        <ion-textarea :rows="5" v-model="enteredDescription"></ion-textarea>
      </ion-item>
    </ion-list>
    <ion-button type="submit" expand="block">Save</ion-button>
  </form>
</template>

<script lang="ts">
import {
  IonList,
  IonItem,
  IonLabel,
  IonInput,
  IonTextarea,
  IonButton,
  IonThumbnail,
  IonIcon
} from "@ionic/vue";
import { camera } from 'ionicons/icons';
import { CameraResultType, CameraSource } from '@capacitor/camera';

async function takePhoto() {
  const photo = await Camera.getPhoto({
    resultType: CameraResultType.Uri,
    source: CameraSource.Camera,
    quality: 60
  });

  console.log(photo.webPath);
}


import { Camera } from '@capacitor/camera';

export default {
  emits: ["save-memory"],
  components: {
    IonList,
    IonItem,
    IonLabel,
    IonInput,
    IonTextarea,
    IonButton,
    IonThumbnail,
    IonIcon
  },
  data() {
    return {
      enteredTitle: "",
      enteredDescription: "",
      takenImageUrl: "",
      camera: camera,
    };
  },

  methods: {
    async takePhoto() {
      const photo = await Camera.getPhoto({
        resultType: CameraResultType.Uri,
        source: CameraSource.Camera,
        quality: 60
      });

      // Verwendung des Nullish Coalescing Operators, um sicherzustellen, dass takenImageUrl immer ein String ist
      this.takenImageUrl = photo.webPath ?? "";

    },
    submitForm() {
      const memoryData = {
        title: this.enteredTitle,
        imageUrl: this.takenImageUrl,
        description: this.enteredDescription,
      };
      this.$emit("save-memory", memoryData);
    },
  },
};
</script>