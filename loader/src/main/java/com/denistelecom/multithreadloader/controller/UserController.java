package com.denistelecom.multithreadloader.controller;

import com.denistelecom.multithreadloader.dto.UserDto;
import com.denistelecom.multithreadloader.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    private final UserService service;

    @GetMapping("/users")
    Page<UserDto> readAll(Pageable pageable){
        return service.readAll(pageable);
    }

    @GetMapping("/users/{userId}")
    UserDto read(@PathVariable UUID userId){
        return service.read(userId).orElseThrow();
    }

    @PostMapping("/users")
    UserDto create(@RequestBody UserDto userDto){
        return service.create(userDto);
    }

    @PutMapping("/users")
    UserDto update(@RequestBody UserDto userDto){
        return service.update(userDto);
    }

    @DeleteMapping("/users/{userId}")
    void delete(@PathVariable UUID userId){
        service.delete(userId);
    }
}
