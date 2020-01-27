package com.spring.poc.user_feature.user_managment.service.controller;

import com.spring.poc.user_feature.domain.User;
import com.spring.poc.user_feature.user_managment.service.use_case.UserManagementUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/rest-api/v1/users")
public class UserController {

    private final UserManagementUseCase userManagement;

    @Autowired
    public UserController(UserManagementUseCase userManagement) {
        this.userManagement = userManagement;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody
    User addUser(@RequestBody User user) {
        return userManagement.addUser(user);
    }

    @RequestMapping(value = "/findUserByEmail", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    User findUserByEmail(@PathVariable String email) {
        return userManagement.findUserByEmail(email);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    List<User> findAllUsers() {
        return userManagement.findAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, params = {"page", "limit"})
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    Page<User> findAllUsers(@RequestParam("page") int page,
                            @RequestParam("size") int limit) {
        PageRequest pageRequest = new PageRequest(page, limit);
        return userManagement.findAllUsers(pageRequest);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody
    User updateUser(@RequestBody User user) {
        return userManagement.updateUser(user);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteUser(@RequestBody User user) {
        userManagement.deleteUser(user);
    }
}
