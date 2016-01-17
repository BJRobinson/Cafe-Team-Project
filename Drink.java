import java.util.HashSet;

/**
 * Drink class.
 *
 * @author Lucas Rezende Correa de Souza
 *
 */

public class Drink {
  private String name;
  private DrinkType type;
  private DrinkSize size;
  private double price;
  private double calories;
  private boolean alcoholContent;
  //private Stock drinkStock;
  public static HashSet<Drink> drinksMenu;
  
  public Drink(String name, DrinkType type, DrinkSize size, double price, 
      double calories, boolean alcoholContent) {
    this.name = name;
    this.type = type;
    this.size = size;
    this.price = price;
    this.calories = calories;
    this.alcoholContent = alcoholContent;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public DrinkType getType() {
    return this.type;
  }
  
  public void setType(DrinkType type) {
    this.type = type;
  }
  
  public DrinkSize getSize() {
    return this.size;
  }
  
  public void setSize(DrinkSize size) {
    this.size = size;
  }
  
  public double getPrice() {
    return this.price;
  }
  
  public void setPrice(double price) {
    this.price = price;
  }
  
  public double getCalories() {
    return this.calories;
  }
  
  public void setCalories(double calories) {
    this.calories = calories;
  }
  
  public boolean getAlcoholContent() {
    return this.alcoholContent;
  }
  
  public void setAlcoholContent(boolean alcoholContent) {
    this.alcoholContent = alcoholContent;
  }
  
  /*public boolean isItInStock(Drink drink) {
    drinkStock = new Stock();
    if(drinkStock.itemsMap.contains(drink)) {
      return true;
    } else {
      return false;
    }
  }*/
}

