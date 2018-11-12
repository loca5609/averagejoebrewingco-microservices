package edu.averagejoecoffeeco.coffeedb.api;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.averagejoecoffeeco.coffeedb.ICoffeeRepository;
import edu.averagejoecoffeeco.coffeedb.api.entities.Coffee;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/coffee")
public class CoffeeController {
  @Autowired
  ICoffeeRepository coffeeRepo;

  
  @GetMapping ("/allCoffee")
  List<Coffee> getAll(){
    List<Coffee> result = coffeeRepo.findAll();
    return result;
  }

  @GetMapping ("/aroma/{aroma}")
  List<Coffee> getByAroma(@PathVariable String aroma){
    List<Coffee> result = coffeeRepo.findByaroma(aroma);
    return result;
  }

  @GetMapping ("/flavor/{flavor}")
  List<Coffee> getByFlavor(@PathVariable String flavor){
    List<Coffee> result = coffeeRepo.findByflavor(flavor);
    return result;
  }

  @GetMapping ("/body/{body}")
  List<Coffee> getByBody(@PathVariable String body){
    List<Coffee> result = coffeeRepo.findBybody(body);
    return result;
  }  

  @GetMapping("/country/{country}")
  List<Coffee> getByCountry(@PathVariable String country){
    List<Coffee> result = coffeeRepo.findBycountry(country);
    return result;
  }

  @GetMapping("/roast/{type}")
  List<Coffee> getByRoastType(@PathVariable String type){
    List<Coffee> result = coffeeRepo.findByRoastType(type);
    return result;
  }

  

}

