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

public abstract class FromLongAbstractTest<T> extends ObjectSetterAbstractTest<T> {

	protected FromLongAbstractTest(ObjectSetterAbstract setter) {
		super(setter);
	}

	protected abstract void checkValue(Long next, T value);

	@Test
	public void testLongPrimitive() {
		final long v = RandomUtils.nextLong();
		setter.fromLong(v, this);
		checkValue(v, value);
	}

	@Test
	public void testLongPrimitiveArray() {
		final long[] v = new long[] { RandomUtils.nextLong() };
		setter.fromLong(v, this);
		checkValue(v[0], value);
	}

	@Test
	public void testLongPrimitiveArrayEmpty() {
		final long[] v = new long[] {};
		setter.fromLong(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testLongPrimitiveArrayOverflow() {
		final long[] v = new long[] { RandomUtils.nextLong(), RandomUtils.nextLong() };
		setter.fromLong(v, this);
	}

	@Test
	public void testLong() {
		final Long v = RandomUtils.nextLong();
		setter.fromLong(v, this);
		checkValue(v, value);
	}

	@Test
	public void testLongArray() {
		final Long[] v = new Long[] { RandomUtils.nextLong() };
		setter.fromLong(v, this);
		checkValue(v[0], value);
	}

	@Test
	public void testLongArrayEmpty() {
		final Long[] v = new Long[] {};
		setter.fromLong(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testLongArrayOverflow() {
		final Long[] v = new Long[] { RandomUtils.nextLong(), RandomUtils.nextLong() };
		setter.fromLong(v, this);
	}

	@Test
	public void testLongCollection() {
		final Collection<Long> v = Arrays.asList(RandomUtils.nextLong());
		setter.fromLong(v, this);
		checkValue(v.iterator().next(), value);
	}

	@Test
	public void testLongCollectionEmpty() {
		final Collection<Long> v = Arrays.asList();
		setter.fromLong(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testLongCollectionOverflow() {
		final Collection<Long> v = Arrays.asList(RandomUtils.nextLong(), RandomUtils.nextLong());
		setter.fromLong(v, this);
	}

	@Test
	public void testLongList() {
		final List<Long> v = Arrays.asList(RandomUtils.nextLong());
		setter.fromLong(v, this);
		checkValue(v.iterator().next(), value);
	}

	@Test
	public void testLongListEmpty() {
		final List<Long> v = Arrays.asList();
		setter.fromLong(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testLongListOverflow() {
		final List<Long> v = Arrays.asList(RandomUtils.nextLong(), RandomUtils.nextLong());
		setter.fromLong(v, this);
	}

}
