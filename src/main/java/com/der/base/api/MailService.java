package com.der.base.api;

/**
 * @ClassName MailService
 * @Desctiption TODO
 * @Author 曹世龙
 * @Date 2019/7/28 22:03
 * @Version 1.0
 **/
public interface MailService {

    /*/**
     * @description: 发送邮件
     * @author: caoshilong
     * @date: 2019-07-28 22:22
     * @param userId: 
     * @param content: 
     * @return: boolean
     */
    public boolean sendMail(Long userId, String content);
}
