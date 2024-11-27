package com.example.student_filiere.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Filiere")
public class Filiere {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idFiliere;

  private String code;
  private String libelle;

  @OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL)
  @JsonIgnore // ignorer la boucle
  private List<Etudiant> etudiants; // Liste des étudiants dans cette filière

  // Getters and Setters
  public Long getIdFiliere() {
    return idFiliere;
  }

  public void setIdFiliere(Long idFiliere) {
    this.idFiliere = idFiliere;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public List<Etudiant> getEtudiants() {
    return etudiants;
  }

  public void setEtudiants(List<Etudiant> etudiants) {
    this.etudiants = etudiants;
  }
}
