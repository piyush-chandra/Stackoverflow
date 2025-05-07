package org.piyush.Stackoverflow.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserLoginRequest {
    private String email;
    private String password;
}
