package com.example.hospital.repositories;

import com.example.hospital.entities.Medecin;
import com.example.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByName( String name);
}
