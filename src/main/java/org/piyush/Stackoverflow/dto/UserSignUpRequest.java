package org.piyush.Stackoverflow.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class UserSignUpRequest {
    private String name;
    private String userName;
    private String email;
    private String password;

    @Override
    public String toString() {
        return "UserSignUpRequest{" +
                "email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
