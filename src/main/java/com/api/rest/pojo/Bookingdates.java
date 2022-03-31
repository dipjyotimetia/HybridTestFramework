package com.api.rest.pojo;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
public class Bookingdates{
    public String checkin;
    public String checkout;
}
