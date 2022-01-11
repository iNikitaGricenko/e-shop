function recall(){
    		var recall = document.getElementById('recall');
			var blur = document.getElementById('blur');
    		blur.classList.toggle('active');
    		recall.classList.toggle('active');
    	}
    	function settings(){
    		var settings = document.getElementById('settings');
			var blur = document.getElementById('blur');
    		blur.classList.toggle('active');
    		settings.classList.toggle('active');
    	}
    	function login(){
    		var login = document.getElementById('login');
			var blur = document.getElementById('blur');
			if(blur.classList.contains('active')) {
    			blur.classList.toggle('active');
    		}
    		blured(login, blur);
    	}
    	function register(){
    		var register = document.getElementById('register');
			var blur = document.getElementById('blur');
			if(blur.classList.contains('active')) {
    			blur.classList.toggle('active');
    		}
    		blured(register, blur);
    	}
    	function some(modal){
			modal.parentElement.classList.toggle('active');
			var blur = document.getElementById('blur');
			blur.classList.toggle('active');
    	}
    	function blured(modal, blur){
    		var login = document.getElementById('login');
    		if(login.classList.contains('active') && login != modal) {
    			login.classList.toggle('active');
    		}
    		var register = document.getElementById('register');
    		if(register.classList.contains('active') && register != modal) {
    			register.classList.toggle('active');
    		}
    		blur.classList.toggle('active');
    		modal.classList.toggle('active');
    	}