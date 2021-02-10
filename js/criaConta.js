//Cadastra Usuario
function criaConta() {
    var usuario = {};
    usuario.nomeUsuario = document.getElementById("idUser");
    usuario.nome = document.getElementById("idNome");
    usuario.telefone = document.getElementById("idTel");
    usuario.cep = document.getElementById("idEndCep");
    usuario.email = document.getElementById("idEmail");
    usuario.senha = document.getElementById("idSenha");
    // var cid = document.getElementById("idEndCid");
    // var bair = document.getElementById("idEndBai");
    //  var rua = document.getElementById("idEndRua");
    //  var comp = document.getElementById("idEndComp");
  
    console.log(usuario.nomeUsuario.value);
    console.log(usuario.nome.value);
    console.log(usuario.telefone.value);
    console.log(usuario.cep.value);
    console.log(usuario.email.value);
    console.log(usuario.senha.value);
  
    var json = JSON.stringify(usuario);
  
    var url = "http://localhost:8081/api/contas/cria";
    var xhr = new XMLHttpRequest();
  
    xhr.open("POST", url, true);
  
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
  
    xhr.onload = function () {
      var users = JSON.parse(xhr.responseText);
      if (xhr.readyState == 4 && xhr.status == "201") {
        console.table(users);
      } else {
        console.error(users);
      }
  
      var form = document.getElementById("idForm");
      form.reset();
    }
    xhr.send(json);
  }
  