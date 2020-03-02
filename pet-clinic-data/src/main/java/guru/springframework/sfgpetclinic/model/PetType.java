package guru.springframework.sfgpetclinic.model;
//closing issue number 2
public class PetType extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
