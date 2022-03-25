

responsive(document.getElementById('body').clientHeight, document.getElementById('body').clientWidth)
window.onresize = doALoadOfStuff;

function responsive(bodyHeight, bodyWidth){

	console.log('Body Height: ' + bodyHeight);
	console.log('Body Width: ' + bodyWidth);

	if(bodyWidth > 1200){
		console.log('Muito grande')
		document.getElementById('side_menu').hidden=false;
		document.getElementById('menu_superior').hidden=false;
		document.getElementById('menu_superior_responsivo').hidden=true;
		document.getElementById('tabela').style.fontSize="1rem";
	}
	else if(bodyWidth <= 1200 && bodyWidth > 992){
		console.log('Grande');
		document.getElementById('side_menu').hidden=false;
		document.getElementById('menu_superior').hidden=false;
		document.getElementById('menu_superior_responsivo').hidden=true;
		document.getElementById('tabela').style.fontSize="1rem";
	}
	else if(bodyWidth <= 992 && bodyWidth > 768){
		console.log('Médio');
		document.getElementById('side_menu').hidden=true;
		document.getElementById('menu_superior').hidden=true;
		document.getElementById('menu_superior_responsivo').hidden=false;
		document.getElementById('tabela').style.fontSize="1rem";
	}
	else if(bodyWidth <= 768 && bodyWidth > 540){
		console.log('Pequeno');
		document.getElementById('side_menu').hidden=true;
		document.getElementById('menu_superior').hidden=true;
		document.getElementById('menu_superior_responsivo').hidden=false;
		document.getElementById('tabela').style.fontSize="0.75rem";
	}
	else if(bodyWidth < 540){
		console.log('Muito pequeno');
		document.getElementById('side_menu').hidden=true;
		document.getElementById('menu_superior').hidden=true;
		document.getElementById('menu_superior_responsivo').hidden=false;
		document.getElementById('tabela').style.fontSize="0.65rem";
	}

	/* Ajustando content */
	var tamanhoMain = document.getElementById('main');
	var tamanhoMenuSuperior = document.getElementById('menu_superior');
	var tamanhoMenuResponsivo = document.getElementById('menu_superior_responsivo');
	var tamanhoTituloPathContainer = document.getElementById('titulo_path_container');
	var tamanhoConteudoContainer = document.getElementById('conteudo_container');

	if(tamanhoMenuSuperior.clientHeight == 0){
		console.log('SEM MENU SUPERIOR');
		console.log('Tamanho main: ' + tamanhoMain.clientHeight);
		console.log('Tamanho menu responsivo: ' + tamanhoMenuResponsivo.clientHeight)
		tamanhoConteudoContainer.style.height = parseInt(parseInt(tamanhoMain.clientHeight) - parseInt(tamanhoMenuResponsivo.clientHeight) - parseInt(tamanhoTituloPathContainer.clientHeight)) - 35 + 'px';
	}
	else{
		console.log('COM MENU SUPERIOR');
		tamanhoConteudoContainer.style.height = parseInt(parseInt(tamanhoMain.clientHeight) - parseInt(tamanhoMenuSuperior.clientHeight) - parseInt(tamanhoTituloPathContainer.clientHeight)) - 35 + 'px';
	}
}

function doALoadOfStuff() {
	responsive(document.getElementById('body').clientHeight, document.getElementById('body').clientWidth);
}