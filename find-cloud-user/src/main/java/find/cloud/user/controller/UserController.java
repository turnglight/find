package find.cloud.user.controller;

import base.web.response.PageResponseResult;
import base.web.response.ResponseResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import find.cloud.user.controller.response.*;
import find.cloud.user.domain.entity.User;
import find.cloud.user.domain.entity.UserDetail;
import find.cloud.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @author turnglight
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页查询用户列表
     * @return
     */
    @GetMapping
    public PageResponseResult page(@RequestParam(required = false) String phone,
                                   @RequestParam(required = false) String wxno,
                                   @RequestParam(required = false) String nickname,
                                   @RequestParam(defaultValue = "1") Integer pageNo,
                                   @RequestParam(defaultValue = "10") Integer pageSize){
        User user = new User();
        user.setPhone(phone);
        user.setWxno(wxno);
        user.setNickname(nickname);

        Page pageable = new Page(pageNo, pageSize);
        IPage<User> page = userService.findPage(user, pageable);

        return PageResponseResult.ok(page.getRecords(), page.getTotal());
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
        userService.create(user);
        return ResponseResult.ok();
    }

    /**
     * 更新用户名称/昵称
     * @param apiPut
     * @return
     */
    @PutMapping(value = "name")
    public ResponseResult updateNicknameAndName(@RequestBody @Validated UserUpdateNickNameApiPut apiPut){
        userService.updateNicknameAndName(apiPut.getId(), apiPut.getName(), apiPut.getNickname());
        return ResponseResult.ok();
    }

    /**
     * 更新密码
     * @param apiPut
     * @return
     */
    @PutMapping(value = "password")
    public ResponseResult updatePassword(@RequestBody @Validated UserUpdatePasswordApiPut apiPut){
        userService.updatePassword(apiPut.getId(), apiPut.getOldPasswd(), apiPut.getNewPasswd());
        return ResponseResult.ok();
    }


    /**
     * 更新用户详情
     * @param userUpdateApiPost
     * @return
     */
    @PutMapping
    public ResponseResult update(@RequestBody @Validated UserDetailUpdateApiPut userUpdateApiPost){
        UserDetail userDetail = new UserDetail();
        BeanUtils.copyProperties(userUpdateApiPost, userDetail);
        userService.updateUserDetail(userDetail);
        return ResponseResult.ok();
    }
}
