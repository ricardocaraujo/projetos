var botaoAdiciona = document.querySelector("#botaoAdiciona");

botaoAdiciona.addEventListener("click", adicionaMarco);

function adicionaMarco(event) {
	event.preventDefault();
	var marco = document.getElementById("marco");
	var numeroMarcos = marco.childElementCount;
	var divLinha = document.createElement("div");
	divLinha.classList.add("form-row");
	var divDescricao = adicionaDescricao();
	var divData = adicionaData();
	divLinha.appendChild(divDescricao);
	divLinha.appendChild(divData);
	marco.appendChild(divLinha);

	function adicionaDescricao() {
		var divDescricao = document.createElement("div");
		divDescricao.classList.add("form-group");
		divDescricao.classList.add("col-md-9");
		var inputDescricao = document.createElement("input");
		inputDescricao.setAttribute("type", "text");
		inputDescricao.classList.add("form-control");
		inputDescricao.id = 'marcos' + numeroMarcos + '.descricao';
		inputDescricao.name = 'marcos[' + numeroMarcos + '].descricao';
		divDescricao.appendChild(inputDescricao);
		return divDescricao;
	}
	
	function adicionaData() {
		var divData = document.createElement("div");
		divData.classList.add("form-group");
		divData.classList.add("col-md-3");
		var inputData = document.createElement("input");
		inputData.setAttribute("type", "date");
		inputData.classList.add("form-control");
		inputData.id = 'marcos' + numeroMarcos + '.dataTermino';
		inputData.name = 'marcos[' + numeroMarcos + '].dataTermino';
		divData.appendChild(inputData);
		return divData;
	}	
}


