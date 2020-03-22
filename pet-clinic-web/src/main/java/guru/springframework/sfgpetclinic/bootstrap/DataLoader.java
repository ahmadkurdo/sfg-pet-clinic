package guru.springframework.sfgpetclinic.bootstrap;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
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

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);
        System.out.println("saved " + savedDogPetType.toString());
        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

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

        Vet vet2 = new Vet();
        vet2.setFirstName("Razaw");
        vet2.setLastName("Mustafa");
        vetService.save(vet2);
        System.out.println("Loaded vets.....");
    }
}
