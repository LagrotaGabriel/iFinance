window.onresize = doALoadOfStuff;
window.onload = responsive()

function responsive(){

	document.getElementById('all').style.display="flex";
	var all = document.getElementById('all')	
	var body = document.getElementById('body')
	bodyWidth = document.getElementById('body').clientWidth;
	bodyHeight = document.getElementById('body').clientHeight;	
	body.style.height = '100vh';
	all.style.height = document.getElementById('body').clientHeight + 'px';

	var informativa = document.getElementById('informativa');

	if(bodyWidth > 1200){
		console.log("Muito grande");
		informativa.style.display="flex";

	}

	else if(bodyWidth <= 1200 && bodyWidth > 992){
		console.log("Grande");		
		informativa.style.display="flex";

	}

	else if(bodyWidth <= 992 && bodyWidth > 768){
		console.log('Médio');
		informativa.style.display="flex";

	}

	else if(bodyWidth <= 768 && bodyWidth > 540){
		console.log('Pequeno');
		informativa.style.display="none";


	}
	
	else if(bodyWidth < 540){
		console.log('Muito pequeno');
		informativa.style.display="none";

	}							





}

function usernameInput(){
	document.getElementById('username').select();
}

function passwordInput(){
	document.getElementById('password').select();
}

function doALoadOfStuff() {
	responsive()
}	

function hideMessage(value){
	if(value==1){
		document.getElementById('erro').style.display="none";
	}
	else if(value==2){
		document.getElementById('logout').style.display="none";
	}
	else{
		document.getElementById('sucesso').style.display="none";
	}
}