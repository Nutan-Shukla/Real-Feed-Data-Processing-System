package com.example.Spring.service;

//import com.example.Spring.Project.protos.*;

import com.example.Spring.protos.PersonalDetailsRequestDto;
import com.example.Spring.protos.UserAddReponseDto;
import com.example.Spring.protos.UserAddRequestDto;
import com.example.Spring.protos.UserDeleteResponseDto;
import com.example.Spring.protos.UserList;
import com.example.Spring.protos.UserUpdateRequestDto;
import com.example.Spring.protos.UserUpdateResponseDto;

public interface UsersService {

     UserList userData();

     UserList getPersonDetails();

     UserAddReponseDto addUserInTable(UserAddRequestDto userAddRequestDto);

     UserUpdateResponseDto updateUser(UserUpdateRequestDto userUpdateRequestDto);

     UserDeleteResponseDto deleteUser();

}

