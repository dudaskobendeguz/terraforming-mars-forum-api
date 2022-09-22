package com.codecool.terraformingmarsforum.mappers;

import com.codecool.terraformingmarsforum.dto.comment.CommentCreationDTO;
import com.codecool.terraformingmarsforum.model.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment CommentCreationDTOToComment(CommentCreationDTO commentCreationDTO);
}
