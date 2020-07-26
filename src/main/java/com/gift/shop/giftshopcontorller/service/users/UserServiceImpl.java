package com.gift.shop.giftshopcontorller.service.users;

import com.gift.shop.giftshopcontorller.models.Users;
import com.gift.shop.giftshopcontorller.repo.UserRepository;
import com.gift.shop.giftshopcontorller.usermodel.UserRequestModel;
import com.gift.shop.giftshopcontorller.usermodel.UserResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UsersService {

    private UserRepository userRepository;
    @Override
    public ResponseEntity<UserResponseModel> registerUser(UserRequestModel userRequestModel) throws Exception {
        System.out.println();
        if(null == userRequestModel) throw new Exception();
        Users users = Users.builder()
                .address(userRequestModel.getAddress())
                .firstName(userRequestModel.getFirstName())
                .lastName(userRequestModel.getLastName())
                .email(userRequestModel.getEmail())
                .country(userRequestModel.getCountry())
                .state(userRequestModel.getState())
                .zipCode(userRequestModel.getZipCode())
                .password(userRequestModel.getPassword())
                .registeredDate(new Timestamp(new Date().getTime()))
                .build();
        userRepository.save(users);
        return new ResponseEntity(users, HttpStatus.CREATED);
    }
}
