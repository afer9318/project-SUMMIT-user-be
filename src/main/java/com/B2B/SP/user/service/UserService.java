package com.B2B.SP.user.service;

import com.B2B.SP.user.dto.UserDto;
import com.B2B.SP.user.model.User;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findById(Long userId);
}
