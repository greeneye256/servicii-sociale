package ro.zenitech.probono.serviciisociale.security.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ro.zenitech.probono.serviciisociale.security.model.ApplicationUser;
import ro.zenitech.probono.serviciisociale.security.repository.ApplicationUserRepository;

import java.util.List;

//@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    AuthenticationManager authenticationManager;

    public UserController(ApplicationUserRepository applicationUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser applicationUser){
        System.out.println(applicationUser);
        String pass = bCryptPasswordEncoder.encode(applicationUser.getPassword());
        applicationUser.setPassword(pass);
        applicationUserRepository.saveAndFlush(applicationUser);
    }

    @GetMapping
    @RequestMapping
    public List<ApplicationUser> getUsers(){
        return applicationUserRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ApplicationUser getUserById(@PathVariable long id){
        return applicationUserRepository.getOne(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable long id){
        applicationUserRepository.deleteById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ApplicationUser update(@PathVariable Long id, @RequestBody ApplicationUser applicationUser) {
        System.out.println("you are in update user");
        ApplicationUser existingUser = applicationUserRepository.getOne(id);
        BeanUtils.copyProperties(applicationUser, existingUser, "id");
        return applicationUserRepository.saveAndFlush(existingUser);
    }
}
