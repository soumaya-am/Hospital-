package com.example.hospital.service;

import com.example.hospital.entities.Consultation;
import com.example.hospital.entities.Medecin;
import com.example.hospital.entities.Patient;
import com.example.hospital.entities.RendezVous;
import com.example.hospital.repositories.ConsultationRepository;
import com.example.hospital.repositories.MedecinRepository;
import com.example.hospital.repositories.PatientRepository;
import com.example.hospital.repositories.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
   private PatientRepository patientRepository;
   private MedecinRepository medecinRepository;
   private RendezVousRepository rendezVousRepository;
   private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
