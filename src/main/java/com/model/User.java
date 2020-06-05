package com.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class User implements UserDetails {
    /**
    * 主键
    */
    private Integer id;

    /**
    * 登录账号
    */
    private String username;

    /**
    * 密码
    */
    private String password;

    /**
    * 性别，（国标：1：男，0：女，-1：未知）
    */
    private Boolean sex;

    /**
    * 手机号码
    */
    private String mobile;

    /**
    * 电子邮箱
    */
    private String email;

    /**
    * 真实姓名
    */
    private String realname;

    /**
    * 行政区划，国标
    */
    private String nation;

    /**
    * 详细地址
    */
    private String address;

    /**
    * 头像
    */
    private String avctor;

    /**
    * 是否启用，（0：禁用，1：启用）
    */
    private Boolean isenable;

    /**
    * 创建用户id
    */
    private Integer creator;

    /**
    * 创建时间
    */
    private Date createtime;

    /**
    * 更新用户id
    */
    private Integer update;

  /**
   * 角色
   */
  private List<Authority> grantedAuthority;

    /**
    * 更新时间
    */
    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }

  public void setUsername(String username) {
        this.username = username;
    }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return grantedAuthority;
  }

  public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvctor() {
        return avctor;
    }

    public void setAvctor(String avctor) {
        this.avctor = avctor;
    }

    public Boolean getIsenable() {
        return isenable;
    }

    public void setIsenable(Boolean isenable) {
        this.isenable = isenable;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getUpdate() {
        return update;
    }

    public void setUpdate(Integer update) {
        this.update = update;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}