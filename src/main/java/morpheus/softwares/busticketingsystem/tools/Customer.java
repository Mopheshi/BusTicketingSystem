package morpheus.softwares.busticketingsystem.tools;

import jakarta.persistence.*;

import java.util.List;

/**
 *
 * @author MOPHE
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Role> roles;
    
    public Customer(){}

    public Customer(Long id, String username, String password, List<Role> roles) {
        setId(id);
        setUsername(username);
        setPassword(password);
        setRoles(roles);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
