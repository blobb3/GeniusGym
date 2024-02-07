import axios from 'axios';
import { API_ROOT } from "@/config/development";
import { Status } from '@/model/status';

// Ruft Statusdaten vom API ab
export async function getStatus(): Promise<Status> {
    const config = {
        withCredentials: true
    };
    try {
        const response = await axios.get(`${API_ROOT}/api/status`, config);
        return response.data;
    } catch (error) {
        console.error('Fehler beim Abrufen der Statusdaten:', error);
        throw error; // Es ist besser, den Fehler zu werfen, damit er von der aufrufenden Komponente behandelt werden kann.
    }
}

// Fügt neue Statusdaten zur API hinzu
export async function addStatus(newStatus: Status): Promise<Status> {
    const config = {
        withCredentials: true
    };
    try {
        const response = await axios.post(`${API_ROOT}/api/status`, newStatus, config);
        return response.data;
    } catch (error) {
        console.error('Fehler beim Hinzufügen der Statusdaten:', error);
        throw error;
    }
}

// Aktualisiert vorhandene Statusdaten
export async function updateStatus(status: Status): Promise<Status> {
    const config = {
        withCredentials: true
    };
    try {
        const response = await axios.put(`${API_ROOT}/api/status`, status, config);
        return response.data;
    } catch (error) {
        console.error('Fehler beim Aktualisieren der Statusdaten:', error);
        throw error;
    }
}
