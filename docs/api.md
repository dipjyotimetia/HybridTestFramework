# Api Testing

### Write your first user journey api test

Create new class and name as the TC00*_E2E_TEST-***

- Provide jira link in @Link
- Provide all the api components as @Feature
- Provide test severity and description
- Write test
- Use CatchBlock in try/catch section

Create pojo for the request body and deserialize the response.
By using the project lombok it's easy to create the data model.

```java

@Data
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
public class Booking {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private Bookingdates bookingdates;
    private String additionalneeds;
}
```

```java
@Severity(SeverityLevel.CRITICAL)
@Test(description = "E2E test for Trading Coins")
@Description("Get Trading Coins")
@Story("Test CryptoCoins")
public void TestTradings(){
    setBaseURI("https://api.coingecko.com");

    Response response=httpGet("/api/v3/search/trending");
    Assert.assertEquals(getStatusCode(response) /*actual value*/,200 /*expected value*/,"Correct status code returned");
    Trades trades=response.getBody().as(Trades.class);
    Assert.assertNotNull(trades.getCoins().get(0).item.name);
    Assert.assertNotNull(trades.getCoins().get(0).item.slug);
}
```