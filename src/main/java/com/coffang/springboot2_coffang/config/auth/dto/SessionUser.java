package com.coffang.springboot2_coffang.config.auth.dto;
import com.coffang.springboot2_coffang.domain.user.User;
import lombok.Getter;

import javax.mail.Session;
import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
