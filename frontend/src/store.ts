import { reactive, readonly, provide, inject } from 'vue';

interface State {
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

const methods: Methods = {
  addPointsToOberkoerper(points: number) {
    state.oberkoerperPunkte += points;
  },
  addPointsToUnterkoerper(points: number) {
    state.unterkoerperPunkte += points;
  }
};

export function useStore() {
  provide('state', readonly(state));
  provide('methods', methods);
}

export function useState() {
  const state = inject<State>('state');
  if (!state) throw new Error('useState must be used within useStore');
  return state;
}

export function useMethods() {
  const methods = inject<Methods>('methods');
  if (!methods) throw new Error('useMethods must be used within useStore');
  return methods;
}
