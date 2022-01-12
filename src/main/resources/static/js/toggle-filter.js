/*$(document).ready(function() {
    /!*const navfilter = document.querySelectorAll('.nav-filter');*!/
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

});*/
$(document).ready(function() {
    /*const navfilter = document.querySelectorAll('.nav-filter');*/
    document.querySelectorAll('.FilterName').forEach(
      el => el.onclick = function() {
        el.parentElement.classList.toggle('active')
      }
    );
    const caret = document.querySelector('.fa-caret-down');
    caret.onclick = function() {
        document.querySelector('.NavigationContainer').classList.toggle('active');
    }
});
