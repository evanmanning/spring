package org.kushikino;

public class PeachStore {

  // Setter injection via property element in peachStore bean in beans.xml
  // Bean defined by peachGenerator bean in beans.xml
  private PeachGenerator peachGenerator;

  public String get() {
    return peachGenerator.getPeaches();
  }

  public void setPeachGenerator(PeachGenerator peachGenerator) {
    this.peachGenerator = peachGenerator;
  }

}
