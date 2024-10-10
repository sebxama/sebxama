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

package com.sebxama.activation.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.sebxama.activation.model.Entity;

import reactor.core.publisher.Flux;

@Repository
public interface ServiceRepository extends R2dbcRepository<Entity, Integer> {

	Flux<Entity> findByNombreContaining(String nombre);

}
