
package com.example.fullstackbackend.controller;
import com.example.fullstackbackend.exception.UsernotfoundException;
import com.example.fullstackbackend.model.Userr;
import com.example.fullstackbackend.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

    @RestController
    @CrossOrigin("http://localhost:3000")
    public class Usercontroller {
        @Autowired
        private  UserRepository userRepository;

        @PostMapping("/users")
        Userr newUser(@RequestBody Userr newUser) {
            return userRepository.save(newUser);
        }


        @GetMapping("/users")
        List<Userr> getAllUsers() {
            return userRepository.findAll();
        }

        @GetMapping("/users/{id}")
        Userr getUserById(@PathVariable Long id) {
            return userRepository.findById(id)
                    .orElseThrow(() -> new UsernotfoundException(id));
        }

        @PutMapping("/users/{id}")
        Userr updateUser(@RequestBody Userr newUser, @PathVariable Long id) {
            return userRepository.findById(id)
                    .map(users -> {
                        users.setDescription(newUser.getDescription());
                        users.setDuedate(newUser.getDuedate());
                        return userRepository.save(users);
                    }).orElseThrow(() -> new UsernotfoundException(id));
      }
        @DeleteMapping("/users/{id}")
        String deleteUser(@PathVariable Long id){
            if(!userRepository.existsById(id)){
                throw new UsernotfoundException(id);
            }
            userRepository.deleteById(id);
            return  "User with id "+id+" has been deleted success.";
        }

//

    }