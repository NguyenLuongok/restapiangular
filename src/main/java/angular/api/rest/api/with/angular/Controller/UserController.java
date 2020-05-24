package angular.api.rest.api.with.angular.Controller;

import angular.api.rest.api.with.angular.Model.User;
import angular.api.rest.api.with.angular.ModelDTO.UserDto;
import angular.api.rest.api.with.angular.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<UserDto> findAll(){
       return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @GetMapping("/findByEmail/{email}")
    public UserDto findByEmail(@PathVariable("email") String email){
        return userService.findByEmail(email);
    }

    @PostMapping(value = "/login/",produces = "application/json")
    public UserDto checkLogin(@RequestBody UserDto userDto){
        return userService.checkLogin(userDto);
    }

    @PostMapping(value = "/")
    public UserDto save(@RequestBody UserDto userDto){
        return  userService.save(userDto);
    }

    @PutMapping(value = "/{id}")
    public UserDto update(@PathVariable Long id,@RequestBody UserDto userDto){
        userDto.setUserId(id);
        return  userService.update(userDto);
    }


}
