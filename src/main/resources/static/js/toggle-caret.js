$(document).ready(function() {
    const caret = document.querySelector('.fa-caret-down');
    caret.onclick = function() {
        document.querySelector('.NavigationContainer').classList.toggle('active');
    }
});