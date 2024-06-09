package com.example.Spring.dao;

import com.example.Spring.protos.UserAddReponseEntity;
import com.example.Spring.protos.UserAddRequestEntity;
import com.example.Spring.protos.UserDeleteReponseEntity;
import com.example.Spring.protos.UserList;
import com.example.Spring.protos.UserUpdateReponseEntity;
import com.example.Spring.protos.UserUpdateRequestEntity;

public interface UsersDao {

     UserAddReponseEntity addUser(UserAddRequestEntity userAddRequestEntity);

     UserUpdateReponseEntity updateUserInTable(UserUpdateRequestEntity userUpdateRequestEntity);

     UserDeleteReponseEntity deleteFromTable();

     UserList forPersonalDetails();

     UserList forUserData();

     int getUserCountByName(String name);  // getUser

    int getUserIdFromEmail(String email);

}

