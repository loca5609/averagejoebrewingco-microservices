package edu.averagejoecoffeeco.coffeedb;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import edu.averagejoecoffeeco.coffeedb.api.entities.Coffee;




@Component
public class CoffeeDbSeeder implements CommandLineRunner {
  @Autowired
  ICoffeeRepository coffeeRepo;

  @Override
  public void run(String ... args) throws Exception {
    //roast, aroma, acidity, body, flavor, country, farm, production, Image Url, inventory, price
    Coffee french = new Coffee("French Roast","Sweet Aroma","Low Acidity","Full Body", "Bold Flavor","Peru","Peru Coffee Co.","Organic","https://athome.starbucks.com/wp-content/uploads/caramel-coffee_ground.jpg",5,5.99);
    Coffee bustello = new Coffee("Breakfast Blend","Sweet","Low","Full","Mild","Peru","Good Farms","Organic","https://athome.starbucks.com/wp-content/uploads/mocha-coffee_ground.jpg",5,4.99);
    Coffee bigBlend = new Coffee("Dark","Nutty","Low","Full","Deep","USA","Great Farms","Non-Organic","https://athome.starbucks.com/wp-content/uploads/cinnamon-dolce-coffee_ground.jpg",5,6.99);
    Coffee mocha = new Coffee("Mocha Blend","Chocolaty","Low","Deep","Sweet","USA","Great Farms","Organic","https://banner2.kisspng.com/20180130/ajq/kisspng-coffee-bean-gunny-sack-bag-kopi-luwak-bags-of-coffee-beans-close-up-5a703364186eb0.8779660015173026281001.jpg",5,3.99);
    Coffee vanilla = new Coffee("Light","Rich","Low","Velvety","Rich","USA","Great Farms","Non-Organic","https://banner2.kisspng.com/20180130/ajq/kisspng-coffee-bean-gunny-sack-bag-kopi-luwak-bags-of-coffee-beans-close-up-5a703364186eb0.8779660015173026281001.jpg",5,3.99);

    coffeeRepo.deleteAll();
    // add seeds
    List<Coffee> coffee = Arrays.asList(french,bustello, bigBlend,mocha,vanilla);
    coffeeRepo.saveAll(coffee);


  }
}
