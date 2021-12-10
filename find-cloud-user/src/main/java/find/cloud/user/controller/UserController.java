package find.cloud.user.controller;

import find.cloud.type.response.ResponseResult;
import find.cloud.user.controller.response.UserCreateApiPost;
import find.cloud.user.controller.response.UserQueryApiGet;
import find.cloud.user.controller.response.UserUpdateApiPost;
import find.cloud.user.domain.User;
import find.cloud.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @author turnglight
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页查询用户列表
     * @return
     */
    @GetMapping
    public ResponseResult page(@RequestBody @Validated UserQueryApiGet userQueryApiGet){
        User user = new User();
        BeanUtils.copyProperties(userQueryApiGet, user);
        Page<User> page = userService.findPage(user);
        return ResponseResult.ok(page);
    }

    /**
     * 创建用户
     * @return
     */
    @PostMapping
    public ResponseResult create(@RequestBody @Validated UserCreateApiPost userCreateVo){
        if(userService.isExist(userCreateVo.getWxno(), userCreateVo.getPhone())){
            return ResponseResult.error("用户已注册");
        }
        User user = new User(userCreateVo.getWxno(), userCreateVo.getPhone());
        return ResponseResult.ok(userService.create(user));
    }

    /**
     * 更新用户信息
     * @param userUpdateApiPost
     * @return
     */
    @PutMapping
    public ResponseResult update(@RequestBody @Validated UserUpdateApiPost userUpdateApiPost){
        User user = new User();
        BeanUtils.copyProperties(userUpdateApiPost, user);
        User result = userService.update(user);
        return ResponseResult.ok(result);
    }
}
