package com.example.dementia.service.jwt;

import com.example.dementia.beans.LoginDetails;
import com.example.dementia.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailService implements UserDetailsService {

    @Autowired
    LoginDao loginDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<LoginDetails> user = loginDao.findByUsername(username);
        if (user.size()==1) {
            return new org.springframework.security.core.userdetails.User(user.get(0).getUsername(), user.get(0).getPassword(),
                    new ArrayList<>());
        }
        else
        {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public void save(LoginDetails newUser) {
        try {
            loginDao.save(newUser);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
