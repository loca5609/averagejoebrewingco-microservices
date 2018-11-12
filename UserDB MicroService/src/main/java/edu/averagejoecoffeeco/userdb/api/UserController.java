package edu.averagejoecoffeeco.userdb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.averagejoecoffeeco.userdb.IUserRepository;
import edu.averagejoecoffeeco.userdb.api.entities.User;

@RestController
public class UserController {
  @Autowired
  IUserRepository userRepo;

  @GetMapping ("/allUserInfo")
  List<User> getAll(){
    List<User> result = userRepo.findAll();
    return result;
  }

  @GetMapping("/firstname/{firstname}")
  public List<User> getByFirstName(@PathVariable String firstname){
    List<User> result = userRepo.findByfirstName(firstname);
    return result;
  }

  @GetMapping("/username/{username}")
  public User getByUserName(@PathVariable String username){
      User result = userRepo.findByusername(username);
      return result;
  }

  @RequestMapping(value="/create", method= RequestMethod.POST)
  public User addNewUser(@RequestBody User user){
      return userRepo.save(user); 
  }

}
