package ro.zenitech.probono.serviciisociale.socialcase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ResponsibleEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    @OneToMany(
            mappedBy="responsibleEmployee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Case> cases = new ArrayList<>();
}
