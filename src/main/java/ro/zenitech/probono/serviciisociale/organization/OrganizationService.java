package ro.zenitech.probono.serviciisociale.organization;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {
    private OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<Organization> getAllOrganizations(){
        return organizationRepository.findAll();
    }

    public Organization getOrganizationById(Long id){
        return organizationRepository.getOne(id);
    }

    public Organization createOrganization(Organization organization){
        return organizationRepository.saveAndFlush(organization);
    }

    public void deleteOrganization(Long id){
        organizationRepository.deleteById(id);
    }

    public Organization updateOrganization(Long id, Organization organization){
        Organization existingOrganization = organizationRepository.getOne(id);
        BeanUtils.copyProperties(organization, existingOrganization, "id");
        return organizationRepository.saveAndFlush(existingOrganization);
    }

}
