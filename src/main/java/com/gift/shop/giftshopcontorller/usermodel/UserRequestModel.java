package com.gift.shop.giftshopcontorller.usermodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestModel implements Serializable {
    @SerializedName("first_name")
    @Expose
    @Column(name ="first_name" )
    private String firstName;
    @SerializedName("last_name")
    @Expose
    @Column(name ="last_name" )
    private String lastName;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("phone_number")
    @Expose
    @Column(name ="phone_number" )
    private String phoneNumber;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("zip_code")
    @Expose
    @Column(name = "zip_code")
    private String zipCode;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("registered_date")
    @Expose
    @Column(name = "registered_date")
    private Timestamp registeredDate;
}
