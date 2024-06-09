package com.example.Spring.controller;

import com.example.Spring.exception.IncorrectUserBodyException;
import com.example.Spring.protos.UserAddReponseDto;
import com.example.Spring.protos.UserAddRequestDto;
import com.example.Spring.protos.UserDeleteResponseDto;
import com.example.Spring.protos.UserList;
import com.example.Spring.protos.UserUpdateRequestDto;
import com.example.Spring.protos.UserUpdateResponseDto;
import com.example.Spring.service.UsersService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE) //
    public UserList getUserDetails() {
        return usersService.userData();
    }

    @GetMapping(value = "/own-details", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserList getOwnDetails() {
        return usersService.getPersonDetails();
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserAddReponseDto addUserInList(@RequestBody UserAddRequestDto userAddRequestDto) {
      return  usersService.addUserInTable(userAddRequestDto);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserUpdateResponseDto updateUserInList(@RequestBody UserUpdateRequestDto userUpdateRequestDto) {
       if (!userUpdateRequestDto.getUpdatedName().equals("") && !userUpdateRequestDto.getUpdatedPassword().equals("")) {
           return usersService.updateUser(userUpdateRequestDto);
       } else {
           throw new IncorrectUserBodyException("Recheck the user Body");
       }
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDeleteResponseDto deleteUserFromList() {
        return usersService.deleteUser();
    }

}


