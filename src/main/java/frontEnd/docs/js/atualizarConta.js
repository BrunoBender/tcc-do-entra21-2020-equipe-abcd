function atualizar(){
    var comercial = {};
    comercial.NomeFantasia = document.getElementById("idNomeFantasia");
    comercial.Logo = document.getElementById("idLogo");
    comercial.categoria = document.getElementById("idCatLoja");
    comercial.cnpj = document.getElementById("idCnpj");
    comercial.cep = document.getElementById("idCep");
    comercial.telefone = document.getElementById("idTel");

    var json = JSON.stringify(usuario);
  
    var url = "http://localhost:8081/api/comercial/cria";
    var xhr = new XMLHttpRequest();
  
    xhr.open("POST", url, true);
  
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
  
    xhr.onload = function () {
      var comercial = JSON.parse(xhr.responseText);
      if (xhr.readyState == 4 && xhr.status == "201") {
        console.table(comercial);
      } else {
        console.error(comercial);
      }
  
      var form = document.getElementById("formCadastro");
      form.reset();
    }
    xhr.send(json);
  }