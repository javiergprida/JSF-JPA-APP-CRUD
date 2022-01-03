package com.jgp.securewepapp.controllers;

import com.jgp.securewepapp.entities.Quality;
import com.jgp.securewepapp.entities.User;
import com.jgp.securewepapp.services.DataService;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;

@RequestScoped
@Named
public class HomeController {

    @Inject
    DataService dataservice;
    
    @Inject
    SecurityContext securityContext;

    private Optional<User> currentUser;

    private List<Quality> currentQualities;

    @PostConstruct
    public void initialize() {
        String username = securityContext.getCallerPrincipal().getName();
        this.currentUser = dataservice.getUser(username);
        this.currentUser.ifPresent(user ->  this.currentQualities = dataservice.getQuality(user));

    }

    public User getCurrentUser() {
        return this.currentUser.orElse(null);

    }

    public List<Quality> getCurrentQualities() {
        return currentQualities;
    }

    

}
