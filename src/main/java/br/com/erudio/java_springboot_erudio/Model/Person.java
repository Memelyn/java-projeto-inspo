package br.com.erudio.java_springboot_erudio.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "person")
public class Person implements Serializable {
/* serialização: tranformar um objeto em uma sequencia de bytes, que opde ser armazenada ou transmitida
posteriormente ele é reconstruído no mesmo estado, facilitando a sua manipulação

a serialização é importante quando enviamos arquivos pela rede, como no REST
    porque permite converter o objeto em um formato que pode ser transportado

    a serialização também é usada para converter objetos em JSON, XML


    também é importante quando armazenamos objetos em caches ou banco de dados
    */

    private static final long serialVersionUID = 1L;
    // número que identifica a versão da classe que fou=i usada durante o
    // processo de serialização
    // garante que a serialização aconteça corretamente


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // tem que falar qual o tipo de geração do ID que vamos adotar
    //IDENTITY: incrementa de um em um
    private Long id;

    @Column(name = "first_name", nullable = false, length = 80)
    private String fistName;

    @Column(name = "last_name", nullable = false, length = 80)
    private String lastName;

    @Column( nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 6)
    private String gender;

    @Column(nullable = false)
    private Boolean enabled;

    public Person() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
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
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getId(), person.getId()) && Objects.equals(getFistName(), person.getFistName()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getAddress(), person.getAddress()) && Objects.equals(getGender(), person.getGender()) && Objects.equals(getEnabled(), person.getEnabled());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFistName(), getLastName(), getAddress(), getGender(), getEnabled());
    }
/*
        determina se os objetos são iguais, verifica se os dois objetos ocupam o mesmo espaço na memória

        Se você sobrescrever equals() sem sobrescrever hashCode(), pode haver inconsistências ao usar coleções baseadas em hash.
         */


    // Se equals() for sobrescrito, hashCode() também deve ser para evitar problemas em coleções como HashMap e HashSet.


        /*
        ferramenta do JVM usada para montar a tabela de hash de modo correto

        tabela hash: tabela onde as informações são armazenadas conforme um número hash
        calculado com base nas prioridades da informação, permitindo recuperar uma informação
        na tabela mais rapidamente

        usar uma tabela hash diminui o tempo de busca
         */

}
