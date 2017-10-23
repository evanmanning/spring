package org.kushikino.endpoint;

import org.kushikino.store.MelonStore;
import org.kushikino.store.PeachStore;
import org.kushikino.store.StrawberryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fruit")
public class FruitEndpoint {

  // Field injection via autowiring
  // Bean defined by StrawberryStore class annotated with @Component
  @Autowired
  private StrawberryStore strawberryStore;

  // Constructor injection via autowiring
  // Bean defined by getMelonStore method annotated with @Bean, in ApplicationConfig class annotated with @Configuration
  private MelonStore melonStore;

  // Setter injection via autowiring
  // Bean defined by peachStore bean in application-config.xml
  private PeachStore peachStore;

  @Autowired
  public FruitEndpoint(MelonStore melonStore) {
    this.melonStore = melonStore;
  }

  @GetMapping("strawberry")
  public ResponseEntity getStrawberry() {
    String response = strawberryStore.get();

    return new ResponseEntity<String>(response, HttpStatus.OK);
  }

  @GetMapping("melon")
  public ResponseEntity getMellon() {
    String response = melonStore.get();

    return new ResponseEntity<String>(response, HttpStatus.OK);
  }

  @GetMapping("peach")
  public ResponseEntity getPeach() {
    String response = peachStore.get();

    return new ResponseEntity<String>(response, HttpStatus.OK);
  }

  @Autowired
  public void setPeachStore(PeachStore peachStore) {
    this.peachStore = peachStore;
  }

}
