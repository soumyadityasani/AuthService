package com.canteen.authService.services;

import com.canteen.authService.entity.User;
import com.canteen.authService.enums.ErrorCodeEnum;
import com.canteen.authService.exceptions.UserNotFoundException;
import com.canteen.authService.repo.UserRepo;
import com.canteen.authService.util.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findByEmail(username)
                .orElseThrow(()->new UserNotFoundException( ErrorCodeEnum.S_404.getMessage()));

        return new MyUserDetails(user);
    }
}
