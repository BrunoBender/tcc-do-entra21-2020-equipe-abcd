//Cadastra Usuario
function criaConta() {
  var usuario = {};
  usuario.nomeUsuario = document.getElementById("idUser").value;
  usuario.nome = document.getElementById("idNome").value;
  usuario.telefone = document.getElementById("idTel").value;
  usuario.cep = document.getElementById("idEndCep").value;
  usuario.email = document.getElementById("idEmail").value;
  usuario.senha = document.getElementById("idSenha").value;
  // var cid = document.getElementById("idEndCid");
  // var bair = document.getElementById("idEndBai");
  //  var rua = document.getElementById("idEndRua");
  //  var comp = document.getElementById("idEndComp");



  
    // var users = JSON.parse(xhr.responseText);
    // if (xhr.readyState == 4 && xhr.status == "201") {
    //   console.table(users);
    // } else {
    //   console.error(users);
    // }

    // var form = document.getElementById("idForm");
    // form.reset();
  
  if (usuario.nomeUsuario == '' || usuario.nome == '' || usuario.telefone == '' || usuario.cep == '' || usuario.email == '' || usuario.senha == '') {
    alert('Preencha os campos corretamente');
  }
  
  else{
    getNomeUsuario(usuario.nomeUsuario, usuario);
  }
}


function getNomeUsuario(nomeUser, usuario){
  const xhr = new XMLHttpRequest;
  xhr.open("GET", "http://localhost:8081/api/contas/busca/nomeUsuario/"+nomeUser);
  xhr.addEventListener("load", function () {
      let resposta = xhr.responseText;
      resposta = JSON.parse(resposta);
      console.log('to aq');
      if( resposta == null){
        criar(usuario);
      }
      else{
        alert('Nome de usuáro já cadastrado');
        
      }
  });
  xhr.send();
}

function criar (usuario){
  var json = JSON.stringify(usuario);

  var url = "http://localhost:8081/api/contas/cria";
  var xhrAdd = new XMLHttpRequest();

  xhrAdd.open("POST", url, true);

  xhrAdd.setRequestHeader('Content-type', 'application/json; charset=utf-8');

  xhrAdd.onload = function () {
    alert('Conta criada com sucesso');
    window.location.href = "../index.html";
  }
  xhrAdd.send(json);
}
