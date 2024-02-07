// composables/useDailyQuote.js
export function useDailyQuote() {
    const quotes = [
        "Zähle die Tage, nicht die Sterne – Training führt zur Meisterschaft.",
        "Möge die Macht mit dir sein... besonders im Fitnessstudio.",
        "Ich finde deinen Mangel an Schweiß beklagenswert.",
        "Ich liebe den Geruch von geschmolzenem Plasma am Morgen... und den Geruch von frischem Schweiß.",
        "Straßen? Wo wir hingehen, brauchen wir keine... Straßen, nur Laufbänder.",
        "Wenn dich jemand fragt, ob du ein Gott bist, dann sagst du: JA! Nach meinem Workout fühle ich mich so.",
        "Die Zukunft ist noch nicht geschrieben. Sie ist, was du daraus machst. Also mach was Gutes draus – beginnend im Fitnessstudio!",
        "Das ist kein Mond. Das ist eine Muskelkugel.",
        "Training ist wie das Hacken einer Software: Es geht um das Brechen von Grenzen.",
        "Lebe lang und in bester Verfassung.",
        "Nicht alle Helden tragen Umhänge, einige tragen Gym-Shirts.",
        "Sei wie ein Superheld – das Workout ist deine Verwandlungskabine.",
        "Auch ein Jedi-Meister muss sein Training absolvieren. Lichtschwert-Lifte, irgendjemand?",
        "In der Welt des Trainings gilt: 'Widerstand ist zwecklos.' – besonders beim Gewichtheben.",
        "Erinnere dich, meine junge Padawan: Ein großes Gewicht führt zu großen Gewinnen.",
        "Gym's Log, Sternendatum 2024. Meine Mission: die letzte Grenze der Fitness zu erforschen.",
        "Für jeden Kilometer, den du läufst, bekommt ein Stormtrooper seinen Treffer. Lauf für die Rebellion!",
        "Dein Wille ist stärker als Mithril. Benutze ihn, um deine Fitnessziele zu schmieden."
    ];

    // Zufälliges Zitat auswählen
    const randomIndex = Math.floor(Math.random() * quotes.length);
    const dailyQuote = quotes[randomIndex];

    return { dailyQuote };
}
