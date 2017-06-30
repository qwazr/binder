/*
 * Copyright 2016-2017 Emmanuel Keller / QWAZR
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qwazr.binder.setter;

import java.util.Collection;

public interface CollectionSetter extends ErrorSetter {

	void fromString(Collection<String> values, Object object);

	void fromDouble(Collection<Double> values, Object object);

	void fromFloat(Collection<Float> values, Object object);

	void fromLong(Collection<Long> values, Object object);

	void fromInteger(Collection<Integer> values, Object object);

	void fromShort(Collection<Short> values, Object object);

	void fromChar(Collection<Character> values, Object object);

	void fromByte(Collection<Byte> values, Object object);

	void fromBoolean(Collection<Boolean> values, Object object);

	default void fromCollection(Class<?> type, Collection<?> values, Object object) {
		if (type == String.class) {
			fromString((Collection<String>) values, object);
		} else if (type == Double.class) {
			fromDouble((Collection<Double>) values, object);
		} else if (type == Float.class) {
			fromFloat((Collection<Float>) values, object);
		} else if (type == Long.class) {
			fromLong((Collection<Long>) values, object);
		} else if (type == Integer.class) {
			fromInteger((Collection<Integer>) values, object);
		} else if (type == Short.class) {
			fromShort((Collection<Short>) values, object);
		} else if (type == Character.class) {
			fromChar((Collection<Character>) values, object);
		} else if (type == Byte.class) {
			fromByte((Collection<Byte>) values, object);
		} else if (type == Boolean.class) {
			fromBoolean((Collection<Boolean>) values, object);
		} else
			throw error("Unsupported generic type for collection: " + type, values);
	}
}
