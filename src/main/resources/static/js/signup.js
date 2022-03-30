
var tamanhoAll = document.getElementById('all');
var tamanhoBody = document.getElementById('body').clientHeight;

tamanhoAll.style.height = tamanhoBody + 'px';

window.onresize = doALoadOfStuff;

function doALoadOfStuff() {
	var tamanhoAll = document.getElementById('all');
	var tamanhoBody = document.getElementById('body').clientHeight;
	tamanhoAll.style.height = tamanhoBody + 'px';
}