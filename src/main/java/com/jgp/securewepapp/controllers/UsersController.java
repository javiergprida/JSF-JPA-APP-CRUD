package com.jgp.securewepapp.controllers;

import com.jgp.securewepapp.entities.Users;
import com.jgp.securewepapp.services.DataService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class UsersController {

    @Inject
    DataService dataservice;

    private List<Users> allUsers;

    @PostConstruct
    public void initialize() {
        this.allUsers = dataservice.getAllUser();

    }

    public List<Users> getAllUsers() {
        return allUsers;
    }


}
