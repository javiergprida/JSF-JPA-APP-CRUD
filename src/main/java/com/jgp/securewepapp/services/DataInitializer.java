package com.jgp.securewepapp.services;

import com.jgp.securewepapp.entities.User;
import javax.enterprise.context.ApplicationScoped;

import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

import javax.inject.Inject;

@ApplicationScoped
public class DataInitializer {

    @Inject
    DataService dataservice;

    
    public void execute(@Observes @Initialized(ApplicationScoped.class) Object Event) {
        if (dataservice.getAllUser().isEmpty()) {
            User Javier = dataservice.createUser("Javier Gomez ", "jprida", "12345", "admin");
            User Roderik = dataservice.createUser("Roderik Sosa ", "roderik", "123456", "user");
            User Lourdes = dataservice.createUser("Flor de Lourdes Prida ", "luliprida", "1234567", "user");

            dataservice.createQuality("Wonderfull", Javier);
            dataservice.createQuality("Excelent TeamLeader", Javier);
            dataservice.createQuality("great worker", Javier);
            
            dataservice.createQuality("Work Hard", Roderik);
            dataservice.createQuality("Great Partners", Roderik);
            dataservice.createQuality("Nice Person", Roderik);
            
            dataservice.createQuality("Responsale", Lourdes);
            dataservice.createQuality("Great Partners", Lourdes);
            dataservice.createQuality("Nice Person", Lourdes);
        }

    }

}
