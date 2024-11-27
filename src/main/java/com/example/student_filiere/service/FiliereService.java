package com.example.student_filiere.service;


import com.example.student_filiere.Entities.Filiere;
import com.example.student_filiere.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FiliereService {
  @Autowired
  private FiliereRepository filiereRepository;

  public List<Filiere> findAll() {
    return filiereRepository.findAll();
  }

  public Optional<Filiere> findById(Long id) {
    return filiereRepository.findById(id);
  }

  public Filiere save(Filiere filiere) {
    return filiereRepository.save(filiere);
  }

  public void deleteById(Long id) {
    filiereRepository.deleteById(id);
  }
}
