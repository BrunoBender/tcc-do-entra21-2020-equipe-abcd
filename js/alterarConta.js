function alteraConta(){
    var atualizaConta = {};
    alteraConta.nome = document.getElementById("nome");
    alteraConta.nomeUsuario = document.getElementById("nomeUsuario");
    alteraConta.telefone = document.getElementById("telefone");
    alteraConta.cep = document.getElementById("cep");
    alteraConta.email = document.getElementById("email");
    alteraConta.senha = document.getElementById("senha");

    console.log(alteraConta.nome.value);
    console.log(alteraConta.nomeUsuario.value);
    console.log(alteraConta.telefone.value);
    console.log(alteraConta.cep.value);
    console.log(alteraConta.email.value);
    console.log(alteraConta.senha.value);
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
