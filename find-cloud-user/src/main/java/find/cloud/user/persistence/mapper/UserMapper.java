package find.cloud.user.persistence.mapper;

import find.cloud.user.persistence.model.UserModel;
import org.springframework.data.repository.CrudRepository;

/**
 * @author turnglight
 * @description 用户
 * @date 2021/11/29
 */
public interface UserMapper extends CrudRepository<UserModel, Long> {
    /**
     * 查找微信号或者手机号码对应的用户
     * @param wxno
     * @param phone
     * @return
     */
    UserModel findByWxnoOrPhone(String wxno, String phone);
}
