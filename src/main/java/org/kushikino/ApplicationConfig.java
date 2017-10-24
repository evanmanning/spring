package org.kushikino;

import org.hibernate.SessionFactory;
import org.kushikino.store.MelonStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
public class ApplicationConfig {

  @Bean
  public MelonStore getMelonStore() {
    return new MelonStore();
  }

  @Bean
  public SessionFactory getSessionFactory(EntityManagerFactory entityManagerFactory) {
    return entityManagerFactory.unwrap(SessionFactory.class);
  }

}
