package br.com.desafio.imobiliaria.controller;

import br.com.desafio.imobiliaria.entity.Corretor;
import br.com.desafio.imobiliaria.entity.Imovel;
import br.com.desafio.imobiliaria.service.CorretorService;
import br.com.desafio.imobiliaria.service.ImovelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/corretor")
public class CorretorController {


    private final CorretorService corretorService;

    public CorretorController(CorretorService corretorService) {
        this.corretorService = corretorService;
    }
    @GetMapping
    public List<Corretor> list(){
        return corretorService.list();
    }


    @PostMapping("/create")
    public ResponseEntity<Corretor> create(@Valid @RequestBody Corretor corretor) {
        Corretor created = corretorService.create(corretor);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Corretor> update(
            @PathVariable Long id,
            @Valid @RequestBody Corretor corretor) {
        return ResponseEntity.ok(corretorService.update(corretor));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        corretorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
