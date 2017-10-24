package org.kushikino.endpoint;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.kushikino.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
    path = "persons",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class PersonsEndpoint {

  private SessionFactory sessionFactory;

  @Autowired
  public PersonsEndpoint(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @RequestMapping(
      path = "/{id}",
      method = RequestMethod.GET
  )
  public ResponseEntity<Person> getPerson(@PathVariable("id") int id) {
    Session session = sessionFactory.openSession();

    session.beginTransaction();

    Person person = session.get(Person.class, id);

    session.getTransaction().commit();
    session.close();

    return ResponseEntity.ok(person);
  }

}
