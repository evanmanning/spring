package org.kushikino.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.google.common.base.CaseFormat;

import java.io.IOException;

public class EnumLowerCamelKeyDeserializer<T extends Enum<T>> extends KeyDeserializer {

  private Class<T> enumType;

  public EnumLowerCamelKeyDeserializer(Class<T> enumType) {
    this.enumType = enumType;
  }

  @Override
  public Object deserializeKey(String key, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    return Enum.valueOf(enumType, CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, key));
  }
}
