<!--Zeigt Details einer Erinnerung an, die durch ID spezifiziert wurde-->
<template>
  <base-layout
    :page-title="loadedMemory ? loadedMemory.title : 'Loading...'"
    page-default-back-link="tabs/memories"
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
import MemoryOverview from "../components/memories/MemoryOverview.vue";
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const memoryId = ref<string | null>(null); // memoryId als Ref<string | null> deklariert

// Annahme: Die Memories werden in LocalStorage gespeichert
const loadedMemory = ref(JSON.parse(localStorage.getItem('memories') || '[]').find((memory: any) => memory.id === memoryId.value));

// Um das Memory basierend auf der ID in der Route zu laden
router.beforeEach((to, from, next) => {
  memoryId.value = Array.isArray(to.params.id) ? null : to.params.id; // Überprüfung auf Array
  next();
});
</script>