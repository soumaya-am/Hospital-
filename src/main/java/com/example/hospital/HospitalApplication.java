package com.example.hospital;

import com.example.hospital.entities.*;
import com.example.hospital.repositories.ConsultationRepository;
import com.example.hospital.repositories.MedecinRepository;
import com.example.hospital.repositories.PatientRepository;
import com.example.hospital.repositories.RendezVousRepository;
import com.example.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    /* @Bean
     CommandLineRunner start(PatientRepository patientRepository,
                             MedecinRepository medecinRepository ,
                             RendezVousRepository rendezVousRepository,
                             ConsultationRepository consultationRepository) {
         return args -> {
             //patientRepository.save(new Patient(null,"soumya",new Date(),false,null));
             Stream.of("Mohammed", "hassan", "najat").forEach(
                     name -> {
                         Patient patient = new Patient();
                         patient.setName(name);
                         patient.setDateNaissance(new Date());
                         patient.setMalade(false);
                         patientRepository.save(patient);
                     }
             );

             Stream.of("aymane", "soumya", "yassmine").forEach(
                     name -> {
                         Medecin medecin = new Medecin();
                         medecin.setName(name);
                         medecin.setEmail(name+"@gmail.com");
                         medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");

                         medecinRepository.save(medecin);
                     }
             );

        Patient patient=patientRepository.findById(1L).orElse(null);
        Patient patient1=patientRepository.findByName("Mohammed");

        Medecin medecin=medecinRepository.findByName("aymane");
             RendezVous rendezVous=new RendezVous();
             rendezVous.setDate(new Date());
             rendezVous.setStatus(StatusRDV.PENDING);
             rendezVous.setMedecin(medecin);
             rendezVous.setPatient(patient);
            rendezVousRepository.save(rendezVous);


            RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);
             Consultation consultation=new Consultation();
             consultation.setDateConsultation(new Date());
             consultation.setRendezVous(rendezVous1);
             consultation.setRapport("Rapport de la consultation  ..........");
             consultationRepository.save(consultation);


         };
     }*/
    @Bean
    CommandLineRunner start(IHospitalService hospitalService, PatientRepository patientRepository, RendezVousRepository rendezVousRepository,
                            MedecinRepository medecinRepository) {
        return args -> {
            //patientRepository.save(new Patient(null,"soumya",new Date(),false,null));
            Stream.of("Mohammed", "hassan", "najat").forEach(
                    name -> {
                        Patient patient = new Patient();
                        patient.setName(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    }
            );

            Stream.of("aymane", "soumya", "yassmine").forEach(
                    name -> {
                        Medecin medecin = new Medecin();
                        medecin.setName(name);
                        medecin.setEmail(name + "@gmail.com");
                        medecin.setSpecialite(Math.random() > 0.5 ? "Cardio" : "Dentiste");
                        hospitalService.saveMedecin(medecin);
                    }
            );

            Patient patient = patientRepository.findById(1L).orElse(null);

            Medecin medecin = medecinRepository.findByName("aymane");
            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            hospitalService.saveRDV(rendezVous);


            RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation  ..........");
            hospitalService.saveConsultation(consultation);




            // chercher un patient par son id
            Patient patient1 = patientRepository.findById(1L).get();
            System.out.println("**********");
            System.out.println(patient1.getId());
            System.out.println(patient1.getName());
            System.out.println(patient1.getDateNaissance());
            System.out.println("**********");

            // List All Patients
            List<Patient> patients = patientRepository.findAll();
            patients.forEach( p -> {
                System.out.println(p.toString());
            });

            // Find a patient
            patient = patientRepository.findById(1L).get();
            System.out.println("**********");
            System.out.println(patient.getId());
            System.out.println(patient.getName());
            System.out.println(patient.getDateNaissance());
            System.out.println("**********");






            // Modifier un patient
            patient1 = patientRepository.findById(2L).get();
            patient1.setName("soumaya");
            System.out.println(patient.toString());

            // supprimer un patient
            patientRepository.delete(patient1);



        };
    }
}