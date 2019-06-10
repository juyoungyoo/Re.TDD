package com.lambda.api.default_method.andthen;

import lombok.Getter;

@Getter
public class Member {
    private String name;
    private String id;
    private Address address;

    public Member(String name,
                  String id,
                  Address address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }
}
