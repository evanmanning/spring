package org.kushikino.model;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class TimeSchema {

  private OffsetDateTime dateTime;
  private LocalDateTime localDateTime1;
  private LocalDateTime localDateTime2;

  public OffsetDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(OffsetDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public LocalDateTime getLocalDateTime1() {
    return localDateTime1;
  }

  public void setLocalDateTime1(LocalDateTime localDateTime1) {
    this.localDateTime1 = localDateTime1;
  }

  public LocalDateTime getLocalDateTime2() {
    return localDateTime2;
  }

  public void setLocalDateTime2(LocalDateTime localDateTime2) {
    this.localDateTime2 = localDateTime2;
  }
}
