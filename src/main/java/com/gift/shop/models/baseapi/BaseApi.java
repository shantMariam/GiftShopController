package com.gift.shop.models.baseapi;

import com.gift.shop.models.user.UsersRequest;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseApi {
    private UsersRequest usersRequest;
}
