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
		for(var i = 0; i < blockInterno.length; i++){
			blockInterno[i].style.padding="45px 0";
		}
		for(var i = 0; i < firstBlockClicavel.length; i++){
			firstBlockClicavel[i].style.fontSize="1.5rem";
		}
		for(var i = 0; i < secondBlockClicavel.length; i++){
			secondBlockClicavel[i].style.fontSize="1rem";
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

		novoTitulo.style.fontSize="1.75rem";

		firstShow.style.display="flex";
		firstShow.style.marginBottom="0";
		secondShow.style.display="none";	
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

		novoTitulo.style.fontSize="1.50rem";
		editTitulo.style.fontSize="1.50rem";

		firstShow.style.display="flex";
		firstShow.style.marginBottom="0";
		secondShow.style.display="none";						
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

		novoTitulo.style.fontSize="1.25rem";
		editTitulo.style.fontSize="1.50rem";

		firstShow.style.display="flex";
		firstShow.style.marginBottom="20px";
		secondShow.style.display="flex";									
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

		novoTitulo.style.fontSize="1.05rem";		
		editTitulo.style.fontSize="1.05rem";

		firstShow.style.display="flex";
		firstShow.style.marginBottom="20px";
		secondShow.style.display="flex";								
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

		novoTitulo.style.fontSize="1rem";	
		editTitulo.style.fontSize="1rem";			

		firstShow.style.display="flex";
		firstShow.style.marginBottom="20px";
		secondShow.style.display="flex";				
	}

	if(tamanhoMenuSuperior.clientHeight == 0){
		var somaTamanho = (tamanhoMain.clientHeight - tamanhoMenuResponsivo.clientHeight) + 'px';
		tamanhoContainerAlign.style.height = somaTamanho;
	}
	else{
		var somaTamanho = (tamanhoAside.clientHeight - tamanhoMenuSuperior.clientHeight) + 'px';
		tamanhoContainerAlign.style.height = somaTamanho;
	}	
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
	else if(item == "despesas"){
		document.getElementById("img_aside_despesas").src="img/despesa.png";
		document.getElementById("img_aside_despesas").style.animation="pulse 2s infinite";
		document.getElementById("title_aside_despesas").style.color="#121212";
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
	else if(item == "despesas"){
		document.getElementById("img_aside_despesas").src="img/despesablue.png";
		document.getElementById("img_aside_despesas").style.animation="none";
		titulos[3].style.color="#00ccff";
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

/* =================== INTERAÇÕES COM AS SETAS =================== */

var col = 0;
var firstShow = document.getElementById('first_show');
var secondShow = document.getElementById('second_show');

function setaEsquerda(){
	if(col == 0){
		firstShow.style.display="none";
		secondShow.style.display="flex";
		secondShow.style.animation="entradaEsquerda 1s linear 0s normal forwards";
		col = 1;
	}
	else{
		secondShow.style.display="none";
		firstShow.style.display="flex";
		firstShow.style.animation="entradaEsquerda 1s linear 0s normal forwards";
		col = 0;
	}
}

function setaDireita(){
	if(col == 0){
		firstShow.style.display="none";
		secondShow.style.display="flex";
		secondShow.style.animation="entradaDireita 1s linear 0s normal forwards";
		col = 1;
	}
	else{
		secondShow.style.display="none";
		firstShow.style.display="flex";
		firstShow.style.animation="entradaDireita 1s linear 0s normal forwards";
		col = 0;
	}
}

/* =================== ABERTURA E FECHAMENTO DO EDIT PATRIMONIO =================== */

function editPatrimonio(id, data, descricao, tipo, valor){

	var conteudoContainer = document.getElementById('conteudo_container');
	var containerEdit = document.getElementById('container_edit');

	console.log(id)
	console.log(data);
	console.log(descricao);
	console.log(tipo);
	console.log(valor);

	document.getElementById('col_edit_id').value=id;
	document.getElementById('col_edit_date').value=data;
	document.getElementById('edit_input_descricao').value=descricao;
	document.getElementById('edit_input_valor').value=valor;

	if(tipo == "Veículo"){
		document.getElementById('edit_veiculo').selected=true;
	}
	else if(tipo == "Imóvel"){
		document.getElementById('edit_imovel').selected=true;
	}
	else if(tipo == "Conta bancária"){
		document.getElementById('edit_conta').selected=true;
	}
	else if(tipo == "Investimento"){
		document.getElementById('edit_investimento').selected=true;
	}
	else if(tipo == "Eletrônico"){
		document.getElementById('edit_eletronico').selected=true;
	}
	else if(tipo == "Intangível"){
		document.getElementById('edit_intangivel').selected=true;
	}
	else if(tipo == "Jóia"){
		document.getElementById('edit_joia').selected=true;
	}
	else if(tipo == "Baixa liquidez"){
		document.getElementById('edit_liquidez').selected=true;
	}
	else if(tipo == "Outro"){
		document.getElementById('edit_outro').selected=true;
	}

	conteudoContainer.style.pointerEvents="none";
	conteudoContainer.style.opacity="0";
	conteudoContainer.style.transition="2s";
	containerEdit.style.display="block";
	containerEdit.style.transition="2s";
}

function fechaEditPatrimonio(){

	var conteudoContainer = document.getElementById('conteudo_container');
	var containerEdit = document.getElementById('container_edit');

	var inputDescricao = document.getElementById('input_descricao');
	var inputTipo = document.getElementById('select_tipo');
	var inputValor = document.getElementById('input_valor');

	if(inputDescricao.value == "" && inputTipo.value == "0" && inputValor.value == ""){
		conteudoContainer.style.pointerEvents="auto";
		conteudoContainer.style.opacity="0.95";
		containerEdit.style.display="none";
		conteudoContainer.style.transition="2s";
		containerEdit.style.transition="2s";
	}
	else{	
		if(confirm('Você tem certeza que deseja fechar o formulário? Os dados preenchidos serão perdidos')) {
			conteudoContainer.style.pointerEvents="auto";
			conteudoContainer.style.opacity="0.95";
			containerEdit.style.display="none";
			conteudoContainer.style.transition="2s";
			containerEdit.style.transition="2s";
		} 
	}	
}

/* =================== ABERTURA E FECHAMENTO DO NOVO PATRIMONIO =================== */

function novoPatrimonio(){

	var conteudoContainer = document.getElementById('conteudo_container');
	var containerNovo = document.getElementById('container_novo');

	conteudoContainer.style.pointerEvents="none";
	conteudoContainer.style.opacity="0";
	conteudoContainer.style.transition="2s";
	containerNovo.style.display="block";
	containerNovo.style.transition="2s";
}

function fechaNovoPatrimonio(){

	var conteudoContainer = document.getElementById('conteudo_container');
	var containerNovo = document.getElementById('container_novo');

	var inputDescricao = document.getElementById('input_descricao');
	var inputTipo = document.getElementById('select_tipo');
	var inputValor = document.getElementById('input_valor');

	if(inputDescricao.value == "" && inputTipo.value == "0" && inputValor.value == ""){
		conteudoContainer.style.pointerEvents="auto";
		conteudoContainer.style.opacity="0.95";
		containerNovo.style.display="none";
		conteudoContainer.style.transition="2s";
		containerNovo.style.transition="2s";
	}
	else{	
		if(confirm('Você tem certeza que deseja fechar o formulário? Os dados preenchidos serão perdidos')) {
			conteudoContainer.style.pointerEvents="auto";
			conteudoContainer.style.opacity="0.95";
			containerNovo.style.display="none";
			conteudoContainer.style.transition="2s";
			containerNovo.style.transition="2s";
		} 
	}	
}