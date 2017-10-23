package org.kushikino.store;

public class PeachStore {

  // Setter injection via property element in peachStore bean in application-config.xml
  // Bean defined by peachGenerator bean in application-config.xml
  private PeachGenerator peachGenerator;

  public String get() {
    return peachGenerator.getPeaches();
  }

  public void setPeachGenerator(PeachGenerator peachGenerator) {
    this.peachGenerator = peachGenerator;
  }

}
