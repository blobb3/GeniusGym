export interface Status {
    id?: number;
    groesse?: number;
    gewicht?: number;
    name?: string;
    punkte?: number;
    level?: Level; // Verwenden Sie das Level Enum statt number
    datum?: string; // JavaScript/TypeScript verwendet ISO Strings für Daten
}


export enum Level {
ANFAENGER = "Anfänger",
SPORTLER = "Sportler",
EXPERTE = "Experte",
}
