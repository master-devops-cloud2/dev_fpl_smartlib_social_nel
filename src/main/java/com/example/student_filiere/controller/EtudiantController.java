package com.example.student_filiere.controller;

import com.example.student_filiere.DTO.EtudiantDTO;
import com.example.student_filiere.Entities.Etudiant;
import com.example.student_filiere.Entities.Filiere;
import com.example.student_filiere.service.EtudiantService;
import com.example.student_filiere.service.FiliereService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/etudiant")
@Tag(name = "Étudiant", description = "API pour gérer les étudiants")
public class EtudiantController {

  @Autowired
  private EtudiantService etudiantService;

  @Autowired
  private FiliereService filiereService; // Ajouter ce service pour récupérer la filière

  @GetMapping
  @Operation(summary = "Récupérer tous les étudiants")
  public List<Etudiant> getAllEtudiants() {
    return etudiantService.findAll();
  }
/* recuperrer l eudiant sans dettailles de filiers
  @GetMapping("/{id}")
  @Operation(summary = "Récupérer un étudiant par son ID")
  public ResponseEntity<Etudiant> getEtudiantById(
    @Parameter(description = "ID de l'étudiant") @PathVariable Long id) {
    return etudiantService.findById(id)
      .map(etudiant -> ResponseEntity.ok().body(etudiant))
      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

 */

  //recupere l etudiants avec infos de filiere
  @GetMapping("/{id}")
  @Operation(summary = "Récupérer un étudiant par son ID")
  public ResponseEntity<Etudiant> getEtudiantById(
    @Parameter(description = "ID de l'étudiant") @PathVariable Long id) {
    Optional<Etudiant> etudiantOptional = etudiantService.findById(id);

    return etudiantOptional.map(etudiant -> ResponseEntity.ok().body(etudiant))
      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping
  @Operation(summary = "Créer un nouvel étudiant")
  public ResponseEntity<Etudiant> createEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
    Filiere filiere = filiereService.findById(etudiantDTO.getFiliereId())
      .orElseThrow(() -> new RuntimeException("Filière non trouvée"));

    Etudiant etudiant = new Etudiant();
    etudiant.setNom(etudiantDTO.getNom());
    etudiant.setPrenom(etudiantDTO.getPrenom());
    etudiant.setCne(etudiantDTO.getCne());
    etudiant.setFiliere(filiere);

    return ResponseEntity.ok(etudiantService.save(etudiant));
  }

  @PutMapping("/{id}")
  @Operation(summary = "Mettre à jour un étudiant")
  public ResponseEntity<Etudiant> updateEtudiant(
    @Parameter(description = "ID de l'étudiant") @PathVariable Long id,
    @RequestBody EtudiantDTO etudiantDTO) {
    return etudiantService.findById(id)
      .map(etudiant -> {
        etudiant.setNom(etudiantDTO.getNom());
        etudiant.setPrenom(etudiantDTO.getPrenom());
        etudiant.setCne(etudiantDTO.getCne());

        Filiere filiere = filiereService.findById(etudiantDTO.getFiliereId())
          .orElseThrow(() -> new RuntimeException("Filière non trouvée"));
        etudiant.setFiliere(filiere);

        return ResponseEntity.ok(etudiantService.save(etudiant));
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
