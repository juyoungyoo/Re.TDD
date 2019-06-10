package com.lambda.api.default_method.andthen;

import lombok.Getter;

@Getter
public class Address {
    private String country;
    private String city;

    public Address(String country,
                   String city) {
        this.country = country;
        this.city = city;
    }
}
