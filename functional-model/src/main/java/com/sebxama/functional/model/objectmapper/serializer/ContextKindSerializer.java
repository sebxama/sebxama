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

package com.sebxama.functional.model.objectmapper.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sebxama.functional.model.Context;
import com.sebxama.functional.model.ContextKind;
import com.sebxama.functional.model.Predicate;
import com.sebxama.functional.model.Subject;
import com.sebxama.functional.model.Value;

public class ContextKindSerializer extends StdSerializer<ContextKind> {
    
    public ContextKindSerializer() {
        this(null);
    }
  
    public ContextKindSerializer(Class<ContextKind> t) {
        super(t);
    }

    @Override
    public void serialize(ContextKind value, JsonGenerator jgen, SerializerProvider provider)
    	throws IOException, JsonProcessingException {
 
        jgen.writeStartObject();
        jgen.writeStringField("source", value.getSource().getURI().getValue());
        jgen.writeObjectField("uri", value.getURI());
        jgen.writeFieldName("contextOccurrences");
        jgen.writeStartArray();
        for(Context ctx : value.getContextOccurrences())
        	jgen.writeString(ctx.getOccurrenceURI().getValue());
        jgen.writeEndArray();
        jgen.writeFieldName("subjectOccurrences");
        jgen.writeStartArray();
        for(Subject ctx : value.getSubjectOccurrences())
        	jgen.writeString(ctx.getOccurrenceURI().getValue());
        jgen.writeEndArray();
        jgen.writeFieldName("predicateOccurrences");
        jgen.writeStartArray();
        for(Predicate ctx : value.getPredicateOccurrences())
        	jgen.writeString(ctx.getOccurrenceURI().getValue());
        jgen.writeEndArray();
        jgen.writeFieldName("objectOccurrences");
        jgen.writeStartArray();
        for(Value ctx : value.getObjectOccurrences())
        	jgen.writeString(ctx.getOccurrenceURI().getValue());
        jgen.writeEndArray();
        jgen.writeEndObject();
    }

}
