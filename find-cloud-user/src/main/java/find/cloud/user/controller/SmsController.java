package find.cloud.user.controller;

import base.commons.response.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author turnglight
 */
@RestController
@RequestMapping(value = "sms")
public class SmsController {

    @GetMapping
    public ResponseResult sendSms(@RequestParam(value = "phone") String phone){

    }
}
