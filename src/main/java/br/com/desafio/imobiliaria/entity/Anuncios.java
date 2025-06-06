package br.com.desafio.imobiliaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "anuncios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Anuncios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "imovel_id", nullable = false, unique = true)
    private Imovel imovel;

    @ManyToOne
    @JoinColumn(name = "corretor_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Corretor corretor;

}