package com.coffang.springboot2_coffang.domain.item;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ItemDeserializer extends JsonDeserializer<Item> {

    @Override
    public Item deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
        ObjectCodec codec = p.getCodec();
        JsonNode node = codec.readTree(p);
        ObjectMapper mapper = (ObjectMapper) p.getCodec();

        if (node.has("region")) {
            return mapper.treeToValue(node, Coffee.class);
        } else if (node.has("toolType")) {
            return mapper.treeToValue(node, Brewing.class);
        } else if (node.has("brand")) {
            return mapper.treeToValue(node, Serveware.class);
        }
        throw new UnsupportedOperationException("Cannot deserialize to a known type");
    }
}