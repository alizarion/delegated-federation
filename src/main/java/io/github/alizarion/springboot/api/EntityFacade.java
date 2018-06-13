package io.github.alizarion.springboot.api;

import io.github.alizarion.springboot.entities.Person;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by sbn on 13/06/2018.
 */
@Named("entityFacade")
public class EntityFacade  implements Serializable {

    @PersistenceContext
    EntityManager em;



    @PostConstruct
    protected void init(){

    }


    @Transactional
    public Person findPersonByID(final Long id){
        return this.em.find(Person.class,id);
    }

    @Transactional
    public Person mergePerson(final Person person){
        return this.em.merge(person);
    }

    @Transactional
    public List<Person> findAllPerson(){
        /*Set<Person> s=  this.personDao.findAll();
        for (Person p: s) {
            p.getAdresses();
        }
        return s;*/
        return this.em.createQuery("select p from Person p")
                .getResultList();
    }
}
