let botao = document.getElementById("idBtnBuscaTodos");
let paragrafo = document.getElementById("idUrl");

botao.addEventListener('click', () => {
	let tabelas = document.getElementsByName("nmTabela");
	let label = document.getElementById("idLblFieldset");

	let xhr = new XMLHttpRequest();
  let url = "http://localhost:8082/api/"+ "comercios";
  paragrafo.innerHTML = "API Endpoint: " + url;

  xhr.open("GET", url);
  xhr.send();

  xhr.onload = function() {
    if (xhr.status != 200) {
      label.innerHTML = `Error ${xhr.status}: ${xhr.statusText}`;
    } else {
      label.innerHTML = xhr.response;
    }
  };

	xhr.onprogress = function(event) {
		if (event.lengthComputable) {
			label.innerHTML = `Received ${event.loaded} of ${event.total} bytes`;
		} else {
			label.innerHTML = `Received ${event.loaded} of bytes`;
		}
	};

	xhr.onerror = function() {
		label.innerHTML = "Request failed";
	}

});


//	for (i = 0; i < tabelas.length; i++) {
//		if (tabelas[i].checked) {
//			console.log(tabelas[i].value);
//			label.innerHTML = tabelas[i].value;
//		}
//	}










let xmlhttp;
function init() {
	// put more code here in case you are concerned about browsers that do not provide XMLHttpRequest object directly
	xmlhttp = new XMLHttpRequest();
}

function buscaResposta2() {
  let url = "http://localhost:8082/api/" + tabela.value + "s";
  xmlhttp.open('GET', url, true);
  xmlhttp.send(null);
  xmlhttp.onreadystatechange = function() {
    let saida = document.getElementById("idLblFieldset");
    if (xmlhttp.readyState == 4) {
      if (xmlhttp.status == 200) {
        let det = eval( "(" +  xmlhttp.responseText + ")");
				saida.value = det.name;
       } else {
         alert("Error ->" + xmlhttp.responseText);
      }
    }
  };
}
