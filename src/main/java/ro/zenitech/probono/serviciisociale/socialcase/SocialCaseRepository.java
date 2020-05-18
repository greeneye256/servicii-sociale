package ro.zenitech.probono.serviciisociale.socialcase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialCaseRepository extends JpaRepository<SocialCase, Long> {
}
