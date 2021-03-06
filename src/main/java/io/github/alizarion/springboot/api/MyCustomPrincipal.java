package io.github.alizarion.springboot.api;

import javax.security.auth.Subject;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

public class MyCustomPrincipal  implements Principal {


    Map<String, Object> publicClaims = new HashMap<>();


    public MyCustomPrincipal(Map<String, Object> publicClaims) {
        this.publicClaims = publicClaims;
    }

    @Override
    public String getName() {
        return (String) publicClaims.get("email");
    }

    public Map<String, Object> getPublicClaims() {
        return publicClaims;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }
}
