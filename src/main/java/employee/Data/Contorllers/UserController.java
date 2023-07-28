package employee.Data.Contorllers;

import employee.Data.Entities.User;
import employee.Data.dto.UserDTO;
import employee.Data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<UserDTO> findAllUsers(){

        return userService.findAllUsers();
    }

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody UserDTO userDTO){

        return userService.registerUser(userDTO);
    }

    @PutMapping("{userId}/update")
    public UserDTO updateUser(@PathVariable("userId") UUID id , @RequestBody UserDTO userDTO){
        userDTO.setId(id);
        UserDTO updatedUser = userService.updateUser(userDTO);
        return updatedUser;

    }


    @DeleteMapping("{id}")//
    public Map<String, Boolean> deleteUser(@PathVariable("id") UUID id ){
        userService.deleteUser(id);
        Map<String, Boolean> map=new HashMap<>();
        map.put("success", true);
        return map;

    }

}
