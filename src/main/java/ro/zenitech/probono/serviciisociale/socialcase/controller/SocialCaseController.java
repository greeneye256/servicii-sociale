package ro.zenitech.probono.serviciisociale.socialcase.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.zenitech.probono.serviciisociale.socialcase.SocialCase;
import ro.zenitech.probono.serviciisociale.socialcase.SocialCaseRepository;
import ro.zenitech.probono.serviciisociale.socialcase.SocialCaseService;
import ro.zenitech.probono.serviciisociale.socialcase.employee.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/socialCases")
public class SocialCaseController {

    private final SocialCaseRepository socialCaseRepository;
    private final EmployeeRepository employeeRepository;
    private final SocialCaseService socialCaseService;

    @Autowired
    public SocialCaseController(SocialCaseRepository socialCaseRepository, EmployeeRepository employeeRepository, SocialCaseService socialCaseService) {
        this.socialCaseRepository = socialCaseRepository;
        this.employeeRepository = employeeRepository;
        this.socialCaseService = socialCaseService;
    }

    @GetMapping
    public List<SocialCase> getCases() {
        return socialCaseRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public SocialCase getById(@PathVariable Long id) {
        return socialCaseRepository.getOne(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        socialCaseRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public SocialCase update(@PathVariable Long id, @RequestBody SocialCase socialCase) {
        SocialCase existingSocialCase = socialCaseRepository.getOne(id);
        BeanUtils.copyProperties(socialCase, existingSocialCase, "id");
        return socialCaseRepository.saveAndFlush(existingSocialCase);
    }

    @PostMapping
    public SocialCase createCase(@RequestBody SocialCase socialCase) {
//        PersonNotifying personNotifying = socialCase.getPersonNotifying();
//        personNotifyingRepository.saveAndFlush(personNotifying);
//        personNotifying = personNotifyingRepository.findByPhoneNumber(personNotifying.getPhoneNumber());
//        ResponsibleEmployee responsibleEmployee = socialCase.getResponsibleEmployee();
//        responsibleEmployeeRepository.saveAndFlush(responsibleEmployee);
//        responsibleEmployee = responsibleEmployeeRepository.findByPhoneNumber(responsibleEmployee.getPhoneNumber());
        if (socialCase.getEmployee() != null) {
            socialCase.setEmployee(employeeRepository.saveAndFlush(socialCase.getEmployee()));
        }
//        return socialCaseRepository.saveAndFlush(socialCase);
        return socialCaseService.saveSocialCase(socialCase);
    }
}
