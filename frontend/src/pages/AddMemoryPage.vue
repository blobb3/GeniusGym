<!--Importiert die Komponente CreateMemoryForm und dient als dereen Vorlage-->
<template>
  <base-layout page-title="Add a Memory" page-default-back-link="tabs/memories">
    <create-memory-form @save-memory="saveMemory"></create-memory-form>
  </base-layout>
</template>

<script setup lang="ts">
import CreateMemoryForm from "../components/memories/CreateMemoryForm.vue";
import { useIonRouter } from '@ionic/vue'; // Korrekter Import

const ionRouter = useIonRouter(); // Verwende ionRouter als Variablennamen

const saveMemory = (memoryData: { title: string, imageUrl: string, description: string }) => {
  const newMemory = {
    id: Math.random(), // Beispiel für eine zufällige ID, anpassen wie nötig
    ...memoryData
  };

  // Speichern des neuen Memory in einer lokalen Liste
  const memories = JSON.parse(localStorage.getItem('memories') || '[]');
  memories.push(newMemory);
  localStorage.setItem('memories', JSON.stringify(memories));

  // Navigieren zurück zur Memories-Seite mit useIonRouter
  ionRouter.replace('/tabs/memories');
};
</script>
