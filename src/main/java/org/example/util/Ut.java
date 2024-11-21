package org.example.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.article.ArticleDto;

public class Ut {
  private final static ObjectMapper om;

  static {
    om = new ObjectMapper();
  }


  public static class json {
    public static String toStr(Object obj, String defaultValue) {

      try {
        return om.writeValueAsString(obj);
      } catch (JsonProcessingException e) {
        return defaultValue;
      }
    }

    public static Object toObj(String jsonStr, Class cls, Object defaultValue) {
      ObjectMapper om = new ObjectMapper();

      try {
        return om.readValue(jsonStr, cls);
      } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
