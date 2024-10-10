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
import com.sebxama.functional.model.objectmapper.deserializer.ContextDeserializer;
import com.sebxama.functional.model.objectmapper.serializer.ContextSerializer;

@JsonDeserialize(using = ContextDeserializer.class)
@JsonSerialize(using = ContextSerializer.class)
public class Context implements URIOccurrence {

	private URI occurrenceURI;
	private URI uri;
	private Statement statement;
	private ContextKind kind;
	
	public Context() {

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
		uri.getContextOccurrences().add(this);
		this.uri = uri;
	}
	
	public Statement getStatement() {
		return this.statement;
	}
	
	public void setStatement(Statement stat) {
		this.statement = stat;
	}

	public ContextKind getKind() {
		return this.kind;
	}
	
	public void setKind(ContextKind kind) {
		kind.getContextOccurrences().add(this);
		kind.getURI().getContextOccurrences().add(this);
		this.kind = kind;
	}
	
	public String toString() {
		return "Context; URI: " + this.uri; 
	}
	
}
