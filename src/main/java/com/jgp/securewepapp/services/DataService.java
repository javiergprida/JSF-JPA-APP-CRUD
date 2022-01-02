package com.jgp.securewepapp.services;

import com.jgp.securewepapp.entities.Quality;
import com.jgp.securewepapp.entities.Users;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class DataService {

    @PersistenceContext(unitName = "SecureWepApp")
    EntityManager em;

    @Transactional
    public Users CreateUser(String name, String username, String password, String group) {

        Users newUser = new Users(name, username, password, group);

        em.persist(newUser);
        em.flush();
        return newUser;
    }

    @Transactional
    public Quality createQuality(String description, Users user) {

        Quality newQuality = new Quality(description, user);
        em.persist(newQuality);
        em.flush();

        return newQuality;

    }

    public List<Users> getAllUser() {
        return em.createNamedQuery("users.all", Users.class).getResultList();

    }

    public Optional<Users> getUser(String username) {
        return em.createNamedQuery("user.byUsername", Users.class)
                .setParameter("username", username)
                .getResultList()
                .stream()
                .findFirst();

    }

    public List<Quality> getQuality(Users user) {
        return em.createNamedQuery("quality.byUsers", Quality.class)
                .setParameter("id", user.getId())
                .getResultList();

    }

}
