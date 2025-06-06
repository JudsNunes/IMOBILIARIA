package br.com.desafio.imobiliaria.repository;

import br.com.desafio.imobiliaria.entity.Corretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorretorRepository extends JpaRepository<Corretor,Long> {
}
