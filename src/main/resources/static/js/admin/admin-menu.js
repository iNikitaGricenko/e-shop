    // Toggle menu
    let toggle = document.querySelector('.toggle');
    let navigation = document.querySelector('.navigation');
    let main = document.querySelector('.main-content');

    toggle.onclick = function() {
      navigation.classList.toggle('active');
      main.classList.toggle('active');
    }

    // hovered class in selected list item
    let list = document.querySelectorAll('.navigation li');
    function activeList() {
      list.forEach((item) =>
      item.classList.remove('hovered'));
      this.classList.add('hovered');
    }
    list.forEach((item) => item.addEventListener('mouseover', activeList));