    $(document).ready(function() {

      let img = document.querySelector(".inputImgBox");
      if (img !== null) {
          img.addEventListener("mousedown", middleClick);
      }

    });
    function middleClick(e) {
        if (e.which == 2) {
            window.open($('#ProfileImage').attr('src'), "_blank");
            return false;
        }
        return true;
    }