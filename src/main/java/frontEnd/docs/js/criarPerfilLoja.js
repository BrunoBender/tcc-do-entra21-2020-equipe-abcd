document.getElementById('selecao').addEventListener('click', function (event) {
    localStorage.setItem('idComercio', event.target.id);
    window.location.href = "../pages/perfilLoja.html";
})







