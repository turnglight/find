package find.cloud.oauth2.service;

import find.cloud.oauth2.security.SecurityUser;

public interface LoginService {

    SecurityUser loadByUsername(String username);
}
