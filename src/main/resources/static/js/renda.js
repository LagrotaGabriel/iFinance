/* =========================== RESPONSIVIDADE DA TELA =========================== */

window.onload = responsive();
window.onresize = doALoadOfStuff;

function responsive(){

	document.getElementById('main_loader').style.display="none";
	document.getElementById('main_row').style.display="flex";

	bodyWidth = document.getElementById('body').clientWidth;
	bodyHeight = document.getElementById('body').clientHeight;

	/* Ajustando content */
	var tamanhoMain = document.getElementById('main');
	var tamanhoAside = document.getElementById('side_menu');
	var tamanhoMenuSuperior = document.getElementById('menu_superior');
	var tamanhoMenuResponsivo = document.getElementById('menu_superior_responsivo');
	var tamanhoConteudoContainer = document.getElementById('conteudo_container');
	var tamanhoConteudoTitulo = document.getElementById('conteudo_titulo');
	var tamanhoSideMenu = document.getElementById('side_menu');
	var tamanhoContainerAlign = document.getElementById('container_align');

	var novoTitulo = document.getElementById('novo_titulo');
	var editTitulo = document.getElementById('edit_titulo');

	var firstShow = document.getElementById('first_show');
	var secondShow = document.getElementById('second_show');

	var imagens_title = document.getElementsByClassName('aside_title');
	var menu_responsivo_item = document.getElementsByClassName('sup_sup');

	var novoLabel = document.getElementsByClassName('novo_label');
	var novoInput = document.getElementsByClassName('novo_input');
	var novoBotao = document.getElementsByClassName('novo_botao');

	var editLabel = document.getElementsByClassName('edit_label');
	var editInput = document.getElementsByClassName('edit_input');
	var editBotao = document.getElementsByClassName('edit_botao');

	var arrow = document.getElementsByClassName('arrow');

	var blockInterno = document.getElementsByClassName('block_interno');
	var firstBlockClicavel = document.getElementsByClassName('first_block_clicavel');
	var secondBlockClicavel = document.getElementsByClassName('second_block_clicavel');
	var block = document.getElementsByClassName('block');

	var botoesOpc = document.getElementsByClassName('botoes_opc');
	var li = document.getElementsByClassName('li');
	var liA = document.getElementsByClassName('li_a');

	var th = document.getElementsByClassName('th');
	var td = document.getElementsByClassName('td');

	

	if(bodyWidth > 1200){
		console.log('Muito grande')
		tamanhoContainerAlign.style.alignItems="center";
		tamanhoContainerAlign.style.marginTop="0px";
		document.getElementById('side_menu').style.display="flex"
		document.getElementById('menu_superior').style.display="flex";
		document.getElementById('menu_superior_responsivo').style.display="none";
		document.getElementById('conteudo_titulo_text').style.fontSize="2rem";
		for(var j = 0; j < imagens_title.length; j++){
			imagens_title[j].style.fontSize="0.90rem";
		}	
		for(var i = 0; i < arrow.length; i++){
			arrow[i].style.display="flex";
		}
		/*for(var i = 0; i < blockInterno.length; i++){
			blockInterno[i].style.padding="45px 0";
		}
		for(var i = 0; i < firstBlockClicavel.length; i++){
			firstBlockClicavel[i].style.fontSize="1.5rem";
		}
		for(var i = 0; i < secondBlockClicavel.length; i++){
			secondBlockClicavel[i].style.fontSize="1rem";
		}*/		
		for(var i = 0; i < block.length; i++){
			block[i].style.margin="0 20px";
		}
		for(var i = 0; i < liA.length; i++){
			liA[i].style.fontSize="1rem";
		}		
		for(var i = 0; i < th.length; i++){
			th[i].style.fontSize="1.5rem";
		}
		for(var i = 0; i < td.length; i++){
			td[i].style.fontSize="1rem";
		}
		for(var i = 0; i < novoLabel.length; i++){
			novoLabel[i].style.fontSize="1.15rem";
			novoInput[i].style.fontSize="1rem";
		}		
		for(var i = 0; i < novoBotao.length; i++){
			novoBotao[i].style.fontSize="1rem";
		}

	}
	else if(bodyWidth <= 1200 && bodyWidth > 992){
		console.log('Grande');
		tamanhoContainerAlign.style.alignItems="center";
		tamanhoContainerAlign.style.marginTop="0px";
		document.getElementById('side_menu').style.display="flex";
		document.getElementById('menu_superior').style.display="flex";
		document.getElementById('menu_superior_responsivo').style.display="none";
		document.getElementById('conteudo_titulo_text').style.fontSize="2rem";
		for(var j = 0; j < imagens_title.length; j++){
			imagens_title[j].style.fontSize="0.70rem";
		}	
		for(var i = 0; i < arrow.length; i++){
			arrow[i].style.display="flex";
		}		
		for(var i = 0; i < blockInterno.length; i++){
			blockInterno[i].style.padding="35px 0";
		}
		for(var i = 0; i < firstBlockClicavel.length; i++){
			firstBlockClicavel[i].style.fontSize="1.25rem";
		}
		for(var i = 0; i < secondBlockClicavel.length; i++){
			secondBlockClicavel[i].style.fontSize="1rem";
		}	
		for(var i = 0; i < block.length; i++){
			block[i].style.margin="0 15px";
		}		
		for(var i = 0; i < liA.length; i++){
			liA[i].style.fontSize="1rem";
		}
		for(var i = 0; i < th.length; i++){
			th[i].style.fontSize="1.35rem";
		}	
		for(var i = 0; i< td.length; i++){
			td[i].style.fontSize="1rem";				
		}		
		for(var i = 0; i < novoLabel.length; i++){
			novoLabel[i].style.fontSize="1.15rem";
			novoInput[i].style.fontSize="1rem";
			editLabel[i].style.fontSize="1.15rem";
			editInput[i].style.fontSize="1rem";
		}	
		for(var i = 0; i < novoBotao.length; i++){
			editBotao[i].style.fontSize="1rem";
			editBotao[i].style.fontSize="1rem";
		}					
				
	}
	else if(bodyWidth <= 992 && bodyWidth > 768){
		console.log('Médio');
		tamanhoContainerAlign.style.alignItems="center";
		tamanhoContainerAlign.style.marginTop="0px";
		document.getElementById('side_menu').style.display="none";
		document.getElementById('menu_superior').style.display="none";
		document.getElementById('menu_superior_responsivo').style.display="flex";
		document.getElementById('conteudo_titulo_text').style.fontSize="2rem";
		for(var i = 0; i < menu_responsivo_item.length; i++){
			menu_responsivo_item[i].style.fontSize="0.85rem";
		}
		for(var i = 0; i < arrow.length; i++){
			arrow[i].style.display="none";
		}		
		for(var i = 0; i < blockInterno.length; i++){
			blockInterno[i].style.padding="25px 0";
		}	
		for(var i = 0; i < firstBlockClicavel.length; i++){
			firstBlockClicavel[i].style.fontSize="1rem";
		}
		for(var i = 0; i < secondBlockClicavel.length; i++){
			secondBlockClicavel[i].style.fontSize="0.75rem";
		}		
		for(var i = 0; i < block.length; i++){
			block[i].style.margin="0 10px";
		}	
		for(var i = 0; i < liA.length; i++){
			liA[i].style.fontSize="0.80rem";
		}	
		for(var i = 0; i < th.length; i++){
			th[i].style.fontSize="1rem";
		}
		for(var i = 0; i< td.length; i++){
			td[i].style.fontSize="0.85rem";				
		}		
		for(var i = 0; i < novoLabel.length; i++){
			novoLabel[i].style.fontSize="1rem";
			novoInput[i].style.fontSize="0.85rem";
			editLabel[i].style.fontSize="1rem";
			editInput[i].style.fontSize="0.85rem";
		}
		for(var i = 0; i < novoBotao.length; i++){
			novoBotao[i].style.fontSize="0.95rem";
			editBotao[i].style.fontSize="0.95rem";
		}		
								
	}
	else if(bodyWidth <= 768 && bodyWidth > 540){
		console.log('Pequeno');
		tamanhoContainerAlign.style.alignItems="flex-start";
		tamanhoContainerAlign.style.marginTop="30px";
		document.getElementById('side_menu').style.display="none";
		document.getElementById('menu_superior').style.display="none";
		document.getElementById('menu_superior_responsivo').style.display="flex";
		document.getElementById('conteudo_titulo_text').style.fontSize="1.5rem";
		for(var i = 0; i < menu_responsivo_item.length; i++){
			menu_responsivo_item[i].style.fontSize="0.75rem";
		}
		for(var i = 0; i < arrow.length; i++){
			arrow[i].style.display="none";
		}			
		for(var i = 0; i < blockInterno.length; i++){
			blockInterno[i].style.padding="23px 0";
		}		
		for(var i = 0; i < firstBlockClicavel.length; i++){
			firstBlockClicavel[i].style.fontSize="0.90rem";
		}
		for(var i = 0; i < secondBlockClicavel.length; i++){
			secondBlockClicavel[i].style.fontSize="0.65rem";
		}		
		for(var i = 0; i < block.length; i++){
			block[i].style.margin="0 5px";
		}	
		for(var i = 0; i < liA.length; i++){
			liA[i].style.fontSize="0.70rem";
			li[i].style.margin="0 5px";			
		}	
		for(var i = 0; i < th.length; i++){
			th[i].style.fontSize="0.95rem";
		}	
		for(var i = 0; i< td.length; i++){
			td[i].style.fontSize="0.75rem";				
		}
		for(var i = 0; i < novoLabel.length; i++){
			novoLabel[i].style.fontSize="0.90rem";
			novoInput[i].style.fontSize="0.75rem";
			editLabel[i].style.fontSize="0.90rem";
			editInput[i].style.fontSize="0.75rem";			
		}	
		for(var i = 0; i < novoBotao.length; i++){
			novoBotao[i].style.fontSize="0.85rem";
			editBotao[i].style.fontSize="0.85rem";
		}					
								
	}
	else if(bodyWidth < 540){
		console.log('Muito pequeno');
		tamanhoContainerAlign.style.alignItems="flex-start";
		tamanhoContainerAlign.style.marginTop="30px";
		document.getElementById('side_menu').style.display="none";
		document.getElementById('menu_superior').style.display="none";
		document.getElementById('menu_superior_responsivo').style.display="flex";
		document.getElementById('conteudo_titulo_text').style.fontSize="1.25rem";
		for(var i = 0; i < menu_responsivo_item.length; i++){
			menu_responsivo_item[i].style.fontSize="0.50rem";
		}
		for(var i = 0; i < arrow.length; i++){
			arrow[i].style.display="none";
		}			
		for(var i = 0; i < blockInterno.length; i++){
			blockInterno[i].style.padding="20px 0";
		}	
		for(var i = 0; i < firstBlockClicavel.length; i++){
			firstBlockClicavel[i].style.fontSize="0.75rem";
		}
		for(var i = 0; i < secondBlockClicavel.length; i++){
			secondBlockClicavel[i].style.fontSize="0.55rem";
		}
		for(var i = 0; i < block.length; i++){
			block[i].style.margin="0 3px";
		}	
		for(var i = 0; i < liA.length; i++){
			liA[i].style.fontSize="0.65rem";
			li[i].style.margin="0 5px";
		}
		for(var i = 0; i < th.length; i++){
			th[i].style.fontSize="0.85rem";
			
		}	
		for(var i = 0; i< td.length; i++){
			td[i].style.fontSize="0.65rem";				
		}	
		for(var i = 0; i < novoLabel.length; i++){
			novoLabel[i].style.fontSize="0.70rem";
			novoInput[i].style.fontSize="0.65rem";
			editLabel[i].style.fontSize="0.70rem";
			editInput[i].style.fontSize="0.65rem";
		}
		for(var i = 0; i < novoBotao.length; i++){
			novoBotao[i].style.fontSize="0.75rem";
			editBotao[i].style.fontSize="0.75rem";
		}							
			
	}

	if(tamanhoMenuSuperior.clientHeight == 0){
		var somaTamanho = (tamanhoMain.clientHeight - tamanhoMenuResponsivo.clientHeight) + 'px';
		tamanhoContainerAlign.style.height = somaTamanho;
	}
	else{
		var somaTamanho = (tamanhoAside.clientHeight - tamanhoMenuSuperior.clientHeight) + 'px';
		tamanhoContainerAlign.style.height = somaTamanho;
	}	

	informativosResponsivity();

}

function doALoadOfStuff() {
	document.getElementById('conteudo_container').style.transition="2s";
	responsive();
}

/* =================== INTERAÇÕES COM O MENU LATERAL ESQUERDO =================== */

function animateMenu(item){

	if(item == "balanco"){
		document.getElementById("img_aside_balanco").src="../static/img/balance.png";
		document.getElementById("img_aside_balanco").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_balanco").style.color="#121212";
	}
	else if(item == "estatisticas"){
		document.getElementById("img_aside_estatisticas").src="../static/img/stats.png";
		document.getElementById("img_aside_estatisticas").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_estatisticas").style.color="#121212";
	}
	else if(item == "principal"){
		document.getElementById("img_aside_principal").src="../static/img/house.png";
		document.getElementById("img_aside_principal").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_principal").style.color="#121212";
	}
	else if(item == "despesas"){
		document.getElementById("img_aside_despesas").src="../static/img/despesa.png";
		document.getElementById("img_aside_despesas").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_despesas").style.color="#121212";
	}
	else if(item == "patrimonio"){
		document.getElementById("img_aside_patrimonio").src="../static/img/shelter.png";
		document.getElementById("img_aside_patrimonio").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_patrimonio").style.color="#121212";
	}
	else if(item == "configuracoes"){
		document.getElementById("img_aside_configuracoes").src="../static/img/settings.png";
		document.getElementById("img_aside_configuracoes").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_configuracoes").style.color="#121212";
	}
}

function returnMenuState(item){

	var titulos = document.getElementsByClassName("aside_title");

	if(item == "balanco"){
		document.getElementById("img_aside_balanco").src="../static/img/balanceblue.png";
		document.getElementById("img_aside_balanco").style.animation="none";
		titulos[1].style.color="#00ccff";
	}
	else if(item == "estatisticas"){
		document.getElementById("img_aside_estatisticas").src="../static/img/statsblue.png";
		document.getElementById("img_aside_estatisticas").style.animation="none";
		titulos[2].style.color="#00ccff";
	}
	else if(item == "principal"){
		document.getElementById("img_aside_principal").src="../static/img/houseblue.png";
		document.getElementById("img_aside_principal").style.animation="none";
		titulos[0].style.color="#00ccff";
	}
	else if(item == "despesas"){
		document.getElementById("img_aside_despesas").src="../static/img/despesablue.png";
		document.getElementById("img_aside_despesas").style.animation="none";
		titulos[3].style.color="#00ccff";
	}
	else if(item == "patrimonio"){
		document.getElementById("img_aside_patrimonio").src="../static/img/shelterblue.png";
		document.getElementById("img_aside_patrimonio").style.animation="none";
		titulos[4].style.color="#00ccff";
	}
	else if(item == "configuracoes"){
		document.getElementById("img_aside_configuracoes").src="../static/img/settingsblue.png";
		document.getElementById("img_aside_configuracoes").style.animation="none";
		titulos[6].style.color="#00ccff";
	}
}

/* =================== FECHAMENTO DOS ALERTAS =================== */

function hideMessage(){
	var alertas = document.getElementsByClassName('alert');
	for(var i = 0; i < alertas.length; i++){
		alertas[i].hidden=true;
	}
}


/* =============== RESPONSIVIDADE DE ESTILO DOS INFORMATIVOS =============== */
function informativosResponsivity(){

	var blockInternoDividendos = document.getElementById('block_interno_dividendos');
	var blockInternoExtra = document.getElementById('block_interno_extra');
	var blockInternoOutros = document.getElementById('block_interno_outros');
	var blockInternoSalario = document.getElementById('block_interno_salario');

	blockInternoDividendos.style.background="transparent";
	blockInternoDividendos.style.color="#FFFFFF";

	blockInternoExtra.style.background="transparent";
	blockInternoExtra.style.color="#FFFFFF";

	blockInternoOutros.style.background="transparent";
	blockInternoOutros.style.color="#FFFFFF";

	blockInternoSalario.style.background="transparent";
	blockInternoSalario.style.color="#FFFFFF";									

}

function overInformativo(hover){

	var blockInternoDividendos = document.getElementById('block_interno_dividendos');
	var blockInternoExtra = document.getElementById('block_interno_extra');
	var blockInternoOutros = document.getElementById('block_interno_outros');
	var blockInternoSalario = document.getElementById('block_interno_salario');

		if(hover == "dividendos"){
			blockInternoDividendos.style.backgroundImage="linear-gradient(to right, #00ccff, #28cffa)";
			blockInternoDividendos.style.color="#121212";
			blockInternoDividendos.style.pointerEvents="auto";	
			blockInternoDividendos.style.cursor="pointer";
			blockInternoDividendos.style.transition="1s";
			blockInternoDividendos.style.animation="pulse 2s infinite"		
		}
		else if(hover == "extra"){
			blockInternoExtra.style.backgroundImage="linear-gradient(to right, #00ccff, #28cffa)";
			blockInternoExtra.style.color="#121212";
			blockInternoExtra.style.pointerEvents="auto";	
			blockInternoExtra.style.cursor="pointer";
			blockInternoExtra.style.transition="1s";
			blockInternoExtra.style.animation="pulse 2s infinite"
		}
		else if(hover == "outros"){
			blockInternoOutros.style.backgroundImage="linear-gradient(to right, #00ccff, #28cffa)";
			blockInternoOutros.style.color="#121212";
			blockInternoOutros.style.pointerEvents="auto";	
			blockInternoOutros.style.cursor="pointer";
			blockInternoOutros.style.transition="1s";
			blockInternoOutros.style.animation="pulse 2s infinite"
		}
		else if(hover == "salario"){
			blockInternoSalario.style.backgroundImage="linear-gradient(to right, #00ccff, #28cffa)";
			blockInternoSalario.style.color="#121212";
			blockInternoSalario.style.pointerEvents="auto";	
			blockInternoSalario.style.cursor="pointer";
			blockInternoSalario.style.transition="1s";
			blockInternoSalario.style.animation="pulse 2s infinite"
		}
}

function leaveInformativo(hover){

	var blockInternoDividendos = document.getElementById('block_interno_dividendos');
	var blockInternoExtra = document.getElementById('block_interno_extra');
	var blockInternoOutros = document.getElementById('block_interno_outros');
	var blockInternoSalario = document.getElementById('block_interno_salario');

		if(hover == "dividendos"){
			blockInternoDividendos.style.background="transparent";
			blockInternoDividendos.style.color="#FFFFFF";	
			blockInternoDividendos.style.cursor="default";
			blockInternoDividendos.style.transition="1s";
			blockInternoDividendos.style.animation="none"		
		}
		else if(hover == "extra"){
			blockInternoExtra.style.background="transparent";
			blockInternoExtra.style.color="#FFFFFF";	
			blockInternoExtra.style.cursor="default";
			blockInternoExtra.style.transition="1s";
			blockInternoExtra.style.animation="none"
		}
		else if(hover == "outros"){
			blockInternoOutros.style.background="transparent";
			blockInternoOutros.style.color="#FFFFFF";	
			blockInternoOutros.style.cursor="default";
			blockInternoOutros.style.transition="1s";
			blockInternoOutros.style.animation="none"
		}
		else if(hover == "salario"){
			blockInternoSalario.style.background="transparent";
			blockInternoSalario.style.color="#FFFFFF";
			blockInternoSalario.style.cursor="default";
			blockInternoSalario.style.transition="1s";
			blockInternoSalario.style.animation="none"
		}

}
