window.onresize = doALoadOfStuff;

responsive(document.getElementById('all'), document.getElementById('body'))

function responsive(all, body){
	body.style.height = '100vh';
	all.style.height = document.getElementById('body').clientHeight + 'px';
}

function usernameInput(){
	document.getElementById('username').select();
}

function passwordInput(){
	document.getElementById('password').select();
}

function doALoadOfStuff() {
	responsive(document.getElementById('all'), document.getElementById('body'))
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