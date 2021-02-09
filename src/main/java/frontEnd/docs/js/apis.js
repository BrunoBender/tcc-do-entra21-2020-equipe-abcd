document.getElementById('btnLogin').addEventListener('click', function(){
    const xhr = new XMLHttpRequest;
    xhr.open("GET", "http://localhost:8081/api/contas/busca/senha/"+document.getElementById("idSenha").value);
    xhr.addEventListener("load", function () {
        let resposta = xhr.responseText;
        resposta = JSON.parse(resposta);
        try {
            getNomeUsuario(resposta.contaId);
        } catch (error) {
            alert("Valores inválidos");
        }
        window.location.href = ".../pages/home.html";
        
    });
    xhr.send();
});

//retorna 
function getNomeUsuario(contaIdSenha){
    const xhr = new XMLHttpRequest;
    xhr.open("GET", "http://localhost:8081/api/contas/busca/nomeUsuario/"+document.getElementById('idUser').value);
    xhr.addEventListener("load", function () {
        let resposta = xhr.responseText;
        resposta = JSON.parse(resposta);
        
        if( resposta.contaId === contaIdSenha){
            window.location.href = "../";
        }
        else{
            alert("Valores inválidos");
        }
    });
    xhr.send();
}
