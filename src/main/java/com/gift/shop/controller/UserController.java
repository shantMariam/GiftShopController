package com.gift.shop.controller;

import com.gift.shop.api.UsersApi;
import com.gift.shop.exceptions.nullexception.MissingDetailsException;
import com.gift.shop.models.baseapi.BaseApi;
import com.gift.shop.models.user.UsersResponse;
import com.gift.shop.service.users.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UsersApi {
    private final UsersService usersService;

    @Override
    @SneakyThrows
    public ResponseEntity<?> registerNewUser(BaseApi baseApi) throws Exception {
       if(baseApi.getUsersRequest() == null) throw new MissingDetailsException();
        ResponseEntity<UsersResponse<?>> response = usersService.registerUser(baseApi);
        return new ResponseEntity<>(response.getBody(),response.getStatusCode());
    }
}
