package br.com.desafio.imobiliaria.service;

import br.com.desafio.imobiliaria.entity.Corretor;
import br.com.desafio.imobiliaria.entity.Imovel;
import br.com.desafio.imobiliaria.repository.CorretorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorretorService {

    private CorretorRepository corretorRepository;

    public CorretorService(CorretorRepository corretorRepository) {
        this.corretorRepository = corretorRepository;
    }

    public Corretor create(Corretor corretor) {
        return corretorRepository.save(corretor);
    }

    public List<Corretor> list() {
        Sort sort = Sort.by("nome").ascending();
        return corretorRepository.findAll(sort);
    }
    public Corretor update(Corretor corretor) {
        return corretorRepository.save(corretor);
    }

    public void delete(Long id) {
        Corretor corretor = corretorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Corretor não encontrado com ID: " + id));
        corretorRepository.delete(corretor);
    }
    public boolean existsById(Long id) {
        return corretorRepository.existsById(id);
    }
}
