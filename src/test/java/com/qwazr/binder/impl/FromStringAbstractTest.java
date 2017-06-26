/*
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
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public abstract class FromStringAbstractTest<T> extends ObjectSetterAbstractTest<T> {

	private final Supplier<String> nextString;

	protected FromStringAbstractTest(Supplier<String> nextString, ObjectSetterAbstract setter) {
		super(setter);
		this.nextString = nextString;
	}

	final protected String nextString() {
		return nextString.get();
	}

	protected abstract void checkValue(String next, T value);

	@Test
	final public void testString() {
		final String v = nextString();
		setter.fromString(v, this);
		checkValue(v, value);
	}

	@Test
	final public void testStringArray() {
		final String[] v = new String[] { nextString() };
		setter.fromString(v, this);
		checkValue(v[0], value);
	}

	@Test
	final public void testStringArrayEmpty() {
		final String[] v = new String[] {};
		setter.fromString(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testStringArrayOverflow() {
		final String[] v = new String[] { nextString(), nextString() };
		setter.fromString(v, this);
	}

	@Test
	final public void testStringCollection() {
		final Collection<String> v = Arrays.asList(nextString());
		setter.fromString(v, this);
		checkValue(v.iterator().next(), value);
	}

	@Test
	final public void testStringCollectionEmpty() {
		final Collection<String> v = Arrays.asList();
		setter.fromString(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testStringCollectionOverflow() {
		final Collection<String> v = Arrays.asList(nextString(), nextString());
		setter.fromString(v, this);
	}

	@Test
	final public void testStringList() {
		final List<String> v = Arrays.asList(nextString());
		setter.fromString(v, this);
		checkValue(v.get(0), value);
	}

	@Test
	final public void testStringListEmpty() {
		final List<String> v = Arrays.asList();
		setter.fromString(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testStringListOverflow() {
		final List<String> v = Arrays.asList(nextString(), nextString());
		setter.fromString(v, this);
	}
}
