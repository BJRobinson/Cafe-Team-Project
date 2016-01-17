import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * TestDrink class.
 *
 * @author Lucas Rezende Correa de Souza
 *
 */

public class TestDrink {
  
  private Drink drink;
  
  @Before
  public void setUp() throws Exception {
    drink = new Drink("Coke", DrinkType.SODA, DrinkSize.LARGE, 1.50, 38.0, false);
  }

  @Test
  public void testName() {
    assertEquals("TEST: checking if expected name is returned", "Coke", drink.getName());
    drink.setName("Fanta");
    assertEquals("TEST: checking if name was changed", "Fanta", drink.getName());
  }
  
  @Test
  public void testType() {
    assertEquals("TEST: checking if expected type is returned", DrinkType.SODA, drink.getType());
    drink.setType(DrinkType.BEER);
    assertEquals("TEST: checking if type was changed", DrinkType.BEER, drink.getType());
  }
  
  @Test
  public void testSize() {
    assertEquals("TEST: checking if expected size is returned", DrinkSize.LARGE, drink.getSize());
    drink.setSize(DrinkSize.EXTRALARGE);
    assertEquals("TEST: checking if size was changed", DrinkSize.EXTRALARGE, drink.getSize());
  }

  @Test
  public void testPrice() {
    assertTrue("TEST: checking if expected price is returned", drink.getPrice() == 1.50);
    drink.setPrice(10.00);
    assertTrue("TEST: checking if price was changed", drink.getPrice() == 10.00);
  }
  
  @Test
  public void testCalories() {
    assertTrue("TEST: checking if expected calories are returned", drink.getCalories() == 38.0);
    drink.setCalories(200.0);
    assertTrue("TEST: checking if calories were changed", drink.getCalories() == 200.00);
  }
  
  @Test
  public void testAlcoholContent() {
    assertFalse("TEST: checking if it returns true", drink.getAlcoholContent());
    drink.setAlcoholContent(true);
    assertTrue("TEST: checking if it returns false", drink.getAlcoholContent());
  }
}
