let razaoSocial = '';
const xhr = new XMLHttpRequest;
xhr.open("GET", "http://localhost:8081/api/comercios/busca/"+localStorage.getItem('ComercioId'));
xhr.addEventListener("load", function () {  
    var resposta = xhr.responseText;
    resposta = JSON.parse(resposta);
    nomeUsuario =  resposta.nomeUsuario;
    document.getElementById('idNomeFantasia').value = resposta.nomeFantasia;
    document.getElementById('idCnpj').value = resposta.cnpj;
    document.getElementById('idLogradouro').value = resposta.logradouro;
    document.getElementById('idCep').value = resposta.cep;
    document.getElementById('idBairro').value = resposta.bairro;
    document.getElementById('idCidade').value = resposta.cidade;
    document.getElementById('idTel').value = resposta.telefone;
    razaoSocial = resposta.razaoSocial;
    
    

});
xhr.send();

document.getElementById('btnAtu').addEventListener('click', function(){
    let comercio = {};
    comercio.comercioId = localStorage.getItem('ComercioId');
    comercio.nomeFantasia = document.getElementById('idNomeFantasia').value;
    comercio.razaoSocial = razaoSocial;
    comercio.cnpj =  document.getElementById('idCnpj').value;
    comercio.logradouro = document.getElementById('idLogradouro').value;
    comercio.numeroEComplemento = '104 Loja';
    comercio.telefone = document.getElementById('idTel').value;
    comercio.cep = document.getElementById('idCep').value;
    comercio.bairro = document.getElementById('idBairro').value;
    comercio.cidade = document.getElementById('idCidade').value;
    comercio.contratoSocialHash = 'AKSJASADHASDJASDHJAS';

    var json = JSON.stringify(comercio);
    console.log(json);
    
    const xhr = new XMLHttpRequest;
    xhr.open("PUT", "http://localhost:8081/api/comercios/atualiza/"+localStorage.getItem('ComercioId'));
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.addEventListener("load", function () { 
        // window.location.href = "../index.html";
    });    
    xhr.send(json);
});
document.getElementById('btndeletar').addEventListener('click', function(){
    const xhr = new XMLHttpRequest;
    const xhr2 = new XMLHttpRequest;
    xhr.open("DELETE", "http://localhost:8081/api/catalogo/"+localStorage.getItem('ComercioId'));
    xhr.addEventListener('load', function(){
        xhr2.open("DELETE", "http://localhost:8081/api/comercio/"+localStorage.getItem('ComercioId'));
        xhr2.addEventListener('load', function(){
            alert('Comércio deletado com sucesso');
            window.location.href = "../pages/home.html";
        });
        xhr2.send();
    });
    xhr.send();
});