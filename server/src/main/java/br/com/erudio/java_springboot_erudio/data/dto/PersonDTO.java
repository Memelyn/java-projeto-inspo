package br.com.erudio.java_springboot_erudio.data.dto;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;
import java.util.Objects;

@Relation(collectionRelation = "people")
public class PersonDTO extends RepresentationModel<PersonDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Boolean enabled;

    public PersonDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PersonDTO dto = (PersonDTO) o;
        return Objects.equals(getId(), dto.getId()) && Objects.equals(getFirstName(), dto.getFirstName()) && Objects.equals(getLastName(), dto.getLastName()) && Objects.equals(getAddress(), dto.getAddress()) && Objects.equals(getGender(), dto.getGender()) && Objects.equals(getEnabled(), dto.getEnabled());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getFirstName(), getLastName(), getAddress(), getGender(), getEnabled());
    }
}
   // equals
        /*
        determina se os objetos são iguais, verifica se os dois objetos ocupam o mesmo espaço na memória

        Se você sobrescrever equals() sem sobrescrever hashCode(), pode haver inconsistências ao usar coleções baseadas em hash.
         */

    // Se equals() for sobrescrito, hashCode() também deve ser para evitar problemas em coleções como HashMap e HashSet.


    // hashCode() {
        /*
        ferramenta do JVM usada para montar a tabela de hash de modo correto

        tabela hash: tabela onde as informações são armazenadas conforme um número hash
        calculado com base nas prioridades da informação, permitindo recuperar uma informação
        na tabela mais rapidamente

        usar uma tabela hash diminui o tempo de busca
         */

