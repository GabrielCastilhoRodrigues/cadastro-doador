package com.doadores.doadores.entity;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class TipoSanguineoDeserializer extends JsonDeserializer<TipoSanguineo> {
    
    @Override
    public TipoSanguineo deserialize(JsonParser jsonParser, DeserializationContext ctxt)
        throws IOException {
        String descricao = jsonParser.getText();
        System.out.println(descricao);
        return TipoSanguineo.fromDescricao(descricao);
    }
}
