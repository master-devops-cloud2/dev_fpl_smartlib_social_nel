package com.example.student_filiere.DTO;

public class FiliereDTO {
  private Long idFiliere;
  private String code;
  private String libelle;

  // Constructeurs
  public FiliereDTO() {
  }

  public FiliereDTO(Long idFiliere, String code, String libelle) {
    this.idFiliere = idFiliere;
    this.code = code;
    this.libelle = libelle;
  }

  // Getters et Setters
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
}
