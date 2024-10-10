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
import com.sebxama.functional.model.Property;
import com.sebxama.functional.model.Statement;
import com.sebxama.functional.model.URI;
import com.sebxama.functional.service.RegistryService;

public class PropertyDeserializer extends StdDeserializer<Property> { 

    public PropertyDeserializer() { 
        this(null); 
    } 

    public PropertyDeserializer(Class<?> vc) { 
        super(vc); 
    }

    @Override
    public Property deserialize(JsonParser jp, DeserializationContext ctxt)
    	throws IOException, JsonProcessingException {
        
    	RegistryService registry = RegistryService.getInstance();
    	JsonNode node = jp.getCodec().readTree(jp);
        String occurrence = node.get("uri").asText();
        String attribute = node.get("attribute").asText();
        String value = node.get("value").asText();
        URI occurUri = registry.getURI(occurrence);
        URI attrUri = registry.getURI(attribute);
        URI valUri = registry.getURI(value);
        
        Property prop = new Property();
        prop.setURI(occurUri);
        prop.setAttribute(attrUri);
        prop.setValue(valUri);

        return prop;
    }
}
