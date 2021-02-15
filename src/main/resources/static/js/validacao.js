function mascaraCPF(i){
   
    var v = i.value;
    
    if(isNaN(v[v.length-1])){ // impede entrar outro caractere que não seja número
       i.value = v.substring(0, v.length-1);
       return;
    }
    
    i.setAttribute("maxlength", "14");
    if (v.length == 3 || v.length == 7) i.value += ".";
    if (v.length == 11) i.value += "-";
 
 }

 function mascaraTel(i){
     var v = i.value;

     if(isNaN(v[v.length-1])){
         i.value = v.substring(0,v.length-1);
         return;
     }
     
     i.setAttribute("maxlength", "14");
     if (v.length == 1) i.value = "(" + i.value;
     if (v.length == 3) i.value+=")";
     if (v.length == 9) i.value+="-"; 
 }

 var cep = document.getElementById('idEndCep');
var cidade;
var bairro;
var rua;
var comp;

cep.addEventListener('focusout', function () {
    buscarCep(cep.value)

})

function buscarCep(cep) {
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "http://viacep.com.br/ws/" + cep + "/json/");

    xhr.addEventListener('load', function () {
        var resposta = xhr.responseText;
        console.log(resposta);

        var resp = JSON.parse(resposta);
        cidade = resp.localidade;
        var campoCidade = document.getElementById('idEndCid').value = cidade;

        bairro = resp.bairro;
        var campoBairro = document.getElementById('idEndBai').value = bairro;

        rua = resp.logradouro;
        var campoRua = document.getElementById('idEndRua').value = rua;

        comp = resp.complemento;
        var campoComp = document.getElementById('idEndComp').value = comp;
    })

    xhr.send();
}