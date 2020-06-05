package com.advance;


import com.utlis.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

  @ExceptionHandler({Exception.class})
  public CommonResult exception(Exception e){
    return CommonResult.failed(e.getMessage());
  }
}
