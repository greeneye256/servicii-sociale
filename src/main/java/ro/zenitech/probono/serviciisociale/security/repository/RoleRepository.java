package ro.zenitech.probono.serviciisociale.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.zenitech.probono.serviciisociale.security.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
