package ro.zenitech.probono.serviciisociale.security.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "roles")
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    @NotEmpty
    private String name;

//    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
//    private List<ApplicationUser> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<ApplicationUser> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<ApplicationUser> users) {
//        this.users = users;
//    }


}

