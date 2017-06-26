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

public abstract class FromIntegerAbstractTest<T> extends ObjectSetterAbstractTest<T> {

	protected FromIntegerAbstractTest(ObjectSetterAbstract setter) {
		super(setter);
	}

	protected abstract void checkValue(Integer next, T value);

	@Test
	public void testIntegerPrimitive() {
		final int v = RandomUtils.nextInt();
		setter.fromInteger(v, this);
		checkValue(v, value);
	}

	@Test
	public void testIntegerPrimitiveArray() {
		final int[] v = new int[] { RandomUtils.nextInt() };
		setter.fromInteger(v, this);
		checkValue(v[0], value);
	}

	@Test
	public void testIntegerPrimitiveArrayEmpty() {
		final int[] v = new int[] {};
		setter.fromInteger(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testIntegerPrimitiveArrayOverflow() {
		final int[] v = new int[] { RandomUtils.nextInt(), RandomUtils.nextInt() };
		setter.fromInteger(v, this);
	}

	@Test
	public void testInteger() {
		final Integer v = RandomUtils.nextInt();
		setter.fromInteger(v, this);
		checkValue(v, value);
	}

	@Test
	public void testIntegerArray() {
		final Integer[] v = new Integer[] { RandomUtils.nextInt() };
		setter.fromInteger(v, this);
		checkValue(v[0], value);
	}

	@Test
	public void testIntegerArrayEmpty() {
		final Integer[] v = new Integer[] {};
		setter.fromInteger(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testIntegerArrayOverflow() {
		final Integer[] v = new Integer[] { RandomUtils.nextInt(), RandomUtils.nextInt() };
		setter.fromInteger(v, this);
	}

	@Test
	public void testIntegerCollection() {
		final Collection<Integer> v = Arrays.asList(RandomUtils.nextInt());
		setter.fromInteger(v, this);
		checkValue(v.iterator().next(), value);
	}

	@Test
	public void testIntegerCollectionEmpty() {
		final Collection<Integer> v = Arrays.asList();
		setter.fromInteger(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testIntegerCollectionOverflow() {
		final Collection<Integer> v = Arrays.asList(RandomUtils.nextInt(), RandomUtils.nextInt());
		setter.fromInteger(v, this);
	}

	@Test
	public void testIntegerList() {
		final List<Integer> v = Arrays.asList(RandomUtils.nextInt());
		setter.fromInteger(v, this);
		checkValue(v.iterator().next(), value);
	}

	@Test
	public void testIntegerListEmpty() {
		final List<Integer> v = Arrays.asList();
		setter.fromInteger(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testIntegerListOverflow() {
		final List<Integer> v = Arrays.asList(RandomUtils.nextInt(), RandomUtils.nextInt());
		setter.fromInteger(v, this);
	}

}
