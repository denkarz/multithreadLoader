//package com.denistelecom.multithreadloader.mapper;
//
//import com.denistelecom.multithreadloader.dto.UserDto;
//import com.denistelecom.multithreadloader.model.User;
//import org.mapstruct.Mapper;
//import org.mapstruct.MappingConstants;
//
//import java.util.List;
//
//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
//        uses = {
//        UserMapperImpl.class
//})
//public interface UserMapper {
//
//    UserDto fromEntity(User user); //map User to UserResponse
//
//    List<UserDto> fromEntityList(List<User> users); //map
//}
