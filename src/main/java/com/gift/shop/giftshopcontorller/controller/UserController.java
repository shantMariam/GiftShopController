package com.gift.shop.giftshopcontorller.controller;

import com.gift.shop.giftshopcontorller.api.UsersApi;
import com.gift.shop.giftshopcontorller.models.Users;
import com.gift.shop.giftshopcontorller.service.users.UsersService;
import com.gift.shop.giftshopcontorller.usermodel.UserRequestModel;
import com.gift.shop.giftshopcontorller.usermodel.UserResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UsersApi {
    private UsersService usersService;

    @Override
    public ResponseEntity<UserResponseModel> registerNewUser(@RequestBody UserRequestModel userRequestModel) throws Exception {
       if(userRequestModel == null) throw new Exception();
        ResponseEntity<UserResponseModel> users = usersService.registerUser(userRequestModel);
        return new ResponseEntity(users,HttpStatus.CREATED);
    }
}
