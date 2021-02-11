
    const xhr = new XMLHttpRequest;
    xhr.open("GET", "http://localhost:8081/api/comercios/busca/"+localStorage.getItem('idComercio'));
    xhr.addEventListener("load", function () {
        var resposta = xhr.responseText;
        resposta = JSON.parse(resposta);
        console.log(resposta);
        document.getElementById('idNome').textContent = resposta.nomeFantasia;
        document.getElementById('idInfo').textContent = "Endereço: "+resposta.logradouro+" | "+resposta.numeroEComplemento+" | "+resposta.bairro+" | "+resposta.cidade;
        buscaProdutos();
    })
    xhr.send();

    function buscaProdutos() {
        const xhrGetProdutos = new XMLHttpRequest;
        xhrGetProdutos.open("GET", "http://localhost:8081/api/catalogo/busca/nome/Banana");
        xhrGetProdutos.addEventListener("load", function () {
            let resposta = xhrGetProdutos.responseText;
            let arrayProdutos = JSON.parse(resposta);
            

            for (let index = 0; index < arrayProdutos.length; index++) {
                let newTr = document.createElement('tr');
                let newTd = document.createElement('td');
                let newDiv = document.createElement('div');
                let newDivGeral = document.createElement('div');
                let newH2NomePreco = document.createElement('h2'); 
                let newH2MercadoDistancia = document.createElement('h2'); 
                newTd.id = arrayProdutos[index].id;
                newTd.className = 'loja';
                newDiv.id = 'logoLoja';
                newDivGeral.id = 'divGeral';
                newH2NomePreco.className = 'NomePreco';
    
                newH2NomePreco.textContent = arrayProdutos[index].nomeDescritivo+" | R$ "+arrayProdutos[index].preco;
                newDivGeral.appendChild(newH2NomePreco);
                newDivGeral.appendChild(newH2MercadoDistancia);
                newTd.appendChild(newDiv);
                newTd.appendChild(newDivGeral);
                newTr.appendChild(newTd);
               
                document.getElementById('selecao').appendChild(newTr);
            }
        });
        xhrGetProdutos.send();
    }