package org.kushikino.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "reservation")
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "confirmation_code")
  private String confirmationCode;

  @OneToMany(
      fetch = FetchType.EAGER,
      cascade = CascadeType.ALL)
  @JoinTable(
      name = "reservation_person",
      joinColumns = @JoinColumn(name = "reservation_id"),
      inverseJoinColumns = @JoinColumn(name = "person_id"))
  private Set<Person> persons;

  @OneToMany(
      fetch = FetchType.EAGER,
      cascade = CascadeType.ALL)
  @JoinTable(
      name = "reservation_flight",
      joinColumns = @JoinColumn(name = "reservation_id"),
      inverseJoinColumns = @JoinColumn(name = "flight_id"))
  private Set<Flight> flights;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getConfirmationCode() {
    return confirmationCode;
  }

  public void setConfirmationCode(String confirmationCode) {
    this.confirmationCode = confirmationCode;
  }

  public Set<Person> getPersons() {
    return persons;
  }

  public void setPersons(Set<Person> persons) {
    this.persons = persons;
  }

  public Set<Flight> getFlights() {
    return flights;
  }

  public void setFlights(Set<Flight> flights) {
    this.flights = flights;
  }

}
