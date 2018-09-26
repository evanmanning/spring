package org.kushikino.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

@Entity
@Table(name = "time")
public class Time {

  private int id;

  private OffsetDateTime dateTime;

  private LocalDateTime localDateTime1;

  private LocalDateTime localDateTime2;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Column(name = "date_time")
  public OffsetDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(OffsetDateTime dateTime) {
    this.dateTime = dateTime;
  }

  @Column(name = "local_date_time_1")
  public LocalDateTime getLocalDateTime1() {
    return localDateTime1;
  }

  public void setLocalDateTime1(LocalDateTime localDateTime1) {
    this.localDateTime1 = localDateTime1;
  }

  @Column(name = "local_date_time_2")
  public Calendar getLocalDateTime2() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
    calendar.setTimeInMillis(localDateTime2.atZone(ZoneId.of("UTC")).toInstant().toEpochMilli());
    //calendar.setTimeInMillis(localDateTime2.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    return calendar;
  }

  public void setLocalDateTime2(Calendar localDateTime2) {
    this.localDateTime2 = LocalDateTime.ofInstant(localDateTime2.toInstant(), ZoneId.of("UTC"));
    //this.localDateTime2 = LocalDateTime.ofInstant(localDateTime2.toInstant(), ZoneId.systemDefault());
  }

  @Transient
  public LocalDateTime getLocalDateTime2TheEasyWay() {
    return localDateTime2;
  }

  public void setLocalDateTime2TheEasyWay(LocalDateTime localDateTime2) {
    this.localDateTime2 = localDateTime2;
  }

}
