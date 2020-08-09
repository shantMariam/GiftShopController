package com.gift.shop.api;

import com.gift.shop.models.baseapi.BaseApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface UsersApi {
    @PostMapping("/register")
    ResponseEntity<?> registerNewUser(@RequestBody BaseApi baseApi) throws Exception;
}
