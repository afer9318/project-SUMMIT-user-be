package com.B2B.SP.user.repository;

import com.B2B.SP.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom Query to filter by account status
//    @Query("SELECT u FROM User u WHERE u.accountStatus != :accountStatus")
//    List<User> findAllByAccountStatusNot(User.AccountStatus accountStatus);

    @Query("SELECT u FROM User u WHERE u.accountStatus != 'INACTIVE'")
    List<User> findAllByAccountNotInActive();

    @Query("SELECT u from User u WHERE u.userId = :userId AND u.accountStatus != 'INACTIVE'")
    User findByIdAccountNotInActive(@Param("userId") Long userId);
}
