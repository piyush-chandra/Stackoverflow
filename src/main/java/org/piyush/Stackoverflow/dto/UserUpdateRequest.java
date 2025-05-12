package org.piyush.Stackoverflow.dto;

public record UserUpdateRequest(
    String name,
    String email,
    String userName,
    String password
) {
    
}
