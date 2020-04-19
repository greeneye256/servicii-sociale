package ro.zenitech.probono.serviciisociale.socialcase;

import ro.zenitech.probono.serviciisociale.beneficiary.Beneficiary;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class NotyfingPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @OneToMany(
            mappedBy="notyfingPerson",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Case> cases = new ArrayList<>();

}
