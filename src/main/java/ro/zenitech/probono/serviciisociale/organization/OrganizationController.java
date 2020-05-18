package ro.zenitech.probono.serviciisociale.organization;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Organization> getAll() {
        return organizationService.getAllOrganizations();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Organization getById(@PathVariable Long id) {
        return organizationService.getOrganizationById(id);
    }

    @PostMapping
    public Organization create(@RequestBody final Organization organization) {
        return organizationService.createOrganization(organization);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        organizationService.deleteOrganization(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Organization update(@PathVariable Long id, @RequestBody Organization organization) {
        return organizationService.updateOrganization(id, organization);
    }
}
