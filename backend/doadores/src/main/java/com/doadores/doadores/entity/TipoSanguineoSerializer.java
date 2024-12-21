package com.doadores.doadores.entity;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class TipoSanguineoSerializer extends JsonSerializer<TipoSanguineo> {

    @Override
    public void serialize(TipoSanguineo tipoSanguineo, JsonGenerator jsonGenerator,
        SerializerProvider serializers) throws IOException {
        jsonGenerator.writeString(tipoSanguineo.getDescricao());
    }
}
