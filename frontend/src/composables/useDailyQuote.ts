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
    "Hasta la vista, Baby! – verabschiede dich von deinen Grenzen und stärke deinen Körper wie der Terminator.",
    "Bist du nicht unterhalten? – sei wie Maximus und beeindrucke dich selbst mit deinem Training.",
    "Erinnere dich, meine junge Padawan: Ein großes Gewicht führt zu großen Gewinnen.",
    "Gym's Log, Sternendatum 2024. Meine Mission: die letzte Grenze der Fitness zu erforschen.",
    "Für jeden Kilometer, den du läufst, bekommt ein Stormtrooper seinen Treffer. Lauf für die Rebellion!",
    "Dein Wille ist stärker als Mithril. Benutze ihn, um deine Fitnessziele zu schmieden.",
    "Kraft ist stark in diesem einen, und das eine ist stark in der Macht – sei wie Yoda und stärke deinen Körper.",
    "Mit großer Macht kommt große Verantwortung – und auch ein großartiges Training.",
    "Fürchte dich nicht vor den dunklen Seiten deines Trainings – sie werden dich nur stärker machen",
    "Niemals untertreiben, immer übertreiben – sei wie Tony Stark und erfinde dein Training neu.",
    "Wenn das Gewichtheben einfach wäre, würde es Fußball heißen.",
    "Schwitz nicht den kleinen Dingen nach – sieh zu, wie sie auf dem Laufband bleiben.",
    "Das Fitnessstudio ist meine Schule, und die Hanteln sind meine Lehrer. Hoffentlich bekomme ich keine Nachhilfe.",
    "Laufen ist nur eine schnelle Möglichkeit, an einen anderen Ort zu gelangen, an dem man schwitzt.",
    "Im Training wie im Leben: 'Du musst lernen, dich selbst zu beherrschen.' – Meister Qui-Gon Jinn",
    "Die Kraft ist stark in diesem einen – möge das Training mit dir sein, junger Padawan.",
    "Nichts ist unmöglich für den, der eine entschlossene Geisteshaltung hat – also sei wie ein Jedi und meistere dein Training.",
    "Vergiss niemals, wer du bist – sei wie Simba und trainiere wie ein König des Fitnessdschungels.",
    "Dein Training ist wie ein Zaubertrank – mische die Zutaten mit Bedacht und werde zum Meister deiner eigenen Geschichte.",

    "Wenn das Training einfach wäre, würde es 'Schlafen' heißen. Aber wer will schon ein Nickerchen, wenn man ein Superheld sein kann?",
    "Ich kämpfe nicht gegen die Schwerkraft, ich nutze sie zu meinem Vorteil – durch Kniebeugen und Kreuzheben.",
  ];

  // Zufälliges Zitat auswählen
  const randomIndex = Math.floor(Math.random() * quotes.length);
  const dailyQuote = quotes[randomIndex];

  return { dailyQuote };
}
