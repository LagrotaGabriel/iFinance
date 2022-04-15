/* =========================== RESPONSIVIDADE DA TELA =========================== */

window.onload = responsive();
window.onresize = doALoadOfStuff;

function responsive(){

	document.getElementById('body').style.display="block";

	bodyWidth = document.getElementById('body').clientWidth;
	bodyHeight = document.getElementById('body').clientHeight;

	/* Ajustando content */
	var tamanhoMain = document.getElementById('main');
	var tamanhoAside = document.getElementById('side_menu');
	var tamanhoMenuSuperior = document.getElementById('menu_superior');
	var tamanhoMenuResponsivo = document.getElementById('menu_superior_responsivo');
	var tamanhoTituloPathContainer = document.getElementById('titulo_path_container');
	var tamanhoConteudoContainer = document.getElementById('conteudo_container');
	var tamanhoConteudoTitulo = document.getElementById('conteudo_titulo');
	var tamanhoInfosPerfil1 = document.getElementById('infos_perfil1');
	var tamanhoInfosPerfil2 = document.getElementById('infos_perfil2');
	var tituloLinhaGeralClicavel = document.getElementById('titulo_linha_geral_clicavel');
	var tamanhoInformativos = document.getElementById('informativos');
	var tamanhoSideMenu = document.getElementById('side_menu');
	var tamanhoContainerAlign = document.getElementById('container_align');

	tamanhoConteudoContainer.style.height = parseInt(parseInt(tamanhoConteudoTitulo.clientHeight) + parseInt(informativos.clientHeight) + 30) + 'px';

	if(tamanhoMenuSuperior.clientHeight == 0){
		//tamanhoMain.style.height=parseInt(parseInt(tamanhoConteudoContainer.clientHeight + parseInt(tamanhoMenuResponsivo)) + 'px');
		var somaTamanho = (tamanhoMain.clientHeight - tamanhoMenuResponsivo.clientHeight) + 'px';
		tamanhoContainerAlign.style.height = somaTamanho;
	}
	else{
		//tamanhoMain.style.height=parseInt(parseInt(tamanhoConteudoContainer.clientHeight + parseInt(tamanhoMenuSuperior)) + 'px');
		var somaTamanho = (tamanhoAside.clientHeight - tamanhoMenuSuperior.clientHeight) + 'px';
		tamanhoContainerAlign.style.height = somaTamanho;
	}

	

	var imagens_title = document.getElementsByClassName('aside_title');
	var menu_responsivo_item = document.getElementsByClassName('sup_sup');

	if(bodyWidth > 1200){
		console.log('Muito grande')
		tamanhoContainerAlign.style.alignItems="center";
		tamanhoContainerAlign.style.marginTop="0px";
		document.getElementById('side_menu').hidden=false;
		document.getElementById('menu_superior').hidden=false;
		document.getElementById('menu_superior_responsivo').hidden=true;
		document.getElementById('conteudo_titulo_text').style.fontSize="2rem";
		for(var j = 0; j < imagens_title.length; j++){
			imagens_title[j].style.fontSize="0.90rem";
		}
	}
	else if(bodyWidth <= 1200 && bodyWidth > 992){
		console.log('Grande');
		tamanhoContainerAlign.style.alignItems="center";
		tamanhoContainerAlign.style.marginTop="0px";
		document.getElementById('side_menu').hidden=false;
		document.getElementById('menu_superior').hidden=false;
		document.getElementById('menu_superior_responsivo').hidden=true;
		document.getElementById('conteudo_titulo_text').style.fontSize="2rem";
		for(var j = 0; j < imagens_title.length; j++){
			imagens_title[j].style.fontSize="0.70rem";
		}
	}
	else if(bodyWidth <= 992 && bodyWidth > 768){
		console.log('Médio');
		tamanhoContainerAlign.style.alignItems="center";
		tamanhoContainerAlign.style.marginTop="0px";
		document.getElementById('side_menu').hidden=true;
		document.getElementById('menu_superior').hidden=true;
		document.getElementById('menu_superior_responsivo').hidden=false;
		document.getElementById('conteudo_titulo_text').style.fontSize="2rem";
		for(var i = 0; i < menu_responsivo_item.length; i++){
			menu_responsivo_item[i].style.fontSize="0.85rem";
		}
	}
	else if(bodyWidth <= 768 && bodyWidth > 540){
		console.log('Pequeno');
		tamanhoContainerAlign.style.alignItems="flex-start";
		tamanhoContainerAlign.style.marginTop="30px";
		document.getElementById('side_menu').hidden=true;
		document.getElementById('menu_superior').hidden=true;
		document.getElementById('menu_superior_responsivo').hidden=false;
		document.getElementById('conteudo_titulo_text').style.fontSize="1.5rem";
		for(var i = 0; i < menu_responsivo_item.length; i++){
			menu_responsivo_item[i].style.fontSize="0.75rem";
		}
	}
	else if(bodyWidth < 540){
		console.log('Muito pequeno');
		tamanhoContainerAlign.style.alignItems="flex-start";
		tamanhoContainerAlign.style.marginTop="30px";
		document.getElementById('side_menu').hidden=true;
		document.getElementById('menu_superior').hidden=true;
		document.getElementById('menu_superior_responsivo').hidden=false;
		document.getElementById('conteudo_titulo_text').style.fontSize="1.25rem";
		for(var i = 0; i < menu_responsivo_item.length; i++){
			menu_responsivo_item[i].style.fontSize="0.65rem";
		}
	}
}

function doALoadOfStuff() {
	responsive();
}

/* =================== INTERAÇÕES COM O MENU LATERAL ESQUERDO =================== */

function animateMenu(item){

	if(item == "balanco"){
		document.getElementById("img_aside_balanco").src="img/balance.png";
		document.getElementById("img_aside_balanco").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_balanco").style.color="#121212";
	}
	else if(item == "estatisticas"){
		document.getElementById("img_aside_estatisticas").src="img/stats.png";
		document.getElementById("img_aside_estatisticas").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_estatisticas").style.color="#121212";
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
	else if(item == "rentabilidade"){
		document.getElementById("img_aside_rentabilidade").src="img/bull.png";
		document.getElementById("img_aside_rentabilidade").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_rentabilidade").style.color="#121212";
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
		document.getElementById("img_aside_estatisticas").src="img/statsblue.png";
		document.getElementById("img_aside_estatisticas").style.animation="none";
		titulos[2].style.color="#00ccff";
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
	else if(item == "rentabilidade"){
		document.getElementById("img_aside_rentabilidade").src="img/bullblue.png";
		document.getElementById("img_aside_rentabilidade").style.animation="none";
		titulos[5].style.color="#00ccff";
	}
	else if(item == "configuracoes"){
		document.getElementById("img_aside_configuracoes").src="img/settingsblue.png";
		document.getElementById("img_aside_configuracoes").style.animation="none";
		titulos[6].style.color="#00ccff";
	}
}

/* =================== INTERAÇÕES COM O CONTEÚDO =================== */

function animateContent(item){

	if(item == 1){
		document.getElementById("maisinfo_item_rendamensal").style.background="#00CCFF";
		document.getElementById("maisinfo_item_rendamensal_clicavel").style.color="#121212";
		document.getElementById("maisinfo_item_rendamensal_clicavel").style.transition="1s";
		document.getElementById("maisinfo_item_rendamensal").style.transition="1s";
		document.getElementById("conteudo_item_total_rendamensal").style.cursor="pointer";
	}
	else if(item == 2){
		document.getElementById("maisinfo_item_despesas").style.background="#00CCFF";
		document.getElementById("maisinfo_item_despesas_clicavel").style.color="#121212";
		document.getElementById("maisinfo_item_despesas_clicavel").style.transition="1s";
		document.getElementById("maisinfo_item_despesas").style.transition="1s";
		document.getElementById("conteudo_item_total_despesas").style.cursor="pointer";
	}
	else if(item == 3){
		document.getElementById("maisinfo_item_contasapagar").style.background="#00CCFF";
		document.getElementById("maisinfo_item_contasapagar_clicavel").style.color="#121212";
		document.getElementById("maisinfo_item_contasapagar_clicavel").style.transition="1s";
		document.getElementById("maisinfo_item_contasapagar").style.transition="1s";
		document.getElementById("conteudo_item_total_contasapagar").style.cursor="pointer";
	}
	else if(item == 4){
		document.getElementById("maisinfo_item_recebido").style.background="#00CCFF";
		document.getElementById("maisinfo_item_recebido_clicavel").style.color="#121212";
		document.getElementById("maisinfo_item_recebido_clicavel").style.transition="1s";
		document.getElementById("maisinfo_item_recebido").style.transition="1s";
		document.getElementById("conteudo_item_total_recebido").style.cursor="pointer";
	}
	else if(item == 5){
		document.getElementById("maisinfo_item_receber").style.background="#00CCFF";
		document.getElementById("maisinfo_item_receber_clicavel").style.color="#121212";
		document.getElementById("maisinfo_item_receber_clicavel").style.transition="1s";
		document.getElementById("maisinfo_item_receber").style.transition="1s";
		document.getElementById("conteudo_item_total_receber").style.cursor="pointer";
	}
	else if(item == 6){
		document.getElementById("maisinfo_item_contasatrasadas").style.background="#00CCFF";
		document.getElementById("maisinfo_item_contasatrasadas_clicavel").style.color="#121212";
		document.getElementById("maisinfo_item_contasatrasadas_clicavel").style.transition="1s";
		document.getElementById("maisinfo_item_contasatrasadas").style.transition="1s";
		document.getElementById("conteudo_item_total_contasatrasadas").style.cursor="pointer";
	}

}

function returnContentState(item){

	if(item == 1){
		document.getElementById("maisinfo_item_rendamensal").style.background="transparent";
		document.getElementById("maisinfo_item_rendamensal_clicavel").style.color="#FFFFFF";
		document.getElementById("maisinfo_item_rendamensal_clicavel").style.transition="1s";
		document.getElementById("maisinfo_item_rendamensal").style.transition="1s";
	}
	else if(item == 2){
		document.getElementById("maisinfo_item_despesas").style.background="transparent";
		document.getElementById("maisinfo_item_despesas_clicavel").style.color="#FFFFFF";
		document.getElementById("maisinfo_item_despesas_clicavel").style.transition="1s";
		document.getElementById("maisinfo_item_despesas").style.transition="1s";
	}
	else if(item == 3){
		document.getElementById("maisinfo_item_contasapagar").style.background="transparent";
		document.getElementById("maisinfo_item_contasapagar_clicavel").style.color="#FFFFFF";
		document.getElementById("maisinfo_item_contasapagar_clicavel").style.transition="1s";
		document.getElementById("maisinfo_item_contasapagar").style.transition="1s";
	}
	else if(item == 4){
		document.getElementById("maisinfo_item_recebido").style.background="transparent";
		document.getElementById("maisinfo_item_recebido_clicavel").style.color="#FFFFFF";
		document.getElementById("maisinfo_item_recebido_clicavel").style.transition="1s";
		document.getElementById("maisinfo_item_recebido").style.transition="1s";
	}
	else if(item == 5){
		document.getElementById("maisinfo_item_receber").style.background="transparent";
		document.getElementById("maisinfo_item_receber_clicavel").style.color="#FFFFFF";
		document.getElementById("maisinfo_item_receber_clicavel").style.transition="1s";
		document.getElementById("maisinfo_item_receber").style.transition="1s";
	}
	else if(item == 6){
		document.getElementById("maisinfo_item_contasatrasadas").style.background="transparent";
		document.getElementById("maisinfo_item_contasatrasadas_clicavel").style.color="#FFFFFF";
		document.getElementById("maisinfo_item_contasatrasadas_clicavel").style.transition="1s";
		document.getElementById("maisinfo_item_contasatrasadas").style.transition="1s";
	}
}