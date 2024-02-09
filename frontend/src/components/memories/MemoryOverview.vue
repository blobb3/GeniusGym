<!--Darstellung der Details einer Erinnerung (Bild, Titel, Description)-->
<template>
  <ion-img :src="image" :alt="title"></ion-img>
  <ion-label label="Titel" class="ion-text-center">{{ title }}</ion-label>
  <ion-label label="Beschreibung" class="ion-text-center">{{ description }}</ion-label>
</template>

<script lang="ts">
import { IonImg, IonLabel, IonIcon } from '@ionic/vue';
import { onMounted } from 'vue';

export default {
  props: ['title', 'image', 'description'],
  components: {
    IonImg,
    IonLabel,
    IonIcon,
  },
  setup(props) {
    onMounted(() => {
      console.log("Komponente geladen mit Titel:", props.title);
      console.log("Bild-URL:", props.image);
      console.log("Beschreibung:", props.description);
    });
  }
}
</script>
