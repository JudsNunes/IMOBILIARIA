package br.com.desafio.imobiliaria.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "corretor")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Corretor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Nome é Obrigatório")
    @JsonProperty("nome")
    private String nome;

    @NotBlank(message = "O Email é Obrigatório")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "O Telefone é Obrigatório")
    @JsonProperty("telefone")
    private String telefone;
}
