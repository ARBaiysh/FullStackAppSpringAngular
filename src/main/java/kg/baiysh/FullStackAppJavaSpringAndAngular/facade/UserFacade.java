package kg.baiysh.FullStackAppJavaSpringAndAngular.facade;

import kg.baiysh.FullStackAppJavaSpringAndAngular.dto.UserDTO;
import kg.baiysh.FullStackAppJavaSpringAndAngular.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstname(user.getName());
        userDTO.setLastname(user.getLastname());
        userDTO.setUsername(user.getUsername());
        userDTO.setBio(user.getBio());
        return userDTO;
    }

}
