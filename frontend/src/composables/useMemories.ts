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
  console.log("Hinzufügen einer Erinnerung gestartet", memory);
  memories.value.push(memory);
  console.log("Erinnerung hinzugefügt", memories.value);
}

async function loadMemories() {
  console.log("Laden der Erinnerungen gestartet");
  try {
    // Simuliere API-Aufruf, um die Erinnerungen zu laden
    const response = await fetch('https://api.example.com/memories');
    
    if (!response.ok) {
      throw new Error('Failed to load memories');
    }

    // Extrahiere die geladenen Daten als JSON
    const data = await response.json();
    console.log("Erinnerungen geladen", data);

    // Setze die geladenen Erinnerungen in die memories-Variable
    memories.value = data;
    console.log("Aktualisierte Erinnerungsliste", memories.value);
  } catch (error) {
    console.error('Error loading memories:', error);
  }
}

/* Die folgende auskommentierte Funktion ist eine Alternative zum Laden von Memories,
   wenn = >statische Liste  oder zum Testen ohne API-Anbindung */
/*
function loadMemories() {
  console.log("Laden der statischen Erinnerungen gestartet");
  memories.value = [
    // Beispiel Memories
    { id: '1', title: 'Memory 1', description: 'Description 1' },
    { id: '2', title: 'Memory 2', description: 'Description 2' },
  ];
  console.log("Statische Erinnerungen geladen", memories.value);
}
*/

export function useMemories() {
  console.log("useMemories Composable wird verwendet");
  return {
    memories,
    addMemory,
    loadMemories
  };
}