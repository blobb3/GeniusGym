<!--Ist leider jetzt Teil des Headers-->
<template>
  <footer class="footer-container">
    <div class="footer-content">
      <img src="/logo.jpg" alt="Genius Gym Logo" class="logo-image"/>
      <!-- Weitere Footer-Inhalte hier -->
    </div>
  </footer>
</template>

<script>
export default {
  name: 'TheFooter'
}
</script>

<style scoped>
.footer-container {
  position: flex-direction; /* Fixiert den Footer am oberen Bildschirmrand */
  left: 0;
  top: 0; /* Setzt den Footer an den oberen Bildschirmrand */
  width: 100%; /* Der Footer sollte die volle Bildschirmbreite einnehmen */
  background-color: black; /* Hintergrundfarbe des Footers */
  z-index: 1000; /* Stellt sicher, dass der Footer über anderen Elementen liegt, höher als andere z-Index Werte */
  padding: 4rem 0; /* Fügt oben und unten im Footer einen Abstand hinzu */
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* Optional: Fügt einen Schatten unter dem Footer hinzu */
}

/* Hier bleiben die restlichen Stile unverändert */


.footer-content {
  display: flex;
  justify-content: center; /* Zentriert die Inhalte horizontal */
  align-items: center; /* Zentriert die Inhalte vertikal */
  flex-direction: column; /* Stapelt die Elemente vertikal */
  text-align: center;
}

.logo-image {
  width: 120px; /* Legt eine feste Breite für das Logo fest */
  height: auto; /* Sorgt dafür, dass das Verhältnis des Logos beibehalten wird */
  border-radius: 50%; /* Macht das Bild rund, wenn es quadratisch ist */
  margin: 0; /* Entfernt den Außenabstand */
  object-fit: cover; /* Stellt sicher, dass das Bild den verfügbaren Bereich ausfüllt, ohne verzerrt zu werden */
}

/* Media Queries für verschiedene Bildschirmgrößen */
@media (max-width: 767px) {
  /* Stile für kleine Bildschirme (Smartphones) */
  .footer-container {
    padding: 0.5rem 0; /* Reduziert den Abstand oben und unten im Footer für kleine Bildschirme */
  }

  .logo-image {
    width: 80px; /* Verkleinert das Logo für kleine Bildschirme */
  }
}

@media (min-width: 768px) {
  /* Stile für mittlere Bildschirme (Tablets) */
  .logo-image {
    width: 100px; /* Vergrößert das Logo leicht für Tablet-Bildschirme */
  }
}

@media (min-width: 992px) {
  /* Stile für große Bildschirme (Desktops) */
  .footer-container {
    padding: 1rem 0; /* Stellt den ursprünglichen Abstand oben und unten im Footer wieder her */
  }

  .logo-image {
    width: 120px; /* Stellt die ursprüngliche Größe des Logos wieder her */
  }
}

</style>