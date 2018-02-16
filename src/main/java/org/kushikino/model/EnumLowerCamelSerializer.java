package org.kushikino.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.base.CaseFormat;

import java.io.IOException;

public class EnumLowerCamelSerializer<T extends Enum<T>> extends JsonSerializer<T> {
  @Override
  public void serialize(T value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {

    jgen.writeFieldName(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, value.name()));
  }
}
