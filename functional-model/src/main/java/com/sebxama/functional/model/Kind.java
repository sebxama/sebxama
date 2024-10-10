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
import java.util.Map;
import java.util.Set;

public abstract class Kind {
	
	private Kind source;
	private URI uri;
	private Set<Context> contextOccurrences;
	private Set<Subject> subjectOccurrences;
	private Set<Predicate> predicateOccurrences;
	private Set<Value> objectOccurrences;
	
	public Kind() {
		this.source = this;
		this.contextOccurrences = new HashSet<Context>();
		this.subjectOccurrences = new HashSet<Subject>();
		this.predicateOccurrences = new HashSet<Predicate>();
		this.objectOccurrences = new HashSet<Value>();
	}
	
	public Kind(Kind src) {
		this();
		this.source = src;
	}

	public Kind getSource() {
		return this.source;
	}
	
	public void setSource(Kind src) {
		this.source = src;
	}
	
	public URI getURI() {
		return this.source.uri;
	}
	
	public void setURI(URI uri) {
		this.source.uri = uri;
	}
	
	public Set<Context> getContextOccurrences() {
		return this.source.contextOccurrences;
	}

	public void setContextOccurrences(Set<Context> occs) {
		this.source.contextOccurrences = occs;
	}
	
	public Set<Subject> getSubjectOccurrences() {
		return this.source.subjectOccurrences;
	}
	
	public void setSubjectOccurrences(Set<Subject> occs) {
		this.source.subjectOccurrences = occs;
	}
	
	public Set<Predicate> getPredicateOccurrences() {
		return this.source.predicateOccurrences;
	}
	
	public void setPredicateOccurrences(Set<Predicate> occs) {
		this.source.predicateOccurrences = occs;
	}
	
	public Set<Value> getObjectOccurrences() {
		return this.source.objectOccurrences;
	}
	
	public void setObjectOccurrences(Set<Value> occs) {
		this.source.objectOccurrences = occs;
	}
	
	public Set<Statement> getStatementOccurrences() {
		Set<Statement> ret = new HashSet<Statement>();
		for(Context ctx : this.source.contextOccurrences)
			ret.add(ctx.getStatement());
		for(Subject subj : this.source.subjectOccurrences)
			ret.add(subj.getStatement());
		for(Predicate pred : this.source.predicateOccurrences)
			ret.add(pred.getStatement());
		for(Value val : this.source.objectOccurrences)
			ret.add(val.getStatement());
		return ret;
	}
	
	public abstract <A> Set<A> getAttributes();
	
	public abstract <A, V> Map<A, Set<V>> getAttributeValues();

}
