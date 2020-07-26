package com.gift.shop.giftshopcontorller.usermodel;

import com.gift.shop.giftshopcontorller.models.Users;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseModel implements Serializable {
    private String message;
    private String code;
    private Users users;
}
