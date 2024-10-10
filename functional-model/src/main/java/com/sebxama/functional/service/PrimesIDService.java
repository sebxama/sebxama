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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimesIDService {

	private static Map<String, Long> uriIDs;
	private static Map<Long, String> idsURIs;
	
	private static PrimesIDService instance;
	public static PrimesIDService getInstance() {
		if(instance == null)
			instance = new PrimesIDService();
		return instance;
	}
	
	private Long current;
	
	protected PrimesIDService() {
		uriIDs = new HashMap<String, Long>();
		idsURIs = new HashMap<Long, String>();
		current = 2l;
	}
	
	public Long nextPrime() {
		BigInteger valbi = BigInteger.valueOf(this.current);
		this.current = valbi.nextProbablePrime().longValue();
		return this.current;
	}
	
	public List<Long> primeFactors(Long product) {
		long n = product;
		List<Long> factors = new ArrayList<Long>();
		for(long i = 2; i <= n / i; i++) {
			while(n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		if(n > 1) {
			factors.add(n);
		}
		return factors;
	}

	public Long getURIPrimeID(String uri) {
		Long ret = uriIDs.get(uri);
		if(ret == null) {
			ret = nextPrime();
			uriIDs.put(uri, ret);
			idsURIs.put(ret, uri);
		}
		return ret;
	}
	
	public String getPrimeIDURI(Long id) {
		return this.idsURIs.get(id);
	}
	
	public static void main(String... args) {
		System.out.println(PrimesIDService.getInstance().primeFactors(21l));
	}
	
}
