package com.B2B.SP.user.repository;

import com.B2B.SP.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.accountStatus != :accountStatus")
    List<User> findAllByAccountStatusNot(User.AccountStatus accountStatus);
}
