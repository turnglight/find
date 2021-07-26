package find.cloud.user.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import find.cloud.user.controller.vo.UserCreateVo;
import find.cloud.user.controller.vo.UserQueryVo;
import find.cloud.user.controller.vo.UserUpdateVo;
import find.cloud.user.entity.User;
import find.cloud.user.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity page(@RequestBody @Validated UserQueryVo userQueryVo){
        IPage<User> iPage = userService.findPage(userQueryVo);
        return ResponseEntity.ok().body(iPage);
    }

    /**
     * 创建用户
     * @return
     */
    @PostMapping
    public ResponseEntity create(@RequestBody @Validated UserCreateVo userCreateVo){
        if(StringUtils.isBlank(userCreateVo.getPhone()) && StringUtils.isBlank(userCreateVo.getWxno())){
            return ResponseEntity.badRequest().body("参数错误");
        }
        User user = new User();
        user.setWxno(Optional.of(userCreateVo.getWxno()).get());
        user.setPhone(Optional.of(userCreateVo.getPhone()).get());
        long id = userService.create(user);
        return ResponseEntity.ok(id);
    }

    /**
     * 更新用户信息
     * @param userUpdateVo
     * @return
     */
    @PutMapping
    public ResponseEntity update(@RequestBody @Validated UserUpdateVo userUpdateVo){
        User user = new User();
        BeanUtils.copyProperties(userUpdateVo, user);
        User newUser = userService.update(user);
        return ResponseEntity.ok(newUser);
    }
}
