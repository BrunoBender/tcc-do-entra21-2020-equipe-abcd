document.getElementById('selecao').addEventListener('click', function (event) {
  
    if(event.target.id == 'selecao'){

    }
    else if(event.target.id == ''){
        localStorage.setItem('idComercio', event.target.parentNode.parentNode.parentNode.querySelector(".loja").id);
        window.location.href = "../pages/perfilLoja.html";
    }
    else if(event.target.id == 'logoLoja'){
        localStorage.setItem('idComercio', event.target.parentNode.id );
        window.location.href = "../pages/perfilLoja.html";
    }
    else{
        localStorage.setItem('idComercio', event.target.id);     
        window.location.href = "../pages/perfilLoja.html";
    }    
    
    
        
    
       
        
    
   
})







