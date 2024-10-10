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
import com.sebxama.functional.model.objectmapper.deserializer.StatementDeserializer;
import com.sebxama.functional.model.objectmapper.serializer.StatementSerializer;

@JsonDeserialize(using = StatementDeserializer.class)
@JsonSerialize(using = StatementSerializer.class)
public class Statement {

	private URI uri;
	private Context context;
	private Subject subject;
	private Predicate predicate;
	private Value value;
	
	public Statement() {
		
	}

	public URI getURI() {
		return this.uri;
	}
	
	public void setURI(URI uri) {
		this.uri = uri;
	}
	
	public Context getContext() {
		return context;
	}

	public void setContext(Context ctx) {
		this.context = ctx;
	}
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subj) {
		this.subject = subj;
	}
	
	public Predicate getPredicate() {
		return predicate;
	}

	public void setPredicate(Predicate pred) {
		this.predicate = pred;
	}
	
	public Value getValue() {
		return value;
	}
	
	public void setValue(Value val) {
		this.value = val;
	}
	
	public String toString() {
		return  "Statement; URI: " + this.uri + ", Context: " + this.context +
				", Subject: " + this.subject + ", Predicate: " + this.predicate +
				", Value: " + this.value;
	}
	
}
