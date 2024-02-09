/*Stellt Struktur bereit, um Erinnerungen zu verwalten*/

// composables/useMemories.ts
import { ref } from 'vue';

interface Memory {
  id: string;
  title: string;
  description: string;
}

const memories = ref<Memory[]>([]);

// Beispiel Funktion zum Hinzufügen einer Memory (weitere Funktionen nach Bedarf)
function addMemory(memory: Memory) {
  memories.value.push(memory);
}

async function loadMemories() {
  try {
    // Simulieren Sie hier den API-Aufruf, um die Erinnerungen zu laden
    const response = await fetch('https://api.example.com/memories');
    
    if (!response.ok) {
      throw new Error('Failed to load memories');
    }

    // Extrahiere die geladenen Daten als JSON
    const data = await response.json();

    // Setze die geladenen Erinnerungen in die memories-Variable
    memories.value = data;
  } catch (error) {
    console.error('Error loading memories:', error);
  }
}

// Beispiel Funktion zum Laden der Memories, könnte API Aufruf sein
 /* function loadMemories() {
  // Hier API-Aufruf simulieren oder lokale Daten laden
  memories.value = [
    // Beispiel Memories
    { id: '1', title: 'Memory 1', description: 'Description 1' },
    { id: '2', title: 'Memory 2', description: 'Description 2' },
  ];
}

export function useMemories() {
  return {
    memories,
    addMemory,
    loadMemories
  };
} */