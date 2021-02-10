document.getElementById('btnLogin').addEventListener('click', function(){
    if(document.getElementById('idUser').value == '' || document.getElementById("idSenha").value == ''){
        alert("Preencha os campos corretamente");
    }
    else{
        const xhr = new XMLHttpRequest;
        xhr.open("GET", "http://localhost:8081/api/contas/busca/senha/"+document.getElementById("idSenha").value);
        xhr.addEventListener("load", function () {
            let resposta = xhr.responseText;
            resposta = JSON.parse(resposta);
            try {
                getNomeUsuario(resposta.contaId);
            } catch (error) {
                alert("Usuário não cadastrado");
    
            }
            
        });
        xhr.send();
    }
    
});

//retorna 
function getNomeUsuario(contaIdSenha){
    const xhr = new XMLHttpRequest;
    xhr.open("GET", "http://localhost:8081/api/contas/busca/nomeUsuario/"+document.getElementById('idUser').value);
    xhr.addEventListener("load", function () {
        let resposta = xhr.responseText;
        resposta = JSON.parse(resposta);
        if( resposta.contaId === contaIdSenha){
            window.location.href = "../pages/home.html";
            
           
        
        }
        else{
            alert("Usuário não cadastrado");
        }
    });
    xhr.send();
}




