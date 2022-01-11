$(document).ready(function() {
    /*const navfilter = document.querySelectorAll('.nav-filter');*/
    const filtertoggle = document.querySelectorAll('.f-toggle').forEach(
      el => el.onclick = function() {
        el.parentElement.classList.toggle('active')
      }
    );
    const caret = document.querySelector('.fa-caret-down');
    const filter = document.querySelector('.filter');
    caret.onclick = function() {
        filter.classList.toggle('active');
    }

});
