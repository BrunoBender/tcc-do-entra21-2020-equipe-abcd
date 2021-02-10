let selecaoCat = document.getElementById('idProdOuServ');
let form = document.getElementById("form");


selecaoCat.addEventListener('change', function () {
    if (selecaoCat.value == ("servico")) {
        limpa();
        servico();

    } else {
        limpa();
        produto();
    }

})

function servico() {
    document.getElementById("prodSelec").hidden = true;
    document.getElementById("labNomeDescr").textContent = ("Insira o nome do Serviço:");
    document.getElementById("medidaUsada").value = ("unidade");
    document.getElementById("quantidadeMedida").value = 1;
}

function produto() {
    document.getElementById("prodSelec").hidden = false;
    document.getElementById("labNomeDescr").textContent = ("Insira o nome do Produto:");
}

function limpa() {
    document.getElementById("nomeDescritivo").value = '';
    document.getElementById("marca").value = '';
    document.getElementById("medidaUsada").value = '';
    document.getElementById("quantidadeMedida").value = '';
    document.getElementById("preco").value = '';
}

function cadProd() {
    if (selecaoCat.value == ("produto")) {
        var catalogo = {};
        catalogo.produto = true;
        catalogo.nomedescritivo = document.getElementById("nomeDescritivo").value;
        catalogo.marca = document.getElementById("marca").value;
        catalogo.medidaUsada = document.getElementById("medidaUsada").value;
        catalogo.quantidadeMedida = document.getElementById("quantidadeMedida").value;
        catalogo.preco = document.getElementById("preco").value;
    } else {
        var catalogo = {};
        catalogo.produto = false;
        catalogo.nomedescritivo = document.getElementById("nomeDescritivo").value;
        catalogo.medidaUsada = document.getElementById("medidaUsada").value;
        catalogo.quantidadeMedida = document.getElementById("quantidadeMedida").value;
        catalogo.preco = document.getElementById("preco").value;
    }

    //Informações que vão retornar
    console.log(catalogo.produto);
    console.log(catalogo.nomedescritivo);
    console.log(catalogo.marca);
    console.log(catalogo.medidaUsada);
    console.log(catalogo.quantidadeMedida);
    console.log(catalogo.preco);

}