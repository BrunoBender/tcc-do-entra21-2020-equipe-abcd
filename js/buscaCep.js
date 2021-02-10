function buscarCep(cep) {
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "http://viacep.com.br/ws/" + cep + "/json/");

    xhr.addEventListener('load', function () {
        var resposta = xhr.responseText;
        console.log(resposta);

        var resp = JSON.parse(resposta);
        cidade = resp.localidade;
        var campoCidade = document.getElementById('idEndCid').value = cidade;

        bairro = resp.bairro;
        var campoBairro = document.getElementById('idEndBai').value = bairro;

        rua = resp.logradouro;
        var campoRua = document.getElementById('idEndRua').value = rua;

        comp = resp.complemento;
        var campoComp = document.getElementById('idEndComp').value = comp;
    })

    xhr.send();
}