<!--Sieht man auf MemoriesPaage.vue - Darstellung in Tabelle-->
<!--Ermöglicht es User  auf Detailsseite zu navigieren, wenn angeklcikt-->
<template>
  <ion-item :router-link="`/memories/${memory.id}`">
    <ion-thumbnail slot="start">
      <ion-img :src="memory.image" :alt="memory.title"></ion-img>
    </ion-thumbnail>
    <ion-label>
      {{ memory.title }}
    </ion-label>
  </ion-item>
</template>

<script lang = "ts">
import { IonItem, IonThumbnail, IonImg, IonLabel } from "@ionic/vue";

export default {
  props: ["memory"],
  components: {
    IonItem,
    IonThumbnail,
    IonImg,
    IonLabel,
  },
};
</script>