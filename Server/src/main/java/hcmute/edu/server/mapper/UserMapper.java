package hcmute.edu.server.mapper;

import hcmute.edu.server.dto.request.UserRegisterRequest;
import hcmute.edu.server.dto.respone.UserRespone;
import hcmute.edu.server.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRegisterRequest userRegisterRequest);
    UserRespone toUserRespone(User user);
}
