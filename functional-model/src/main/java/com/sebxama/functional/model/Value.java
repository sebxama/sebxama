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

package com.sebxama.functional.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sebxama.functional.model.objectmapper.deserializer.ValueDeserializer;
import com.sebxama.functional.model.objectmapper.serializer.ValueSerializer;

@JsonDeserialize(using = ValueDeserializer.class)
@JsonSerialize(using = ValueSerializer.class)
public class Value implements URIOccurrence {

	private URI occurrenceURI;
	private URI uri;
	private Statement statement;
	private ValueKind kind;
	
	public Value() {

	}
	
	public URI getOccurrenceURI() {
		return this.occurrenceURI;
	}
	
	public void setOccurrenceURI(URI uri) {
		this.occurrenceURI = uri;
	}
	
	public URI getURI() {
		return this.uri;
	}
	
	public void setURI(URI uri) {
		uri.getObjectOccurrences().add(this);
		this.uri = uri;
	}
	
	public Statement getStatement() {
		return this.statement;
	}
	
	public void setStatement(Statement stat) {
		this.statement = stat;
	}

	public ValueKind getKind() {
		return this.kind;
	}
	
	public void setKind(ValueKind kind) {
		kind.getObjectOccurrences().add(this);
		kind.getURI().getObjectOccurrences().add(this);
		this.kind = kind;
	}
	
	public String toString() {
		return "Value; URI: " + this.uri; 
	}
	
}
