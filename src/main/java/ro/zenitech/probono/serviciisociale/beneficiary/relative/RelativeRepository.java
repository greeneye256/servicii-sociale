package ro.zenitech.probono.serviciisociale.beneficiary.relative;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelativeRepository extends JpaRepository<Relative,Long> {
}
