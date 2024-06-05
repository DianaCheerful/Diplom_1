package test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static constant.Constants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends BaseTest {

    private Burger burger;
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Before
    public void init() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        Mockito.when(ingredient.getPrice()).thenReturn(INGREDIENT_PRICE);
    }


    @Test
    public void shouldGetPrice() {
        assertEquals(getBurgerExpectedPrice(), burger.getPrice(), 0);
    }

    @Test
    public void shouldGetReceipt() {
        assertEquals(getExpectedReceipt(), burger.getReceipt());
    }

    @Test
    public void shouldAddIngredient() {
        String oldReceipt = burger.getReceipt();
        burger.addIngredient(getDataBase().availableIngredients().get(3));
        String newReceipt = burger.getReceipt();
        assertNotEquals(oldReceipt, newReceipt);
    }

    @Test
    public void shouldRemoveIngredient() {
        String oldReceipt = burger.getReceipt();
        burger.addIngredient(getDataBase().availableIngredients().get(3));
        burger.removeIngredient(1);
        String newReceipt = burger.getReceipt();
        assertEquals(oldReceipt, newReceipt);
    }

    @Test
    public void shouldMoveIngredient(){
        burger.addIngredient(getDataBase().availableIngredients().get(3));
        burger.addIngredient(getDataBase().availableIngredients().get(4));
        String oldReceipt = burger.getReceipt();
        burger.moveIngredient(1, 0);
        String newReceipt = burger.getReceipt();
        assertNotEquals(oldReceipt, newReceipt);
    }

    private float getBurgerExpectedPrice() {
        return (BUN_PRICE * 2) + INGREDIENT_PRICE;
    }

    private String getExpectedReceipt() {
        return String.format("(==== %s ====)%n", BUN_NAME) +
                String.format("= %s %s =%n", IngredientType.SAUCE.toString().toLowerCase(), INGREDIENT_NAME) +
                String.format("(==== %s ====)%n", BUN_NAME) +
                String.format("%nPrice: %f%n", getBurgerExpectedPrice());
    }
}
