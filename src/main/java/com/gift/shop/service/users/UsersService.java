package com.gift.shop.service.users;

import com.gift.shop.models.baseapi.BaseApi;
import com.gift.shop.models.user.UsersResponse;
import org.springframework.http.ResponseEntity;

public interface UsersService {

    ResponseEntity<UsersResponse<?>> registerUser(BaseApi baseApi) throws Exception;
}
