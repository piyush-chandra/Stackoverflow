package org.piyush.Stackoverflow.repository;

import org.piyush.Stackoverflow.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUserName(String userId);
    Users findByEmail(String email);
    Users findByUserNameOrEmail(String userName, String email);
    Users findByEmailAndPassword(String email, String password);
}
