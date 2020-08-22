var botaoRemove = document.querySelector("#botaoRemove");

botaoRemove.addEventListener("click", removeMarco);

function removeMarco(event) {
	event.preventDefault();
	var marcos = document.querySelector("#marco");
	var ultimoMarco = marcos.lastChild;
	marcos.removeChild(ultimoMarco);
	console.log(ultimoMarco);
}