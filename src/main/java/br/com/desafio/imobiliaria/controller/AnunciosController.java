package br.com.desafio.imobiliaria.controller;

import br.com.desafio.imobiliaria.entity.Anuncios;
import br.com.desafio.imobiliaria.service.AnunciosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anuncios")
public class AnunciosController {

    private final AnunciosService anunciosService;

    public AnunciosController(AnunciosService anunciosService) {
        this.anunciosService = anunciosService;
    }

    @GetMapping
    public ResponseEntity<List<Anuncios>> list(@RequestParam(required = false) String search) {
        try {
            List<Anuncios> anuncios = (search != null && !search.isEmpty())
                    ? anunciosService.search(search)
                    : anunciosService.listAll();
            return ResponseEntity.ok(anuncios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anuncios> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(anunciosService.findById(id));
        } catch (jakarta.persistence.EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody Anuncios anuncio) {
        try {
            Anuncios created = anunciosService.create(anuncio);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (jakarta.persistence.EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @Valid @RequestBody Anuncios anuncio) {
        try {
            return ResponseEntity.ok(anunciosService.update(id, anuncio));
        } catch (jakarta.persistence.EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            anunciosService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (jakarta.persistence.EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}