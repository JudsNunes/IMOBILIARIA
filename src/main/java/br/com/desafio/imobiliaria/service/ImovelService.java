package br.com.desafio.imobiliaria.service;

import br.com.desafio.imobiliaria.entity.Imovel;
import br.com.desafio.imobiliaria.repository.ImovelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImovelService {

    private final ImovelRepository imovelRepository;

    public ImovelService(ImovelRepository imovelRepository) {
        this.imovelRepository = imovelRepository;
    }

    public Imovel create(Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    public Imovel findById(Long id) {
        return imovelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Imóvel não encontrado com o ID: " + id));
    }

    public List<Imovel> list() {
        Sort sort = Sort.by("tipo").ascending();
        return imovelRepository.findAll(sort);
    }

    public Imovel update(Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    public void delete(Long id) {
        Imovel imovel = imovelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Imóvel não encontrado com ID: " + id));
        imovelRepository.delete(imovel);
    }
}