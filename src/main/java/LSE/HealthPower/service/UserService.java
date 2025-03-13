package LSE.HealthPower.service;

import LSE.HealthPower.repository.UserRepository;
import LSE.HealthPower.user.SiteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String username, String password, String email) {
        SiteUser siteUser = new SiteUser();
        siteUser.setUsername(username);

        //BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        //siteUser.setPassword(bCryptPasswordEncoder.encode(password));
        siteUser.setPassword(password);
        siteUser.setEmail(email);

        userRepository.save(siteUser);
    }
}
