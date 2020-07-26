package com.gift.shop.giftshopcontorller.api;

import com.gift.shop.giftshopcontorller.models.Users;
import com.gift.shop.giftshopcontorller.usermodel.UserRequestModel;
import com.gift.shop.giftshopcontorller.usermodel.UserResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface UsersApi {
    @PostMapping("/register")
    ResponseEntity<UserResponseModel> registerNewUser(@RequestBody UserRequestModel userRequestModel) throws Exception;
}
