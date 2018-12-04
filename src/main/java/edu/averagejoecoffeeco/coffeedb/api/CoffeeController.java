package edu.averagejoecoffeeco.coffeedb.api;

import java.awt.PageAttributes.MediaType;
import java.io.Console;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.owasp.encoder.Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.averagejoecoffeeco.coffeedb.CoffeedbApplication;
import edu.averagejoecoffeeco.coffeedb.ICoffeeRepository;
import edu.averagejoecoffeeco.coffeedb.api.entities.Coffee;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CoffeeController {
    private static final Logger logger = LoggerFactory.getLogger(CoffeedbApplication.class);
    @Autowired
    ICoffeeRepository coffeeRepo;

    // sanitized input thats 5% extra credit (Project Wide)

    @GetMapping("/allCoffee")
    List<Coffee> getAll() {
        List<Coffee> result = coffeeRepo.findAll();
        return result;
    }

    @GetMapping("/id/{id}")
    Optional<Coffee> getById(@PathVariable String id) {
        String sanitizedId = Encode.forJava(id);
        Optional<Coffee> result = coffeeRepo.findById(sanitizedId);
        return result;
    }

    @GetMapping("/name/{name}")
    List<Coffee> getByName(@PathVariable String name) {
        String sanitizedName = Encode.forJava(name);
        List<Coffee> result = coffeeRepo.findByName(sanitizedName);
        return result;
    }

    @GetMapping("/aroma/{aroma}")
    List<Coffee> getByAroma(@PathVariable String aroma) {
        String sanitizedAroma = Encode.forJava(aroma);
        List<Coffee> result = coffeeRepo.findByaroma(sanitizedAroma);
        return result;
    }

    @GetMapping("/flavor/{flavor}")
    List<Coffee> getByFlavor(@PathVariable String flavor) {
        String sanitizedFlavor = Encode.forJava(flavor);
        List<Coffee> result = coffeeRepo.findByflavor(sanitizedFlavor);
        return result;
    }

    @GetMapping("/body/{body}")
    List<Coffee> getByBody(@PathVariable String body) {
        String sanitizedBody = Encode.forJava(body);
        List<Coffee> result = coffeeRepo.findBybody(sanitizedBody);
        return result;
    }

    @GetMapping("/country/{country}")
    List<Coffee> getByCountry(@PathVariable String country) {
        String sanitizedCountry = Encode.forJava(country);
        List<Coffee> result = coffeeRepo.findBycountry(sanitizedCountry);
        return result;
    }

    @GetMapping("/roast/{type}")
    List<Coffee> getByRoastType(@PathVariable String type) {
        String sanitizedType = Encode.forJava(type);
        List<Coffee> result = coffeeRepo.findByRoastType(sanitizedType);
        return result;
    }

    @GetMapping("/{id}/{quantity}")
    public ResponseEntity<Coffee> updateCoffee(@PathVariable("id") String id,
            @PathVariable("quantity") Integer quantity) {
        String sanId = Encode.forJava(id);
        Optional<Coffee> coffeeData = coffeeRepo.findById(sanId);
        if (coffeeData.isPresent()) {
            logger.info("Adjusting Coffee:" + id + " by " + quantity + "units.");
            Coffee savedCoffee = coffeeData.get();
            // Return 400 bad request if subtracting inventory would make it negative
            if ((savedCoffee.getInventory() - quantity) < 0) {
                logger.error("Coffee Inventory for " + savedCoffee.getId() + " would be set to negative!");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            savedCoffee.setInventory((savedCoffee.getInventory() - quantity));
            Coffee updatedCoffee = coffeeRepo.save(savedCoffee);
            return new ResponseEntity<Coffee>(updatedCoffee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
