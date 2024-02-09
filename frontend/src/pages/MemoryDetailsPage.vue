<!--Zeigt Details einer Erinnerung an, die durch ID spezifiziert wurde-->
<template>
  <base-layout
    :page-title="loadedMemory ? loadedMemory.title : 'Loading...'"
    page-default-back-link="/tabs/memories"
  >
    <h2 v-if="!loadedMemory">Could not find a memory for the given id.</h2>
    <memory-overview 
      v-else 
      :title="loadedMemory.title" 
      :image="loadedMemory.image" 
      :description="loadedMemory.description"></memory-overview>
  </base-layout>
</template>

<script setup lang="ts">
import { ref, watch } from 'vue';
import { useRoute } from 'vue-router';
import MemoryOverview from '../components/memories/MemoryOverview.vue';

interface Memory {
  id: string;
  title: string;
  image: string;
  description: string;
}

const route = useRoute();
const loadedMemory = ref<Memory | null>(null);

console.log("Komponente initialisiert. Beobachte Route-Änderungen...");

// Funktion zum Laden des Memory-Objekts
function loadMemory(id: string | string[]) {
  console.log(`Lade Memory mit ID: ${id}`);
  const memories: Memory[] = JSON.parse(localStorage.getItem('memories') || '[]');
  const memoryId = Array.isArray(id) ? id[0] : id; // Unterstützung für den Fall, dass id ein Array ist
  console.log(`Verwende Memory-ID: ${memoryId} für die Suche`);
  const memory = memories.find((m) => m.id === memoryId);
  if (memory) {
    console.log(`Gefundenes Memory:`, memory);
  } else {
    console.log("Kein Memory mit der gegebenen ID gefunden.");
  }
  loadedMemory.value = memory || null;
}
// Reagiere auf Änderungen der Route-Parameter
watch(() => route.params.id, (newId) => {
  console.log(`Route-Parameter geändert: ${newId}`);
  if (typeof newId === 'string' || Array.isArray(newId)) {
    console.log("Aufruf von loadMemory mit neuer ID.");
    loadMemory(newId);
  } else {
    console.log("Neue ID ist nicht gültig.");
  }
}, { immediate: true });
</script>