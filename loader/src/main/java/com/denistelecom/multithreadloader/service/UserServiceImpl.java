package com.denistelecom.multithreadloader.service;

import com.denistelecom.multithreadloader.dto.UserDto;
import com.denistelecom.multithreadloader.mapper.UserMapper;
import com.denistelecom.multithreadloader.model.User;
import com.denistelecom.multithreadloader.repository.UserRepository;
import com.denistelecom.multithreadloader.utils.LanguageEnum;
import com.denistelecom.multithreadloader.utils.MultilingualField;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public Page<UserDto> readAll(Pageable pageable) {
        Page<User> users = repository.findAll(pageable);
        return new PageImpl<>(mapper.fromEntityList(users.getContent()), pageable, users.getTotalElements());
    }

    @Override
    public Optional<UserDto> read(UUID id) {
        return repository.findById(id).map(mapper::fromEntity);
    }

    @Override
    public UserDto create(UserDto user) {
        UUID id = UUID.randomUUID();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        User userForCreate = mapper.toEntity(user);
        userForCreate.setId(id);
        userForCreate.setCreatedAt(now);
        userForCreate.setUpdatedAt(now);
        userForCreate.setDeletedAt(null);
        User save = repository.save(userForCreate);
        return mapper.fromEntity(save);
    }

    @Override
    public UserDto update(UserDto user) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        User userFromDb = repository.findById(user.getId()).orElseThrow();
        user.setId(userFromDb.getId());
        user.setUpdatedAt(now);
        User userAfterSave = repository.save(mapper.toEntity(user));
        return mapper.fromEntity(userAfterSave);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id)
                .ifPresentOrElse(repository::delete, () -> log.info("User not found"));
    }
}
