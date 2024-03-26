package com.example.hospital.service;

import com.example.hospital.entities.Consultation;
import com.example.hospital.entities.Medecin;
import com.example.hospital.entities.Patient;
import com.example.hospital.entities.RendezVous;
import com.example.hospital.repositories.RendezVousRepository;

public interface IHospitalService {
    public Patient savePatient(Patient patient);
    public Medecin saveMedecin(Medecin medecin);
    public RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
