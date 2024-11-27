package com.example.student_filiere.service;

import com.example.student_filiere.Entities.Etudiant;
import com.example.student_filiere.Entities.Filiere;
import com.example.student_filiere.repository.EtudiantRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

  private final String API_URL = "http://localhost:8080/api/etudiant"; // L'URL de votre API
  private final String API_FILIERE_URL = "http://localhost:8080/api/filiere";

  @Autowired
  private EtudiantRepository etudiantRepository;

  public List<Etudiant> findAll() {
    return etudiantRepository.findAll();
  }

  public Optional<Etudiant> findById(Long id) {
    return etudiantRepository.findById(id);
  }

  public Etudiant save(Etudiant etudiant) {
    return etudiantRepository.save(etudiant);
  }

  public void deleteById(Long id) {
    etudiantRepository.deleteById(id);
  }
  // Méthode pour faire une requête HTTP externe, par exemple


}
