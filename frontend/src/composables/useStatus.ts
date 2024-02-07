import { getStatus, addStatus, updateStatus } from '@/api/status';
import { Status } from '@/model/status';
import { onMounted, ref } from 'vue';

export function useStatus() {
    // Eine reaktive Referenz für das Statusobjekt, initial null
    const status = ref<Status | null>(null);

    // Ruft die aktuellen Statusdaten von der API ab und aktualisiert die `status`-Referenz
    const getStatusData = async () => {
        try {
            // API-Aufruf, um Statusdaten zu holen
            status.value = await getStatus();
        } catch (error) {
            // Fehlerbehandlung, falls der API-Aufruf fehlschlägt
            console.error('Fehler beim Abrufen der Statusdaten:', error);
        }
    };

    // Nimmt ein aktualisiertes Statusobjekt entgegen und sendet es zur Aktualisierung an die API
    const updateStatusData = async (updatedStatus: Status) => {
        try {
            // API-Aufruf, um den Status zu aktualisieren
            await updateStatus(updatedStatus);
            // Nach erfolgreicher Aktualisierung die lokalen Statusdaten erneut abrufen
            await getStatusData();
        } catch (error) {
            // Fehlerbehandlung, falls der API-Aufruf fehlschlägt
            console.error('Fehler beim Aktualisieren der Statusdaten:', error);
        }
    };

    // Fügt neue Statusdaten hinzu und aktualisiert anschließend die lokale Kopie
    const addNewStatus = async (newStatus: Status) => {
        try {
            // API-Aufruf, um neuen Status hinzuzufügen
            await addStatus(newStatus);
            // Nach dem Hinzufügen die lokalen Statusdaten aktualisieren
            await getStatusData();
        } catch (error) {
            // Fehlerbehandlung, falls der API-Aufruf fehlschlägt
            console.error('Fehler beim Hinzufügen neuer Statusdaten:', error);
        }
    };

    // Lifecycle-Hook, der beim Einhängen der Komponente aufgerufen wird
    // Ruft initial die Statusdaten ab
    onMounted(getStatusData);

    // Exponiert die reaktive Referenz und Funktionen für die Verwendung in Komponenten
    return {
        status,
        getStatusData,
        updateStatusData,
        addNewStatus
    };
}
