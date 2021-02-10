package tcc.controller;

import org.springframework.web.bind.annotation.*;
import tcc.model.Catalogo;
import tcc.model.Conta;
import tcc.model.dto.CatalogoAtualizacaoDTO;
import tcc.model.dto.CatalogoCriacaoDTO;
import tcc.persistence.CatalogoRepository;
import tcc.util.DTO;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
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

    @CrossOrigin
    @PostMapping("/cria")
    public void novoItem(@DTO(CatalogoCriacaoDTO.class) Catalogo catalogo) {
        catalogoRepository.save(catalogo);
    }

    @CrossOrigin
    @PutMapping("/atualiza/{itemId}")
    public void atualizaItem(@DTO(CatalogoAtualizacaoDTO.class) Catalogo catalogo, @PathVariable long itemId) {
        catalogo.setCatalogoId(itemId);
        catalogoRepository.save(catalogo);
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
