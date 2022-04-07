responsive(document.getElementById('body').clientHeight, document.getElementById('body').clientWidth)
window.onresize = doALoadOfStuff;

function responsive(bodyHeight, bodyWidth){

	var textos = document.getElementsByClassName('txt');

	if(bodyWidth > 1200){
		console.log('Muito grande')
		document.getElementById('side_menu').hidden=false;
		document.getElementById('menu_superior').hidden=false;
		document.getElementById('menu_superior_responsivo').hidden=true;
		document.getElementById('titulo_linha_geral_clicavel1').style.fontSize="2rem";
		document.getElementById('titulo_linha_geral_clicavel2').style.fontSize="2rem";
		document.getElementById('titulo_linha_geral_clicavel3').style.fontSize="2rem";
		document.getElementById('titulo_linha_geral_clicavel4').style.fontSize="2rem";

		document.getElementById('titulo_linha_geral_clicavel1').style.padding="10px 15px";
		document.getElementById('titulo_linha_geral_clicavel2').style.padding="10px 15px";
		document.getElementById('titulo_linha_geral_clicavel3').style.padding="10px 15px";
		document.getElementById('titulo_linha_geral_clicavel4').style.padding="10px 15px";

		document.getElementById('titulo_linha_geral_clicavel1').style.textAlign="left";
		document.getElementById('titulo_linha_geral_clicavel2').style.textAlign="left";
		document.getElementById('titulo_linha_geral_clicavel3').style.textAlign="left";
		document.getElementById('titulo_linha_geral_clicavel4').style.textAlign="left";		
		for (var i = 0; i < textos.length; i++) {
  			var texto = textos[i];
  			texto.style.fontSize = "1.25rem";
		}
	}
	else if(bodyWidth <= 1200 && bodyWidth > 992){
		console.log('Grande');
		document.getElementById('side_menu').hidden=false;
		document.getElementById('menu_superior').hidden=false;
		document.getElementById('menu_superior_responsivo').hidden=true;
		document.getElementById('titulo_linha_geral_clicavel1').style.fontSize="2rem";
		document.getElementById('titulo_linha_geral_clicavel2').style.fontSize="2rem";
		document.getElementById('titulo_linha_geral_clicavel3').style.fontSize="2rem";
		document.getElementById('titulo_linha_geral_clicavel4').style.fontSize="2rem";

		document.getElementById('titulo_linha_geral_clicavel1').style.padding="10px 15px";
		document.getElementById('titulo_linha_geral_clicavel2').style.padding="10px 15px";
		document.getElementById('titulo_linha_geral_clicavel3').style.padding="10px 15px";
		document.getElementById('titulo_linha_geral_clicavel4').style.padding="10px 15px";

		document.getElementById('titulo_linha_geral_clicavel1').style.textAlign="left";
		document.getElementById('titulo_linha_geral_clicavel2').style.textAlign="left";
		document.getElementById('titulo_linha_geral_clicavel3').style.textAlign="left";
		document.getElementById('titulo_linha_geral_clicavel4').style.textAlign="left";		
		for (var i = 0; i < textos.length; i++) {
  			var texto = textos[i];
  			texto.style.fontSize = "1rem";
		}
	}
	else if(bodyWidth <= 992 && bodyWidth > 768){
		console.log('Médio');
		document.getElementById('side_menu').hidden=true;
		document.getElementById('menu_superior').hidden=true;
		document.getElementById('menu_superior_responsivo').hidden=false;
		document.getElementById('titulo_linha_geral_clicavel1').style.fontSize="1.5rem";
		document.getElementById('titulo_linha_geral_clicavel2').style.fontSize="1.5rem";
		document.getElementById('titulo_linha_geral_clicavel3').style.fontSize="1.5rem";
		document.getElementById('titulo_linha_geral_clicavel4').style.fontSize="1.5rem";

		document.getElementById('titulo_linha_geral_clicavel1').style.padding="10px 15px";
		document.getElementById('titulo_linha_geral_clicavel2').style.padding="10px 15px";
		document.getElementById('titulo_linha_geral_clicavel3').style.padding="10px 15px";
		document.getElementById('titulo_linha_geral_clicavel4').style.padding="10px 15px";

		document.getElementById('titulo_linha_geral_clicavel1').style.textAlign="left";
		document.getElementById('titulo_linha_geral_clicavel2').style.textAlign="left";
		document.getElementById('titulo_linha_geral_clicavel3').style.textAlign="left";
		document.getElementById('titulo_linha_geral_clicavel4').style.textAlign="left";
		for (var i = 0; i < textos.length; i++) {
  			var texto = textos[i];
  			texto.style.fontSize = "0.95rem";
		}
	}
	else if(bodyWidth <= 768 && bodyWidth > 540){
		console.log('Pequeno');
		document.getElementById('side_menu').hidden=true;
		document.getElementById('menu_superior').hidden=true;
		document.getElementById('menu_superior_responsivo').hidden=false;
		document.getElementById('titulo_linha_geral_clicavel1').style.fontSize="1rem";
		document.getElementById('titulo_linha_geral_clicavel2').style.fontSize="1rem";
		document.getElementById('titulo_linha_geral_clicavel3').style.fontSize="1rem";
		document.getElementById('titulo_linha_geral_clicavel4').style.fontSize="1rem";

		document.getElementById('titulo_linha_geral_clicavel1').style.padding="7px";
		document.getElementById('titulo_linha_geral_clicavel2').style.padding="7px";
		document.getElementById('titulo_linha_geral_clicavel3').style.padding="7px";
		document.getElementById('titulo_linha_geral_clicavel4').style.padding="7px";

		document.getElementById('titulo_linha_geral_clicavel1').style.textAlign="left";
		document.getElementById('titulo_linha_geral_clicavel2').style.textAlign="left";
		document.getElementById('titulo_linha_geral_clicavel3').style.textAlign="left";
		document.getElementById('titulo_linha_geral_clicavel4').style.textAlign="left";

		for (var i = 0; i < textos.length; i++) {
  			var texto = textos[i];
  			texto.style.fontSize = "0.90rem";
		}
	}
	else if(bodyWidth < 540){
		console.log('Muito pequeno');
		document.getElementById('side_menu').hidden=true;
		document.getElementById('menu_superior').hidden=true;
		document.getElementById('menu_superior_responsivo').hidden=false;
		document.getElementById('titulo_linha_geral_clicavel1').style.fontSize="0.75rem";
		document.getElementById('titulo_linha_geral_clicavel2').style.fontSize="0.75rem";
		document.getElementById('titulo_linha_geral_clicavel3').style.fontSize="0.75rem";
		document.getElementById('titulo_linha_geral_clicavel4').style.fontSize="0.75rem";

		document.getElementById('titulo_linha_geral_clicavel1').style.padding="5px";
		document.getElementById('titulo_linha_geral_clicavel2').style.padding="5px";
		document.getElementById('titulo_linha_geral_clicavel3').style.padding="5px";
		document.getElementById('titulo_linha_geral_clicavel4').style.padding="5px";

		document.getElementById('titulo_linha_geral_clicavel1').style.textAlign="center";
		document.getElementById('titulo_linha_geral_clicavel2').style.textAlign="center";
		document.getElementById('titulo_linha_geral_clicavel3').style.textAlign="center";
		document.getElementById('titulo_linha_geral_clicavel4').style.textAlign="center";

		for (var i = 0; i < textos.length; i++) {
  			var texto = textos[i];
  			texto.style.fontSize = "0.80rem";
		}
	}

	/* Ajustando content */
	var tamanhoMain = document.getElementById('main');
	var tamanhoMenuSuperior = document.getElementById('menu_superior');
	var tamanhoMenuResponsivo = document.getElementById('menu_superior_responsivo');
	var tamanhoTituloPathContainer = document.getElementById('titulo_path_container');
	var tamanhoConteudoContainer = document.getElementById('conteudo_container');
	var tamanhoConteudoTitulo = document.getElementById('conteudo_titulo');
	var tamanhoInfosPerfil1 = document.getElementById('infos_perfil1');
	var tamanhoInfosPerfil2 = document.getElementById('infos_perfil2');
	var tituloLinhaGeralClicavel = document.getElementById('titulo_linha_geral_clicavel');


	if(tamanhoMenuSuperior.clientHeight == 0){
		console.log('SEM MENU SUPERIOR');
		tamanhoConteudoContainer.style.height = parseInt(parseInt(tamanhoMain.clientHeight) - parseInt(tamanhoMenuResponsivo.clientHeight) - parseInt(tamanhoTituloPathContainer.clientHeight)) - 35 + 'px';
		tamanhoInfosPerfil1.style.height = (parseInt(parseInt(tamanhoConteudoContainer.clientHeight) - parseInt(tamanhoConteudoTitulo.clientHeight)) - 0 + 'px');
		tamanhoInfosPerfil2.style.height = (parseInt(parseInt(tamanhoConteudoContainer.clientHeight) - parseInt(tamanhoConteudoTitulo.clientHeight)) - 0 + 'px');
	}
	else{
		console.log('COM MENU SUPERIOR');
		tamanhoConteudoContainer.style.height = parseInt(parseInt(tamanhoMain.clientHeight) - parseInt(tamanhoMenuSuperior.clientHeight) - parseInt(tamanhoTituloPathContainer.clientHeight)) - 35 + 'px';
		tamanhoInfosPerfil1.style.height = (parseInt(parseInt(tamanhoConteudoContainer.clientHeight) - parseInt(tamanhoConteudoTitulo.clientHeight)) - 0 + 'px');
		tamanhoInfosPerfil2.style.height = (parseInt(parseInt(tamanhoConteudoContainer.clientHeight) - parseInt(tamanhoConteudoTitulo.clientHeight)) - 0 + 'px');
	}
}

function doALoadOfStuff() {
	responsive(document.getElementById('body').clientHeight, document.getElementById('body').clientWidth);
}