package org.kushikino;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.hibernate.SessionFactory;
import org.kushikino.model.EnumLowerCamelKeyDeserializer;
import org.kushikino.model.EnumLowerCamelSerializer;
import org.kushikino.model.FoxColor;
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
  public Module module() {
    SimpleModule module = new SimpleModule();
    module.addKeySerializer(FoxColor.class, new EnumLowerCamelSerializer<FoxColor>());
    module.addKeyDeserializer(FoxColor.class, new EnumLowerCamelKeyDeserializer<FoxColor>(FoxColor.class));
    return module;
  }

}
