package test;

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void shouldReturnSauceTypeName(){
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void shouldReturnFillingTypeName(){
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}
