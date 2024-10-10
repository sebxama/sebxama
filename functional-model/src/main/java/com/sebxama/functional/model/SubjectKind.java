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
import com.sebxama.functional.model.objectmapper.deserializer.SubjectKindDeserializer;
import com.sebxama.functional.model.objectmapper.serializer.SubjectKindSerializer;

@JsonDeserialize(using = SubjectKindDeserializer.class)
@JsonSerialize(using = SubjectKindSerializer.class)
public class SubjectKind extends Kind {

	public SubjectKind() {
		
	}

	public SubjectKind(Kind src) {
		super(src);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Set<Predicate> getAttributes() {
		Set<Predicate> ret = new HashSet<Predicate>();
		for(Subject subj : super.getSubjectOccurrences()) {
			ret.add(subj.getStatement().getPredicate());
		}
		return ret;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Map<Predicate, Set<Value>> getAttributeValues() {
		Map<Predicate, Set<Value>> ret = new HashMap<Predicate, Set<Value>>();
		Set<Predicate> attrs = getAttributes();
		for(Predicate pred : attrs) {
			Set<Value> vals = new HashSet<Value>();
			for(Predicate occur : pred.getURI().getPredicateOccurrences()) {
				vals.add(occur.getStatement().getValue());
			}
			ret.put(pred, vals);
		}
		return ret;
	}

}
