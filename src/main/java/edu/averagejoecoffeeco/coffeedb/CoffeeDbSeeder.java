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
    public void run(String... args) throws Exception {
        // roast, aroma, acidity, body, flavor, country, farm, production, Image Url,
        // inventory, price
        Coffee french = new Coffee("French Roast", "French Roast", "Sweet Aroma", "Low Acidity", "Full Body",
                "Bold Flavor", "Peru", "Peru Coffee Co.", "Organic",
                "https://athome.starbucks.com/wp-content/uploads/caramel-coffee_ground.jpg", 5, 5.99);
        Coffee bustello = new Coffee("Breakfast Blend", "Breakfast Blend", "Sweet", "Low", "Full", "Mild", "Peru",
                "Good Farms", "Organic", "https://athome.starbucks.com/wp-content/uploads/mocha-coffee_ground.jpg", 5,
                4.99);
        Coffee bigBlend = new Coffee("Chock Full o' Nuts", "Dark", "Nutty", "Low", "Full", "Deep", "USA", "Great Farms",
                "Non-Organic", "https://athome.starbucks.com/wp-content/uploads/cinnamon-dolce-coffee_ground.jpg", 5,
                6.99);
        Coffee mocha = new Coffee("Mocha Blend", "Mocha Blend", "Chocolaty", "Low", "Deep", "Sweet", "USA",
                "Great Farms", "Organic",
                "https://banner2.kisspng.com/20180130/ajq/kisspng-coffee-bean-gunny-sack-bag-kopi-luwak-bags-of-coffee-beans-close-up-5a703364186eb0.8779660015173026281001.jpg",
                5, 3.99);
        Coffee vanilla = new Coffee("Vanilla Blend", "Light", "Rich", "Low", "Velvety", "Rich", "USA", "Great Farms",
                "Non-Organic",
                "https://banner2.kisspng.com/20180130/ajq/kisspng-coffee-bean-gunny-sack-bag-kopi-luwak-bags-of-coffee-beans-close-up-5a703364186eb0.8779660015173026281001.jpg",
                5, 3.99);

        Coffee lastMinute1 = new Coffee("Light Roast","Light Roast","Nutty","Low","Full","Slightly Sweet","USA","Good ol Farms","Organic",
		"https://banner2.kisspng.com/20180130/ajq/kisspng-coffee-bean-gunny-sack-bag-kopi-luwak-bags-of-coffee-beans-close-up-5a703364186eb0.8779660015173026281001.jpg",100,3.99);
	    
	Coffee lastMinute2 = new Coffee("Brutal","Blacker than the Blackest Black times Infinity Roast","Cursed","VERY HIGH","NONE","BITTER","FROM THE HILLS OF COLOMBIA","Duncan Hills Coffee","BRUTAL","https://ih0.redbubble.net/image.472463630.5051/flat,1000x1000,075,f.u1.jpg",666,6.66);
	    
	Coffee why = new Coffee("Good Coffee","Good Coffee","Sweet","Medium","Light","Good?","Colombia","Great Farms","Organic",
		"https://banner2.kisspng.com/20180130/ajq/kisspng-coffee-bean-gunny-sack-bag-kopi-luwak-bags-of-coffee-beans-close-up-5a703364186eb0.8779660015173026281001.jpg",25,4.99);

        coffeeRepo.deleteAll();
        // add seeds
        List<Coffee> coffee = Arrays.asList(french, bustello, bigBlend, mocha, vanilla,lastMinute1,lastMinute2,why);
        coffeeRepo.saveAll(coffee);

    }
}
