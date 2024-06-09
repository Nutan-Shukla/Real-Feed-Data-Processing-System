package com.example.Spring.service.impl;

import com.example.Spring.dao.UsersDao;
import com.example.Spring.exception.UserNotFoundException;
import com.example.Spring.protos.PersonalDetailsRequestDto;
import com.example.Spring.protos.PersonalDetailsRequestEntity;
import com.example.Spring.protos.UserAddReponseDto;
import com.example.Spring.protos.UserAddReponseEntity;
import com.example.Spring.protos.UserAddRequestDto;
import com.example.Spring.protos.UserAddRequestEntity;
import com.example.Spring.protos.UserDeleteReponseEntity;
import com.example.Spring.protos.UserDeleteResponseDto;
import com.example.Spring.protos.UserList;
import com.example.Spring.protos.UserUpdateReponseEntity;
import com.example.Spring.protos.UserUpdateRequestDto;
import com.example.Spring.protos.UserUpdateRequestEntity;
import com.example.Spring.protos.UserUpdateResponseDto;
import com.example.Spring.service.UsersService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UsersService {

    private UsersDao usersDao;

    public  UserServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public UserList userData() {  // getUserAdmin
        return usersDao.forUserData();
    }

    @Override
    public UserList getPersonDetails() { // getUser

            return usersDao.forPersonalDetails();

    }

    @Override
    public UserAddReponseDto addUserInTable(UserAddRequestDto userAddRequestDto) { // createUser
        UserAddRequestEntity.Builder u = UserAddRequestEntity.newBuilder();
        u.setName(userAddRequestDto.getName());
        u.setPassword(userAddRequestDto.getPassword());
        u.setEmail(userAddRequestDto.getEmail());
        UserAddReponseEntity addedUser = usersDao.addUser(u.build());

        String daoResponse = addedUser.getMsg();

        return UserAddReponseDto.newBuilder().setMsg(daoResponse).build();
    }

    @Override
    public UserUpdateResponseDto updateUser(UserUpdateRequestDto userUpdateRequestDto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


            UserUpdateRequestEntity.Builder u = UserUpdateRequestEntity.newBuilder();

            u.setUpdatedName(userUpdateRequestDto.getUpdatedName());
            u.setUpdatedPassword(userUpdateRequestDto.getUpdatedPassword());


            UserUpdateReponseEntity updatedUser = usersDao.updateUserInTable(u.build());

            String daoResponse = updatedUser.getMsg();

            return UserUpdateResponseDto.newBuilder().setMsg(daoResponse).build();


        }


    @Override
    public UserDeleteResponseDto deleteUser() {


           UserDeleteReponseEntity deleteUser =  usersDao.deleteFromTable();

           String daoResponse = deleteUser.getMsg();
           return UserDeleteResponseDto.newBuilder().setMsg(daoResponse).build();


    }

}

//    @Override
//    public String recoverpassword(String name) {
//
//        return usersDao.gettingPassword(name);
//    }

//    @Override
//    public boolean getAuthicate(String name, String password) throws SQLException {
//
//        return usersDao.checkAuthicate(name, password);
//    }
