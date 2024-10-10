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
import com.sebxama.functional.model.Predicate;
import com.sebxama.functional.model.Statement;
import com.sebxama.functional.model.Subject;
import com.sebxama.functional.model.URI;
import com.sebxama.functional.model.Value;
import com.sebxama.functional.service.RegistryService;

public class StatementDeserializer extends StdDeserializer<Statement> { 

    public StatementDeserializer() { 
        this(null); 
    } 

    public StatementDeserializer(Class<?> vc) { 
        super(vc); 
    }

    @Override
    public Statement deserialize(JsonParser jp, DeserializationContext ctxt)
    	throws IOException, JsonProcessingException {
    	
    	RegistryService registry = RegistryService.getInstance();
        JsonNode node = jp.getCodec().readTree(jp);
        
        JsonParser parser = node.findValue("uri").traverse();
        parser.setCodec(jp.getCodec());
        URI uri = parser.readValueAs(URI.class);

        Statement ret = registry.getStatement(uri);
        if(ret == null)
        	ret = new Statement();
        ret.setURI(uri);
        registry.putStatement(ret);
        
        parser = node.findValue("context").traverse();
        parser.setCodec(jp.getCodec());
        Context ctx = parser.readValueAs(Context.class);

        parser = node.findValue("subject").traverse();
        parser.setCodec(jp.getCodec());
        Subject subj = parser.readValueAs(Subject.class);

        parser = node.findValue("predicate").traverse();
        parser.setCodec(jp.getCodec());
        Predicate pred = parser.readValueAs(Predicate.class);

        parser = node.findValue("value").traverse();
        parser.setCodec(jp.getCodec());
        Value val = parser.readValueAs(Value.class);
        
        ret.setContext(ctx);
        ret.setSubject(subj);
        ret.setPredicate(pred);
        ret.setValue(val);
        
        return ret;
        
//        int id = (Integer) ((IntNode) node.get("id")).numberValue();
//        String itemName = node.get("itemName").asText();
//        int userId = (Integer) ((IntNode) node.get("createdBy")).numberValue();

    }
}
