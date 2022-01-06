package find.cloud.oauth2.service;

import find.cloud.oauth2.security.SecurityUser;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface LoginService {

    SecurityUser loadByUsername(String username) throws UsernameNotFoundException;
}
