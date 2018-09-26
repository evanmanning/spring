package org.kushikino.endpoint;

import org.kushikino.model.TimeSchema;
import org.kushikino.model.Time;
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
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@RestController
@RequestMapping(
    path = "/time",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class TimeEndpoint {

  private EntityManager entityManager;

  @Autowired
  public TimeEndpoint(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @RequestMapping(
      path = "/{id}",
      method = RequestMethod.GET
  )
  @Transactional
  public ResponseEntity<TimeSchema> getTime(@PathVariable("id") int id) {

    Time time = entityManager.find(Time.class, id);

    if (time == null) {
      return new ResponseEntity<TimeSchema>(HttpStatus.NOT_FOUND);
    }

    TimeSchema timeSchema = new TimeSchema();
    timeSchema.setDateTime(time.getDateTime());
    timeSchema.setLocalDateTime1(time.getLocalDateTime1());
    timeSchema.setLocalDateTime2(time.getLocalDateTime2TheEasyWay());

    return ResponseEntity.ok(timeSchema);
  }

  @RequestMapping(
      method = RequestMethod.POST
  )
  @Transactional
  public ResponseEntity createTime(@RequestBody TimeSchema timeSchema) {

    OffsetDateTime dateTime = timeSchema.getDateTime();
    LocalDateTime localDateTimeFromOffsetDateTime = dateTime.toLocalDateTime();

    Time time = new Time();
    time.setDateTime(dateTime);
    time.setLocalDateTime1(localDateTimeFromOffsetDateTime);
    time.setLocalDateTime2TheEasyWay(timeSchema.getLocalDateTime2());

    entityManager.persist(time);

    HttpHeaders headers = new HttpHeaders();
    headers.add("X-Entity-Id", "" + time.getId());
    return new ResponseEntity(headers, HttpStatus.CREATED);
  }

}
