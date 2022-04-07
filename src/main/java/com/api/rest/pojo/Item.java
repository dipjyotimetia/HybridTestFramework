package com.api.rest.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
public class Item {
    public String id;
    public int coin_id;
    public String name;
    public String symbol;
    public int market_cap_rank;
    public String thumb;
    public String small;
    public String large;
    public String slug;
    public double price_btc;
    public int score;
}
