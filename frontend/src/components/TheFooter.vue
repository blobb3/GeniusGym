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
  display: flex;
  justify-content: center;
  align-items: center;
  left: 0;
  bottom: var(--ion-tab-bar-height); /* Passt den Footer an die Höhe der Tab-Bar an */
  width: 10%;
  z-index: 1; /* Stellt sicher, dass der Footer über der Tab-Leiste liegt */
}

.footer-content {
  text-align: center;
}

.logo-image {
  border-radius: 70px; 
  margin: 25px 25px; 
 
}
</style>