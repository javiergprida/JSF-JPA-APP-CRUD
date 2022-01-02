package com.jgp.securewepapp.services;

import com.jgp.securewepapp.entities.Users;
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
            Users Javier = dataservice.CreateUser("Javier Gomez ", "jprida", "12345", "admin");
            Users Roderik = dataservice.CreateUser("Roderik Sosa ", "roderik", "123456", "user");
            Users Lourdes = dataservice.CreateUser("Flor de Lourdes Prida ", "luliprida", "1234567", "user");

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
