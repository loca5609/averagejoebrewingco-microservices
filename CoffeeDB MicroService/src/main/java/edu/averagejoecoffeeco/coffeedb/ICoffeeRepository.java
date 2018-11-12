package edu.averagejoecoffeeco.coffeedb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import edu.averagejoecoffeeco.coffeedb.api.entities.Coffee;

@Repository
public interface ICoffeeRepository extends MongoRepository<Coffee, String> {

  @Query (value = "{'aroma':?0}")
  List<Coffee> findByaroma(String aroma);

  @Query (value = "{'flavor':?0}")
  List<Coffee> findByflavor(String flavor);

  @Query (value = "{'body':?0}")
  List<Coffee> findBybody(String body);

  @Query (value = "{'country':?0}")
  List<Coffee> findBycountry(String country);

  @Query (value = "{'roast':?0}")
  List<Coffee> findByRoastType(String type);

}

