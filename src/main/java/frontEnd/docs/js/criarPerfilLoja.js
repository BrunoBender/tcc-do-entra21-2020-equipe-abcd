document.getElementById('selecao').addEventListener('click', function (event) {
    try {
        let teste = document.getElementById('idH1').value;
    } catch (error) {
        localStorage.setItem('idComercio', event.target.id);
        window.location.href = "../pages/perfilLoja.html";
    }
   
})







