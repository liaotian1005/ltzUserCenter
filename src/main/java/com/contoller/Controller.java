package com.contoller;
import	java.lang.ProcessBuilder.Redirect;

import com.model.User;
import com.service.UserService;
import com.utlis.CommonResult;
import com.utlis.DgbSecurityUserHelper;
import com.utlis.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class Controller {



  @Autowired
  private UserService userService;


  @GetMapping("login")
  public CommonResult login(String username, String password) {
    return CommonResult.success(userService.login(username,password));
  }


  @PostMapping("/register")
  public CommonResult register(@RequestBody User user){
    return CommonResult.success(userService.register(user));
  }




}
