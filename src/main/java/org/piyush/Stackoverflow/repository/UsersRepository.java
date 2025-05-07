package org.piyush.Stackoverflow.repository;

import org.piyush.Stackoverflow.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUserId(Long usersId);
    Users findByEmail(String email);
    Users findByEmailAndPassword(String email, String password);
    Users findByUserIdAndPassword(String name, String password);
}
