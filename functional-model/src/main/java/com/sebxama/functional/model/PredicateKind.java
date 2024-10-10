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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sebxama.functional.model.objectmapper.deserializer.PredicateKindDeserializer;
import com.sebxama.functional.model.objectmapper.serializer.PredicateKindSerializer;

@JsonDeserialize(using = PredicateKindDeserializer.class)
@JsonSerialize(using = PredicateKindSerializer.class)
public class PredicateKind extends Kind {

	public PredicateKind() {
		
	}
	
	public PredicateKind(Kind src) {
		super(src);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Set<Subject> getAttributes() {
		Set<Subject> ret = new HashSet<Subject>();
		for(Predicate pred : super.getPredicateOccurrences()) {
			ret.add(pred.getStatement().getSubject());
		}
		return ret;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Map<Subject, Set<Value>> getAttributeValues() {
		Map<Subject, Set<Value>> ret = new HashMap<Subject, Set<Value>>();
		Set<Subject> subjs = getAttributes();
		for(Subject subj : subjs) {
			Set<Value> vals = new HashSet<Value>();
			for(Subject occur : subj.getURI().getSubjectOccurrences()) {
				vals.add(occur.getStatement().getValue());
			}
			ret.put(subj, vals);
		}
		return ret;
	}
	
}
