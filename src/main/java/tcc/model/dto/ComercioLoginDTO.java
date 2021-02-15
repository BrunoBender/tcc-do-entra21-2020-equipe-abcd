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

public class ComercioLoginDTO {

    @Column(name="comercio_id")
    @NotNull
    @Id
    private long comercioId;

    @Column(name="nome_fantasia")
    @NotNull
    private String nomeFantasia;

    @Column(name="cnpj")
    @NotNull
    private long cnpj;

    @Column(name="cep")
    @NotNull
    private long cep;

    @JsonIgnore
    private final LocalDateTime criadoEm = LocalDateTime.now();

    @JsonIgnore
    private final LocalDateTime editadoEm = LocalDateTime.now();

    @JsonIgnore
    private final LocalDateTime logarEm = LocalDateTime.now();

}
