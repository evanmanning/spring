package org.kushikino;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

  @Bean
  public MelonStore getMelonStore() {
    return new MelonStore();
  }

}
