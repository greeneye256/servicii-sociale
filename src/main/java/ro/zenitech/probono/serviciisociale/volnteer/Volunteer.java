package ro.zenitech.probono.serviciisociale.volnteer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ro.zenitech.probono.serviciisociale.socialcase.SocialCase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy="volunteer"
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
    )
    @JsonIgnore
    private List<SocialCase> cases = new ArrayList<>();

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<SocialCase> getCases() {
        return cases;
    }

    public void setCases(List<SocialCase> cases) {
        this.cases = cases;
    }
}
