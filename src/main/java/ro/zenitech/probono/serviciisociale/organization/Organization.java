package ro.zenitech.probono.serviciisociale.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ro.zenitech.probono.serviciisociale.socialcase.SocialCase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contactPerson;
    private String email;
    private String phoneNumber;
    private String details;
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy="volunteer"
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
    )
    @JsonIgnore
    private List<SocialCase> cases = new ArrayList<>();

    public List<SocialCase> getCases() {
        return cases;
    }

    public void setCases(List<SocialCase> cases) {
        this.cases = cases;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
