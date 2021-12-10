package find.cloud.user.repository;

import find.cloud.user.domain.User;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface UserRepository {
    /**
     * 创建用户
     * @param user
     * @return
     */
    User create(User user);

    /**
     * 判断是否已经存在对应的用户
     * @param wxno
     * @param phone
     * @return
     */
    Boolean isExist(String wxno, String phone);

    /**
     * 查找指定用户
     * @param userId
     * @return
     */
    Optional<User> findById(Long userId);

    /**
     * 保存用户
     * @param user
     * @return
     */
    User save(User user);

    /**
     * 分页查询用户
     * @param user
     * @return
     */
    Page<User> findPage(User user);
}
