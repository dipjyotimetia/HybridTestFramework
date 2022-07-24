package com.config;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ConfigModel {
    private String firstName;
    private String lastName;
    private List<Contact> contactDetails;
    private int age;
    private Address homeAddress;
}

@Data
@Builder
class Contact {
    private String type;
    private int number;
}

@Data
@Builder
class Address {
    private String line;
    private String city;
    private String state;
    private Integer zip;
}

/*
 firstName: "John"
 lastName: "Doe"
 age: 31
 contactDetails:
 - type: "mobile"
 number: 123456789
 - type: "landline"
 number: 456786868
 homeAddress:
 line: "Xyz, DEF Street"
 city: "City Y"
 state: "State Y"
 zip: 345657
*/