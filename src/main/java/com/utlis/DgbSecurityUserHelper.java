package com.utlis;

import com.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 用户支撑类
 * @date 2018-07-12 23:03
 */
public class DgbSecurityUserHelper {

  /**
   * 获取当前用户
   * @return
   */
  public static Authentication getCurrentUserAuthentication(){
    return SecurityContextHolder.getContext().getAuthentication();
  }

  /**
   * 获取当前用户
   * @return
   */
  public static User getCurrentPrincipal(){
    return (User) getCurrentUserAuthentication().getPrincipal();
  }
}
