package test;

import constant.BunData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBun() {
        return new Object[][]{
                {BunData.BUN_1.getName(), BunData.BUN_1.getPrice()},
                {BunData.BUN_2.getName(), BunData.BUN_2.getPrice()},
                {BunData.BUN_3.getName(), BunData.BUN_3.getPrice()},
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
