package find.cloud.user.service;

import find.cloud.user.domain.entity.User;
import org.springframework.data.domain.Page;

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
    User create(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    User update(User user);

    /**
     * 分页查询用户信息
     * @param user
     * @return
     */
    Page<User> findPage(User user);

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
}
