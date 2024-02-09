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
      <div class="container">
        <form class="ion-padding" @submit.prevent="submitForm">
          <ion-list>
            <ion-item>
              <ion-label position="floating">Erinnerungstitel</ion-label>
              <ion-input type="text" required v-model="enteredTitle" />
            </ion-item>
            <ion-item>
              <ion-thumbnail slot="start">
                <img :src="takenImageUrl" />
              </ion-thumbnail>
              <ion-button type="button" fill="clear" @click="takePhoto">
                <ion-icon :icon="cameraIcon"></ion-icon>
                Lade Fotos
              </ion-button>
            </ion-item>
            <ion-item>
              <ion-label position="floating">Beschreibung</ion-label>
              <ion-textarea :rows="5" v-model="enteredDescription"></ion-textarea>
            </ion-item>
          </ion-list>
          <ion-button type="submit" expand="block" class="butti">Save</ion-button>
        </form>
      </div>
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
    console.log("Setup-Funktion gestartet");
    const ionRouter = useIonRouter();
    const enteredTitle = ref('');
    const enteredDescription = ref('');
    const takenImageUrl = ref('');

    const takePhoto = async () => {
      console.log("takePhoto aufgerufen");
      try {
        const photo = await Camera.getPhoto({
          resultType: CameraResultType.Uri,
          source: CameraSource.Camera,
          quality: 60
        });
        console.log("Foto aufgenommen:", photo); 
        takenImageUrl.value = photo.webPath ?? "";
      } catch (error) {
        console.error("Fehler beim Aufnehmen des Fotos:", error);
      }
    };


    const submitForm = () => {
      console.log("submitForm aufgerufen");
      const memoryData = {
        title: enteredTitle.value,
        imageUrl: takenImageUrl.value,
        description: enteredDescription.value,
      };
      console.log("Memory Daten:", memoryData); 
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

<style scoped>
/* Stil für ion-item, um die Input-Felder zu umrahmen */
ion-item {
  --border-color: #ffe81f;
  /* Gelb für die Umrandung */
  --border-style: solid;
  --border-width: 2px;
  --border-radius: 10px;
  /* Ecken abrunden */
  margin-bottom: 15px;
  /* Fügt etwas Abstand zwischen den Feldern hinzu */
}


/* Stil für ion-button, um ihn kleiner zu machen und zu zentrieren */
.butti {
  --padding-start: 14px;
  /* Kleiner Padding für den Button */
  --padding-end: 14px;
  /* Kleiner Padding für den Button */
  --padding-top: 8px;
  /* Kleiner Padding für den Button */
  --padding-bottom: 8px;
  /* Kleiner Padding für den Button */
  margin: 0 auto;
  /* Zentriert den Button horizontal */
  display: block;
  /* Ermöglicht das Zentrieren mit margin */
  width: auto;
  /* Setzt die Breite auf den Inhalt des Buttons */
  max-width: 200px;
  /* Maximale Breite des Buttons */
  --background: linear-gradient(45deg, #691a67, #ffe81f);
  /* Gelbe Hintergrundfarbe */
}

.container {
  display: flex;
  justify-content: center;
}
</style>
