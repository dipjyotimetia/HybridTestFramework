package com.api.rest.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
public class Trades {
    public ArrayList<Coin> coins;
    public ArrayList<Object> exchanges;
}
