
package com.jgp.securewepapp;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;


@DatabaseIdentityStoreDefinition(
        dataSourceLookup="jdbc/SecureAppDS",
        callerQuery = "SELECT password FROM users WHERE username = ?",
        groupsQuery = "SELECT usergroup FROM users WHERE username = ?"
)
@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/Login.xhtml",
                errorPage = "",
                useForwardToLogin = false
        )
)
@FacesConfig
@ApplicationScoped
public class AppConfiguration {
    
}
