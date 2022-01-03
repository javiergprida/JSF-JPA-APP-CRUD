package com.jgp.securewepapp.services;

import com.jgp.securewepapp.entities.Quality;
import com.jgp.securewepapp.entities.User;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.transaction.Transactional;

@ApplicationScoped
public class DataService {

    @PersistenceContext(unitName = "SecureWepApp")
    EntityManager em;
    
    @Inject
    Pbkdf2PasswordHash  passwordHasher;
    

    @Transactional
    public User createUser(String fullname, String username, String password, String group) {

        User newUser = new User(fullname, username,passwordHasher.generate(password.toCharArray()), group);

        em.persist(newUser);
        em.flush();
        return newUser;
    }

    @Transactional
    public Quality createQuality(String description, User user) {

        Quality newQuality = new Quality(description, user);
        em.persist(newQuality);
        em.flush();
        return newQuality;

    }

    public List<User> getAllUser() {
        return em.createNamedQuery("User.all", User.class).getResultList();

    }

    public Optional<User> getUser(String username) {
        return em.createNamedQuery("User.byUsername", User.class)
                .setParameter("username", username)
                .getResultList()
                .stream()
                .findFirst();

    }

    public List<Quality> getQuality(User user) {
        return em.createNamedQuery("Quality.byUser", Quality.class)
                .setParameter("userId", user.getId())
                .getResultList();

    }

}
