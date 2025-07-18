package com.canteen.authService.util;

import com.canteen.authService.enums.RoleEnum;
import com.canteen.authService.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class MyUserDetails implements UserDetails {

    private User user;

    public MyUserDetails(User user){
        this.user=user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole().getRole().toString()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    //Custom
    public String getFullName() {
        return user.getUsername();
    }

    public String getCollegeRoll(){
        return user.getCollegeRoll();
    }

    public String getContact(){
        return user.getContact();
    }

    public RoleEnum getRole(){
        return user.getRole().getRole();
    }



}
