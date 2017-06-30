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

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

public interface FieldSetter
		extends CollectionSetter, ListSetter, ObjectArraySetter, ObjectSetter, PrimitiveArraySetter, PrimitiveSetter {

	void fromNull(Object object);

	Object get(Object object);

	default void setValue(Object object, Object value) {
		if (value == null) {
			fromNull(object);
			return;
		}
		final Class<?> valueClass = value.getClass();
		if (valueClass == Collection.class) {
			final Class<?> genericClass =
					(Class<?>) ((ParameterizedType) valueClass.getGenericSuperclass()).getActualTypeArguments()[0];
			fromCollection(genericClass, (Collection<?>) value, object);
			return;
		} else if (valueClass.isArray()) {
			final Class<?> componentType = valueClass.getComponentType();
			if (componentType.isPrimitive())
				fromPrimitiveArray(componentType, value, object);
			else
				fromObjectArray(componentType, value, object);
			return;
		} else {
			if (valueClass.isPrimitive())
				fromPrimitive(valueClass, value, object);
			else
				fromObject(valueClass, value, object);
		}
		throw error("Unsupported type: " + valueClass, value);
	}
}
