package com.mayikt.service;

import com.google.common.util.concurrent.RateLimiter;
import com.mayikt.service.annotation.MayiktCurrentLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 余胜军
 * @ClassName MemberService
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@RestController
public class MemberService {
    private String userName;

    /**
     * 每秒生成1.0个令牌
     * //
     */
    @GetMapping("/get")
    @MayiktCurrentLimit(name = "get", token = 1)
    public String get() {
//        boolean result = rateLimiter.tryAcquire();
//        if (!result) {
//            return "当前访问人数过多，请稍后重试!";
//        }
        return "my is get";
    }

    @GetMapping("/add")
    @MayiktCurrentLimit(name = "add", token = 10)
    public String add() {
        return "my is add";
    }

    @GetMapping("/my")
    public String my() {
        return "my is add";
    }
}
