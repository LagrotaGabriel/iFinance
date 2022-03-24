var tamanhoMain = document.getElementById('main');
var tamanhoMenuSuperior = document.getElementById('menu_superior');
var tamanhoTituloPathContainer = document.getElementById('titulo_path_container');
var tamanhoConteudoContainer = document.getElementById('conteudo_container');

var equacao = parseInt(parseInt(tamanhoMain.clientHeight) - parseInt(tamanhoMenuSuperior.clientHeight) - parseInt(tamanhoTituloPathContainer.clientHeight)) - 35;

console.log(equacao)
tamanhoConteudoContainer.style.height = equacao + 'px';

window.onresize = doALoadOfStuff;

function doALoadOfStuff() {
	var tamanhoMain = document.getElementById('main');
	var tamanhoMenuSuperior = document.getElementById('menu_superior');
	var tamanhoTituloPathContainer = document.getElementById('titulo_path_container');
	var tamanhoConteudoContainer = document.getElementById('conteudo_container');
	var equacao = parseInt(parseInt(tamanhoMain.clientHeight) - parseInt(tamanhoMenuSuperior.clientHeight) - parseInt(tamanhoTituloPathContainer.clientHeight)) - 35;

	console.log(equacao)
	tamanhoConteudoContainer.style.height = equacao + 'px';
}