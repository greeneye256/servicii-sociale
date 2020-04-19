package ro.zenitech.probono.serviciisociale.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.zenitech.probono.serviciisociale.security.model.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
