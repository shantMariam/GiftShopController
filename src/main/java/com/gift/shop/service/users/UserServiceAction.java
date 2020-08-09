package com.gift.shop.service.users;

import com.gift.shop.models.user.UsersRequest;
import com.gift.shop.models.user.UsersResponse;

public interface UserServiceAction {
    UsersResponse<?> saveUserToDatabase(UsersRequest usersRequest);

    boolean isUserExist(UsersRequest usersRequest);
}
