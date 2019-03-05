package org.kushikino.endpoint;

import org.kushikino.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RestController
@RequestMapping(
    path = "persons",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class PersonsEndpoint {

  private EntityManagerFactory entityManagerFactory;

  @Autowired
  public PersonsEndpoint(EntityManagerFactory entityManagerFactory) {
    this.entityManagerFactory = entityManagerFactory;
  }

  @RequestMapping(
      path = "/{id}",
      method = RequestMethod.GET
  )
  public ResponseEntity<Person> getPerson(@PathVariable("id") int id) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    entityManager.getTransaction().begin();

    Person person = entityManager.find(Person.class, id);

    entityManager.getTransaction().commit();

    if (person == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return ResponseEntity.ok(person);
  }

}