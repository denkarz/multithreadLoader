package com.denistelecom.multithreadloader.service;

import com.denistelecom.multithreadloader.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Page<UserDto> readAll(Pageable pageable);
    Optional<UserDto> read(UUID id);
    UserDto create(UserDto user);
    UserDto update(UserDto user);
    void delete(UUID id);
}
