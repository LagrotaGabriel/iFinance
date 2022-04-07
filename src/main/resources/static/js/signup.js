var tamanhoAll = document.getElementById('all');
var tamanhoBody = document.getElementById('body');
tamanhoAll.style.height = tamanhoBody.clientHeight + 'px';

tamanhoBody.style.height = '100vh';

window.onresize = doALoadOfStuff;
responsive(document.getElementById('body').clientWidth, document.getElementById('body').clientHeight)

function responsive(bodyWidth, bodyHeight){

	var textos = document.getElementsByClassName('label');
	var inputs = document.getElementsByClassName('input');
	var titulos = document.getElementsByClassName('titulo');

	if(bodyWidth > 1200){
		console.log('Muito grande')

		document.getElementById('all').style.alignItems="center";
		document.getElementById('menu_box').style.height = 'initial';

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
	responsive(document.getElementById('body').clientWidth, document.getElementById('body').clientHeight)
}