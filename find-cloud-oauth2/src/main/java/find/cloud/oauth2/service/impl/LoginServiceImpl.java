package find.cloud.oauth2.service.impl;

import find.cloud.oauth2.model.UserModel;
import find.cloud.oauth2.repository.UserRepository;
import find.cloud.oauth2.security.SecurityUser;
import find.cloud.oauth2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author turnglight
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public SecurityUser loadByUsername(String username) {
        UserModel user = userRepository.findByName(username);
        SecurityUser securityUser = new SecurityUser(user.getName(), user.getPassword(), null);
        return securityUser;

    }
}
