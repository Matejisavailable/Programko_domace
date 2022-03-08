package umb.fpv.ki.demo;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

   private final UserRepository userRepository;

   public UserService(UserRepository userRepository){
       this.userRepository = userRepository;

   }

   private static UserDto mapUserDto(UserEntity userEntity){

       UserDto userDto = new UserDto();

       userDto.setEmail(userEntity.getEmail());
       userDto.setfName(userEntity.getfName());
       userDto.setlName(userEntity.getlName());
       userDto.setId(userEntity.getId());

       return userDto;
   }
    @Transactional
    public List<UserDto> getUsers(String userFirstName){
        List<UserDto> ret = new LinkedList<>();
        for (UserEntity u1 : userRepository.findAll()){
            UserDto u2 = mapUserDto(u1);
            ret.add(u2);
        }
        return ret;
    }

    @Transactional
    public List<UserDto>getUserId(String userID){
        List<UserDto> ret = new LinkedList<>();
        for (UserEntity u1 : userRepository.findAll()){
            UserDto u2 = mapUserDto(u1);
            ret.add(u2);
        }
        return ret;
    }

    @Transactional
    public String createUser(UserDto userDto){
        UserEntity userEntity = new UserEntity();

        userEntity.setfName(userDto.getfName());
        userEntity.setlName(userDto.getlName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setId(userDto.getId());

        this.userRepository.save(userEntity);
        return userEntity.getId();
    }

    @Transactional
    public void deleteUser(int userId){
        Optional<UserEntity> byID = userRepository.findById((long)userId);
        if(byID.isPresent()){
            userRepository.delete(byID.get());
        }
    }

    @Transactional
    public void putUser(int userId, UserDto userDto){
        Optional<UserEntity> byID = userRepository.findById((long)userId);
        if(byID.isPresent()){
            byID.get().setfName(userDto.getfName());
            byID.get().setlName(userDto.getlName());
            byID.get().setEmail(userDto.getEmail());
            byID.get().setId(userDto.getId());
        }
    }

}
