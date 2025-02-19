package com.denistelecom.multithreadloader.mapper;

import com.denistelecom.multithreadloader.dto.UserDto;
import com.denistelecom.multithreadloader.model.User;
import com.denistelecom.multithreadloader.utils.LanguageEnum;
import com.denistelecom.multithreadloader.utils.MultilingualField;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.beans.BeanUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {
        UserMapperUtils.class
})
public interface UserMapper {
    default  User toEntity(UserDto user) {
        User result = new User();
        BeanUtils.copyProperties(user, result);
        result.setFirstName(new MultilingualField());
        result.setLastName(new MultilingualField());
        result.setMiddleName(new MultilingualField());
        for (Map.Entry<LanguageEnum, String> entry :user.getFullName().entrySet()) {
            List<String> values = new ArrayList(Arrays.asList(entry.getValue().split(" ")));
            values.addAll(List.of("","",""));
            result.getLastName().put(entry.getKey(),!"".equals(values.get(0))&&values.get(0)!=null?values.get(0):null);
            result.getFirstName().put(entry.getKey(),!"".equals(values.get(1))&&values.get(1)!=null?values.get(1):null);
            result.getMiddleName().put(entry.getKey(),!"".equals(values.get(2))&&values.get(2)!=null?values.get(2):null);
        }
        return result;
    };
//    @Mapping( qualifiedByName = {"UserMapperUtil", "fromEntity"})
    default UserDto fromEntity(User user) {
        UserDto result = new UserDto();
        BeanUtils.copyProperties(user, result);
        MultilingualField fullName = new MultilingualField();
        Set<LanguageEnum> languages = new HashSet<>();
        languages.addAll(user.getFirstName() != null ? user.getFirstName().keySet() : Collections.emptySet());
        languages.addAll(user.getLastName() != null ? user.getLastName().keySet() : Collections.emptySet());
        languages.addAll(user.getMiddleName() != null ? user.getMiddleName().keySet() : Collections.emptySet());
        for (LanguageEnum lang : languages) {
            String fullNameString = Stream.of(user.getLastName(), user.getFirstName(), user.getMiddleName())
                    .filter(Objects::nonNull)
                    .map(val-> val.get(lang))
                    .filter(Objects::nonNull)
                    .collect(Collectors.joining(" "));
            fullName.put(lang, fullNameString);
        }
        if (fullName.isEmpty()) {
            fullName=null;
        }
        result.setFullName(fullName);
        return result;
    }

    ;

    List<UserDto> fromEntityList(List<User> users);
}
