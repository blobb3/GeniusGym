<template>
  <ion-page>
    <ion-header class="ion-header-flex">
      <TheFooter />
      <ion-toolbar>
        <ion-title class="ion-padding">Gym-Goals</ion-title>
        <p class="ion-padding">{{ dailyQuote }}</p>
        <ion-buttons slot="end">
          <ion-button @click="navigateToAddMemory" class="ion-padding">
            <ion-icon :icon="addIcon"></ion-icon>
          </ion-button>
        </ion-buttons>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true" class="ion-padding">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Goals</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-list>
        <ion-item :key="todo.id" v-for="todo in todos" class="todo-item">
          <ion-grid>
            <ion-row>
              <ion-col size="8">
                <h2>{{ todo.title }}</h2>
                <p v-if="todo.imageUrl">Bild vorhanden</p>
              </ion-col>
              <ion-col size="4" class="action-buttons">
                <ion-button color="warning" v-if="!todo.done && !todo.archived" @click="finishTodo(todo)">Erledigt</ion-button>
                <ion-button color="success" v-if="todo.done && !todo.archived" @click="archiveTodo(todo)">Archivieren</ion-button>
              </ion-col>
            </ion-row>
          </ion-grid>
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
  IonCol,
  IonRow,
  IonGrid,
  IonItem,
  IonList,
  IonButton,
  IonInput,
  useIonRouter,
} from "@ionic/vue";

import { useTodos } from "../composables/useTodos";
import { add } from 'ionicons/icons';
import { useDailyQuote } from '@/composables/useDailyQuote';
import TheFooter from '@/components/TheFooter.vue';

const { dailyQuote } = useDailyQuote();
const { newTodo, todos, getTodos, addTodo, finishTodo, archiveTodo } = useTodos();
const addIcon = add;

const router = useIonRouter();
const navigateToAddMemory = () => {
  router.push('/addmemory');
};

</script>

<style scoped>
/* Star Wars-Theme Anpassungen weiter verwenden */
:root {
  --ion-color-primary: #000; /* Schwarz */
  --ion-color-secondary: #ffe81f; /* Gold */
  --ion-color-tertiary: #d0d0d0; /* Grau */
}

ion-title,
ion-label,
ion-button {
  color: #ffe81f;
}

ion-item[color="light"] {
  --background: rgba(0, 0, 0, 0.8);
  --color: #ffe81f;
  border: 1px solid #ffe81f;
}

/* Zusätzliche Stil-Anpassungen für die Gym-Memories Liste */
.todo-item {
  --background: #1c1c1c;
  --border-radius: 8px;
  margin-bottom: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

h2 {
  color: #ffe81f;
  font-size: 1.2rem;
}

.action-buttons ion-button {
  margin-top: 10px;
}

.ion-header-flex {
  display: flex;
  justify-content: center; /* Zentriert die Inhalte horizontal */
  align-items: center; /* Zentriert die Inhalte vertikal */
  flex-direction: column; /* Stapelt die Kinder vertikal */
  text-align: center; /* Zentriert den Text der direkten Kinder */
}

/* Leichte Animation beim Hovern über die Liste */
ion-item:hover {
  transform: translateY(-3px);
  box-shadow: 0 6px 6px rgba(0, 0, 0, 0.2);
  transition: transform 0.2s ease, box-shadow 0.2s ease;
}

/* Zurücksetzen der Transformation beim Mouseout */
ion-item {
  transition: transform 0.2s ease, box-shadow 0.2s ease;
}

/* Pulsierender Effekt für die Buttons XD*/
@keyframes pulse {
  0% {
    transform: scale(1);
  }
  50% {
    transform: scale(1.05);
  }
  100% {
    transform: scale(1);
  }
}

.action-buttons ion-button {
  animation: pulse 1.5s infinite;
}

/* Fixierter Header mit höherem Z-Index */
ion-header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 1; /* Stellen Sie sicher, dass der Header über anderen Elementen liegt */
  background-color:black; /* Schwarzer Hintergrund */
}

/* Abstand für den Content, damit dieser nicht unter dem Header beginnt */
.ion-content {
  padding-top: 56px; /* Höhe des Headers */
}

/* Header-Inhalte */
.ion-header-flex {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  text-align: center;
}

.ion-header-flex {
  padding: 1rem 0; /* Etwas Raum oben und unten */
}

</style>
