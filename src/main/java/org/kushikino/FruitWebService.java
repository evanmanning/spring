package org.kushikino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitWebService {

  // Field injection
  // Bean defined by StrawberryStore class annotated with @Component
  @Autowired
  private StrawberryStore strawberryStore;

  // Field injection
  // Bean defined by peachStore bean in beans.xml
  @Autowired
  private PeachStore peachStore;

  // Constructor injection
  // Bean defined by PineappleStore class annotated with @Component
  private PineappleStore pineappleStore;

  // Setter injection
  // Bean defined by getMelonStore method annotated with @Bean, in Beans class annotated with @Configuration
  private MelonStore melonStore;

  @Autowired
  public FruitWebService(PineappleStore pineappleStore) {
    this.pineappleStore = pineappleStore;
  }

  @RequestMapping(value = "strawberry")
  public ResponseEntity getStrawberry() {
    String response = strawberryStore.get();

    return new ResponseEntity<String>(response, HttpStatus.OK);
  }

  @RequestMapping(value = "peach")
  public ResponseEntity getPeach() {
    String response = peachStore.get();

    return new ResponseEntity<String>(response, HttpStatus.OK);
  }

  @RequestMapping(value = "pineapple")
  public ResponseEntity getPineapple() {
    String response = pineappleStore.get();

    return new ResponseEntity<String>(response, HttpStatus.OK);
  }

  @RequestMapping(value = "melon")
  public ResponseEntity getMellon() {
    String response = melonStore.get();

    return new ResponseEntity<String>(response, HttpStatus.OK);
  }

  @Autowired
  public void setMelonStore(MelonStore melonStore) {
    this.melonStore = melonStore;
  }

}
