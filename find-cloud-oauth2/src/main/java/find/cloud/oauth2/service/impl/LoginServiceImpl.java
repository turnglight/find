package find.cloud.oauth2.service.impl;

import find.cloud.oauth2.model.SecurityUser;
import find.cloud.oauth2.model.UserModel;
import find.cloud.oauth2.repository.UserRepository;
import find.cloud.oauth2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author turnglight
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public SecurityUser loadByUsername(String username) throws UsernameNotFoundException{
        UserModel user = userRepository.findByName(username);
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException("用户不存在");
        }
        SecurityUser securityUser = new SecurityUser(user.getId(), user.getName(), user.getPassword(), null);
        return securityUser;

    }
}
