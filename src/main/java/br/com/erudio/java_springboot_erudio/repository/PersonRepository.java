package br.com.erudio.java_springboot_erudio.repository;
import br.com.erudio.java_springboot_erudio.Model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PersonRepository extends JpaRepository<Person, Long> {

    @Modifying(clearAutomatically = true)
    // garante que os conceitos de ACID sejam aplicados
    // o spring data já adiciona isso, mas como estamos usando uma query manual precisamos colocar
    @Query("UPDATE Person p SET p.enabled = false WHERE p.id =:id")
    // o nome do atributo deve ser da forma escrita no código JAVA, não do banco
    void disablePerson(@Param("id")Long id);

    @Query("SELECT p FROM Person p WHERE p.fistName LIKE LOWER(CONCAT('%',:fistName, '%'))")
    // o nome do atributo deve ser da forma escrita no código JAVA, não do banco
    // não precisa de modifying pq é apenas leitura
    Page<Person> findPeopleByName(@Param("fistName")String firstName, Pageable pageable);

}
