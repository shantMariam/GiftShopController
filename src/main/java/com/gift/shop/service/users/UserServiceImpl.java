package com.gift.shop.service.users;

import com.gift.shop.exceptions.nullexception.MissingDetailsException;
import com.gift.shop.models.baseapi.BaseApi;
import com.gift.shop.models.user.UsersRequest;
import com.gift.shop.models.user.UsersResponse;
import com.gift.shop.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UsersService, UserServiceAction {

    private final UserRepository userRepository;

    @Override
    @SneakyThrows
    public ResponseEntity<UsersResponse<?>> registerUser(BaseApi baseApi) {
        if (null == baseApi.getUsersRequest()) throw new MissingDetailsException();
        UsersRequest users = UsersRequest.builder()
                .address(baseApi.getUsersRequest().getAddress())
                .firstName(baseApi.getUsersRequest().getFirstName())
                .lastName(baseApi.getUsersRequest().getLastName())
                .email(baseApi.getUsersRequest().getEmail())
                .country(baseApi.getUsersRequest().getCountry())
                .state(baseApi.getUsersRequest().getState())
                .zipCode(baseApi.getUsersRequest().getZipCode())
                .password(baseApi.getUsersRequest().getPassword())
                .registeredDate(new Timestamp(new Date().getTime()))
                .build();
        UsersResponse<?> response = saveUserToDatabase(users);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    @SneakyThrows
    public UsersResponse<?> saveUserToDatabase(UsersRequest usersRequest) {
        if(!isUserExist(usersRequest)){
            userRepository.save(usersRequest);
            return new UsersResponse<>(new Timestamp(new Date().getTime()),true, "User created successfully", HttpStatus.CREATED.value());
        }
        return new UsersResponse<>(new Timestamp(new Date().getTime()),false, "User Already exist", HttpStatus.FORBIDDEN.value());
    }

    @Override
    @SneakyThrows
    public boolean isUserExist(UsersRequest usersRequest) {
        return userRepository.existsByEmail(usersRequest.getEmail());
    }
}
