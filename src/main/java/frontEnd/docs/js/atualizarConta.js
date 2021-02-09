function atualizar(){
    var comercial = {};
    //comercial.contaId = (usar a variavel global do user)  ;
    comercial.nomeFantasia = document.getElementById("idNomeFantasia").value;
    //comercial.Logo = document.getElementById("idLogo");
    comercial.razaoSocial = document.getElementById("idCatLoja").value;
    comercial.cnpj = document.getElementById("idCnpj").value;
    comercial.cep = document.getElementById("idCep").value;
   // comercial.telefone = document.getElementById("idTel").value;

    console.log(comercial.nomeFantasia);
    console.log(comercial.categoria);
    console.log(comercial.cnpj);
    console.log(comercial.cep);
    console.log(comercial.telefone);

    var json = JSON.stringify(comercial);
  
    var url = "http://localhost:8081/api/comercios/cria";
    var xhr = new XMLHttpRequest();
  
    xhr.open("POST", url, true);
  
   xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
  
    xhr.onload = function () {
      var comercio = JSON.parse(xhr.responseText);
      if (xhr.readyState == 4 && xhr.status == "201") {
    console.table(comercio);
      } else {
        console.error(comercio);
      }
  
      var form = document.getElementById("formCadastro");
      form.reset();
    }
    xhr.send(json);
  }