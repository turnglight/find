package find.cloud.user.repository;

import find.cloud.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author 01407975
 * @description 用户
 * @date 2021/11/29
 */
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT u FROM t_user u")
    Page<User> findPage(String name, String nickname, String sno, Integer gender, String phone, String wxno, Integer status, Integer vipState, Integer vipLevel, Pageable pageable);
}
