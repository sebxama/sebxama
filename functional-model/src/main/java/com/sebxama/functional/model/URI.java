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

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sebxama.functional.model.objectmapper.deserializer.URIDeserializer;
import com.sebxama.functional.model.objectmapper.serializer.URISerializer;

@JsonDeserialize(using = URIDeserializer.class)
@JsonSerialize(using = URISerializer.class)
public class URI {
	
	private String value;
	private Long primeID;
	private Set<Context> contextOccurrences;
	private Set<Subject> subjectOccurrences;
	private Set<Predicate> predicateOccurrences;
	private Set<Value> objectOccurrences;
	private Set<Property> properties;
	
	public URI() {
		this.contextOccurrences = new HashSet<Context>();
		this.subjectOccurrences = new HashSet<Subject>();
		this.predicateOccurrences = new HashSet<Predicate>();
		this.objectOccurrences = new HashSet<Value>();
		this.properties = new HashSet<Property>();
	}
	
	public URI(String value) {
		this();
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public Long getPrimeID() {
		return this.primeID;
	}

	public void setPrimeID(Long id) {
		this.primeID = id;
	}
	
	public Set<Context> getContextOccurrences() {
		return this.contextOccurrences;
	}
	
	public void setContextOccurrences(Set<Context> occs) {
		this.contextOccurrences = occs;
	}

	public Set<Subject> getSubjectOccurrences() {
		return this.subjectOccurrences;
	}

	public void setSubjectOccurrences(Set<Subject> occs) {
		this.subjectOccurrences = occs;
	}
	
	public Set<Predicate> getPredicateOccurrences() {
		return this.predicateOccurrences;
	}

	public void setPredicateOccurrences(Set<Predicate> occs) {
		this.predicateOccurrences = occs;
	}
	
	public Set<Value> getObjectOccurrences() {
		return this.objectOccurrences;
	}
	
	public void setObjectOccurrences(Set<Value> occs) {
		this.objectOccurrences = occs;
	}

	public Set<Property> getProperties() {
		return this.properties;
	}
	
	public Set<ContextKind> getContextKindOccurrences() {
		Set<ContextKind> ret = new HashSet<ContextKind>();
		for(Context ctx : this.contextOccurrences)
			ret.add(ctx.getKind());
		return ret;
	}

	public Set<SubjectKind> getSubjectKindOccurrences() {
		Set<SubjectKind> ret = new HashSet<SubjectKind>();
		for(Subject ctx : this.subjectOccurrences)
			ret.add(ctx.getKind());
		return ret;
	}

	public Set<PredicateKind> getPredicateKindOccurrences() {
		Set<PredicateKind> ret = new HashSet<PredicateKind>();
		for(Predicate ctx : this.predicateOccurrences)
			ret.add(ctx.getKind());
		return ret;
	}

	public Set<ValueKind> getValueKindOccurrences() {
		Set<ValueKind> ret = new HashSet<ValueKind>();
		for(Value ctx : this.objectOccurrences)
			ret.add(ctx.getKind());
		return ret;
	}
	
	public Set<Statement> getStatementOccurrences() {
		Set<Statement> ret = new HashSet<Statement>();
		for(Context ctx : this.contextOccurrences)
			ret.add(ctx.getStatement());
		for(Subject subj : this.subjectOccurrences)
			ret.add(subj.getStatement());
		for(Predicate pred : this.predicateOccurrences)
			ret.add(pred.getStatement());
		for(Value val : this.objectOccurrences)
			ret.add(val.getStatement());
		return ret;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
	@Override
	public int hashCode() {
		return this.value.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof URI)
			if(obj.hashCode() == this.hashCode())
				return true;
		return false;
	}
	
}
