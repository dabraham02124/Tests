package org.sweatshop.tests;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Value;

public class JacksonStreaming {
    @Value
    @JsonSerialize(using = ToStreamSerializer.class)
    private static class ToStream {
        int intVal;
        String stringVal;
    }
    
    private static class ToStreamSerializer extends JsonSerializer<ToStream> {
        @Override
        public void serialize(ToStream value, JsonGenerator jgen, SerializerProvider provider) 
          throws IOException, JsonProcessingException {
            jgen.writeStartObject();
            jgen.writeNumberField("id", value.getIntVal());
            jgen.writeEndObject();
        }
    }

    public static void main(String[] args) throws IOException {
        ToStream ts = new ToStream(5, "string");
        ObjectMapper mapper = new ObjectMapper();
//        SimpleModule module = new SimpleModule("Name", new Version(0, 1, 2, "alpha", "beta", "gamma"));
//        module.addSerializer(ToStream.class, new ToStreamSerializer());
//        mapper.registerModule(module);
        mapper.writeValue(new BufferedWriter(new OutputStreamWriter(System.out)), ts);
        
//        JsonFactory factory = new JsonFactory();
//        JsonGenerator jg = factory.createGenerator(System.out);
//        jg.writeObject(ts);
    }
}
