package br.com.desafio.imobiliaria.controller;

import br.com.desafio.imobiliaria.entity.Imovel;
import br.com.desafio.imobiliaria.service.ImovelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {

    private final ImovelService imovelService;

    public ImovelController(ImovelService imovelService) {
        this.imovelService = imovelService;
    }
    @GetMapping
    public List<Imovel> list(){
        return imovelService.list();
    }


    @PostMapping("/create")
    public ResponseEntity<Imovel> create(@Valid @RequestBody Imovel imovel) {
        Imovel created = imovelService.create(imovel);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imovel> update(
            @PathVariable Long id,
            @Valid @RequestBody Imovel imovel) {
        return ResponseEntity.ok(imovelService.update(imovel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        imovelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}