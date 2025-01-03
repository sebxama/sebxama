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

package com.sebxama.functional.function;

import java.util.function.Function;

import com.sebxama.functional.model.URI;

public abstract class ModelFunction implements Function<URI, URI>{

	private URI strategy;
	
	protected ModelFunction(URI strategy) {
		this.strategy = strategy;
	}
	
	@Override
	public URI apply(URI t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
