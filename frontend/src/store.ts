import { reactive, readonly, provide, inject, computed } from 'vue';

export interface State {
  oberkoerperPunkte: number;
  unterkoerperPunkte: number;
}

const state: State = reactive({
  oberkoerperPunkte: 0,
  unterkoerperPunkte: 0
});

interface Methods {
  addPointsToOberkoerper: (points: number) => void;
  addPointsToUnterkoerper: (points: number) => void;
}

// Methode zur Zustandsmanipulation (können Punkte hinzufügen, indem sie den reatkiven zustand manipulieren)
const methods: Methods = {
  addPointsToOberkoerper(points: number) {
    state.oberkoerperPunkte += points;
  },
  addPointsToUnterkoerper(points: number) {
    state.unterkoerperPunkte += points;
  }
};

// stellt Zustand/Methoden für andere Kompontenten bereit
export function useStore() {
  provide('state', readonly(state));
  provide('methods', methods);
}

// Zugriff auf den Zustand/Methoden 
export function useState() {
  const state = inject<State>('state');
  if (!state) throw new Error('useState must be used within useStore');
  
  // Erstellen von reaktiven Referenzen für jeden Zustand
  const oberkoerperPunkte = computed(() => state.oberkoerperPunkte);
  const unterkoerperPunkte = computed(() => state.unterkoerperPunkte);

  // Rückgabe der reaktiven Referenzen
  return { oberkoerperPunkte, unterkoerperPunkte };
}

export function useMethods() {
  const methods = inject<Methods>('methods');
  if (!methods) throw new Error('useMethods must be used within useStore');
  return methods;
}
