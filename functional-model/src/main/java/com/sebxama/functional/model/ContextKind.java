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
import com.sebxama.functional.model.objectmapper.deserializer.ContextKindDeserializer;
import com.sebxama.functional.model.objectmapper.serializer.ContextKindSerializer;

@JsonDeserialize(using = ContextKindDeserializer.class)
@JsonSerialize(using = ContextKindSerializer.class)
public class ContextKind extends Kind {

	public ContextKind() {
		
	}
	
	public ContextKind(Kind src) {
		super(src);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Set<Subject> getAttributes() {
		Set<Subject> ret = new HashSet<Subject>();
		for(Context ctx : super.getContextOccurrences()) {
			ret.add(ctx.getStatement().getSubject());
		}
		return ret;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Map<Subject, Set<Predicate>> getAttributeValues() {
		Map<Subject, Set<Predicate>> ret = new HashMap<Subject, Set<Predicate>>();
		Set<Subject> attrs = getAttributes();
		for(Subject subj : attrs) {
			Set<Predicate> vals = new HashSet<Predicate>();
			for(Subject occur : subj.getURI().getSubjectOccurrences()) {
				vals.add(occur.getStatement().getPredicate());
			}
			ret.put(subj, vals);
		}
		return ret;
	}

}
