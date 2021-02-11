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