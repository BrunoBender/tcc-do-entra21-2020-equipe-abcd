package tcc.controller;

import org.springframework.web.bind.annotation.*;
import tcc.model.Catalogo;
import tcc.model.Conta;
import tcc.persistence.CatalogoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {
    private CatalogoRepository catalogoRepository;

    public CatalogoController(CatalogoRepository catalogoRepository){
        this.catalogoRepository = catalogoRepository;
    }

    @CrossOrigin
    @GetMapping("/busca/todos")
    public List<Catalogo> buscaTodosCatalogos(){
        return catalogoRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/busca/nome/{nomeDescritivo}")
    public List<Catalogo> buscaNome(@PathVariable String nomeDescritivo){

        //organiza os produtos em ordem de menor preço

        List<Catalogo> lista = catalogoRepository.findByNomeDescritivo(nomeDescritivo);
        return organizaPorPreco(lista);
    }

    public List<Catalogo> organizaPorPreco(List <Catalogo> lista){
        Catalogo temp;
        Double mLista = 0d;

        for(int j = 0; j < lista.size(); j++) {
            for(int i = 0; i <lista.size()-1; i++) {
                if (lista.get(i).getPreco() > lista.get(i+1).getPreco()) {
                    temp = lista.get(i);
                    lista.set(i, lista.get(i+1));
                    lista.set(i+1, temp);
                }
            }
        }

        return lista;
    }

}
