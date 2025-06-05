package br.com.desafio.imobiliaria.repository;

import br.com.desafio.imobiliaria.entity.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel,Long> {
}
