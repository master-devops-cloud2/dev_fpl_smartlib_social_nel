package com.example.student_filiere.controller;

import com.example.student_filiere.Entities.Etudiant;
import com.example.student_filiere.service.EtudiantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiant")
@Tag(name = "Étudiant", description = "API pour gérer les étudiants")
public class EtudiantController {

  @Autowired
  private EtudiantService etudiantService;

  @GetMapping
  @Operation(summary = "Récupérer tous les étudiants")
  public List<Etudiant> getAllEtudiants() {
    return etudiantService.findAll();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Récupérer un étudiant par son ID")
  public ResponseEntity<Etudiant> getEtudiantById(
    @Parameter(description = "ID de l'étudiant") @PathVariable Long id) {
    return etudiantService.findById(id)
      .map(etudiant -> ResponseEntity.ok().body(etudiant))
      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping
  @Operation(summary = "Créer un nouvel étudiant")
  public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
    return etudiantService.save(etudiant);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Mettre à jour un étudiant")
  public ResponseEntity<Etudiant> updateEtudiant(
    @Parameter(description = "ID de l'étudiant") @PathVariable Long id,
    @RequestBody Etudiant etudiantDetails) {
    return etudiantService.findById(id)
      .map(etudiant -> {
        etudiant.setNom(etudiantDetails.getNom());
        etudiant.setPrenom(etudiantDetails.getPrenom());
        etudiant.setCne(etudiantDetails.getCne());
        etudiant.setFiliere(etudiantDetails.getFiliere());
        return ResponseEntity.ok().body(etudiantService.save(etudiant));
      })
      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Supprimer un étudiant")
  public ResponseEntity<Void> deleteEtudiant(
    @Parameter(description = "ID de l'étudiant") @PathVariable Long id) {
    etudiantService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
