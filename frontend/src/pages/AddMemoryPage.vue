<!--Importiert die Komponente CreateMemoryForm und dient als dereen Vorlage-->
<template>
  <base-layout page-title="Add a Memory" page-default-back-link="tabs/memories">
    <create-memory-form @save-memory="saveMemory"></create-memory-form>
  </base-layout>
</template>

<script setup lang="ts">
import CreateMemoryForm from "../components/memories/CreateMemoryForm.vue";
import { useIonRouter } from '@ionic/vue'; 

const ionRouter = useIonRouter();

const saveMemory = (memoryData: { title: string, imageUrl: string, description: string }) => {
  console.log("Speichern der Erinnerung gestartet", memoryData); 

  const newMemory = {
    id: Math.random().toString(), // Sicherstellen, dass die ID ein String ist
    ...memoryData
  };
  console.log("Neue Erinnerung erstellt", newMemory);

  // Speichern des neuen Memory in einer lokalen Liste
  const memories = JSON.parse(localStorage.getItem('memories') || '[]');
  memories.push(newMemory);
  localStorage.setItem('memories', JSON.stringify(memories));

  console.log("Erinnerung gespeichert", memories);

  // Navigieren zurück zur Memories-Seite mit useIonRouter
  ionRouter.replace('/tabs/memories');
  console.log("Navigation zurück zu den Erinnerungen");
};
</script>

