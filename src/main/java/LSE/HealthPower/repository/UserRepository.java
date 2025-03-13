package LSE.HealthPower.repository;

import LSE.HealthPower.user.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {

    SiteUser findByUsername(String username);
}
