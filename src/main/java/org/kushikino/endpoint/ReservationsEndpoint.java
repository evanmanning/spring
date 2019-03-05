package org.kushikino.endpoint;

import org.kushikino.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@RestController
@RequestMapping(
    path = "reservations",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class ReservationsEndpoint {

  private EntityManager entityManager;

  @Autowired
  public ReservationsEndpoint(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @RequestMapping(
      path = "/{id}",
      method = RequestMethod.GET
  )
  @Transactional
  public ResponseEntity<Reservation> getReservation(@PathVariable("id") int id) {

    Reservation reservation = entityManager.find(Reservation.class, id);

    if (reservation == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return ResponseEntity.ok(reservation);
  }

  @RequestMapping(
      method = RequestMethod.POST
  )
  @Transactional
  public ResponseEntity createReservation(@RequestBody Reservation reservation) {

    entityManager.persist(reservation);

    HttpHeaders headers = new HttpHeaders();
    headers.add("X-Entity-Id", "" + reservation.getId());
    return new ResponseEntity(headers, HttpStatus.CREATED);
  }

}
