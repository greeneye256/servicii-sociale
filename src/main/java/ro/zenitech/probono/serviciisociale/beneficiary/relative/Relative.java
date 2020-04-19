package ro.zenitech.probono.serviciisociale.beneficiary.relative;

import ro.zenitech.probono.serviciisociale.beneficiary.Beneficiary;

import javax.persistence.*;

@Entity
public class Relative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String firstName;
    private String lastName;
    private byte age;
    private String familyBonding;
    @ManyToOne(fetch = FetchType.LAZY)
    private Beneficiary beneficiary;




}
