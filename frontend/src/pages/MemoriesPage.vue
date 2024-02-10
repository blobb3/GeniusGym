<template>
  <ion-page >
    <ion-header class="ion-header-flex">
      <ion-toolbar>
        <TheFooter />
        <ion-title class="ion-padding">All Gym-Memories</ion-title>
        <ion-buttons slot="end">
          <ion-button @click="goToAddMemoryPage" aria-label="Add Memory">
            <ion-icon :icon="addIcon"></ion-icon>
          </ion-button>
        </ion-buttons>
        <p class="ion-padding">{{ dailyQuote }}</p>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-list :inset="true">
        <ion-item v-for="memory in memories" :key="memory.id" @click="viewMemoryDetails(memory.id)">
          {{ memory.title }}
          <ion-icon :icon="trashIcon" slot="end" @click.stop="deleteMemory(memory.id)" aria-label="Delete Memory"></ion-icon>
        </ion-item>
      </ion-list>
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
  IonList,
  IonItem,
  IonButton,
  IonButtons,
  IonIcon,
  useIonRouter,
} from '@ionic/vue';
import { add , trash} from 'ionicons/icons';
import { ref, onMounted } from 'vue';
import TheFooter from '@/components/TheFooter.vue';
import { useDailyQuote } from '@/composables/useDailyQuote';

const { dailyQuote } = useDailyQuote();
const ionRouter = useIonRouter();
const addIcon = add;
const memories = ref(JSON.parse(localStorage.getItem('memories') || '[]'));
const trashIcon = trash;

const viewMemoryDetails = (memoryId: string) => {
  console.log(`Navigiere zu den Details der Erinnerung mit der ID: ${memoryId}`);
  ionRouter.push(`/tabs/memories/${memoryId}`);
};

const goToAddMemoryPage = () => {
  console.log("Navigiere zur Seite zum Hinzufügen einer Erinnerung");
  ionRouter.push('/memories/add');
};

const deleteMemory = (memoryId: string) => {
  console.log(`Lösche Erinnerung mit der ID: ${memoryId}`);
  const index = memories.value.findIndex((memory: { id: string; }) => memory.id === memoryId);
  if (index !== -1) {
    memories.value.splice(index, 1);
    localStorage.setItem('memories', JSON.stringify(memories.value));
  } else {
    console.log("Keine Erinnerung mit dieser ID gefunden.");
  }
};

onMounted(() => {
  console.log("Komponente geladen. Geladene Erinnerungen: ", memories.value);
  memories.value = JSON.parse(localStorage.getItem('memories') || '[]');
});
</script>

<style scoped>
/* Star Wars-Theme Farben */
:root {
    --ion-color-primary: #000; /* Schwarz für den Hintergrund */
    --ion-color-secondary: #ffe81f; /* Gold für wichtige Elemente */
    --ion-color-tertiary: #d0d0d0; /* Grau für Nebenelemente */
}

ion-title,
ion-item {
    color: #ffe81f;
}

ion-item {
    --background: rgba(0, 0, 0, 0.8);
    border: 1px solid #ffe81f;
}

.ion-header-flex {
  display: flex;
  justify-content: center; /* Zentriert die Inhalte horizontal */
  align-items: center; /* Zentriert die Inhalte vertikal */
  flex-direction: column; /* Stapelt die Kinder vertikal */
  text-align: center; /* Zentriert den Text der direkten Kinder */
}

/* Media Query für Responsive Design */
@media (min-width: 768px) {
  .ion-header-flex {
    flex-direction: row; /* Ändert die Richtung auf horizontal für größere Bildschirme */
  }

  .ion-header-flex ion-title {
    margin-right: auto; /* Verschiebt den Titel ganz nach links für größere Bildschirme */
  }

  .ion-header-flex ion-buttons {
    margin-left: auto; /* Verschiebt die Schaltflächen ganz nach rechts für größere Bildschirme */
  }
}
</style>
