package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class BunTest extends BaseTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunFields() {
        return new Object[][]{
                {getDataBase().availableBuns().get(0).getName(), getDataBase().availableBuns().get(0).getPrice()},
                {getDataBase().availableBuns().get(1).getName(), getDataBase().availableBuns().get(1).getPrice()},
                {getDataBase().availableBuns().get(2).getName(), getDataBase().availableBuns().get(2).getPrice()},
        };
    }

    @Test
    public void shouldGetGivenName() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void shouldGetGivenPrice() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0);
    }

}
