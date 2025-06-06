package br.com.desafio.imobiliaria.repository;

import br.com.desafio.imobiliaria.entity.Anuncios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnunciosRepository extends JpaRepository<Anuncios, Long> {

    @Query("SELECT a FROM Anuncios a WHERE " +
            "LOWER(a.corretor.nome) LIKE LOWER(CONCAT('%', :termo, '%')) OR " +
            "LOWER(a.imovel.bairro) LIKE LOWER(CONCAT('%', :termo, '%'))")
    List<Anuncios> findByCorretorNomeOrImovelBairro(@Param("termo") String termo);

    @Query("SELECT COUNT(a) > 0 FROM Anuncios a WHERE a.imovel.id = :imovelId")
    boolean existsByImovelId(@Param("imovelId") Long imovelId);
}