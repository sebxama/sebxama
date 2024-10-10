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
import com.sebxama.functional.model.ContextKind;
import com.sebxama.functional.model.URI;
import com.sebxama.functional.service.RegistryService;

public class ContextKindDeserializer extends StdDeserializer<ContextKind> { 

    public ContextKindDeserializer() { 
        this(null); 
    } 

    public ContextKindDeserializer(Class<?> vc) { 
        super(vc); 
    }

    @Override
    public ContextKind deserialize(JsonParser jp, DeserializationContext ctxt)
    	throws IOException, JsonProcessingException {
        
    	RegistryService registry = RegistryService.getInstance();
    	JsonNode node = jp.getCodec().readTree(jp);
        String srcStr = node.get("source").asText();
        
        ContextKind src = registry.getContextKind(srcStr);

        JsonParser parser = node.findValue("uri").traverse();
        parser.setCodec(jp.getCodec());
        URI uri = parser.readValueAs(URI.class);
        
        ContextKind kind = registry.getContextKind(uri);
        kind.setSource(src);
        
        parser = node.findValue("contextOccurrences").traverse();
        parser.setCodec(jp.getCodec());
        String[] arr = parser.readValueAs(String[].class);
        for(String c : arr)
        	kind.getContextOccurrences().add(registry.getContext(c));
        
        parser = node.findValue("subjectOccurrences").traverse();
        parser.setCodec(jp.getCodec());
        arr = parser.readValueAs(String[].class);
        for(String c : arr)
        	kind.getSubjectOccurrences().add(registry.getSubject(c));

        parser = node.findValue("predicateOccurrences").traverse();
        parser.setCodec(jp.getCodec());
        arr = parser.readValueAs(String[].class);
        for(String c : arr)
        	kind.getPredicateOccurrences().add(registry.getPredicate(c));

        parser = node.findValue("objectOccurrences").traverse();
        parser.setCodec(jp.getCodec());
        arr = parser.readValueAs(String[].class);
        for(String c : arr)
        	kind.getObjectOccurrences().add(registry.getValue(c));
        
        return kind;
    }
}
