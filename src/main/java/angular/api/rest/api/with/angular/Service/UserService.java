package angular.api.rest.api.with.angular.Service;

import angular.api.rest.api.with.angular.Model.Receipt;
import angular.api.rest.api.with.angular.Model.User;
import angular.api.rest.api.with.angular.ModelDTO.UserDto;
import angular.api.rest.api.with.angular.Repository.ReceiptRepository;
import angular.api.rest.api.with.angular.Repository.ReceiptRepositoryExample;
import angular.api.rest.api.with.angular.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private ReceiptRepositoryExample receiptRepositoryExample;

    public UserDto checkLogin(UserDto userDto){
        User user = userRepository.checkLogin(userDto.getEmail(),userDto.getPassword());
        if(user == null){
            return  null;
        }
        else {
            UserDto uDto = modelMapper.map(user,userDto.getClass());
            return uDto;
        }
    }

    public List<UserDto> findAll(){
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for(User user : users){
            userDtos.add(new UserDto(user.getUserId(),user.getUserName(),user.getEmail(),user.getPassword(),user.getPhone(),user.getAddress(),true,user.getTypeValue()));
        }
        Type listType = new TypeToken<List<UserDto>>(){}.getType();
        List<UserDto> us = modelMapper.map(userDtos,listType);
        return us;
    }

    public UserDto findById(Long id){
        User user = userRepository.findById(id).get();
        UserDto userDto = modelMapper.map(user,UserDto.class);
        return userDto;
    }

    public UserDto findByEmail(String email){
       try {
           User user = userRepository.findByEmail(email);
           if (user==null){
               return null;
           }
           UserDto userDto = modelMapper.map(user,UserDto.class);
           return userDto;
       }
       catch (Exception e){
           return null;
       }
    }

    public UserDto save(UserDto userDto) {
        User user = modelMapper.map(new User(null,userDto.getUserName(),userDto.getEmail(),userDto.getPassword(),userDto.getPhone(),userDto.getAddress(),
                true,userDto.getTypeValue()),User.class);
        userRepository.save(user);
        return userDto;
    }

    public UserDto update(UserDto userDto) {
        List<Receipt> receipts = receiptRepository.findAllByUserId(userDto.getUserId());
        User user = modelMapper.map(new User(userDto.getUserId(),userDto.getUserName(),userDto.getEmail(),userDto.getPassword(),userDto.getPhone(),userDto.getAddress(),
                true,userDto.getTypeValue(),receipts),User.class);
        userRepository.save(user);
        return userDto;
    }
}
