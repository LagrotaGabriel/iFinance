/* ESSA PARTE DO CÓDIGO É RESPONSÁVEL PELA RESPONSIVIDADE DA PÁGINA */

var tamanhoAll = document.getElementById('all');
var tamanhoBody = document.getElementById('body');
tamanhoAll.style.height = tamanhoBody.clientHeight + 'px';

tamanhoBody.style.height = '100vh';

responsive();
window.onresize = doALoadOfStuff;

function responsive(){

	document.getElementById('main_loader').style.display="none";
	document.getElementById('all').style.display="flex";

	var bodyWidth = document.getElementById('body').clientWidth;
	var bodyHeight = document.getElementById('body').clientHeight;

	var textos = document.getElementsByClassName('label');
	var inputs = document.getElementsByClassName('input');
	var titulos = document.getElementsByClassName('titulo');

	if(bodyWidth > 1200){
		console.log('Muito grande')

		document.getElementById('all').style.alignItems="center";
		document.getElementById('menu_box').style.height = 'initial';
		document.getElementById('menu_box').style.margin = '0 auto';

		for (var i = 0; i < textos.length; i++) {
  			var texto = textos[i];
  			texto.style.fontSize = "1rem";
		}
		for (var i = 0; i < inputs.length; i++) {
  			var input = inputs[i];
  			input.style.fontSize = "1rem";
		}
		for (var i = 0; i < titulos.length; i++) {
  			var titulo = titulos[i];
  			titulo.style.fontSize = "2rem";
		}		
	}
	else if(bodyWidth <= 1200 && bodyWidth > 992){
		console.log('Grande');

		document.getElementById('all').style.alignItems="center";
		document.getElementById('menu_box').style.height = 'initial';
		document.getElementById('menu_box').style.margin = '0 auto';

		for (var i = 0; i < textos.length; i++) {
  			var texto = textos[i];
  			texto.style.fontSize = "0.85rem";
		}
		for (var i = 0; i < inputs.length; i++) {
  			var input = inputs[i];
  			input.style.fontSize = "0.85rem";
		}	
		for (var i = 0; i < titulos.length; i++) {
  			var titulo = titulos[i];
  			titulo.style.fontSize = "2rem";
		}					
	}
	else if(bodyWidth <= 992 && bodyWidth > 768){
		console.log('Médio');

		document.getElementById('all').style.alignItems="center";
		document.getElementById('menu_box').style.height = 'initial';
		document.getElementById('menu_box').style.margin = '0 auto';

		for (var i = 0; i < textos.length; i++) {
  			var texto = textos[i];
  			texto.style.fontSize = "1rem";
		}
		for (var i = 0; i < inputs.length; i++) {
  			var input = inputs[i];
  			input.style.fontSize = "0.85rem";
		}
		for (var i = 0; i < titulos.length; i++) {
  			var titulo = titulos[i];
  			titulo.style.fontSize = "2rem";
		}						
	}
	else if(bodyWidth <= 768 && bodyWidth > 540){
		console.log('Pequeno');

		document.getElementById('all').style.alignItems="flex-start";
		document.getElementById('menu_box').style.height = 'auto'
		document.getElementById('menu_box').style.margin = '50px auto';

		for (var i = 0; i < textos.length; i++) {
  			var texto = textos[i];
  			texto.style.fontSize = "1rem";
		}
		for (var i = 0; i < inputs.length; i++) {
  			var input = inputs[i];
  			input.style.fontSize = "0.85rem";
		}		
		for (var i = 0; i < titulos.length; i++) {
  			var titulo = titulos[i];
  			titulo.style.fontSize = "2rem";
		}						
	}
	else if(bodyWidth < 540){
		console.log('Muito pequeno');

		document.getElementById('all').style.alignItems="flex-start";
		document.getElementById('menu_box').style.height = 'auto';
		document.getElementById('menu_box').style.margin = '50px auto';

		for (var i = 0; i < textos.length; i++) {
  			var texto = textos[i];
  			texto.style.fontSize = "1rem";
		}
		for (var i = 0; i < inputs.length; i++) {
  			var input = inputs[i];
  			input.style.fontSize = "1rem";
		}
		for (var i = 0; i < titulos.length; i++) {
  			var titulo = titulos[i];
  			titulo.style.fontSize = "1.5rem";
		}							
	}						

	var tamanhoAll = document.getElementById('all');
	var tamanhoBody = document.getElementById('body');
	tamanhoAll.style.height = tamanhoBody.clientHeight + 'px';

	tamanhoBody.style.height = '100vh';

}

function doALoadOfStuff() {
	responsive()
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////

/* ESSA PARTE DO CÓDIGO É RESPONSÁVEL PELOS EVENTOS DOS INPUTS */

/* Ao passar o mouse em cima dos labels aparece mensagem instrutiva sobre como
preencher o campo */
function showMessage(message){
	document.getElementById('mensagem').hidden=false;
	document.getElementById('mensagem').innerHTML=message;
	document.getElementById('erro').style.display="none";
}

function hideMessage(){
	document.getElementById('mensagem').hidden=true;
	document.getElementById('erro').style.display="none";
}

/* Confirma se as duas senhas são compatíveis */
function confirm(){
	var senha = document.getElementById('password');
	var resenha = document.getElementById('repassword');
	if(senha.value != resenha.value){
		resenha.style.backgroundColor="#ffd1d1";
		document.getElementById('button_ir').disabled=true;
	}
	else if(senha.value == resenha.value && senha.value != ""){
		resenha.style.backgroundColor="#c7ffd4";
		document.getElementById('button_ir').disabled=false;

	}
	else if(senha.value == "" && resenha.value == ""){
		resenha.style.backgroundColor="#FFFFFF";
	}
}