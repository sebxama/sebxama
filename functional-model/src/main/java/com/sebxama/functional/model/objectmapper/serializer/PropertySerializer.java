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
import com.sebxama.functional.model.Property;

public class PropertySerializer extends StdSerializer<Property> {
    
    public PropertySerializer() {
        this(null);
    }
  
    public PropertySerializer(Class<Property> t) {
        super(t);
    }

    @Override
    public void serialize(Property value, JsonGenerator jgen, SerializerProvider provider)
    	throws IOException, JsonProcessingException {
    	
		jgen.writeStartObject();
		jgen.writeStringField("uri", value.getURI().getValue());
		jgen.writeStringField("attribute", value.getAttribute().getValue());
		jgen.writeStringField("value", value.getValue().getValue());
		jgen.writeEndObject();
    }

}
