/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.loonxi.channel.LinkedIn.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

/**
 * Base class for all LinkedIn types.
 * Offers an extraData property for carrying any data in response from LinkedIn that won't be otherwise mapped to any properties of the subclass.
 * @author Craig Walls
 */
public abstract class LinkedInObject {

	private Map<String, Object> extraData;

	public LinkedInObject() {
		this.extraData = new HashMap<String, Object>();
	}
	
	/**
	 * @return Any fields in response from LinkedIn that are otherwise not mapped to any properties.
	 */
	public Map<String, Object> getExtraData() {
		return extraData;
	}
	
	/**
	 * {@link JsonAnySetter} hook. Called when an otherwise unmapped property is being processed during JSON deserialization.
	 * @param key The property's key.
	 * @param value The property's value.
	 */
	protected void add(String key, Object value) {
		extraData.put(key, value);
	}

}
