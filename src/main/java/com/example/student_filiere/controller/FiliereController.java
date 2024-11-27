package com.example.student_filiere.controller;


import com.example.student_filiere.DTO.FiliereDTO;
import com.example.student_filiere.Entities.Filiere;
import com.example.student_filiere.service.FiliereService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/filiere")
@Tag(name = "Filière", description = "API pour gérer les filières")
public class FiliereController {

  @Autowired
  private FiliereService filiereService;

  @GetMapping
  @Operation(summary = "Récupérer toutes les filières")
  public List<Filiere> getAllFilieres() {
    return filiereService.findAll();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Récupérer une filière par son ID")
  public ResponseEntity<Filiere> getFiliereById(
    @Parameter(description = "ID de la filière") @PathVariable Long id) {
    return filiereService.findById(id)
      .map(filiere -> ResponseEntity.ok().body(filiere))
      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping
  @Operation(summary = "Créer une nouvelle filière")
  public Filiere createFiliere(@RequestBody FiliereDTO filiereDTO) {
    Filiere filiere = new Filiere();
    filiere.setCode(filiereDTO.getCode());
    filiere.setLibelle(filiereDTO.getLibelle());
    return filiereService.save(filiere);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Mettre à jour une filière")
  public ResponseEntity<Filiere> updateFiliere(
    @Parameter(description = "ID de la filière") @PathVariable Long id,
    @RequestBody FiliereDTO filiereDTO) {
    return filiereService.findById(id)
      .map(filiere -> {
        filiere.setCode(filiereDTO.getCode());
        filiere.setLibelle(filiereDTO.getLibelle());
        return ResponseEntity.ok().body(filiereService.save(filiere));
      })
      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Supprimer une filière")
  public ResponseEntity<Void> deleteFiliere(
    @Parameter(description = "ID de la filière") @PathVariable Long id) {
    filiereService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
