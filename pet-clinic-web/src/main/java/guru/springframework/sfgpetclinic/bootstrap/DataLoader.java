package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialitiesService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
// === loads in data ===

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitiesService specialitiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
    }


    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);
        System.out.println("saved " + savedDogPetType.toString());

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialitiesService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("surgery");
        Speciality savedSurgery = specialitiesService.save(surgery);


        Speciality dentist = new Speciality();
        radiology.setDescription("dentist");
        Speciality savedDentist = specialitiesService.save(dentist);


        Owner owner1 = new Owner();
        owner1.setFirstName("Ahmed");
        owner1.setLastName("Rashid");
        owner1.setAddress("Burgemeester Pruissingel");
        owner1.setCity("Vlaardingen");
        owner1.setTelephone("0619783221");
        Pet ahmadsPet = new Pet();
        ahmadsPet.setPetType(savedDogPetType);
        ahmadsPet.setBirthDate(LocalDate.now());
        ahmadsPet.setName("Rosco");
        owner1.getPets().add(ahmadsPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Steven");
        owner2.setLastName("Soekha");
        owner2.setAddress("Burgemeester Straat");
        owner2.setCity("Schiedam");
        owner2.setTelephone("06197834454");
        Pet stevensPet = new Pet();
        stevensPet.setPetType(savedCatPetType);
        stevensPet.setBirthDate(LocalDate.now());
        stevensPet.setName("Rezhwan");
        owner2.getPets().add(stevensPet);
        ownerService.save(owner2);
        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Razhan");
        vet1.setLastName("Rashid");
        vetService.save(vet1);
        vet1.getSpecialities().add(savedRadiology);

        Vet vet2 = new Vet();
        vet2.setFirstName("Razaw");
        vet2.setLastName("Mustafa");
        vetService.save(vet2);
        vet2.getSpecialities().add(surgery);
        System.out.println("Loaded vets.....");
    }
}
