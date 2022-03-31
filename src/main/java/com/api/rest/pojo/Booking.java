package com.api.rest.pojo;

import lombok.*;

@Data
public class Booking {
    public String firstname;
    public String lastname;
    public int totalprice;
    public boolean depositpaid;
    public Bookingdates bookingdates;
    public String additionalneeds;
}
