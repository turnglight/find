package find.cloud.user.service.impl;

import base.web.exception.NotExistDataException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import find.cloud.user.domain.entity.User;
import find.cloud.user.domain.entity.UserDetail;
import find.cloud.user.domain.repository.UserRepository;
import find.cloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void create(User user) {
        userRepository.create(user);
    }

    @Override
    public void update(User user) {
        Optional<User> oldUser = userRepository.findById(user.getId());
        if(oldUser.isEmpty()){
            throw new NotExistDataException("用户不存在");
        }
        userRepository.save(user);
    }

    @Override
    public IPage<User> findPage(User user, Page page) {
        return userRepository.findPage(user, page);
    }

    @Override
    public Boolean isExist(String wxno, String phone) {
        return userRepository.isExist(wxno, phone);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateNicknameAndName(Long userId, String name, String nickName) {
        Boolean isExist = userRepository.isExist(userId);
        if(Boolean.FALSE.equals(isExist)){
            throw new NotExistDataException("用户不存在");
        }
        userRepository.updateNicknameAndName(userId, name, nickName);
    }

    @Override
    public void updateUserDetail(UserDetail userDetail) {
        Boolean isExist = userRepository.isExist(userDetail.getUserId());
        if(Boolean.FALSE.equals(isExist)){
            throw new NotExistDataException("用户不存在");
        }
        userRepository.updateUserDetail(userDetail);
    }

    @Override
    public void updatePassword(Long id, String oldPasswd, String newPasswd) {

    }

}
