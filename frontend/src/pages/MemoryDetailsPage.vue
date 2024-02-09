<!--Zeigt Details einer Erinnerung an, die durch ID spezifiziert wurde-->
<template>
  <base-layout
    :page-title="loadedMemory ? loadedMemory.title : 'Loading...'"
    page-default-back-link="/tabs/memories"
    label="Memory Details"
  >
    <h2 v-if="!loadedMemory" aria-label="Memory not found">Could not find a memory for the given id.</h2>
    <memory-overview 
      v-else 
      :title="loadedMemory.title" 
      :image="loadedMemory.image" 
      :description="loadedMemory.description"
      label="Memory Overview"
    ></memory-overview>
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

console.log("Component initialized. Watching for route changes...");

// Function to load the memory object
function loadMemory(id: string | string[]) {
  console.log(`Loading memory with ID: ${id}`);
  const memories: Memory[] = JSON.parse(localStorage.getItem('memories') || '[]');
  const memoryId = Array.isArray(id) ? id[0] : id; // Support for the case when id is an array
  console.log(`Using memory ID: ${memoryId} for search`);
  const memory = memories.find((m) => m.id === memoryId);
  if (memory) {
    console.log(`Found memory:`, memory);
  } else {
    console.log("No memory found with the given ID.");
  }
  loadedMemory.value = memory || null;
}
// React to changes in route parameters
watch(() => route.params.id, (newId) => {
  console.log(`Route parameter changed: ${newId}`);
  if (typeof newId === 'string' || Array.isArray(newId)) {
    console.log("Calling loadMemory with new ID.");
    loadMemory(newId);
  } else {
    console.log("New ID is not valid.");
  }
}, { immediate: true });
</script>
