package br.com.desafio.imobiliaria.entity;

import br.com.desafio.imobiliaria.enums.TipoImoveis;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "imovel")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Tipo do imóvel é obrigatório")
    @Enumerated(EnumType.STRING)
    @JsonProperty("tipo")
    private TipoImoveis tipo;

    @NotBlank(message = "Bairro é obrigatório")
    @JsonProperty("bairro")
    private String bairro;

    @NotBlank(message = "Descrição é obrigatória")
    @JsonProperty("descricao")
    private String descricao;
    
}
