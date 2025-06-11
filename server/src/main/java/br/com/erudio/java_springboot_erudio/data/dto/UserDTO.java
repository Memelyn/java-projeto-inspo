package br.com.erudio.java_springboot_erudio.data.dto;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Relation(collectionRelation = "users")
public class UserDTO extends RepresentationModel<UserDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String userName;
    private String fullName;
    private String password;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;
    //private List<String> roles;

    public UserDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPassword() {
        return password;
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

   // public List<String> getRoles() {
    //    return roles;
    //}

   // public void setRoles(List<String> roles) {
      //  this.roles = roles;
    //}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO user = (UserDTO) o;
        return Objects.equals(getId(), user.getId()) &&
               Objects.equals(getUserName(), user.getUserName()) &&
               Objects.equals(getFullName(), user.getFullName()) &&
               Objects.equals(getPassword(), user.getPassword()) &&
               Objects.equals(getAccountNonExpired(), user.getAccountNonExpired()) &&
               Objects.equals(getAccountNonLocked(), user.getAccountNonLocked()) &&
               Objects.equals(getCredentialsNonExpired(), user.getCredentialsNonExpired()) &&
               Objects.equals(getEnabled(), user.getEnabled()) ;
             //  Objects.equals(getRoles(), user.getRoles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getFullName(), getPassword(),
                getAccountNonExpired(), getAccountNonLocked());
               // getCredentialsNonExpired(), getEnabled(), getRoles());
    }
}
