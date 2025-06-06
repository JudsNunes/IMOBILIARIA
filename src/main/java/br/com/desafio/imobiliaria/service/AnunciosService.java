package br.com.desafio.imobiliaria.service;

import br.com.desafio.imobiliaria.entity.Anuncios;
import br.com.desafio.imobiliaria.entity.Corretor;
import br.com.desafio.imobiliaria.entity.Imovel;
import br.com.desafio.imobiliaria.repository.AnunciosRepository;
import br.com.desafio.imobiliaria.repository.CorretorRepository;
import br.com.desafio.imobiliaria.repository.ImovelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnunciosService {

    private final AnunciosRepository anunciosRepository;
    private final CorretorRepository corretorRepository;
    private final ImovelRepository imovelRepository;

    public AnunciosService(AnunciosRepository anunciosRepository,
                           CorretorRepository corretorRepository,
                           ImovelRepository imovelRepository) {
        this.anunciosRepository = anunciosRepository;
        this.corretorRepository = corretorRepository;
        this.imovelRepository = imovelRepository;
    }

    public Anuncios create(Anuncios anuncio) {
        if (anunciosRepository.existsByImovelId(anuncio.getImovel().getId())) {
            throw new IllegalArgumentException("Este imóvel já possui um anúncio");
        }

        Corretor corretor = corretorRepository.findById(anuncio.getCorretor().getId())
                .orElseThrow(() -> new EntityNotFoundException("Corretor não encontrado"));

        Imovel imovel = imovelRepository.findById(anuncio.getImovel().getId())
                .orElseThrow(() -> new EntityNotFoundException("Imóvel não encontrado"));

        anuncio.setCorretor(corretor);
        anuncio.setImovel(imovel);

        return anunciosRepository.save(anuncio);
    }

    public List<Anuncios> listAll() {
        return anunciosRepository.findAll();
    }

    public List<Anuncios> search(String termo) {
        return anunciosRepository.findByCorretorNomeOrImovelBairro(termo);
    }

    public Anuncios findById(Long id) {
        return anunciosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Anúncio não encontrado com ID: " + id));
    }

    public Anuncios update(Long id, Anuncios anuncioAtualizado) {
        Anuncios anuncioExistente = findById(id);

        if (!anuncioExistente.getCorretor().getId().equals(anuncioAtualizado.getCorretor().getId())) {
            Corretor novoCorretor = corretorRepository.findById(anuncioAtualizado.getCorretor().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Corretor não encontrado"));
            anuncioExistente.setCorretor(novoCorretor);
        }

        return anunciosRepository.save(anuncioExistente);
    }

    public void delete(Long id) {
        Anuncios anuncio = anunciosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Anúncio não encontrado"));

        anunciosRepository.delete(anuncio);
    }
}