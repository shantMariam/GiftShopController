package com.gift.shop.exceptions.nullexception;

public class MissingDetailsException extends RuntimeException {

    public MissingDetailsException() {
        super("Details are missing, please fill the required fields");
    }

}
