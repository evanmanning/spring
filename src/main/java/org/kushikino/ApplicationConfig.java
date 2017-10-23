package org.kushikino;

import org.kushikino.store.MelonStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

  @Bean
  public MelonStore getMelonStore() {
    return new MelonStore();
  }

}
