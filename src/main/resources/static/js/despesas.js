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

		if(thTipo != null){
			thTipo.hidden=true;
		}	
	}

	mesResponsivo();
	anoResponsivo();
	pageResponsiva();
	ajustaTabela();

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
	else if(item == "estatisticas"){
		document.getElementById("img_aside_estatisticas").src="img/stats.png";
		document.getElementById("img_aside_estatisticas").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_estatisticas").style.color="#121212";
	}
	else if(item == "principal"){
		document.getElementById("img_aside_principal").src="img/house.png";
		document.getElementById("img_aside_principal").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_principal").style.color="#121212";
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
	else if(item == "principal"){
		document.getElementById("img_aside_principal").src="img/houseblue.png";
		document.getElementById("img_aside_principal").style.animation="none";
		titulos[0].style.color="#00ccff";
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

/* =================== ABERTURA E FECHAMENTO DO NOVA DESPESA =================== */

function novaDespesa(){

	var conteudoContainer = document.getElementById('conteudo_container');
	var containerNovo = document.getElementById('container_novo');
	var botoesOpc = document.getElementsByClassName('botoes_opc');
	var selectOpc = document.getElementsByClassName('select_opc');
	var meses = document.getElementsByClassName('mes_opc');

	conteudoContainer.style.pointerEvents="none";
	conteudoContainer.style.opacity="0";
	conteudoContainer.style.transition="2s";
	containerNovo.style.display="block";
	containerNovo.style.transition="2s";

}

function fechaNovaDespesa(){

	var conteudoContainer = document.getElementById('conteudo_container');
	var containerNovo = document.getElementById('container_novo');
	var botoesOpc = document.getElementsByClassName('botoes_opc');
	var selectOpc = document.getElementsByClassName('select_opc');
	var meses = document.getElementsByClassName('mes_opc');

	conteudoContainer.style.pointerEvents="auto";
	conteudoContainer.style.opacity="0.96";
	conteudoContainer.style.transition="2s";
	containerNovo.style.display="none";
	containerNovo.style.transition="2s";

}

/* =================== ABERTURA E FECHAMENTO DO EDIT =================== */

function editDespesa(id, descricao, status, valor, forma, data, agendamento){

	console.log(id);
	console.log(descricao);
	console.log(status);
	console.log(valor);
	console.log(forma);
	console.log(data);
	console.log(agendamento);

	var conteudoContainer = document.getElementById('conteudo_container');
	var containerEdit = document.getElementById('container_edit');
	var botoesOpc = document.getElementsByClassName('botoes_opc');
	var selectOpc = document.getElementsByClassName('select_opc');
	var meses = document.getElementsByClassName('mes_opc');

	conteudoContainer.style.pointerEvents="none";
	conteudoContainer.style.opacity="0";
	conteudoContainer.style.transition="2s";
	containerEdit.style.display="block";
	containerEdit.style.transition="2s";

	// ============================================================== //
	
	var labelAgendamento = document.getElementById('edit_label_agendamento');
	var inputAgendamento = document.getElementById('edit_input_agendamento');

	var labelData = document.getElementById('edit_label_data');
	var inputData = document.getElementById('edit_input_data');

	var labelForma = document.getElementById('edit_label_forma');
	var inputForma = document.getElementById('edit_input_forma');

	if(data != null){
		var novaData = data.split('/').reverse().join('-');
	}		

	if(agendamento != null){
		var novoAgendamento = agendamento.split('/').reverse().join('-');
	}

	if(status == "Pago"){

		document.getElementById('Pago').selected=true;

		labelAgendamento.style.color="grey";
		inputAgendamento.value="";
		inputAgendamento.disabled=true;
		inputAgendamento.style.border="1px solid grey";
		inputAgendamento.style.color="grey";

		labelData.style.color="#FFFFFF";
		inputData.disabled=false;
		inputData.style.border="1px solid #00CCFF";
		inputData.style.color="#FFFFFF";
		inputData.value=novaData;

		labelForma.style.color="#FFFFFF";
		inputForma.disabled=false;
		inputForma.value="Dinheiro";
		inputForma.style.border="1px solid #00CCFF";
		inputForma.style.color="#FFFFFF";
		
		// DEFININDO O FORMA
		if(forma == "Espécie"){
			document.getElementById('dinheiro').selected=true;
		}
		else if(forma == "Cartão de débito"){
			document.getElementById('debito').selected=true;
		}
		else if(forma == "Cartão de crédito"){
			document.getElementById('credito').selected=true;
		}
		else if(forma == "Transferência via PIX"){
			document.getElementById('pix').selected=true;
		}
		else if(forma == "Cheque"){
			document.getElementById('cheque').selected=true;
		}	
		else if(forma == "Transferência via TED"){
			document.getElementById('ted').selected=true;
		}
		else if(forma == "Transferência via DOC"){
			document.getElementById('doc').selected=true;
		}
		else if(forma == "Boleto"){
			document.getElementById('boleto').selected=true;
		}
		else if(forma == "Outro"){
			document.getElementById('outro').selected=true;
		}							

		inputData.value=novaData;
	}

	else if(status == "A pagar"){

		document.getElementById('Pagar').selected=true;

		labelAgendamento.style.color="#FFFFFF";
		inputAgendamento.disabled=false;
		inputAgendamento.style.border="1px solid #00CCFF";
		inputAgendamento.style.color="#FFFFFF";
		inputAgendamento.value=novoAgendamento;

		labelData.style.color="grey";
		inputData.value="";
		inputData.disabled=true;
		inputData.style.border="1px solid grey";
		inputData.style.color="grey";

		labelForma.style.color="grey";
		inputForma.value="";
		inputForma.disabled=true;
		inputForma.style.border="1px solid grey";
		inputForma.style.color="grey";						
	}	

	// ============================================================== //
	
	var inputDescricao = document.getElementById('edit_input_descricao');
	inputDescricao.value=descricao;

	var inputValor = document.getElementById('edit_input_valor');
	inputValor.value=valor;

	document.getElementById('col_edit_id').value=id;

}

function fechaEditDespesa(){

	var conteudoContainer = document.getElementById('conteudo_container');
	var containerEdit = document.getElementById('container_edit');
	var botoesOpc = document.getElementsByClassName('botoes_opc');
	var selectOpc = document.getElementsByClassName('select_opc');
	var meses = document.getElementsByClassName('mes_opc');

	conteudoContainer.style.pointerEvents="auto";
	conteudoContainer.style.opacity="0.96";
	conteudoContainer.style.transition="2s";
	containerEdit.style.display="none";
	containerEdit.style.transition="2s";

}

/* =================== INTERAÇÕES COM O NOVA DESPESA =================== */

function changeStatus(){

	var status = document.getElementById('select_status').value;
	
	var labelAgendamento = document.getElementById('label_agendamento');
	var inputAgendamento = document.getElementById('input_agendamento');

	var labelData = document.getElementById('label_data');
	var inputData = document.getElementById('input_data');

	var labelForma = document.getElementById('label_forma');
	var inputForma = document.getElementById('input_forma');

	const d = new Date();
	var ano = d.getFullYear();
	var mes = d.getMonth()+1;
	var dia = d.getDate();

	if(mes < 10){
		mes = '0'+mes;
	}

	var data = (ano + '-' + mes + '-' + dia);

	if(status == 0){

		labelAgendamento.style.color="grey";
		inputAgendamento.value="";
		inputAgendamento.disabled=true;
		inputAgendamento.style.border="1px solid grey";
		inputAgendamento.style.color="grey";

		labelData.style.color="grey";
		inputData.value="";
		inputData.disabled=true;
		inputData.style.border="1px solid grey";
		inputData.style.color="grey";

		labelForma.style.color="grey";
		document.getElementById('novo_aberto').selected=true;
		inputForma.disabled=true;
		inputForma.style.border="1px solid grey";
		inputForma.style.color="grey";				

	}

	else if(status == "PAGO"){

		labelAgendamento.style.color="grey";
		inputAgendamento.value="";
		inputAgendamento.disabled=true;
		inputAgendamento.style.border="1px solid grey";
		inputAgendamento.style.color="grey";

		labelData.style.color="#FFFFFF";
		inputData.disabled=false;
		inputData.style.border="1px solid #00CCFF";
		inputData.style.color="#FFFFFF";

		labelForma.style.color="#FFFFFF";
		inputForma.disabled=false;

		document.getElementById('novo_aberto').disabled=true;
		document.getElementById('novo_dinheiro').disabled=false;
		document.getElementById('novo_debito').disabled=false;
		document.getElementById('novo_credito').disabled=false;
		document.getElementById('novo_pix').disabled=false;
		document.getElementById('novo_ted').disabled=false;
		document.getElementById('novo_doc').disabled=false;
		document.getElementById('novo_boleto').disabled=false;
		document.getElementById('novo_cheque').disabled=false;
		document.getElementById('novo_outro').disabled=false;

		document.getElementById('input_data').required=true;

		document.getElementById('novo_dinheiro').selected=true;
		inputForma.style.border="1px solid #00CCFF";
		inputForma.style.color="#FFFFFF";


		inputData.value=data;
	}

	else if(status == "PAGAR"){

		labelAgendamento.style.color="#FFFFFF";
		inputAgendamento.disabled=false;
		inputAgendamento.style.border="1px solid #00CCFF";
		inputAgendamento.style.color="#FFFFFF";

		labelData.style.color="grey";
		inputData.value="";
		inputData.disabled=true;
		inputData.style.border="1px solid grey";
		inputData.style.color="grey";

		labelForma.style.color="grey";

		document.getElementById('novo_aberto').disabled=false;
		document.getElementById('novo_dinheiro').disabled=true;
		document.getElementById('novo_debito').disabled=true;
		document.getElementById('novo_credito').disabled=true;
		document.getElementById('novo_pix').disabled=true;
		document.getElementById('novo_ted').disabled=true;
		document.getElementById('novo_doc').disabled=true;
		document.getElementById('novo_boleto').disabled=true;
		document.getElementById('novo_cheque').disabled=true;
		document.getElementById('novo_outro').disabled=true;

		document.getElementById('input_data').required=false;

		document.getElementById('novo_aberto').selected=true;
		inputForma.disabled=true;
		inputForma.style.border="1px solid grey";
		inputForma.style.color="grey";						

	}

}

/* =================== INTERAÇÕES COM O EDITAR DESPESA =================== */

function editChangeStatus(){

	var status = document.getElementById('edit_select_status').value;
	
	var labelAgendamento = document.getElementById('edit_label_agendamento');
	var inputAgendamento = document.getElementById('edit_input_agendamento');

	var labelData = document.getElementById('edit_label_data');
	var inputData = document.getElementById('edit_input_data');

	var labelForma = document.getElementById('edit_label_forma');
	var inputForma = document.getElementById('edit_input_forma');

	const d = new Date();
	var ano = d.getFullYear();
	var mes = d.getMonth()+1;
	var dia = d.getDate();

	if(mes < 10){
		mes = '0'+mes;
	}

	var data = (ano + '-' + mes + '-' + dia);

	if(status == 0){

		labelAgendamento.style.color="grey";
		inputAgendamento.value="";
		inputAgendamento.disabled=true;
		inputAgendamento.style.border="1px solid grey";
		inputAgendamento.style.color="grey";

		labelData.style.color="grey";
		inputData.value="";
		inputData.disabled=true;
		inputData.style.border="1px solid grey";
		inputData.style.color="grey";

		labelForma.style.color="grey";
		inputForma.value="";
		inputForma.disabled=true;
		inputForma.style.border="1px solid grey";
		inputForma.style.color="grey";				

	}

	else if(status == "PAGO"){

		labelAgendamento.style.color="grey";
		inputAgendamento.value="";
		inputAgendamento.disabled=true;
		inputAgendamento.style.border="1px solid grey";
		inputAgendamento.style.color="grey";

		labelData.style.color="#FFFFFF";
		inputData.disabled=false;
		inputData.style.border="1px solid #00CCFF";
		inputData.style.color="#FFFFFF";

		labelForma.style.color="#FFFFFF";
		inputForma.disabled=false;

		document.getElementById('aberto').disabled=true;
		document.getElementById('dinheiro').disabled=false;
		document.getElementById('debito').disabled=false;
		document.getElementById('credito').disabled=false;
		document.getElementById('pix').disabled=false;
		document.getElementById('ted').disabled=false;
		document.getElementById('doc').disabled=false;
		document.getElementById('boleto').disabled=false;
		document.getElementById('cheque').disabled=false;
		document.getElementById('outro').disabled=false;

		document.getElementById('input_data').required=true;
		inputData.value=data;

		document.getElementById('dinheiro').selected=true;
		inputForma.style.border="1px solid #00CCFF";
		inputForma.style.color="#FFFFFF";		
	}

	else if(status == "PAGAR"){

		labelAgendamento.style.color="#FFFFFF";
		inputAgendamento.disabled=false;
		inputAgendamento.style.border="1px solid #00CCFF";
		inputAgendamento.style.color="#FFFFFF";

		labelData.style.color="grey";
		inputData.value="";
		inputData.disabled=true;
		inputData.style.border="1px solid grey";
		inputData.style.color="grey";

		labelForma.style.color="grey";

		document.getElementById('aberto').disabled=false;
		document.getElementById('dinheiro').disabled=true;
		document.getElementById('debito').disabled=true;
		document.getElementById('credito').disabled=true;
		document.getElementById('pix').disabled=true;
		document.getElementById('ted').disabled=true;
		document.getElementById('doc').disabled=true;
		document.getElementById('boleto').disabled=true;
		document.getElementById('cheque').disabled=true;
		document.getElementById('outro').disabled=true;

		document.getElementById('input_data').required=false;

		document.getElementById('aberto').selected=true;
		inputForma.disabled=true;
		inputForma.style.border="1px solid grey";
		inputForma.style.color="grey";		

	}
}

/* ================== FECHA MENSAGENS INFORMATIVAS ====================== */

function hideMessage(){
	var alertas = document.getElementsByClassName('alert');
	for(var i = 0; i < alertas.length; i++){
		alertas[i].hidden=true;
	}
}

/* ================== REALIZA OS AJUSTES DE TEXTO NA TABELA ====================== */
function ajustaTabela(){

	// Definindo prioridades
	var line = document.getElementsByClassName('tr');
	var columnScheduling = document.getElementsByClassName('td_scheduling');
	var columnData = document.getElementsByClassName('td_data');

	for(var i = 0; i < line.length; i++){

		if(columnScheduling[i].innerText == "NÃO" || columnScheduling[i].innerText == "Não possui"){
			line[i].style.borderLeft="4px solid #5eff00";
			columnScheduling[i].innerText="Não possui";
			if(columnData[i].innerText == 'Em aberto'){
				line[i].style.borderLeft="4px solid #ffdd00";
			}
		}

		else{
			const d = new Date();
			var ano = d.getFullYear();
			var mes = d.getMonth()+1;
			var dia = d.getDate();

			if(mes < 10){
				var mes = '0' + mes;
			}

			var hoje = (dia + '/' + mes + '/' + ano); 

			if(columnScheduling[i].innerText == hoje || columnScheduling[i].innerText == "Hoje"){
				line[i].style.borderLeft="4px solid #ff5900";
				columnData[i].style.color="#ff5900";
				columnData[i].innerText="Vence hoje";
				columnScheduling[i].style.color="#ff5900"
				columnScheduling[i].innerText="Hoje"
			}
			else if(columnScheduling[i].innerText.split("/")[2] <= ano && 
				columnScheduling[i].innerText.split("/")[1] <= mes && 
				columnScheduling[i].innerText.split("/")[0] <= dia || 
				columnScheduling[i].innerText == "Atrasado"){
				line[i].style.borderLeft="4px solid #f20a0a";
				columnData[i].style.color="#f20a0a";
				columnScheduling[i].style.color="#F20a0a"
				columnData[i].innerText="Atrasado";
			}
			else{
				line[i].style.borderLeft="4px solid #ffdd00";
				columnData[i].innerText="Agendado";
			}

		}
	}
}

/* ================== REALIZA OS AJUSTES DE CORES NOS MESES ====================== */
function mesResponsivo(){

	var meses = document.getElementsByClassName('mes_opc');
	var mesSelecionado = document.getElementById('pegando_mes').innerText;
	for(var i = 0; i < meses.length; i++){
		meses[i].style.background="transparent";
		meses[i].style.color="#FFFFFF";
	}

	meses[mesSelecionado-1].style.background="#00CCFF";
	meses[mesSelecionado-1].style.color="#121212";

}

/* ================== REALIZA OS AJUSTES DE CORES NOS ANOS ====================== */
function anoResponsivo(){
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

/* ================== REALIZA OS AJUSTES DE CORES NOS NÚMEROS DAS PÁGINAS ====================== */
function pageResponsiva(){
	var pages = document.getElementsByClassName('page_number');
	var PaginaSelecionada = document.getElementById('pegando_page').innerText;
	for(var i = 0; i < pages.length; i++){
		pages[i].style.background="transparent";
		pages[i].style.color="#FFFFFF";
		if(pages[i].innerText == PaginaSelecionada){
			pages[i].style.background="#00CCFF";
			pages[i].style.color="#121212";
		}
	}
	
	if((pages.length) == PaginaSelecionada){
		document.getElementById('proxima').style.pointerEvents="none";
		document.getElementById('proxima').style.borderColor="grey";
		document.getElementById('proxima').style.color="grey";
	}
	else{
		document.getElementById('proxima').style.pointerEvents="auto";
		document.getElementById('proxima').style.borderColor="#00CCFF";
		document.getElementById('proxima').style.color="#FFFFFF";
	}

	if(PaginaSelecionada == 1){
		document.getElementById('anterior').style.pointerEvents="none";
		document.getElementById('anterior').style.borderColor="grey";
		document.getElementById('anterior').style.color="grey";
	}
	else{
		document.getElementById('anterior').style.pointerEvents="auto";
		document.getElementById('anterior').style.borderColor="#00CCFF";
		document.getElementById('anterior').style.color="FFFFFF";
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