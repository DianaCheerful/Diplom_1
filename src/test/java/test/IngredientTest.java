package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static test.BaseTest.getDataBase;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientFields() {
        return new Object[][]{
                {
                        getDataBase().availableIngredients().get(0).getType(),
                        getDataBase().availableIngredients().get(0).getName(),
                        getDataBase().availableIngredients().get(0).getPrice()
                },
                {
                        getDataBase().availableIngredients().get(1).getType(),
                        getDataBase().availableIngredients().get(1).getName(),
                        getDataBase().availableIngredients().get(1).getPrice()
                },
                {
                        getDataBase().availableIngredients().get(2).getType(),
                        getDataBase().availableIngredients().get(2).getName(),
                        getDataBase().availableIngredients().get(2).getPrice()
                },
        };
    }

    @Test
    public void shouldGetType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void shouldGetName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void shouldGetPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0);
    }
}
