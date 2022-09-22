package com.codecool.terraformingmarsforum.mappers;

import com.codecool.terraformingmarsforum.dto.user.CreateAppUserDTO;
import com.codecool.terraformingmarsforum.model.AppUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppUserMapper {

    AppUser createAppUserDTOtoAppUser(CreateAppUserDTO userDTO);
}
