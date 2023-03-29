# GraphQL api Testing

### Write your first user journey graph api test

Create new graph api test by using the following test conventions

```java
@Severity(SeverityLevel.NORMAL)
@Test(description = "E2E test for graphql")
@Description("Get Fruit Shop")
@Story("Test Graphql")
public void TestFruitShop(){
        String query="query{\n"+
        "  products(id: \"7\") {\n"+
        "    name\n"+
        "    price\n"+
        "    category {\n"+
        "      name\n"+
        "    }\n"+
        "    vendor {\n"+
        "      name\n"+
        "      id\n"+
        "    }\n"+
        "  }\n"+
        "}";
        String jsonString=graphqlToJson(query);

        setBaseURI("https://www.predic8.de/fruit-shop-graphql?");
        RestAssured
        .given()
        .contentType("application/json")
        .body(jsonString)
        .when().post().then()
        .assertThat()
        .statusLine("HTTP/1.1 200 OK")
        .log()
        .body();
        }
```