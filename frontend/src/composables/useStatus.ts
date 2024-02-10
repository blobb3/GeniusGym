import { ref, onMounted } from 'vue';
import { getStatus, addStatus, updateStatus } from '@/api/status';
import { Status } from '@/model/status';

export function useStatus() {
    const status = ref<Status | null>(null);

    // Ruft die aktuellen Statusdaten von der API ab
    const getStatusData = async () => {
        try {
            const fetchedStatus = await getStatus();
            status.value = fetchedStatus;
        } catch (error) {
            console.error('Fehler beim Abrufen der Statusdaten:', error);
        }
    };

    // Aktualisiert ein Statusobjekt über die API
    const updateStatusData = async (updatedStatus: Status) => {
        try {
            await updateStatus(updatedStatus);
            await getStatusData(); // Aktualisiere den lokalen Status nach dem API-Aufruf
        } catch (error) {
            console.error('Fehler beim Aktualisieren der Statusdaten:', error);
        }
    };

    // Fügt neue Statusdaten hinzu
    const addNewStatus = async (newStatus: Status) => {
        try {
            await addStatus(newStatus);
            await getStatusData(); // Aktualisiere den lokalen Status nach dem Hinzufügen
        } catch (error) {
            console.error('Fehler beim Hinzufügen neuer Statusdaten:', error);
        }
    };

    // Abrufen der Statusdaten beim Einhängen der Komponente
    onMounted(getStatusData);

    return {
        status,
        getStatusData,
        updateStatusData,
        addNewStatus
    };
}
