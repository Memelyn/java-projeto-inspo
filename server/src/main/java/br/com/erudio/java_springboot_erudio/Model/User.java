package br.com.erudio.java_springboot_erudio.Model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name =  "user_name", unique = true)
    private String userName;

    @Column(name = "full_name")
    private String fullName;

    @Column
    private String password;

    @Column (name = "account_non_expired")
    private Boolean accountNonExpired;

    @Column (name = "account_non_locked")
    private Boolean accountNonLocked;

    @Column (name = "credentials_non_expired")
    private Boolean credentialsNonExpired;

    @Column
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    // quando carregar o user, trazer as permissões, não recomendável usar Eager em atributos muito grandes
    @JoinTable (name = "user_permission",
            joinColumns = {@JoinColumn(name = "id_user")},
            inverseJoinColumns = {@JoinColumn(name = "id_permission")})
    private List<Permission> permissions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books;

    // não é uma convenção do JPA, mas a gente precisa adicionar para usar em camadas superiores
    public List<String> getRoles(){
        List<String> roles =  new ArrayList<>();
        for (Permission permission : permissions){
            roles.add(permission.getDescription());
            // vamos criar uma lista com as strings de permissões que cada pessoa possui
        }
        return roles;
    }

    // Construtor vazio
    public User() {}

    // implementações do UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.permissions;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    // getters e setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // equals and hash code


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return getId() == user.getId() && Objects.equals(getUserName(), user.getUserName()) && Objects.equals(getFullName(), user.getFullName()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(isAccountNonExpired(), user.isAccountNonExpired()) && Objects.equals(isAccountNonLocked(), user.isAccountNonLocked()) && Objects.equals(isCredentialsNonExpired(), user.isCredentialsNonExpired()) && Objects.equals(isEnabled(), user.isEnabled()) && Objects.equals(getPermissions(), user.getPermissions()) && Objects.equals(getBooks(), user.getBooks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getFullName(), getPassword(), isAccountNonExpired(), isAccountNonLocked(), isCredentialsNonExpired(), isEnabled(), getPermissions(), getBooks());
    }
}
