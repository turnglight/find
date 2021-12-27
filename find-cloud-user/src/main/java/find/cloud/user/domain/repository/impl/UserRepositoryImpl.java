package find.cloud.user.domain.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import find.cloud.user.domain.entity.User;
import find.cloud.user.domain.entity.UserDetail;
import find.cloud.user.persistence.mapper.UserDetailMapper;
import find.cloud.user.persistence.mapper.UserMapper;
import find.cloud.user.persistence.model.UserDetailModel;
import find.cloud.user.persistence.model.UserModel;
import find.cloud.user.domain.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.openssl.PasswordException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
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
    public void create(User user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserModel userModel = new UserModel();
        userModel.setWxno(user.getWxno());
        userModel.setPhone(user.getPhone());
        userModel.setPassword(passwordEncoder.encode("888888"));
        userMapper.insert(userModel);

        UserDetailModel userDetailModel= generateEmptyUserDetailModel(userModel.getId(), userModel.getPhone());
        userDetailMapper.insert(userDetailModel);
    }

    @Override
    public Boolean isExist(String wxno, String phone) {
        QueryWrapper<UserModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("wxno", wxno).or().eq("phone", phone);
        return userMapper.selectOne(queryWrapper) == null ? Boolean.FALSE : Boolean.TRUE;
    }

    @Override
    public Boolean isExist(Long userId) {
        return userMapper.selectById(userId) == null ? Boolean.FALSE : Boolean.TRUE;
    }

    @Override
    public Optional<User> findById(Long userId) {
        UserModel userModel = userMapper.selectById(userId);
        QueryWrapper<UserDetailModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        UserDetailModel userDetailModel = userDetailMapper.selectOne(queryWrapper);

        User result = new User();
        BeanUtils.copyProperties(userModel, result);
        BeanUtils.copyProperties(userDetailModel, result);
        return Optional.of(result);
    }

    @Override
    public void save(User user) {
        UserDetailModel userDetailModel = new UserDetailModel();
        QueryWrapper<UserDetailModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user.getId());
        UserDetailModel oldModel = userDetailMapper.selectOne(queryWrapper);
        if(oldModel != null ){
            userDetailModel.setId(oldModel.getId());
            userDetailModel.setLat(oldModel.getLat());
            userDetailModel.setLng(oldModel.getLng());
            userDetailModel.setSno(oldModel.getSno());
            userDetailModel.setUserId(oldModel.getUserId());
        }
        userDetailMapper.insert(userDetailModel);
    }

    @Override
    public IPage<User> findPage(User user, Page page) {
        return userMapper.queryPage(page, user);
    }

    @Override
    public void updateNicknameAndName(Long userId, String name, String nickName) {
        UserModel userModel = userMapper.selectById(userId);
        userModel.setName(name);
        userModel.setNickname(nickName);
        userMapper.updateById(userModel);
    }

    @Override
    public void updateUserDetail(UserDetail userDetail) {
        UserDetailModel oldUserDetailModel = userDetailMapper.selectById(userDetail.getId());
        copyProperties(oldUserDetailModel, userDetail);
        userDetailMapper.updateById(oldUserDetailModel);
    }

    @Override
    public void updatePassword(Long id, String oldPasswd, String newPasswd) throws PasswordException {
        PasswordEncoder passwordEncoder  = new BCryptPasswordEncoder();
        UserModel userModel = userMapper.selectById(id);
        if(passwordEncoder.matches(oldPasswd, userModel.getPassword())){
            userModel.setPassword(passwordEncoder.encode(newPasswd));
            userMapper.updateById(userModel);
        }else{
            throw new PasswordException("旧密码错误");
        }
    }

    private void copyProperties(UserDetailModel model, UserDetail userDetail){
        model.setWeight(userDetail.getWeight());
        model.setHeight(userDetail.getHeight());
        model.setVoice(StringUtils.isNotBlank(userDetail.getVoice())?userDetail.getVoice():"");
        model.setVideo(StringUtils.isNotBlank(userDetail.getVideo())?userDetail.getVideo():"");
        model.setVia(StringUtils.isNotBlank(userDetail.getVia())?userDetail.getVia():"");
        model.setSmoking(userDetail.getSmoking() != null? userDetail.getSmoking() : 0);
        model.setSignature(StringUtils.isNotBlank(userDetail.getSignature())?userDetail.getSignature():"");
        model.setSchoolYear(StringUtils.isNotBlank(userDetail.getSchoolYear())?userDetail.getSchoolYear():"");
        model.setSchool(StringUtils.isNotBlank(userDetail.getSchool())?userDetail.getSchool():"");
        model.setRegion(StringUtils.isNotBlank(userDetail.getRegion())?userDetail.getRegion():"");
        model.setProfession(StringUtils.isNotBlank(userDetail.getProfession())?userDetail.getProfession():"");
        model.setPhotos(StringUtils.isNotBlank(userDetail.getPhotos())?userDetail.getPhotos():"");
        model.setHobby(StringUtils.isNotBlank(userDetail.getHobby())?userDetail.getHobby():"");
        model.setEdu(StringUtils.isNotBlank(userDetail.getEdu())?userDetail.getEdu():"");
        model.setDrink(userDetail.getDrink());
        model.setCareer(StringUtils.isNotBlank(userDetail.getCareer())?userDetail.getCareer():"");
        model.setAge(userDetail.getAge());
    }

    public UserDetailModel generateEmptyUserDetailModel(Long userId, String phone){
        UserDetailModel userDetailModel = new UserDetailModel();
        userDetailModel.setUserId(userId);
        LocalDateTime now = LocalDateTime.now();
        Instant instant = now.toInstant(ZoneOffset.UTC);
        userDetailModel.setSno(String.valueOf(instant.getEpochSecond()));
        userDetailModel.setLng(new BigDecimal(0));
        userDetailModel.setLat(new BigDecimal(0));
        userDetailModel.setAge(18);
        userDetailModel.setCareer("");
        userDetailModel.setDrink(0);
        userDetailModel.setEdu("");
        userDetailModel.setGender(0);
        userDetailModel.setHeight(160);
        userDetailModel.setHobby("");
        userDetailModel.setIdNumber("");
        userDetailModel.setPhone(phone);
        userDetailModel.setPhotos("");
        userDetailModel.setProfession("");
        userDetailModel.setRegion("");
        userDetailModel.setSchool("");
        userDetailModel.setSchoolYear("");
        userDetailModel.setSignature("");
        userDetailModel.setSmoking(0);
        userDetailModel.setVia("");
        userDetailModel.setVideo("");
        userDetailModel.setVoice("");
        userDetailModel.setWeight(40);
        return userDetailModel;
    }
}
