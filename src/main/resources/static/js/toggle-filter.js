$(document).ready(function() {
    document.querySelectorAll('.FilterName').forEach(
      el => el.onclick = function() {
        el.parentElement.classList.toggle('active')
      }
    );
});
