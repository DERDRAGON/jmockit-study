package com.der.base;

import com.der.base.api.MailService;
import com.der.base.api.UserCheckService;

import javax.annotation.Resource;

/**
 * @ClassName OrderService
 * @Desctiption TODO
 * @Author 曹世龙
 * @Date 2019/7/28 22:22
 * @Version 1.0
 **/
public class OrderService {

    MailService mailService;

    @Resource
    UserCheckService userCheckService;

    public OrderService(MailService mailService) {
        this.mailService = mailService;
    }

    public boolean submitOrder(Long userId, Long itemId){
        if (!userCheckService.check(userId)){
            return false;
        }
        if (!this.mailService.sendMail(userId, "下单成功")){
            return false;
        }
        return true;
    }

}
