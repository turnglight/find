package find.cloud.user.repository.impl;

import find.cloud.user.converter.UserConverter;
import find.cloud.user.domain.User;
import find.cloud.user.persistence.mapper.UserDetailMapper;
import find.cloud.user.persistence.mapper.UserMapper;
import find.cloud.user.persistence.model.UserDetailModel;
import find.cloud.user.persistence.model.UserModel;
import find.cloud.user.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author 01407975
 * @description 用户
 * @date 2021/12/9
 */
@Service
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDetailMapper userDetailMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public User create(User user) {
        UserModel userModel = UserConverter.INSTANCE.userToUserModel(user);
        UserModel savedUserModel = userMapper.save(userModel);

        UserDetailModel userDetailModel= UserConverter.INSTANCE.userToUserDetailModel(user);
        UserDetailModel savedDetailModel = userDetailMapper.save(userDetailModel);

        User result = new User();
        BeanUtils.copyProperties(savedUserModel, result);
        BeanUtils.copyProperties(savedDetailModel, result);
        return result;
    }

    @Override
    public Boolean isExist(String wxno, String phone) {
        UserModel existOne = userMapper.findByWxnoOrPhone(wxno, phone);
        if(existOne != null){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Optional<User> findById(Long userId) {
        UserModel userModel = userMapper.findById(userId).get();
        UserDetailModel userDetailModel = userDetailMapper.findByUserId(userId).get();

        User result = new User();
        BeanUtils.copyProperties(userModel, result);
        BeanUtils.copyProperties(userDetailModel, result);
        return Optional.of(result);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public User save(User user) {
        UserDetailModel userDetailModel = UserConverter.INSTANCE.userToUserDetailModel(user);
        Optional<UserDetailModel> oldModel = userDetailMapper.findByUserId(user.getId());
        if(oldModel.isPresent()){
            UserDetailModel v2 = oldModel.get();
            userDetailModel.setId(v2.getId());
            userDetailModel.setLat(v2.getLat());
            userDetailModel.setLng(v2.getLng());
            userDetailModel.setSno(v2.getSno());
            userDetailModel.setUserId(v2.getUserId());
        }
        UserDetailModel v3 = userDetailMapper.save(userDetailModel);
        User result = new User();
        BeanUtils.copyProperties(v3, result);
        return result;
    }

    @Override
    public Page<User> findPage(User user) {
        return null;
    }
}
