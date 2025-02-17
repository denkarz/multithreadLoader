package com.denistelecom.multithreadloader.service;

import com.denistelecom.multithreadloader.dto.UserDto;
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

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
//    private final UserMapper mapper;

    @Override
    public Page<UserDto> readAll(Pageable pageable) {
        Page<User> users = repository.findAll(pageable);
//        return new PageImpl<>(mapper.fromEntityList(users.getContent()), pageable, users.getTotalElements());
        return null;
    }

    @Override
    public Optional<UserDto> read(UUID id) {
//        return repository.findById(id).map(mapper::fromEntity);
        return null;
    }

    @Override
    public UserDto create(UserDto user) {
        UUID id = UUID.randomUUID();
        MultilingualField firstName = new MultilingualField();
        firstName.put(LanguageEnum.ENG,"first_name");
        MultilingualField lastName = new MultilingualField();
        lastName.put(LanguageEnum.ENG,"last_name");

        User userdb = new User().setId(id).setAge(29).setFirstName(firstName).setLastName(lastName);
        repository.save(userdb);
        return new UserDto().setId(id).setAge(29).setFirstName(firstName).setLastName(lastName);
    }

    @Override
    public UserDto update(UserDto user) {
        return null;
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id)
                .ifPresentOrElse(repository::delete, () -> log.info("User not found"));
    }
}
