<!--Sieht man auf MemoriesPaage.vue - Darstellung in Tabelle-->
<!--Ermöglicht es User  auf Detailsseite zu navigieren, wenn angeklcikt-->
<template>
  <ion-item :router-link="`/memories/${memory.id}`">
    <ion-thumbnail slot="start">
      <ion-img :src="memory.image" :alt="memory.title"></ion-img>
    </ion-thumbnail>
    <ion-label label="Titel">{{ memory.title }}</ion-label>
  </ion-item>
</template>

<script lang="ts">
import { IonItem, IonThumbnail, IonImg, IonLabel, IonIcon } from "@ionic/vue";
import { onMounted } from "vue";

export default {
  props: ["memory"],
  components: {
    IonItem,
    IonThumbnail,
    IonImg,
    IonLabel,
    IonIcon,
  },
  setup(props) {
    onMounted(() => {
      console.log("Memory-Objekt beim Mounten der Komponente:", props.memory);
    });
  },
};
</script>
