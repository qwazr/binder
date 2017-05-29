/**
 * Copyright 2017 Emmanuel Keller / QWAZR
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
package com.qwazr.binder.impl;

import com.qwazr.binder.BinderException;
import com.qwazr.binder.setter.FieldSetter;

import java.lang.reflect.Field;

abstract class FieldSetterAbstract implements FieldSetter {

	final Field field;

	FieldSetterAbstract(final Field field) {
		this.field = field;
		field.setAccessible(true);
	}

	final void set(final Object object, final Object value) {
		try {
			field.set(object, value);
		} catch (IllegalAccessException e) {
			throw new BinderException(field, value, e);
		}
	}

	final void error(final Object value) {
		throw new BinderException(field, value);
	}
}