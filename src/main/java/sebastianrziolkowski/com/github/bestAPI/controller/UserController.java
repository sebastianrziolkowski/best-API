package sebastianrziolkowski.com.github.bestAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sebastianrziolkowski.com.github.bestAPI.models.DeviceModels.Device;
import sebastianrziolkowski.com.github.bestAPI.models.LoginData;
import sebastianrziolkowski.com.github.bestAPI.models.User;
import sebastianrziolkowski.com.github.bestAPI.repo.UserRepository;
import sebastianrziolkowski.com.github.bestAPI.staticClass.mappingPath;
import sebastianrziolkowski.com.github.bestAPI.staticClass.messages;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping(value = mappingPath.USERS)
    public List<User> getAllUsers() {
        System.out.println(messages.GET_ALL_USERS_LIST);
        return new ArrayList<>(repository.findAll());
    }

    @PostMapping(mappingPath.USER_BY_LOGIN_NAME)
    public User getUserByLoginName(@RequestBody String loginName) {
        User user =  repository.findByLoginName(loginName);
        System.out.println(user);
        return user;
    }


    @RequestMapping(value = mappingPath.AUTHORIZATION, method = RequestMethod.POST)
    public boolean process(@RequestBody LoginData loginData) {
        User user = repository.findByLoginName(loginData.getLoginName());
        if (user != null && user.getPassword().equals(loginData.getPassword())) {
            System.out.println(messages.CORRECT_LOGIN_DATA + loginData.toString());
            return true;
        } else {
            System.out.println(messages.INCORRECT_LOGIN_DATA);
            return false;
        }
    }


    @PostMapping(value = mappingPath.LOGGED_USER)
    public User loggedUser(@RequestBody String loginName) {
        User user = repository.findByLoginName(loginName);
        if (user != null) {
            System.out.println(messages.FOUND_USER + loginName);
        } else {
            System.out.println(messages.INCORRECT_LOGIN_DATA);
        }
        return user;
    }

    @PostMapping(mappingPath.ADD_USER)
    public void addUser(@Valid @RequestBody User user) {
        try {
            repository.save(user);
            System.out.println(messages.ADD_USER + user.getLoginName());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    @GetMapping("/counter")
    public long getNumberOfInstance() {
        return repository.count();
    }

}
