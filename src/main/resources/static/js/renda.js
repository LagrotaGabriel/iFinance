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
		tamanhoContainerAlign.style.alignItems="flex-start";
		tamanhoContainerAlign.style.marginTop="30px";
		tamanhoContainerAlign.style.marginBottom="30px";
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
		tamanhoContainerAlign.style.alignItems="flex-start";
		tamanhoContainerAlign.style.marginTop="30px";
		tamanhoContainerAlign.style.marginBottom="30px";
		document.getElementById('side_menu').style.display="flex"
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
	
	}
	else if(bodyWidth <= 992 && bodyWidth > 768){
		console.log('M??dio');
		tamanhoContainerAlign.style.alignItems="flex-start";
		tamanhoContainerAlign.style.marginTop="30px";
		tamanhoContainerAlign.style.marginBottom="30px";
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
								
	}
	else if(bodyWidth <= 768 && bodyWidth > 540){
		console.log('Pequeno');
		tamanhoContainerAlign.style.alignItems="flex-start";
		tamanhoContainerAlign.style.marginTop="30px";
		tamanhoContainerAlign.style.marginBottom="30px";
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
								
	}
	else if(bodyWidth < 540){
		console.log('Muito pequeno');
		tamanhoContainerAlign.style.alignItems="flex-start";
		tamanhoContainerAlign.style.marginTop="30px";
		tamanhoContainerAlign.style.marginBottom="30px";
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

	}

	informativosResponsivity();

}

function doALoadOfStuff() {
	document.getElementById('conteudo_container').style.transition="2s";
	responsive();
}

/* =================== INTERA????ES COM O MENU LATERAL ESQUERDO =================== */

function animateMenu(item){

	if(item == "balanco"){
		document.getElementById("img_aside_balanco").src="img/balance.png";
		document.getElementById("img_aside_balanco").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_balanco").style.color="#121212";
	}
	else if(item == "estatisticas"){
		document.getElementById("img_aside_estatisticas").src="img/money.png";
		document.getElementById("img_aside_estatisticas").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_estatisticas").style.color="#121212";
	}
	else if(item == "principal"){
		document.getElementById("img_aside_principal").src="img/house.png";
		document.getElementById("img_aside_principal").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_principal").style.color="#121212";
	}
	else if(item == "despesas"){
		document.getElementById("img_aside_despesas").src="img/despesa.png";
		document.getElementById("img_aside_despesas").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_despesas").style.color="#121212";
	}
	else if(item == "patrimonio"){
		document.getElementById("img_aside_patrimonio").src="img/shelter.png";
		document.getElementById("img_aside_patrimonio").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_patrimonio").style.color="#121212";
	}
	else if(item == "configuracoes"){
		document.getElementById("img_aside_configuracoes").src="img/settings.png";
		document.getElementById("img_aside_configuracoes").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_configuracoes").style.color="#121212";
	}
}

function returnMenuState(item){

	var titulos = document.getElementsByClassName("aside_title");

	if(item == "balanco"){
		document.getElementById("img_aside_balanco").src="img/balanceblue.png";
		document.getElementById("img_aside_balanco").style.animation="none";
		titulos[1].style.color="#00ccff";
	}
	else if(item == "estatisticas"){
		document.getElementById("img_aside_estatisticas").src="img/moneyblue.png";
		document.getElementById("img_aside_estatisticas").style.animation="none";
		titulos[2].style.color="#00ccff";
	}
	else if(item == "principal"){
		document.getElementById("img_aside_principal").src="img/houseblue.png";
		document.getElementById("img_aside_principal").style.animation="none";
		titulos[0].style.color="#00ccff";
	}
	else if(item == "despesas"){
		document.getElementById("img_aside_despesas").src="img/despesablue.png";
		document.getElementById("img_aside_despesas").style.animation="none";
		titulos[3].style.color="#00ccff";
	}
	else if(item == "patrimonio"){
		document.getElementById("img_aside_patrimonio").src="img/shelterblue.png";
		document.getElementById("img_aside_patrimonio").style.animation="none";
		titulos[4].style.color="#00ccff";
	}
	else if(item == "configuracoes"){
		document.getElementById("img_aside_configuracoes").src="img/settingsblue.png";
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
		}
		else if(hover == "extra"){
			blockInternoExtra.style.backgroundImage="linear-gradient(to right, #00ccff, #28cffa)";
			blockInternoExtra.style.color="#121212";
			blockInternoExtra.style.pointerEvents="auto";	
			blockInternoExtra.style.cursor="pointer";
			blockInternoExtra.style.transition="1s";
		}
		else if(hover == "outros"){
			blockInternoOutros.style.backgroundImage="linear-gradient(to right, #00ccff, #28cffa)";
			blockInternoOutros.style.color="#121212";
			blockInternoOutros.style.pointerEvents="auto";	
			blockInternoOutros.style.cursor="pointer";
			blockInternoOutros.style.transition="1s";
		}
		else if(hover == "salario"){
			blockInternoSalario.style.backgroundImage="linear-gradient(to right, #00ccff, #28cffa)";
			blockInternoSalario.style.color="#121212";
			blockInternoSalario.style.pointerEvents="auto";	
			blockInternoSalario.style.cursor="pointer";
			blockInternoSalario.style.transition="1s";
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
		}
		else if(hover == "extra"){
			blockInternoExtra.style.background="transparent";
			blockInternoExtra.style.color="#FFFFFF";	
			blockInternoExtra.style.cursor="default";
			blockInternoExtra.style.transition="1s";
		}
		else if(hover == "outros"){
			blockInternoOutros.style.background="transparent";
			blockInternoOutros.style.color="#FFFFFF";	
			blockInternoOutros.style.cursor="default";
			blockInternoOutros.style.transition="1s";
		}
		else if(hover == "salario"){
			blockInternoSalario.style.background="transparent";
			blockInternoSalario.style.color="#FFFFFF";
			blockInternoSalario.style.cursor="default";
			blockInternoSalario.style.transition="1s";
		}
}

/* =============== INTERA????ES COM OS SAL??RIOS INFORMATIVOS =============== */

function openSalario(){

	var conteudoContainer = document.getElementById('conteudo_container');
	var conteudoContainerSalario = document.getElementById('conteudo_container_salario');

	conteudoContainer.style.display="none";
	conteudoContainerSalario.style.display="block";
}

function editSalario(id, desc, val, freq){

	console.log("ID: " + id);

	var conteudoContainerSalario = document.getElementById('conteudo_container_salario');
	var conteudoContainerEditSalario = document.getElementById('conteudo_container_edit_salario');

	var salarioTitulo = document.getElementById('conteudo_titulo_text_edit_salario');
	var salarioId = document.getElementById('edit_salario_id');
	var salarioIdDelete = document.getElementById('salario_id_delete');
	var salarioDescricao = document.getElementById('edit_salario_descricao');
	var salarioValor = document.getElementById('edit_salario_valor');
	var salarioPeriodicidade = document.getElementById('edit_salario_frequencia');

	salarioTitulo.innerText=desc;
	salarioId.value=id;
	salarioIdDelete.value=id;
	salarioDescricao.value=desc;
	salarioValor.value=val;
	salarioPeriodicidade.value=freq;

	conteudoContainerSalario.style.display="none";
	conteudoContainerEditSalario.style.display="block";

}

function clickOnNewSalario(){

	var conteudoContainerSalario = document.getElementById('conteudo_container_salario');
	var conteudoContainerNovoSalario = document.getElementById('conteudo_container_novo_salario');

	conteudoContainerSalario.style.display="none";
	conteudoContainerNovoSalario.style.display="block";

}

function closeSalario(){

	var conteudoContainer = document.getElementById('conteudo_container');
	var conteudoContainerSalario = document.getElementById('conteudo_container_salario');

	conteudoContainer.style.display="block";
	conteudoContainerSalario.style.display="none";
}

function closeEditSalario(){

	var conteudoContainerSalario = document.getElementById('conteudo_container_salario');
	var conteudoContainerEditSalario = document.getElementById('conteudo_container_edit_salario');

	conteudoContainerSalario.style.display="block";
	conteudoContainerEditSalario.style.display="none";

}

function closeNewSalario(){

	var conteudoContainerSalario = document.getElementById('conteudo_container_salario');
	var conteudoContainerNovoSalario = document.getElementById('conteudo_container_novo_salario');

	conteudoContainerSalario.style.display="block";
	conteudoContainerNovoSalario.style.display="none";

}

/* =============== INTERA????ES COM OS DIVIDENDOS INFORMATIVOS =============== */

function openDividendo(){

	var conteudoContainer = document.getElementById('conteudo_container');
	var conteudoContainerDividendo = document.getElementById('conteudo_container_dividendo');

	conteudoContainer.style.display="none";
	conteudoContainerDividendo.style.display="block";
}

function editDividendo(id, desc, val, freq){

	var conteudoContainerDividendo = document.getElementById('conteudo_container_dividendo');
	var conteudoContainerEditDividendo = document.getElementById('conteudo_container_edit_dividendo');

	var dividendoTitulo = document.getElementById('conteudo_titulo_text_edit_dividendo');
	var dividendoId = document.getElementById('edit_dividendo_id');
	var dividendoIdDelete = document.getElementById('dividendo_id_delete');
	var dividendoDescricao = document.getElementById('edit_dividendo_descricao');
	var dividendoValor = document.getElementById('edit_dividendo_valor');
	var dividendoPeriodicidade = document.getElementById('edit_dividendo_frequencia');

	dividendoTitulo.innerText=desc;
	dividendoId.value=id;
	dividendoIdDelete.value=id;
	dividendoDescricao.value=desc;
	dividendoValor.value=val;
	dividendoPeriodicidade.value=freq;

	conteudoContainerDividendo.style.display="none";
	conteudoContainerEditDividendo.style.display="block";

}

function clickOnNewDividendo(){

	var conteudoContainerDividendo = document.getElementById('conteudo_container_dividendo');
	var conteudoContainerNovoDividendo = document.getElementById('conteudo_container_novo_dividendo');

	conteudoContainerDividendo.style.display="none";
	conteudoContainerNovoDividendo.style.display="block";

}

function closeDividendo(){

	var conteudoContainer = document.getElementById('conteudo_container');
	var conteudoContainerDividendo = document.getElementById('conteudo_container_dividendo');

	conteudoContainer.style.display="block";
	conteudoContainerDividendo.style.display="none";
}

function closeEditDividendo(){

	var conteudoContainerDividendo = document.getElementById('conteudo_container_dividendo');
	var conteudoContainerEditDividendo = document.getElementById('conteudo_container_edit_dividendo');

	conteudoContainerDividendo.style.display="block";
	conteudoContainerEditDividendo.style.display="none";
	
}

function closeNewDividendo(){

	var conteudoContainerDividendo = document.getElementById('conteudo_container_dividendo');
	var conteudoContainerNovoDividendo = document.getElementById('conteudo_container_novo_dividendo');

	conteudoContainerDividendo.style.display="block";
	conteudoContainerNovoDividendo.style.display="none";

}

/* =============== INTERA????ES COM OS EXTRAS INFORMATIVOS =============== */

function openExtra(){

	var conteudoContainer = document.getElementById('conteudo_container');
	var conteudoContainerExtra = document.getElementById('conteudo_container_extra');

	conteudoContainer.style.display="none";
	conteudoContainerExtra.style.display="block";
}

function editExtra(id, desc, val, freq){

	var conteudoContainerExtra = document.getElementById('conteudo_container_extra');
	var conteudoContainerEditExtra = document.getElementById('conteudo_container_edit_extra');

	var extraTitulo = document.getElementById('conteudo_titulo_text_edit_extra');
	var extraId = document.getElementById('edit_extra_id');
	var extraIdDelete = document.getElementById('extra_id_delete');
	var extraDescricao = document.getElementById('edit_extra_descricao');
	var extraValor = document.getElementById('edit_extra_valor');
	var extraPeriodicidade = document.getElementById('edit_extra_frequencia');

	extraTitulo.innerText=desc;
	extraId.value=id;
	extraIdDelete.value=id;
	extraDescricao.value=desc;
	extraValor.value=val;
	extraPeriodicidade.value=freq;	

	conteudoContainerExtra.style.display="none";
	conteudoContainerEditExtra.style.display="block";

}

function clickOnNewExtra(){

	var conteudoContainerExtra = document.getElementById('conteudo_container_extra');
	var conteudoContainerNovoExtra = document.getElementById('conteudo_container_novo_extra');

	conteudoContainerExtra.style.display="none";
	conteudoContainerNovoExtra.style.display="block";

}

function closeExtra(){

	var conteudoContainer = document.getElementById('conteudo_container');
	var conteudoContainerExtra = document.getElementById('conteudo_container_extra');

	conteudoContainer.style.display="block";
	conteudoContainerExtra.style.display="none";
}

function closeEditExtra(){

	var conteudoContainerExtra = document.getElementById('conteudo_container_extra');
	var conteudoContainerEditExtra = document.getElementById('conteudo_container_edit_extra');

	conteudoContainerExtra.style.display="block";
	conteudoContainerEditExtra.style.display="none";
	
}

function closeNewExtra(){

	var conteudoContainerExtra = document.getElementById('conteudo_container_extra');
	var conteudoContainerNovoExtra = document.getElementById('conteudo_container_novo_extra');

	conteudoContainerExtra.style.display="block";
	conteudoContainerNovoExtra.style.display="none";

}

/* =============== INTERA????ES COM OS OUTROS INFORMATIVOS =============== */

function openOutro(){

	var conteudoContainer = document.getElementById('conteudo_container');
	var conteudoContainerOutro = document.getElementById('conteudo_container_outro');

	conteudoContainer.style.display="none";
	conteudoContainerOutro.style.display="block";
}

function editOutro(id, desc, val, freq){

	var conteudoContainerOutro = document.getElementById('conteudo_container_outro');
	var conteudoContainerEditOutro = document.getElementById('conteudo_container_edit_outro');

	var outroTitulo = document.getElementById('conteudo_titulo_text_edit_outro');
	var outroId = document.getElementById('edit_outro_id');
	var outroIdDelete = document.getElementById('outro_id_delete');
	var outroDescricao = document.getElementById('edit_outro_descricao');
	var outroValor = document.getElementById('edit_outro_valor');
	var outroPeriodicidade = document.getElementById('edit_outro_frequencia');

	outroTitulo.innerText=desc;
	outroId.value=id;
	outroIdDelete.value=id;
	outroDescricao.value=desc;
	outroValor.value=val;
	outroPeriodicidade.value=freq;

	conteudoContainerOutro.style.display="none";
	conteudoContainerEditOutro.style.display="block";

}

function clickOnNewOutro(){

	var conteudoContainerOutro = document.getElementById('conteudo_container_outro');
	var conteudoContainerNovoOutro = document.getElementById('conteudo_container_novo_outro');

	conteudoContainerOutro.style.display="none";
	conteudoContainerNovoOutro.style.display="block";

}

function closeOutro(){

	var conteudoContainer = document.getElementById('conteudo_container');
	var conteudoContainerOutro = document.getElementById('conteudo_container_outro');

	conteudoContainer.style.display="block";
	conteudoContainerOutro.style.display="none";
}

function closeEditOutro(){

	var conteudoContainerOutro = document.getElementById('conteudo_container_outro');
	var conteudoContainerEditOutro = document.getElementById('conteudo_container_edit_outro');

	conteudoContainerOutro.style.display="block";
	conteudoContainerEditOutro.style.display="none";
	
}

function closeNewOutro(){

	var conteudoContainerOutro = document.getElementById('conteudo_container_outro');
	var conteudoContainerNovoOutro = document.getElementById('conteudo_container_novo_outro');

	conteudoContainerOutro.style.display="block";
	conteudoContainerNovoOutro.style.display="none";

}