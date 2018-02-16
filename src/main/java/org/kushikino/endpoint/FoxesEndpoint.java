package org.kushikino.endpoint;

import org.kushikino.model.Fox;
import org.kushikino.model.FoxColor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/foxes")
public class FoxesEndpoint {

  @GetMapping
  public ResponseEntity get() {

    Fox fox = new Fox();
    fox.setColor(FoxColor.BROWN);

    Map<FoxColor, Integer> map = new HashMap<>();
    map.put(FoxColor.BROWN, 4);
    map.put(FoxColor.RED, 2);

    fox.setChildrenColorCounts(map);

    return new ResponseEntity<Fox>(fox, HttpStatus.OK);
  }

  @RequestMapping(
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity post(@RequestBody Fox fox) {

    System.out.println("Caught a fox");
    System.out.println(fox);

    return new ResponseEntity(HttpStatus.OK);

  }

}
