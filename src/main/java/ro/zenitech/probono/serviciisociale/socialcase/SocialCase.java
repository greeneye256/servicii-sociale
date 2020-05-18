package ro.zenitech.probono.serviciisociale.socialcase;

import ro.zenitech.probono.serviciisociale.beneficiary.Beneficiary;
import ro.zenitech.probono.serviciisociale.organization.Organization;
import ro.zenitech.probono.serviciisociale.socialcase.employee.Employee;
import ro.zenitech.probono.serviciisociale.volnteer.Volunteer;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class SocialCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateOfTakingOverCase;
    private String notifyingPerson;
    private String notifyingPersonPhoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "beneficiary_id", referencedColumnName = "id")
    private Beneficiary beneficiary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id", nullable = true)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="volunteer_id", nullable = true)
    private Volunteer volunteer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="organization_id", nullable = true)
    private Organization organization;

    public Date getDateOfTakingOverCase() {
        return dateOfTakingOverCase;
    }

    public void setDateOfTakingOverCase(Date dateOfTakingOverCase) {
        this.dateOfTakingOverCase = dateOfTakingOverCase;
    }

    public String getNotifyingPerson() {
        return notifyingPerson;
    }

    public void setNotifyingPerson(String notifyingPerson) {
        this.notifyingPerson = notifyingPerson;
    }

    public String getNotifyingPersonPhoneNumber() {
        return notifyingPersonPhoneNumber;
    }

    public void setNotifyingPersonPhoneNumber(String notifyingPersonPhoneNumber) {
        this.notifyingPersonPhoneNumber = notifyingPersonPhoneNumber;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
