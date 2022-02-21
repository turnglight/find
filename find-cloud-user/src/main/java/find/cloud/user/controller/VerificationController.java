package find.cloud.user.controller;

import base.commons.response.ResponseResult;
import find.cloud.user.controller.api.VerificationPostApi;
import find.cloud.user.service.VerificationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/third/jiguang")
@RestController
public class VerificationController {

    @Resource
    private VerificationService verificationService;

    @RequestMapping("/verification")
    @PostMapping
    public ResponseResult verification(@RequestBody @Validated VerificationPostApi postApi){
        boolean success = verificationService.loginTokenVerify(postApi.getPhone(), postApi.getLoginToken());
        if(success == true){
            return ResponseResult.ok();
        }
        return ResponseResult.error("认证失败");
    }

}
