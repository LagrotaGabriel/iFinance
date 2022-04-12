/* =========================== RESPONSIVIDADE DA TELA =========================== */

responsive(document.getElementById('body').clientHeight, document.getElementById('body').clientWidth)
window.onresize = doALoadOfStuff;

function responsive(bodyHeight, bodyWidth){

	/* Ajustando content */
	var tamanhoMain = document.getElementById('main');
	var tamanhoAside = document.getElementById('side_menu');
	var tamanhoMenuSuperior = document.getElementById('menu_superior');
	var tamanhoMenuResponsivo = document.getElementById('menu_superior_responsivo');
	var tamanhoConteudoContainer = document.getElementById('conteudo_container');
	var tamanhoConteudoTitulo = document.getElementById('conteudo_titulo');
	var tamanhoSideMenu = document.getElementById('side_menu');
	var tamanhoContainerAlign = document.getElementById('container_align');

	tamanhoConteudoContainer.style.height = parseInt(parseInt(tamanhoConteudoTitulo.clientHeight) + 'px');

	if(tamanhoMenuSuperior.clientHeight == 0){
		var somaTamanho = (tamanhoMain.clientHeight - tamanhoMenuResponsivo.clientHeight) + 'px';
		tamanhoContainerAlign.style.height = somaTamanho;
	}
	else{
		var somaTamanho = (tamanhoAside.clientHeight - tamanhoMenuSuperior.clientHeight) + 'px';
		tamanhoContainerAlign.style.height = somaTamanho;
	}

	

	var imagens_title = document.getElementsByClassName('aside_title');
	var menu_responsivo_item = document.getElementsByClassName('sup_sup');
	var meses = document.getElementsByClassName('mes_opc');
	var mesesLetra = ["J", "F", "M", "A", "M", "J", "J", "A", "S", "O", "N", "D"]
	var mesesPalavra = ["Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"];
	var th = document.getElementsByClassName('th');
	var thTipo = document.getElementById('th_tipo');
	var tdTipo = document.getElementsByClassName('td_tipo');
	var botoesOpc = document.getElementsByClassName('botoes_opc');
	var selectOpc = document.getElementsByClassName('select_opc');

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
		thTipo.hidden=false;		
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
		thTipo.hidden=false;		
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
		thTipo.hidden=false;		
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
		for(var i = 0; i < meses.length; i++){
			meses[i].style.fontSize="0.75rem";
			meses[i].text=mesesPalavra[i];
		}
		for(var i = 0; i < th.length; i++){
			th[i].style.fontSize="1rem";
		}
		for(var i = 0; i < tdTipo.length; i++){
			tdTipo[i].hidden=false;
		}
		for(var i = 0; i < botoesOpc.length; i++){
			botoesOpc[i].style.fontSize="0.85rem";
		}
		for(var i = 0; i < selectOpc.length; i++){
			selectOpc[i].style.fontSize="0.85rem";
		}
		thTipo.hidden=false;
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
		for(var i = 0; i < meses.length; i++){
			meses[i].style.fontSize="0.75rem";
			meses[i].text=mesesLetra[i];
		}
		for(var i = 0; i < th.length; i++){
			th[i].style.fontSize="0.85rem";
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
		thTipo.hidden=true;
	}

}

function doALoadOfStuff() {
	responsive(document.getElementById('body').clientHeight, document.getElementById('body').clientWidth);
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
	else if(item == "patrimonio"){
		document.getElementById("img_aside_patrimonio").src="../static/img/shelter.png";
		document.getElementById("img_aside_patrimonio").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_patrimonio").style.color="#121212";
	}
	else if(item == "rentabilidade"){
		document.getElementById("img_aside_rentabilidade").src="../static/img/bull.png";
		document.getElementById("img_aside_rentabilidade").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_rentabilidade").style.color="#121212";
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
	else if(item == "patrimonio"){
		document.getElementById("img_aside_patrimonio").src="../static/img/shelterblue.png";
		document.getElementById("img_aside_patrimonio").style.animation="none";
		titulos[4].style.color="#00ccff";
	}
	else if(item == "rentabilidade"){
		document.getElementById("img_aside_rentabilidade").src="../static/img/bullblue.png";
		document.getElementById("img_aside_rentabilidade").style.animation="none";
		titulos[5].style.color="#00ccff";
	}
	else if(item == "configuracoes"){
		document.getElementById("img_aside_configuracoes").src="../static/img/settingsblue.png";
		document.getElementById("img_aside_configuracoes").style.animation="none";
		titulos[6].style.color="#00ccff";
	}
}