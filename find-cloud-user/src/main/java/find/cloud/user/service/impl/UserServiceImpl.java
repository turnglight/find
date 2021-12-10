package find.cloud.user.service.impl;

import find.cloud.user.domain.User;
import find.cloud.user.repository.UserRepository;
import find.cloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author turnglight
 * @date  2021-11-30
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.create(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<User> findPage(User user) {
        return userRepository.findPage(user);
    }

    @Override
    public Boolean isExist(String wxno, String phone) {
        return userRepository.isExist(wxno, phone);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
