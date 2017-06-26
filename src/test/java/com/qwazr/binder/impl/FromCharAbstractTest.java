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
import com.qwazr.binder.RandomUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public abstract class FromCharAbstractTest<T> extends ObjectSetterAbstractTest<T> {

	protected FromCharAbstractTest(ObjectSetterAbstract setter) {
		super(setter);
	}

	@Test
	final public void testCharPrimitive() {
		final char v = RandomUtils.nextChar();
		setter.fromChar(v, this);
		Assert.assertEquals(Character.toString(v), value);
	}

	@Test
	final public void testCharPrimitiveArray() {
		final char[] v = new char[] { RandomUtils.nextChar() };
		setter.fromChar(v, this);
		Assert.assertEquals(Character.toString(v[0]), value);
	}

	@Test
	final public void testCharPrimitiveArrayEmpty() {
		final char[] v = new char[] {};
		setter.fromChar(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testCharPrimitiveArrayOverflow() {
		final char[] v = new char[] { RandomUtils.nextChar(), RandomUtils.nextChar() };
		setter.fromChar(v, this);
	}

	@Test
	final public void testChar() {
		final Character v = RandomUtils.nextChar();
		setter.fromChar(v, this);
		Assert.assertEquals(v.toString(), value);
	}

	@Test
	final public void testCharArray() {
		final Character[] v = new Character[] { RandomUtils.nextChar() };
		setter.fromChar(v, this);
		Assert.assertEquals(Character.toString(v[0]), value);
	}

	@Test
	final public void testCharArrayEmpty() {
		final Character[] v = new Character[] {};
		setter.fromChar(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testCharArrayOverflow() {
		final Character[] v = new Character[] { RandomUtils.nextChar(), RandomUtils.nextChar() };
		setter.fromChar(v, this);
	}

	@Test
	final public void testCharCollection() {
		final Collection<Character> v = Arrays.asList(RandomUtils.nextChar());
		setter.fromChar(v, this);
		Assert.assertEquals(Character.toString(v.iterator().next()), value);
	}

	@Test
	final public void testCharCollectionEmpty() {
		final Collection<Character> v = Arrays.asList();
		setter.fromChar(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testCharCollectionOverflow() {
		final Collection<Character> v = Arrays.asList(RandomUtils.nextChar(), RandomUtils.nextChar());
		setter.fromChar(v, this);
	}

	@Test
	public void testCharList() {
		final List<Character> v = Arrays.asList(RandomUtils.nextChar());
		setter.fromChar(v, this);
		Assert.assertEquals(Character.toString(v.iterator().next()), value);
	}

	@Test
	final public void testCharListEmpty() {
		final List<Character> v = Arrays.asList();
		setter.fromChar(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testCharListOverflow() {
		final List<Character> v = Arrays.asList(RandomUtils.nextChar(), RandomUtils.nextChar());
		setter.fromChar(v, this);
	}

}
