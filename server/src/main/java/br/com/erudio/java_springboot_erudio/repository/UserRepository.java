package br.com.erudio.java_springboot_erudio.repository;

import br.com.erudio.java_springboot_erudio.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    // aqui ele passou só pra gente saber caso precise e blablabla

    @Query ("SELECT u FROM User u WHERE u.userName =:userName")
    User findByUsername(@Param("userName") String userName);

}
