package find.cloud.user.domain.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import find.cloud.user.domain.entity.User;
import find.cloud.user.domain.entity.UserDetail;

import java.util.Optional;

public interface UserRepository {
    /**
     * 创建用户
     * @param user
     * @return
     */
    void create(User user);

    /**
     * 判断是否已经存在对应的用户
     * @param wxno
     * @param phone
     * @return
     */
    Boolean isExist(String wxno, String phone);

    /**
     * 判断用户是否存在
     * @param userId
     * @return
     */
    Boolean isExist(Long userId);

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
    void save(User user);

    /**
     * 分页查询用户
     * @param user
     * @param page
     * @return
     */
    IPage<User> findPage(User user, Page page);

    /**
     * 更新用户昵称和用户名称
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
}
