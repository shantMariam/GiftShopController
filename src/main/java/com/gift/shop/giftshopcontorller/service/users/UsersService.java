package com.gift.shop.giftshopcontorller.service.users;

import com.gift.shop.giftshopcontorller.usermodel.UserRequestModel;
import com.gift.shop.giftshopcontorller.usermodel.UserResponseModel;
import org.springframework.http.ResponseEntity;

public interface UsersService {
    ResponseEntity<UserResponseModel> registerUser(UserRequestModel userRequestModel) throws Exception;
}
