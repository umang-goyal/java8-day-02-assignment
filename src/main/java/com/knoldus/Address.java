package com.knoldus;

import java.util.Optional;

public class Address {
    String primaryAddress;
    Optional<String> secondaryAddress;

    public Address(String primaryAddress, String secondaryAddress){
        this.primaryAddress = primaryAddress;
        this.secondaryAddress =  Optional.ofNullable(secondaryAddress);
    }

    public Address(String primaryAddress){
        this(primaryAddress, null);
    }

    @Override
    public String toString() {
        return "Address{" +
                "primaryAddress='" + primaryAddress + '\'' +
                ", secondaryAddress=" + secondaryAddress +
                '}';
    }
}
