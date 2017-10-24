package org.kushikino.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "flight")
public class Flight {

  @Id
  private int id;

  @Column(name = "origin")
  private String origin;

  @Column(name = "destination")
  private String destination;

  @Column(name = "departure_time")
  private OffsetDateTime departureTime;

  @Column(name = "arrival_time")
  private OffsetDateTime arrivalTime;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public OffsetDateTime getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(OffsetDateTime departureTime) {
    this.departureTime = departureTime;
  }

  public OffsetDateTime getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(OffsetDateTime arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

}
