package io.github.alizarion.springboot.api;


import com.itesoft.common.utils.security.utils.SecurityUtils;
import io.github.alizarion.springboot.entities.Person;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.*;

/**
 * @author selim@openlinux.fr.
 */
@Path("/persons")
@Named
public class PersonRessource {


    @Inject
    @Named("entityFacade")
    EntityFacade facade;

    @Context SecurityContext context;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> findPersons(){
        return new ArrayList<>(facade.findAllPerson());
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person updatePerson(Person person){
        return facade.mergePerson(person);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin"})
    @Consumes(MediaType.APPLICATION_JSON)
    public Person createPerson(Person person){
        return facade.mergePerson(person);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    @Path("/{id}")
    public Person getPerson(@PathParam("id") Long id){
        return facade.findPersonByID(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/test")
    public Person testMethod(){
        return new Person("selim","bensenouci");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)

    @Path("/user")
    public MyCustomPrincipal currentUser(@Context SecurityContext securityContext){
        return (MyCustomPrincipal) securityContext.getUserPrincipal();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/debug")
    public Set<Map.Entry<String, Object>> debug(@Context HttpServletRequest httpServletRequest){
        return SecurityUtils.extractRequestClaims(httpServletRequest,"IT_CLAIM_");
    }
}
