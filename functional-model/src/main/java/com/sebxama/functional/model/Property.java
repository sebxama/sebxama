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
import com.sebxama.functional.model.objectmapper.deserializer.PropertyDeserializer;
import com.sebxama.functional.model.objectmapper.serializer.PropertySerializer;

@JsonDeserialize(using = PropertyDeserializer.class)
@JsonSerialize(using = PropertySerializer.class)
public class Property {

	private URI uri;
	private URI attribute;
	private URI value;
	
	public Property() {
		
	}

	public URI getURI() {
		return uri;
	}

	public void setURI(URI uri) {
		uri.getProperties().add(this);
		this.uri = uri;
	}

	public URI getAttribute() {
		return attribute;
	}

	public void setAttribute(URI attribute) {
		this.attribute = attribute;
	}

	public URI getValue() {
		return value;
	}

	public void setValue(URI value) {
		this.value = value;
	}
	
}
