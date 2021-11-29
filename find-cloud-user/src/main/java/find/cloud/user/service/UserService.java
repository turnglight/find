package find.cloud.user.service;

import find.cloud.user.controller.vo.UserQueryVo;
import find.cloud.user.entity.User;
import org.springframework.data.domain.Page;

public interface UserService{
    Page<User> findPage(UserQueryVo userQueryVo);
    User create(User user);
    User update(User user);

}
