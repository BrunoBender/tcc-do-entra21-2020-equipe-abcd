function atualizar(){
    var comercial = {};
    comercial.NomeFantasia = document.getElementById("idNomeFantasia").value;
    comercial.Logo = document.getElementById("idLogo");
    comercial.categoria = document.getElementById("idCatLoja").value;
    comercial.cnpj = document.getElementById("idCnpj").value;
    comercial.cep = document.getElementById("idCep").value;
    comercial.telefone = document.getElementById("idTel").value;

    console.log(comercial.NomeFantasia);
    console.log(comercial.categoria);
    console.log(comercial.cnpj);
    console.log(comercial.cep);
    console.log(comercial.telefone);

    //var json = JSON.stringify(usuario);
  
   // var url = "http://localhost:8081/api/comercial/cria";
 //   var xhr = new XMLHttpRequest();
  
    //xhr.open("POST", url, true);
  
   // xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
  
 //   xhr.onload = function () {
    //  var comercial = JSON.parse(xhr.responseText);
    //  if (xhr.readyState == 4 && xhr.status == "201") {
    //    console.table(comercial);
    //  } else {
    //    console.error(comercial);
    //  }
  
    //  var form = document.getElementById("formCadastro");
    //  form.reset();
    //}
    //xhr.send(json);
  }