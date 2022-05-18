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
	var mainRow = document.getElementById('main_row');
	var tamanhoAside = document.getElementById('side_menu');
	var tamanhoMenuSuperior = document.getElementById('menu_superior');
	var tamanhoMenuResponsivo = document.getElementById('menu_superior_responsivo');
	var tamanhoConteudoContainer = document.getElementById('conteudo_container');
	var tamanhoConteudoTitulo = document.getElementById('conteudo_titulo');
	var tamanhoSideMenu = document.getElementById('side_menu');
	var tamanhoContainerAlign = document.getElementById('container_align');

	//tamanhoConteudoContainer.style.height = "90%";
	var imagens_title = document.getElementsByClassName('aside_title');
	var menu_responsivo_item = document.getElementsByClassName('sup_sup');
	var meses = document.getElementsByClassName('mes_opc');
	var mesesLetra = ["J", "F", "M", "A", "M", "J", "J", "A", "S", "O", "N", "D"]
	var mesesPalavra = ["Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"];
	var th = document.getElementsByClassName('th');
	var td = document.getElementsByClassName('td');
	var btnExcluir = document.getElementsByClassName('btn_excluir');
	var thTipo = document.getElementById('th_forma');
	var tdTipo = document.getElementsByClassName('td_mean');
	var botoesOpc = document.getElementsByClassName('botoes_opc');
	var selectOpc = document.getElementsByClassName('select_opc');
	var novoLabel = document.getElementsByClassName('novo_label');
	var novoInput = document.getElementsByClassName('novo_input');
	var pageClick = document.getElementsByClassName('page_click');

	var dadosContainer = document.getElementsByClassName('dados_container');
	var informativosDataSegundaCol = document.getElementById('informativos_data_segunda_col');

	var li = document.getElementsByClassName('li');
	var liA = document.getElementsByClassName('li_a');


	if(bodyWidth > 1200){

		console.log("Muito grande");
		
		tamanhoContainerAlign.style.alignItems="initial";
		tamanhoContainerAlign.style.marginTop="30px";
		tamanhoContainerAlign.style.marginBottom="30px";
		
		document.getElementById('side_menu').style.display="flex"
		document.getElementById('menu_superior').style.display="flex";
		document.getElementById('menu_superior_responsivo').style.display="none";
		document.getElementById('conteudo_titulo_text').style.fontSize="2rem";
		for(var j = 0; j < imagens_title.length; j++){
			imagens_title[j].style.fontSize="0.90rem";
		}
		for(var i = 0; i < meses.length; i++){
			meses[i].style.fontSize="1rem";
			meses[i].text=mesesPalavra[i];
		}
		for(var i = 0; i < th.length; i++){
			th[i].style.fontSize="1.25rem";
		}
		for(var i = 0; i < tdTipo.length; i++){
			tdTipo[i].hidden=false;
		}
		for(var i = 0; i < botoesOpc.length; i++){
			botoesOpc[i].style.fontSize="1rem";
		}
		for(var i = 0; i < selectOpc.length; i++){
			selectOpc[i].style.fontSize="1rem";
		}
		for(var i = 0; i < novoLabel.length; i++){
			novoLabel[i].style.fontSize="1.15rem";
			novoInput[i].style.fontSize="1rem";
		}
		for(var i = 0; i < liA.length; i++){
			liA[i].style.fontSize="1rem";
		}	
		for(var i = 0; i < td.length; i++){
			td[i].style.fontSize="0.90rem";
		}
		for(var i = 0; i < btnExcluir.length; i++){
			btnExcluir[i].style.padding="8px 15px";
			btnExcluir[i].innerText="Excluir";
		}

		for(var i = 0; i < pageClick.length; i++){
			pageClick[i].style.fontSize = "1rem";
		}

		for(var i = 0;i < dadosContainer.length; i++){
			dadosContainer[i].style.marginBottom = "0px";
		}
		informativosDataSegundaCol.marginTop="15px";



		if(thTipo != null){
			thTipo.hidden=false;
		}		
	}
	else if(bodyWidth <= 1200 && bodyWidth > 992){

		console.log("Grande");

		tamanhoContainerAlign.style.alignItems="initial";
		tamanhoContainerAlign.style.marginTop="30px";
		tamanhoContainerAlign.style.marginBottom="30px";			

		document.getElementById('side_menu').style.display="flex";
		document.getElementById('menu_superior').style.display="flex";
		document.getElementById('menu_superior_responsivo').style.display="none";
		document.getElementById('conteudo_titulo_text').style.fontSize="2rem";
		for(var j = 0; j < imagens_title.length; j++){
			imagens_title[j].style.fontSize="0.70rem";
		}
		for(var i = 0; i < meses.length; i++){
			meses[i].style.fontSize="1rem";
			meses[i].text=mesesPalavra[i];
		}
		for(var i = 0; i < th.length; i++){
			th[i].style.fontSize="1.15rem";
		}
		for(var i = 0; i < tdTipo.length; i++){
			tdTipo[i].hidden=false;
		}
		for(var i = 0; i < botoesOpc.length; i++){
			botoesOpc[i].style.fontSize="1rem";
		}
		for(var i = 0; i < selectOpc.length; i++){
			selectOpc[i].style.fontSize="1rem";
		}
		for(var i = 0; i < novoLabel.length; i++){
			novoLabel[i].style.fontSize="1.15rem";
			novoInput[i].style.fontSize="1rem";
		}
		for(var i = 0; i < liA.length; i++){
			liA[i].style.fontSize="1rem";
		}
		for(var i = 0; i < td.length; i++){
			td[i].style.fontSize="0.80rem";
		}		
		for(var i = 0; i < btnExcluir.length; i++){
			btnExcluir[i].style.padding="5px 10px";
			btnExcluir[i].innerText="Excluir";
		}

		for(var i = 0; i < pageClick.length; i++){
			pageClick[i].style.fontSize = "0.90rem";
		}
		for(var i = 0;i < dadosContainer.length; i++){
			dadosContainer[i].style.marginBottom = "0px";
		}
		informativosDataSegundaCol.marginTop="15px";				

		if(thTipo != null){
			thTipo.hidden=false;
		}		
	}
	else if(bodyWidth <= 992 && bodyWidth > 768){
		console.log('Médio');
		tamanhoContainerAlign.style.alignItems="initial";
		tamanhoContainerAlign.style.marginTop="30px";
		tamanhoContainerAlign.style.marginBottom="30px";
		document.getElementById('side_menu').style.display="none";
		document.getElementById('menu_superior').style.display="none";
		document.getElementById('menu_superior_responsivo').style.display="flex";
		document.getElementById('conteudo_titulo_text').style.fontSize="2rem";
		for(var i = 0; i < menu_responsivo_item.length; i++){
			menu_responsivo_item[i].style.fontSize="0.85rem";
		}
		for(var i = 0; i < meses.length; i++){
			meses[i].style.fontSize="1rem";
			meses[i].text=mesesPalavra[i];
		}
		for(var i = 0; i < th.length; i++){
			th[i].style.fontSize="1.05rem";
		}
		for(var i = 0; i < tdTipo.length; i++){
			tdTipo[i].hidden=false;
		}
		for(var i = 0; i < botoesOpc.length; i++){
			botoesOpc[i].style.fontSize="1rem";
		}
		for(var i = 0; i < selectOpc.length; i++){
			selectOpc[i].style.fontSize="1rem";
		}
		for(var i = 0; i < novoLabel.length; i++){
			novoLabel[i].style.fontSize="1rem";
			novoInput[i].style.fontSize="0.85rem";
		}		
		for(var i = 0; i < liA.length; i++){
			liA[i].style.fontSize="0.80rem";
		}	
		for(var i = 0; i < td.length; i++){
			td[i].style.fontSize="0.70rem";
		}		
		for(var i = 0; i < btnExcluir.length; i++){
			btnExcluir[i].style.padding="5px 13px";
			btnExcluir[i].innerText="Excluir";
		}

		for(var i = 0; i < pageClick.length; i++){
			pageClick[i].style.fontSize = "0.85rem";
		}	
		for(var i = 0;i < dadosContainer.length; i++){
			dadosContainer[i].style.marginBottom = "0px";
		}
		informativosDataSegundaCol.marginTop="15px";			

		if(thTipo != null){
			thTipo.hidden=false;
		}		
	}
	else if(bodyWidth <= 768 && bodyWidth > 540){
		console.log('Pequeno');
		tamanhoContainerAlign.style.alignItems="initial";
		tamanhoContainerAlign.style.marginTop="30px";
		tamanhoContainerAlign.style.marginBottom="30px";
		document.getElementById('side_menu').style.display="none";
		document.getElementById('menu_superior').style.display="none";
		document.getElementById('menu_superior_responsivo').style.display="flex";
		document.getElementById('conteudo_titulo_text').style.fontSize="1.5rem";
		for(var i = 0; i < menu_responsivo_item.length; i++){
			menu_responsivo_item[i].style.fontSize="0.75rem";
		}
		for(var i = 0; i < meses.length; i++){
			meses[i].style.fontSize="0.75rem";
			meses[i].text=mesesPalavra[i];
		}
		for(var i = 0; i < th.length; i++){
			th[i].style.fontSize="1rem";
		}
		for(var i = 0; i < tdTipo.length; i++){
			tdTipo[i].hidden=true;
		}
		for(var i = 0; i < botoesOpc.length; i++){
			botoesOpc[i].style.fontSize="0.85rem";
		}
		for(var i = 0; i < selectOpc.length; i++){
			selectOpc[i].style.fontSize="0.85rem";
		}
		for(var i = 0; i < novoLabel.length; i++){
			novoLabel[i].style.fontSize="0.90rem";
			novoInput[i].style.fontSize="0.75rem";
		}		
		for(var i = 0; i < liA.length; i++){
			liA[i].style.fontSize="0.70rem";
			li[i].style.margin="0 5px";			
		}	
		for(var i = 0; i < td.length; i++){
			td[i].style.fontSize="0.70rem";
		}		
		for(var i = 0; i < btnExcluir.length; i++){
			btnExcluir[i].style.padding="5px 10px";
			btnExcluir[i].innerText="X";
		}

		for(var i = 0; i < pageClick.length; i++){
			pageClick[i].style.fontSize = "0.80rem";
		}	
		for(var i = 0;i < dadosContainer.length; i++){
			dadosContainer[i].style.marginBottom = "15px";
		}
		dadosContainer[2].style.marginBottom = "0";
		informativosDataSegundaCol.marginTop="0";		


		if(thTipo != null){
			thTipo.hidden=true;
		}	
	}
	else if(bodyWidth < 540){
		console.log('Muito pequeno');
		tamanhoContainerAlign.style.alignItems="initial";
		tamanhoContainerAlign.style.marginTop="30px";
		tamanhoContainerAlign.style.marginBottom="30px";
		document.getElementById('side_menu').style.display="none";
		document.getElementById('menu_superior').style.display="none";
		document.getElementById('menu_superior_responsivo').style.display="flex";
		document.getElementById('conteudo_titulo_text').style.fontSize="1.25rem";
		for(var i = 0; i < menu_responsivo_item.length; i++){
			menu_responsivo_item[i].style.fontSize="0.50rem";
		}
		for(var i = 0; i < meses.length; i++){
			meses[i].style.fontSize="0.75rem";
			meses[i].text=mesesLetra[i];
		}
		for(var i = 0; i < th.length; i++){
			th[i].style.fontSize="0.70rem";
		}
		for(var i = 0; i < tdTipo.length; i++){
			tdTipo[i].hidden=true;
		}
		for(var i = 0; i < botoesOpc.length; i++){
			botoesOpc[i].style.fontSize="0.75rem";
		}
		for(var i = 0; i < selectOpc.length; i++){
			selectOpc[i].style.fontSize="0.75rem";
		}
		for(var i = 0; i < novoLabel.length; i++){
			novoLabel[i].style.fontSize="0.70rem";
			novoInput[i].style.fontSize="0.65rem";
		}		
		for(var i = 0; i < liA.length; i++){
			liA[i].style.fontSize="0.65rem";
			li[i].style.margin="0 5px";
		}
		for(var i = 0; i < td.length; i++){
			td[i].style.fontSize="0.60rem";
		}		
		for(var i = 0; i < btnExcluir.length; i++){
			btnExcluir[i].style.padding="5px 10px";
			btnExcluir[i].innerText="X";
		}

		for(var i = 0; i < pageClick.length; i++){
			pageClick[i].style.fontSize = "0.75rem";
		}	
		for(var i = 0;i < dadosContainer.length; i++){
			dadosContainer[i].style.marginBottom = "15px";
		}
		dadosContainer[2].style.marginBottom = "0";
		informativosDataSegundaCol.marginTop="0";					

		if(thTipo != null){
			thTipo.hidden=true;
		}	

		
	}

	sexoAtual();

}

function doALoadOfStuff() {
	document.getElementById('conteudo_container').style.transition="2s";
	responsive();
}

/* =================== INTERAÇÕES COM O MENU LATERAL ESQUERDO =================== */

function animateMenu(item){

	if(item == "balanco"){
		document.getElementById("img_aside_balanco").src="img/balance.png";
		document.getElementById("img_aside_balanco").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_balanco").style.color="#121212";
	}
	else if(item == "entradas"){
		document.getElementById("img_aside_estatisticas").src="img/money.png";
		document.getElementById("img_aside_estatisticas").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_estatisticas").style.color="#121212";
	}
	else if(item == "renda"){
		document.getElementById("img_aside_rentabilidade").src="img/bull.png";
		document.getElementById("img_aside_rentabilidade").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_rentabilidade").style.color="#121212";
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
		else if(item == "entradas"){
		document.getElementById("img_aside_estatisticas").src="img/moneyblue.png";
		document.getElementById("img_aside_estatisticas").style.animation="none";
	}
	else if(item == "renda"){
		document.getElementById("img_aside_rentabilidade").src="img/bullblue.png";
		document.getElementById("img_aside_rentabilidade").style.animation="none";
		titulos[5].style.color="#00ccff";
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

/* =================== ABERTURA E FECHAMENTO DO NOVA DESPESA =================== */

/* =================== FECHAMENTO DOS ALERTAS =================== */

function hideMessage(){
	var alertas = document.getElementsByClassName('alert');
	for(var i = 0; i < alertas.length; i++){
		alertas[i].hidden=true;
	}
}


function animateButton(id){

	var item = document.getElementById(id);
	item.style.background = "#00CCFF";
	item.style.color = "#121212";
	item.style.transition = "1s";

}

function animateButtonLeave(id){

	var item = document.getElementById(id);

	if(id == 'mes_opc_jan' 
		|| id == 'mes_opc_fev' 
		|| id == 'mes_opc_mar' 
		|| id == 'mes_opc_abr' 
		|| id == 'mes_opc_mai' 
		|| id == 'mes_opc_jun'
		|| id == 'mes_opc_jul'
		|| id == 'mes_opc_ago'
		|| id == 'mes_opc_set'
		|| id == 'mes_opc_out'
		|| id == 'mes_opc_nov'
		|| id == 'mes_opc_dez'){

		item.style.background = "transparent";
		item.style.color = "#FFFFFF";
		item.style.transition = "1s";

		var meses = document.getElementsByClassName('mes_opc');
		var mesSelecionado = document.getElementById('pegando_mes').innerText;
		for(var i = 0; i < meses.length; i++){
			meses[i].style.background="transparent";
			meses[i].style.color="#FFFFFF";
		}

		meses[mesSelecionado-1].style.background="#00CCFF";
		meses[mesSelecionado-1].style.color="#121212";		
	}
	else if(id == 'ano_2023'
		|| id == 'ano_2022'
		|| id == 'ano_2021'){

		item.style.background = "transparent";
		item.style.color = "#FFFFFF";
		item.style.transition = "1s";

		var anos = document.getElementsByClassName('select_opc');
		var anoSelecionado = document.getElementById('pegando_ano').innerText;
		for(var i = 0; i < anos.length; i++){
			anos[i].style.background="transparent";
			anos[i].style.color="#FFFFFF";
			if(anos[i].innerText == anoSelecionado){
				anos[i].style.background="#00CCFF";
				anos[i].style.color="#121212";
			}
		}
	}
	else{
		item.style.background = "transparent";
		item.style.color = "#FFFFFF";
		item.style.transition = "1s";
	}
}

function selectSexo(){
	var sexo = document.getElementById('select_sexo').value;
	if(sexo == 'M'){
		document.getElementById("img_user").src="img/man.png";
		document.getElementById('m').style.selected=true;	
	}
	else if(sexo == 'F'){
		document.getElementById("img_user").src="img/woman.png";
		document.getElementById('f').style.selected=true;
	}
}

function sexoAtual(){

	if(document.getElementById('sexo').innerText == 'M'){
		document.getElementById("img_user").src="img/man.png";
		document.getElementById('m').selected=true;
	}

	else if(document.getElementById('sexo').innerText == 'F'){
		document.getElementById("img_user").src="img/woman.png";
		document.getElementById('f').selected=true;
	}	
}