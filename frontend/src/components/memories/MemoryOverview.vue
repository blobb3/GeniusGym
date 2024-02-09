<!--Darstellung der Details einer Erinnerung (Bild, Titel, Description)-->
<template>
  <ion-img :src="image" :alt="title"></ion-img>
  <h2 class="ion-text-center">{{ title }}</h2>
  <p class="ion-text-center">{{ description }}</p>
</template>

<script lang="ts">
import { IonImg } from '@ionic/vue';
import { onMounted } from 'vue';

export default {
  props: ['title', 'image', 'description'],
  components: {
    IonImg
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