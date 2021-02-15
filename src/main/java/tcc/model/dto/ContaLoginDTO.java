package tcc.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter

public class ContaLoginDTO {

    @Column(name = "conta_id")
    @NotNull
    @Id
    private long contaId;

    @Column(name = "nome_usuario")
    @NotNull
    private String nomeUsuario;

    @Column(name = "senha")
    @NotNull
    private String senha;

    @JsonIgnore
    private final LocalDateTime criadoEm = LocalDateTime.now();

    @JsonIgnore
    private final LocalDateTime editadoEm = LocalDateTime.now();

    @JsonIgnore
    private final LocalDateTime logarEm = LocalDateTime.now();

}
