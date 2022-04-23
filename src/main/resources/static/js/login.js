window.onresize = doALoadOfStuff;
window.onload = responsive()

function responsive(){

	document.getElementById('all').style.display="flex";
	var all = document.getElementById('all')	
	var body = document.getElementById('body')
	bodyWidth = document.getElementById('body').clientWidth;
	bodyHeight = document.getElementById('body').clientHeight;	
	//body.style.minHeight = '100vh';
	//all.style.height = document.getElementById('body').clientHeight + 'px';

	var prenchimento = document.getElementById('prenchimento');

	if(bodyHeight < prenchimento.clientHeight){
		all.style.alignItems="initial";
		body.style.paddingTop="50px";
	}
	else{
		all.style.alignItems="center";
		body.style.paddingTop="0";
	}

	if(bodyWidth > 1200){
		console.log("Muito grande");
		document.getElementById('first_hr').style.margin="0 50px";
		document.getElementById('prenchimento').style.padding="40px 5px";

	}

	else if(bodyWidth <= 1200 && bodyWidth > 992){
		console.log("Grande");		
		document.getElementById('first_hr').style.margin="0";
		document.getElementById('prenchimento').style.padding="50px";

	}

	else if(bodyWidth <= 992 && bodyWidth > 768){
		console.log('Médio');
		document.getElementById('first_hr').style.margin="0";
		document.getElementById('prenchimento').style.padding="50px";

	}

	else if(bodyWidth <= 768 && bodyWidth > 540){
		console.log('Pequeno');
		document.getElementById('first_hr').style.margin="0";
		document.getElementById('prenchimento').style.padding="50px";


	}
	
	else if(bodyWidth < 540){
		console.log('Muito pequeno');
		document.getElementById('first_hr').style.margin="0";
		document.getElementById('prenchimento').style.padding="50px";

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