package ro.zenitech.probono.serviciisociale.socialcase;

import ro.zenitech.probono.serviciisociale.beneficiary.Beneficiary;

import javax.persistence.*;

@Entity
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Beneficiary beneficiary;
    @ManyToOne
    private NotyfingPerson notyfingPerson;
    @ManyToOne
    private ResponsibleEmployee responsibleEmployee;
}
