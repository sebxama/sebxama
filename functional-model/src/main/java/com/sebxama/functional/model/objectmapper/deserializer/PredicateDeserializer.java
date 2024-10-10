/*
* Copyright 2024 Sebastian Samaruga
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.sebxama.functional.model.objectmapper.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.sebxama.functional.model.Context;
import com.sebxama.functional.model.ContextKind;
import com.sebxama.functional.model.Predicate;
import com.sebxama.functional.model.PredicateKind;
import com.sebxama.functional.model.Property;
import com.sebxama.functional.model.Statement;
import com.sebxama.functional.model.Subject;
import com.sebxama.functional.model.URI;
import com.sebxama.functional.service.RegistryService;

public class PredicateDeserializer extends StdDeserializer<Predicate> { 

    public PredicateDeserializer() { 
        this(null); 
    } 

    public PredicateDeserializer(Class<?> vc) { 
        super(vc); 
    }

    @Override
    public Predicate deserialize(JsonParser jp, DeserializationContext ctxt)
    	throws IOException, JsonProcessingException {
        
    	RegistryService registry = RegistryService.getInstance();
    	JsonNode node = jp.getCodec().readTree(jp);
        String statementUri = node.get("statement").asText();
        URI stmtUri = registry.getURI(statementUri);

        JsonParser parser = node.findValue("occurrenceUri").traverse();
        parser.setCodec(jp.getCodec());
        URI occUri = parser.readValueAs(URI.class);
        
        parser = node.findValue("uri").traverse();
        parser.setCodec(jp.getCodec());
        URI uri = parser.readValueAs(URI.class);

        parser = node.findValue("kind").traverse();
        parser.setCodec(jp.getCodec());
        PredicateKind kind = parser.readValueAs(PredicateKind.class);
        
        Predicate ctx = registry.getPredicate(uri);
        ctx.setOccurrenceURI(occUri);
        Statement stat = registry.getStatement(stmtUri);
        stat.setPredicate(ctx);
        ctx.setStatement(stat);
        ctx.setURI(uri);
        ctx.setKind(kind);
        
        return ctx;
    }
}
