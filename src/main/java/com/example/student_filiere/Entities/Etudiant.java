package com.example.student_filiere.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Etudiant")
public class Etudiant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idEtudiant;

  private String nom;
  private String prenom;
  private String cne;

  //@ManyToOne(fetch = FetchType.LAZY) // pour la boucle
  @ManyToOne
  @JoinColumn(name = "filiere_id", nullable = false)
  private Filiere filiere; // clé étrangère vers la filière

  // Constructeurs
  public Etudiant() {
  }

  public Etudiant(String nom, String prenom, String cne, Filiere filiere) {
    this.nom = nom;
    this.prenom = prenom;
    this.cne = cne;
    this.filiere = filiere;
  }

  // Getters et Setters
  public Long getIdEtudiant() {
    return idEtudiant;
  }

  public void setIdEtudiant(Long idEtudiant) {
    this.idEtudiant = idEtudiant;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getCne() {
    return cne;
  }

  public void setCne(String cne) {
    this.cne = cne;
  }

  public Filiere getFiliere() {
    return filiere;
  }

  public void setFiliere(Filiere filiere) {
    this.filiere = filiere;
  }
}
