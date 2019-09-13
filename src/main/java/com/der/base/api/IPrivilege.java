package com.der.base.api;

/**
 * <br>explain:</br>
 * <br>权限类，校验用户没有权限访问某资源</br>
 * <br>Created by 1297886375@qq.com on 2019/7/28 22:42</br>
 */
public interface IPrivilege {

    /**
     * <p> @description: 判断用户有没有权限</p>
     * <p> @author: caoshilong </p>
     * <p> @date: 2019-07-28 22:54 </p>
     * <p> @param0 userId: 用户ID </p>
     * <p> @return: boolean 有权限，就返回true,否则返回false </p>
     */
    public boolean isAllow(Long userId);
}
