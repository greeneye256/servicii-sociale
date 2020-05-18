package ro.zenitech.probono.serviciisociale.volnteer;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/volunteers")
public class VolunteerController {
    private final VolunteerRepository volunteerRepository;

    @Autowired
    public VolunteerController(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Volunteer> getAll() {
        return volunteerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Volunteer getById(@PathVariable Long id) {
        return volunteerRepository.getOne(id);
    }

    @PostMapping
    public Volunteer create(@RequestBody final Volunteer Volunteer) {
        return volunteerRepository.saveAndFlush(Volunteer);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        volunteerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Volunteer update(@PathVariable Long id, @RequestBody Volunteer volunteer) {
        System.out.println();
        Volunteer existingVolunteer = volunteerRepository.getOne(id);
        BeanUtils.copyProperties(volunteer, existingVolunteer, "id");
        return volunteerRepository.saveAndFlush(existingVolunteer);
    }
}
