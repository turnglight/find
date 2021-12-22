package find.cloud.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import find.cloud.user.domain.entity.User;
import find.cloud.user.domain.entity.UserDetail;

import java.util.Optional;

/**
 * 用户服务
 * @author turnglight
 * @date  2021-11-30
 */
public interface UserService{
    /**
     * 创建用户
     * @param user
     * @return
     */
    void create(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    void update(User user);

    /**
     * 分页查询用户信息
     * @param user
     * @return
     */
    IPage<User> findPage(User user, Page page);

    /**
     * 是否已经存在
     * @param wxno
     * @param phone
     * @return
     */
    Boolean isExist(String wxno, String phone);

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    Optional<User> findById(Long id);

    /**
     * 更新用户昵称
     * @param userId
     * @param name
     * @param nickName
     */
    void updateNicknameAndName(Long userId, String name, String nickName);

    /**
     * 更新用户详情
     * @param userDetail
     */
    void updateUserDetail(UserDetail userDetail);

    /**
     * 更新用户密码
     * @param id
     * @param oldPasswd
     * @param newPasswd
     */
    void updatePassword(Long id, String oldPasswd, String newPasswd);
}
