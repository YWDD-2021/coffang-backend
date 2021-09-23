package com.coffang.springboot2_coffang.config.auth.dto;
import com.coffang.springboot2_coffang.domain.user.Role;
import com.coffang.springboot2_coffang.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String,Object> attributes;
    private String nameAttibuteKey;
    private String name;
    private String email;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,String nameAttibuteKey, String name, String email){
        this.attributes = attributes;
        this.nameAttibuteKey = nameAttibuteKey;
        this.name = name;
        this.email = email;
    }

    public static OAuthAttributes of(String registerationId,String userNameAttributeName, Map<String,Object> attributes){
        return ofGoogle(userNameAttributeName,attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName,Map<String,Object> attributes){
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttibuteKey(userNameAttributeName)
                .build();
    }

    public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .role(Role.GUEST)
                .build();
    }
}
