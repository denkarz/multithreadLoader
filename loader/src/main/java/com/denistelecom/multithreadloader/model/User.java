package com.denistelecom.multithreadloader.model;


import com.denistelecom.multithreadloader.utils.LanguageEnum;
import com.denistelecom.multithreadloader.utils.MultilingualField;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "person",schema = "temp_schema")
public class User {
    @Id
    @Column
    private UUID id;

    @Type(JsonType.class)
    private MultilingualField firstName;
    @Type(JsonType.class)
    private MultilingualField lastName;
    @Type(JsonType.class)
    private MultilingualField middleName;
    @Column
    private Integer age;

}
