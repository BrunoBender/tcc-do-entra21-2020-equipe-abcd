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

  console.log(usuario.nomeUsuario);
  console.log(usuario.nome);
  console.log(usuario.telefone);
  console.log(usuario.cep);
  console.log(usuario.email);
  console.log(usuario.senha);

  var json = JSON.stringify(usuario);

  var url = "http://localhost:8081/api/contas/cria";
  var xhr = new XMLHttpRequest();

  xhr.open("POST", url, true);

  xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');

  xhr.onload = function () {
    // var users = JSON.parse(xhr.responseText);
    // if (xhr.readyState == 4 && xhr.status == "201") {
    //   console.table(users);
    // } else {
    //   console.error(users);
    // }

    // var form = document.getElementById("idForm");
    // form.reset();
  }
  xhr.send(json);
}
