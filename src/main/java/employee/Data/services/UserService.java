package employee.Data.services;

import employee.Data.Entities.User;
import employee.Data.dto.UserDTO;
import employee.Data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO registerUser(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        user.setGender(userDTO.getGender());
        user.setSalary(userDTO.getSalary());
        userRepository.save(user);
        UserDTO savedDTO = new UserDTO(user.getId(),user.getName(),user.getAge(),user.getGender(), user.getSalary());
        return savedDTO;
    }
    public List<UserDTO> findAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for(User user:users){
            UserDTO userDTO = new UserDTO(user.getId(),user.getName(),user.getAge(),user.getGender(),user.getSalary());
            userDTOS.add(userDTO);
        }
        return userDTOS;

    }
    public UserDTO updateUser( UserDTO updatedUser) {
        User user = userRepository.findById(updatedUser.getId()).orElse(null);
        if(updatedUser.getName()!=null && updatedUser.getAge()>0&& updatedUser.getGender()!=null&&updatedUser.getSalary()>0){
            user.setName(updatedUser.getName());
            user.setGender(updatedUser.getGender());
            user.setAge(updatedUser.getAge());
            user.setSalary(updatedUser.getSalary());
            user= userRepository.save(user);
            UserDTO userDTO = new UserDTO(user.getId(),user.getName(),user.getAge(),user.getGender(), user.getSalary());
            return userDTO;
        }
        return null;
    }
    public void deleteUser(UUID id){

        userRepository.deleteById(id);
    }


}
