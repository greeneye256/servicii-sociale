package ro.zenitech.probono.serviciisociale.beneficiary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ro.zenitech.probono.serviciisociale.beneficiary.relative.Relative;
import ro.zenitech.probono.serviciisociale.socialcase.SocialCase;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String cnp;
    private int age;
    private String neighborhood;
    private String street;
    private String addressDetails;
    private String phoneNumber;
    private int income;
    private String livingConditions;
    private String risks;
    private String health;
    private String autonomy;
    private boolean alimentationNeeds;
    private boolean medicationNeeds;
    private boolean counselingNeeds;
    private String needsDetails;
    private String potentialSupportPersons;
    private String potentialSupportPersonsDetails;
    private boolean shoppingSupport;
    private boolean utilityPaymentSupport;
    private boolean counselingSupport;
    private String supportDetails;
    private String levelOfUrgency;
    private boolean isCaseActive = true;

    @OneToOne(
            fetch = FetchType.LAZY,
            mappedBy = "beneficiary"
    )
    @JsonIgnore
    private SocialCase socialCase;
    @OneToMany(
            mappedBy="beneficiary",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Relative> relatives = new ArrayList<>();

    public String getLivingConditions() {
        return livingConditions;
    }

    public void setLivingConditions(String livingConditions) {
        this.livingConditions = livingConditions;
    }

    public String getRisks() {
        return risks;
    }

    public void setRisks(String risks) {
        this.risks = risks;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAutonomy() {
        return autonomy;
    }

    public void setAutonomy(String autonomy) {
        this.autonomy = autonomy;
    }

    public boolean isAlimentationNeeds() {
        return alimentationNeeds;
    }

    public void setAlimentationNeeds(boolean alimentationNeeds) {
        this.alimentationNeeds = alimentationNeeds;
    }

    public boolean isMedicationNeeds() {
        return medicationNeeds;
    }

    public void setMedicationNeeds(boolean medicationNeeds) {
        this.medicationNeeds = medicationNeeds;
    }

    public boolean isCounselingNeeds() {
        return counselingNeeds;
    }

    public void setCounselingNeeds(boolean counselingNeeds) {
        this.counselingNeeds = counselingNeeds;
    }

    public String getNeedsDetails() {
        return needsDetails;
    }

    public void setNeedsDetails(String needsDetails) {
        this.needsDetails = needsDetails;
    }

    public String getPotentialSupportPersons() {
        return potentialSupportPersons;
    }

    public void setPotentialSupportPersons(String potentialSupportPersons) {
        this.potentialSupportPersons = potentialSupportPersons;
    }

    public String getPotentialSupportPersonsDetails() {
        return potentialSupportPersonsDetails;
    }

    public void setPotentialSupportPersonsDetails(String potentialSupportPersonsDetails) {
        this.potentialSupportPersonsDetails = potentialSupportPersonsDetails;
    }

    public boolean isShoppingSupport() {
        return shoppingSupport;
    }

    public void setShoppingSupport(boolean shoppingSupport) {
        this.shoppingSupport = shoppingSupport;
    }

    public boolean isUtilityPaymentSupport() {
        return utilityPaymentSupport;
    }

    public void setUtilityPaymentSupport(boolean utilityPaymentSupport) {
        this.utilityPaymentSupport = utilityPaymentSupport;
    }

    public boolean isCounselingSupport() {
        return counselingSupport;
    }

    public void setCounselingSupport(boolean counselingSupport) {
        this.counselingSupport = counselingSupport;
    }

    public String getSupportDetails() {
        return supportDetails;
    }

    public void setSupportDetails(String supportDetails) {
        this.supportDetails = supportDetails;
    }

    public String getLevelOfUrgency() {
        return levelOfUrgency;
    }

    public void setLevelOfUrgency(String levelOfUrgency) {
        this.levelOfUrgency = levelOfUrgency;
    }

    public boolean isCaseActive() {
        return isCaseActive;
    }

    public void setCaseActive(boolean caseActive) {
        isCaseActive = caseActive;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SocialCase getSocialCase() {
        return socialCase;
    }

    public void setSocialCase(SocialCase socialCase) {
        this.socialCase = socialCase;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public List<Relative> getRelatives() {
        return relatives;
    }

    public void setRelatives(List<Relative> relatives) {
        this.relatives = relatives;
    }
}
