package find.cloud.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import find.cloud.user.controller.vo.UserQueryVo;
import find.cloud.user.entity.User;

public interface UserService extends IService<User> {
    IPage<User> findPage(UserQueryVo userQueryVo);
    long create(User user);
    User update(User user);
}
