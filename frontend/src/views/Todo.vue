<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Todos</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Todos</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-list>
        <ion-item :key="todo.id" v-for="todo in todos">
          <ion-grid>
            <ion-row>
              <ion-col>
                {{ todo.title }}
              </ion-col>
              <ion-col>
                <ion-button color="danger" v-if="!todo.done && !todo.archived"
                  @click="finishTodo(todo)">Finish</ion-button>
                <ion-button color="success" v-if="todo.done && !todo.archived"
                  @click="archiveTodo(todo)">Archive</ion-button>
              </ion-col>
            </ion-row>
          </ion-grid>
        </ion-item>
      </ion-list>
      <ion-item>
        <ion-input type="text" placeholder="New Todo Title" v-model="newTodo.title"></ion-input>
      </ion-item>
      <div padding>
        <ion-button @click="addTodo()">Add New ToDo</ion-button>
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
  IonCol,
  IonRow,
  IonGrid,
  IonItem,
  IonList,
  IonButton,
  IonInput,
} from "@ionic/vue";
import { useTodos } from "../composables/useTodos";

const { newTodo, todos, getTodos, addTodo, finishTodo, archiveTodo } = useTodos();

</script>

<style>
/* Star Wars-Theme Anpassungen */
:root {
    --ion-color-primary: #000; /* Schwarz */
    --ion-color-secondary: #ffe81f; /* Gold */
    --ion-color-tertiary: #d0d0d0; /* Grau */
}

ion-title, ion-label, ion-button {
    color: #ffe81f;
}


ion-item[color="light"] {
    --background: rgba(0, 0, 0, 0.8);
    --color: #ffe81f;
    border: 1px solid #ffe81f;
}
</style>