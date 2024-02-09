<!--Benutzeroberfläche zum Hinzuüfgen von Erinnerung in Form eines Forms-->
<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-back-button defaultHref="/tabs/memories"></ion-back-button>
        </ion-buttons>
        <ion-title>Add a Memory</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content>
      <form class="ion-padding" @submit.prevent="submitForm">
        <ion-list>
          <ion-item>
            <ion-label position="floating">Title</ion-label>
            <ion-input type="text" required v-model="enteredTitle" />
          </ion-item>
          <ion-item>
            <ion-thumbnail slot="start">
              <img :src="takenImageUrl" />
            </ion-thumbnail>
            <ion-button type="button" fill="clear" @click="takePhoto">
              <ion-icon :icon="cameraIcon"></ion-icon>
              Take Photo
            </ion-button>
          </ion-item>

          <ion-item>
            <ion-textarea aria-label="Description" :rows="5" v-model="enteredDescription">Memory Description</ion-textarea>
          </ion-item>

        </ion-list>
        <ion-button type="submit" expand="block">Save</ion-button>
      </form>
    </ion-content>
  </ion-page>
</template>

<script lang="ts">
import { ref, defineComponent } from 'vue';
import {
  IonPage,
  IonHeader,
  IonContent,
  IonToolbar,
  IonList,
  IonItem,
  IonInput,
  IonTextarea,
  IonButton,
  IonThumbnail,
  useIonRouter,
} from "@ionic/vue";
import { camera as cameraIcon } from 'ionicons/icons';
import { CameraResultType, CameraSource, Camera } from '@capacitor/camera';
import { IonBackButton } from '@ionic/vue';

export default defineComponent({
  emits: ["save-memory"],
  components: {
    IonList,
    IonItem,
    IonInput,
    IonTextarea,
    IonButton,
    IonBackButton,
    IonThumbnail,
  },
  setup() {
    const ionRouter = useIonRouter();
    const enteredTitle = ref('');
    const enteredDescription = ref('');
    const takenImageUrl = ref('');

    const takePhoto = async () => {
      const photo = await Camera.getPhoto({
        resultType: CameraResultType.Uri,
        source: CameraSource.Camera,
        quality: 60
      });
      takenImageUrl.value = photo.webPath ?? "";
    };

    const submitForm = () => {
      const memoryData = {
        title: enteredTitle.value,
        imageUrl: takenImageUrl.value,
        description: enteredDescription.value,
      };
      // Logik zum Speichern des Memory könnte hier implementiert werden
      ionRouter.replace('/tabs/memories');
    };

    return {
      takePhoto,
      submitForm,
      enteredTitle,
      enteredDescription,
      takenImageUrl,
      cameraIcon
    };
  }
});

</script>
