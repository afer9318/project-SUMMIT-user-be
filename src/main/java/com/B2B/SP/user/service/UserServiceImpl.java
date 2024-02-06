package com.B2B.SP.user.service;

import com.B2B.SP.user.dto.UserDto;
import com.B2B.SP.user.exceptions.customexceptions.UserNotFoundException;
import com.B2B.SP.user.mapper.UserMapper;
import com.B2B.SP.user.model.User;
import com.B2B.SP.user.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final EntityManager entityManager;

    // Constructor
    public UserServiceImpl(UserRepository userRepository, EntityManager entityManager) {
        this.userRepository = userRepository;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        try {
            logger.info("Finding all users");

            return userRepository.findAllByAccountStatusNot(User.AccountStatus.INACTIVE)
                    .stream()
                    .map(UserMapper.INSTANCE::userToDto)
                    .collect(Collectors.toList());
        }catch (Exception e){
            logger.error("Exception while finding all users", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto findById(Long userId){
        try{
            logger.info("Finding user by id: {}", userId);

            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new UserNotFoundException("User not found with id" + userId));

            return UserMapper.INSTANCE.userToDto(user);
        }catch (Exception e){
            logger.error("Exception while finding user by id: {}", userId, e);
            throw e;
        }
    }
}
