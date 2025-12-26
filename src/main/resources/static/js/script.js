document.addEventListener('DOMContentLoaded', function() {

    const click = document.getElementById('click');
    let contador = document.getElementById('contador');
    let reset = document.getElementById('reset');
    let entrar = document.getElementById('entrar');
    let volver = document.getElementById('volver');



});

// script.js
const role = document.querySelector('.role');
let lastScroll = 0;

window.addEventListener('scroll', () => {
  const currentScroll = window.pageYOffset || document.documentElement.scrollTop;

  if (currentScroll > lastScroll && currentScroll > 50) {
    // Scroll hacia abajo
    role.style.opacity = 1;
  } else if (currentScroll < lastScroll) {
    // Scroll hacia arriba
    role.style.opacity = 0;
  }

  lastScroll = currentScroll <= 0 ? 0 : currentScroll;
});


