package com.service.impl;

import cn.hutool.core.util.StrUtil;
import com.contoller.Controller;
import com.exception.ServiceException;
import com.mapper.UserMapper;
import com.model.User;
import com.service.UserService;
import com.utlis.DgbSecurityUserHelper;
import com.utlis.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserDetailsServiceImpl  implements UserService {

  @Autowired
  UserMapper userMapper;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

  @Override
  public User loadUserByUsername(String username) throws UsernameNotFoundException {
    return userMapper.selectByUsername(username);
  }

  @Override
  public Boolean register(User user) {

    if (StrUtil.isBlank(user.getUsername())){
      throw new ServiceException("用户名为空");
    }
    if (StrUtil.isBlank(user.getPassword())){
      throw new ServiceException("密码为空");
    }
    // 准备发送验证码
    if (StrUtil.isBlank(user.getMobile())){
      throw new ServiceException("手机号码为空");
    }
    // 准备发送邮箱激活
    if (StrUtil.isBlank(user.getEmail())){
      throw new ServiceException("邮箱为空");
    }
    Date date = new Date();
    user.setIsenable(false);
    user.setCreatetime(date);
    user.setCreator(DgbSecurityUserHelper.getCurrentPrincipal().getId());
    user.setUpdatetime(date);
    user.setUpdate(DgbSecurityUserHelper.getCurrentPrincipal().getId());
    int insert = userMapper.insert(user);
    return insert > 0;
  }

  @Override
  public String login(String username, String password) {
    String token ;
    try {
      UserDetails userDetails = this.loadUserByUsername(username);
      if (!passwordEncoder.matches(password, userDetails.getPassword())) {
        throw new BadCredentialsException("密码不正确");
      }
      UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication(authentication);
      token = jwtTokenUtil.generateToken(userDetails);
    } catch (AuthenticationException e) {
      LOGGER.warn("登录异常:{}", e.getMessage());
      throw new BadCredentialsException("密码不正确");
    }
    return token;
  }
}
