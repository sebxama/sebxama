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

package com.sebxama.functional.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sebxama.functional.model.Context;
import com.sebxama.functional.model.ContextKind;
import com.sebxama.functional.model.Kind;
import com.sebxama.functional.model.Predicate;
import com.sebxama.functional.model.PredicateKind;
import com.sebxama.functional.model.Statement;
import com.sebxama.functional.model.Subject;
import com.sebxama.functional.model.SubjectKind;
import com.sebxama.functional.model.URI;
import com.sebxama.functional.model.Value;
import com.sebxama.functional.model.ValueKind;
import com.sebxama.functional.model.dto.Quad;

public class RegistryService {

	private static RegistryService instance;
	public static RegistryService getInstance() {
		if(instance == null)
			instance = new RegistryService();
		return instance;
	}
	
	private Map<String, URI> URIs;
	private Map<URI, Statement> statements;
	private Map<URI, Context> contexts;
	private Map<URI, Subject> subjects;
	private Map<URI, Predicate> predicates;
	private Map<URI, Value> values;
	private Map<URI, ContextKind> contextKinds;
	private Map<URI, SubjectKind> subjectKinds;
	private Map<URI, PredicateKind> predicateKinds;
	private Map<URI, ValueKind> valueKinds;
	
	protected RegistryService() {
		this.URIs = new HashMap<String, URI>();
		this.statements = new HashMap<URI, Statement>();
		this.contexts = new HashMap<URI, Context>();
		this.subjects = new HashMap<URI, Subject>();
		this.predicates = new HashMap<URI, Predicate>();
		this.values = new HashMap<URI, Value>();
		this.contextKinds = new HashMap<URI, ContextKind>();
		this.subjectKinds = new HashMap<URI, SubjectKind>();
		this.predicateKinds = new HashMap<URI, PredicateKind>();
		this.valueKinds = new HashMap<URI, ValueKind>();
	}
	
	public URI getURI(String value) {
		URI ret = URIs.get(value);
		if(ret == null) {
			ret = new URI(value);
			ret.setPrimeID(PrimesIDService.getInstance().getURIPrimeID(value));
			URIs.put(value, ret);
		}
		return ret;
	}

	public Set<URI> getURIs() {
		Set<URI> ret = new HashSet<URI>(URIs.values());
		return ret;
	}
	
	public Statement getStatement(Quad input) {
		URI context = getURI(input.getContext());
		URI subject = getURI(input.getSubject());
		URI predicate = getURI(input.getPredicate());
		URI object = getURI(input.getObject());
		URI contextKind = getURI(input.getContext()+"#ContextKind");
		URI subjectKind = getURI(input.getSubject()+"#SubjectKind");
		URI predicateKind = getURI(input.getPredicate()+"#PredicateKind");
		URI objectKind = getURI(input.getObject()+"#ValueKind");
		URI id = getStatementURI(context, subject, predicate, object);
		Statement ret = getStatement(id);
		if(ret == null) {
			ret = new Statement();
			ret.setURI(id);
			
			ContextKind ctxKind = getContextKind(contextKind);
			Context ctx = getContext(context);
			URI occurrenceUri = getContextOccurrenceURI(id, context, contextKind);
			ctx.setOccurrenceURI(occurrenceUri);
			ctx.setURI(context);
			ctx.setStatement(ret);
			ctx.setKind(ctxKind);
			ret.setContext(ctx);

			SubjectKind subjKind = getSubjectKind(subjectKind);
			Subject subj = getSubject(subject);
			occurrenceUri = getSubjectOccurrenceURI(id, subject, subjectKind);
			subj.setOccurrenceURI(occurrenceUri);
			subj.setURI(subject);
			subj.setStatement(ret);
			subj.setKind(subjKind);
			ret.setSubject(subj);
			
			Predicate pred = getPredicate(predicate);
			PredicateKind predKind = getPredicateKind(predicateKind);
			occurrenceUri = getPredicateOccurrenceURI(id, predicate, predicateKind);
			pred.setOccurrenceURI(occurrenceUri);
			pred.setURI(predicate);
			pred.setStatement(ret);
			pred.setKind(predKind);
			ret.setPredicate(pred);
			
			Value val = getValue(object);
			ValueKind valKind = getValueKind(objectKind);
			occurrenceUri = getValueOccurrenceURI(id, object, objectKind);
			val.setOccurrenceURI(occurrenceUri);
			val.setURI(object);
			val.setStatement(ret);
			val.setKind(valKind);
			ret.setValue(val);
			
			statements.put(id, ret);
		}
		return ret;
	}

	public URI getStatementURI(URI context, URI subject, URI predicate, URI object) {
		return getURI("urn:statement:"+context.getPrimeID()+":"+subject.getPrimeID()+":"+predicate.getPrimeID()+":"+object.getPrimeID());
	}

	public URI getContextOccurrenceURI(URI stmt, URI uri, URI kind) {
		return getURI("urn:context:"+stmt.getPrimeID()+":"+uri.getPrimeID()+":"+kind.getPrimeID());
	}

	public URI getSubjectOccurrenceURI(URI stmt, URI uri, URI kind) {
		return getURI("urn:subject:"+stmt.getPrimeID()+":"+uri.getPrimeID()+":"+kind.getPrimeID());
	}

	public URI getPredicateOccurrenceURI(URI stmt, URI uri, URI kind) {
		return getURI("urn:predicate:"+stmt.getPrimeID()+":"+uri.getPrimeID()+":"+kind.getPrimeID());
	}

	public URI getValueOccurrenceURI(URI stmt, URI uri, URI kind) {
		return getURI("urn:value:"+stmt.getPrimeID()+":"+uri.getPrimeID()+":"+kind.getPrimeID());
	}
	
	public Statement getStatement(URI uri) {
		return this.statements.get(uri);
	}

	public void putStatement(Statement stat) {
		this.statements.put(stat.getURI(), stat);
	}
	
	public Set<Statement> getStatements() {
		Set<Statement> ret = new HashSet<Statement>(statements.values());
		return ret;
	}

	public Context getContext(URI uri) {
		Context ctx = this.contexts.get(uri);
		if(ctx == null) {
			ctx = new Context();
			ctx.setOccurrenceURI(uri);
			this.contexts.put(uri, ctx);
		}
		return ctx;
	}
	
	public Context getContext(String uriStr) {
		URI key = getURI(uriStr);
		return getContext(key);
	}
	
	public void putContext(Context ctx) {
		this.contexts.put(ctx.getURI(), ctx);
	}
	
	public Set<Context> getContexts() {
		Set<Context> ret = new HashSet<Context>(contexts.values());
		return ret;
	}

	public Subject getSubject(URI uri) {
		Subject ctx = this.subjects.get(uri);
		if(ctx == null) {
			ctx = new Subject();
			ctx.setOccurrenceURI(uri);
			this.subjects.put(uri, ctx);
		}
		return ctx;
	}

	public Subject getSubject(String uriStr) {
		URI key = getURI(uriStr);
		return getSubject(key);
	}
	
	public void putSubject(Subject subj) {
		this.subjects.put(subj.getURI(), subj);
	}
	
	public Set<Subject> getSubjects() {
		Set<Subject> ret = new HashSet<Subject>(subjects.values());
		return ret;
	}

	public Predicate getPredicate(URI uri) {
		Predicate ctx = this.predicates.get(uri);
		if(ctx == null) {
			ctx = new Predicate();
			ctx.setOccurrenceURI(uri);
			this.predicates.put(uri, ctx);
		}
		return ctx;
	}

	public Predicate getPredicate(String uriStr) {
		URI key = getURI(uriStr);
		return getPredicate(key);
	}
	
	public void putPredicate(Predicate pred) {
		this.predicates.put(pred.getURI(), pred);
	}
	
	public Set<Predicate> getPredicates() {
		Set<Predicate> ret = new HashSet<Predicate>(predicates.values());
		return ret;
	}

	public Value getValue(URI uri) {
		Value ctx = this.values.get(uri);
		if(ctx == null) {
			ctx = new Value();
			ctx.setOccurrenceURI(uri);
			this.values.put(uri, ctx);
		}
		return ctx;
	}

	public Value getValue(String uriStr) {
		URI key = getURI(uriStr);
		return getValue(key);
	}
	
	public void putValue(Value val) {
		this.values.put(val.getURI(), val);
	}
	
	public Set<Value> getValues() {
		Set<Value> ret = new HashSet<Value>(values.values());
		return ret;
	}

	public ContextKind getContextKind(String uristr) {
		URI uri = getURI(uristr);
		return getContextKind(uri);
	}
	
	public ContextKind getContextKind(URI uri) {
		ContextKind ctx = this.contextKinds.get(uri);
		if(ctx == null) {
			ctx = new ContextKind();
			ctx.setURI(uri);
			this.contextKinds.put(uri, ctx);
		}
		return ctx;
	}

	public void putContextKind(ContextKind kind) {
		this.contextKinds.put(kind.getURI(), kind);
	}
	
	public Set<ContextKind> getContextKinds() {
		Set<ContextKind> ret = new HashSet<ContextKind>(contextKinds.values());
		return ret;
	}

	public SubjectKind getSubjectKind(String uristr) {
		URI uri = getURI(uristr);
		return getSubjectKind(uri);
	}
	
	public SubjectKind getSubjectKind(URI uri) {
		SubjectKind ctx = this.subjectKinds.get(uri);
		if(ctx == null) {
			ctx = new SubjectKind();
			ctx.setURI(uri);
			this.subjectKinds.put(uri, ctx);
		}
		return ctx;
	}

	public void putSubjectKind(SubjectKind kind) {
		this.subjectKinds.put(kind.getURI(), kind);
	}
	
	public Set<SubjectKind> getSubjectKinds() {
		Set<SubjectKind> ret = new HashSet<SubjectKind>(subjectKinds.values());
		return ret;
	}

	public PredicateKind getPredicateKind(String uristr) {
		URI uri = getURI(uristr);
		return getPredicateKind(uri);
	}
	
	public PredicateKind getPredicateKind(URI uri) {
		PredicateKind ctx = this.predicateKinds.get(uri);
		if(ctx == null) {
			ctx = new PredicateKind();
			ctx.setURI(uri);
			this.predicateKinds.put(uri, ctx);
		}
		return ctx;
	}

	public void putPredicateKind(PredicateKind kind) {
		this.predicateKinds.put(kind.getURI(), kind);
	}
	
	public Set<PredicateKind> getPredicateKinds() {
		Set<PredicateKind> ret = new HashSet<PredicateKind>(predicateKinds.values());
		return ret;
	}

	public ValueKind getValueKind(String uristr) {
		URI uri = getURI(uristr);
		return getValueKind(uri);
	}
	
	public ValueKind getValueKind(URI uri) {
		ValueKind ctx = this.valueKinds.get(uri);
		if(ctx == null) {
			ctx = new ValueKind();
			ctx.setURI(uri);
			this.valueKinds.put(uri, ctx);
		}
		return ctx;
	}

	public void putValueKind(ValueKind kind) {
		this.valueKinds.put(kind.getURI(), kind);
	}
	
	public Set<ValueKind> getValueKinds() {
		Set<ValueKind> ret = new HashSet<ValueKind>(valueKinds.values());
		return ret;
	}
	
}
