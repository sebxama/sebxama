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

package com.sebxama.augmentation.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sebxama.functional.model.Context;
import com.sebxama.functional.model.ContextKind;
import com.sebxama.functional.model.Predicate;
import com.sebxama.functional.model.PredicateKind;
import com.sebxama.functional.model.Property;
import com.sebxama.functional.model.Statement;
import com.sebxama.functional.model.Subject;
import com.sebxama.functional.model.SubjectKind;
import com.sebxama.functional.model.URI;
import com.sebxama.functional.model.Value;
import com.sebxama.functional.model.ValueKind;
import com.sebxama.functional.model.objectmapper.deserializer.ContextDeserializer;
import com.sebxama.functional.model.objectmapper.deserializer.ContextKindDeserializer;
import com.sebxama.functional.model.objectmapper.deserializer.PredicateDeserializer;
import com.sebxama.functional.model.objectmapper.deserializer.PredicateKindDeserializer;
import com.sebxama.functional.model.objectmapper.deserializer.PropertyDeserializer;
import com.sebxama.functional.model.objectmapper.deserializer.StatementDeserializer;
import com.sebxama.functional.model.objectmapper.deserializer.SubjectDeserializer;
import com.sebxama.functional.model.objectmapper.deserializer.SubjectKindDeserializer;
import com.sebxama.functional.model.objectmapper.deserializer.URIDeserializer;
import com.sebxama.functional.model.objectmapper.deserializer.ValueDeserializer;
import com.sebxama.functional.model.objectmapper.deserializer.ValueKindDeserializer;
import com.sebxama.functional.model.objectmapper.serializer.ContextKindSerializer;
import com.sebxama.functional.model.objectmapper.serializer.ContextSerializer;
import com.sebxama.functional.model.objectmapper.serializer.PredicateKindSerializer;
import com.sebxama.functional.model.objectmapper.serializer.PredicateSerializer;
import com.sebxama.functional.model.objectmapper.serializer.PropertySerializer;
import com.sebxama.functional.model.objectmapper.serializer.StatementSerializer;
import com.sebxama.functional.model.objectmapper.serializer.SubjectKindSerializer;
import com.sebxama.functional.model.objectmapper.serializer.SubjectSerializer;
import com.sebxama.functional.model.objectmapper.serializer.URISerializer;
import com.sebxama.functional.model.objectmapper.serializer.ValueKindSerializer;
import com.sebxama.functional.model.objectmapper.serializer.ValueSerializer;

@Configuration
public class JacksonConfig {

	@Bean
	public ObjectMapper objectMapper() {
	    return new ObjectMapper()
	      .registerModule(customSerialization());
	}
	
    public com.fasterxml.jackson.databind.Module customSerialization() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(Context.class, new ContextSerializer());
        module.addSerializer(ContextKind.class, new ContextKindSerializer());
        module.addSerializer(Subject.class, new SubjectSerializer());
        module.addSerializer(SubjectKind.class, new SubjectKindSerializer());
        module.addSerializer(Predicate.class, new PredicateSerializer());
        module.addSerializer(PredicateKind.class, new PredicateKindSerializer());
        module.addSerializer(Value.class, new ValueSerializer());
        module.addSerializer(ValueKind.class, new ValueKindSerializer());
        module.addSerializer(Statement.class, new StatementSerializer());
        module.addSerializer(URI.class, new URISerializer());
        module.addSerializer(Property.class, new PropertySerializer());
        module.addDeserializer(Context.class, new ContextDeserializer());
        module.addDeserializer(ContextKind.class, new ContextKindDeserializer());
        module.addDeserializer(Subject.class, new SubjectDeserializer());
        module.addDeserializer(SubjectKind.class, new SubjectKindDeserializer());
        module.addDeserializer(Predicate.class, new PredicateDeserializer());
        module.addDeserializer(PredicateKind.class, new PredicateKindDeserializer());
        module.addDeserializer(Value.class, new ValueDeserializer());
        module.addDeserializer(ValueKind.class, new ValueKindDeserializer());
        module.addDeserializer(Statement.class, new StatementDeserializer());
        module.addDeserializer(URI.class, new URIDeserializer());
        module.addDeserializer(Property.class, new PropertyDeserializer());
        return module;
    }

}
