package ro.zenitech.probono.serviciisociale.socialcase.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByPhoneNumber(String phoneNumber);
}
