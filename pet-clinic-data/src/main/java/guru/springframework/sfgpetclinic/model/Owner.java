package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.security.PublicKey;
import java.util.Set;

//commit
@Entity
@Table(name = "owners") // setup owner table as owners in db.
public class Owner extends Person {
    @Column(name = "address")
    public String address;

    @Column(name = "city")
    public String city;

    @Column(name = "telephone")
    public String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
