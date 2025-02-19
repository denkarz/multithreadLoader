package com.denistelecom.multithreadloader.dto;

import com.denistelecom.multithreadloader.utils.MultilingualField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class UserDto {
    private UUID id;
    private MultilingualField fullName;
    private Integer age;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
}
