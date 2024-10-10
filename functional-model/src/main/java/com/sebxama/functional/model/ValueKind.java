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
import com.sebxama.functional.model.objectmapper.deserializer.ValueKindDeserializer;
import com.sebxama.functional.model.objectmapper.serializer.ValueKindSerializer;

@JsonDeserialize(using = ValueKindDeserializer.class)
@JsonSerialize(using = ValueKindSerializer.class)
public class ValueKind extends Kind {

	public ValueKind() {
		
	}

	public ValueKind(Kind src) {
		super(src);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Set<Predicate> getAttributes() {
		Set<Predicate> ret = new HashSet<Predicate>();
		for(Value val : super.getObjectOccurrences()) {
			ret.add(val.getStatement().getPredicate());
		}
		return ret;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Map<Predicate, Set<Subject>> getAttributeValues() {
		Map<Predicate, Set<Subject>> ret = new HashMap<Predicate, Set<Subject>>();
		Set<Predicate> preds = getAttributes();
		for(Predicate pred : preds) {
			Set<Subject> vals = new HashSet<Subject>();
			for(Predicate occur : pred.getURI().getPredicateOccurrences()) {
				vals.add(occur.getStatement().getSubject());
			}
			ret.put(pred, vals);
		}
		return ret;
	}

}
