package com.gift.shop.models.user;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersResponse<T> {
    private Timestamp date;
    private boolean status;
    private String message;
    private int code;
}
