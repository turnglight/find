package find.cloud.oauth2.repository;

import find.cloud.oauth2.model.UserModel;
import org.springframework.data.repository.CrudRepository;

/**
 * @author 01407975
 * @description 用户
 * @date 2022/1/5
 */
public interface UserRepository extends CrudRepository<UserModel, Long> {

    UserModel findByName(String name);
}
