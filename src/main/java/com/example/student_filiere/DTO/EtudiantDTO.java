package com.example.student_filiere.DTO;

public class EtudiantDTO {
  private Long idEtudiant;
  private String nom;
  private String prenom;
  private String cne;
  private Long filiereId; // Utilisez uniquement l'ID de la filière

  // Constructeurs
  public EtudiantDTO() {
  }

  public EtudiantDTO(Long idEtudiant, String nom, String prenom, String cne, Long filiereId) {
    this.idEtudiant = idEtudiant;
    this.nom = nom;
    this.prenom = prenom;
    this.cne = cne;
    this.filiereId = filiereId;
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

  public Long getFiliereId() {
    return filiereId;
  }

  public void setFiliereId(Long filiereId) {
    this.filiereId = filiereId;
  }
}
