let nomeUsuario = '';
const xhr = new XMLHttpRequest;
xhr.open("GET", "http://localhost:8081/api/contas/busca/"+localStorage.getItem('UsuarioId'));
xhr.addEventListener("load", function () {  
    var resposta = xhr.responseText;
    resposta = JSON.parse(resposta);
    nomeUsuario =  resposta.nomeUsuario;
    document.getElementById('nome').value = resposta.nome;
    document.getElementById('telefone').value = resposta.telefone;
    document.getElementById('cep').value = resposta.cep;
    document.getElementById('email').value = resposta.email;
    document.getElementById('senha').value = resposta.senha;
    if (localStorage.getItem('ComercioId') == "") {
        document.getElementById('tipoConta').textContent = 'Pessoal';
    } else {
        document.getElementById('tipoConta').textContent = 'Comerciante';
    }
    

});
xhr.send();

document.getElementById('btnAtu').addEventListener('click', function () {
    let conta = {};
    conta.contaId = localStorage.getItem('UsuarioId');
    conta.nomeUsuario = nomeUsuario;
    conta.nome = document.getElementById('nome').value;
    conta.telefone = document.getElementById('telefone').value;
    conta.cep = document.getElementById('cep').value;
    conta.email = document.getElementById('email').value;
    conta.senha = document.getElementById('senha').value;

    var json = JSON.stringify(conta);
    console.log(json);
    
    const xhr = new XMLHttpRequest;
    xhr.open("PUT", "http://localhost:8081/api/contas/atualiza/"+Number(localStorage.getItem('UsuarioId')));
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.addEventListener("load", function () {
        window.location.href = "../index.html";
    });
    xhr.send(json);
    

});
