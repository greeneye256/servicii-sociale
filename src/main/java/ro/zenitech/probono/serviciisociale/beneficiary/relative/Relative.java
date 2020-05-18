package ro.zenitech.probono.serviciisociale.beneficiary.relative;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ro.zenitech.probono.serviciisociale.beneficiary.Beneficiary;

import javax.persistence.*;

@Entity
public class Relative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private byte age;
    private String familyBonding;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Beneficiary beneficiary;

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

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getFamilyBonding() {
        return familyBonding;
    }

    public void setFamilyBonding(String familyBonding) {
        this.familyBonding = familyBonding;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }
}
