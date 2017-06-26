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

public abstract class FromShortAbstractTest<T> extends ObjectSetterAbstractTest<T> {

	protected FromShortAbstractTest(ObjectSetterAbstract setter) {
		super(setter);
	}

	protected abstract void checkValue(Short next, T value);

	@Test
	final public void testShortPrimitive() {
		final short v = RandomUtils.nextShort();
		setter.fromShort(v, this);
		checkValue(v, value);
	}

	@Test
	final public void testShortPrimitiveArray() {
		final short[] v = new short[] { RandomUtils.nextShort() };
		setter.fromShort(v, this);
		checkValue(v[0], value);
	}

	@Test
	final public void testShortPrimitiveArrayEmpty() {
		final short[] v = new short[] {};
		setter.fromShort(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testShortPrimitiveArrayOverflow() {
		final short[] v = new short[] { RandomUtils.nextShort(), RandomUtils.nextShort() };
		setter.fromShort(v, this);
	}

	@Test
	final public void testShort() {
		final Short v = RandomUtils.nextShort();
		setter.fromShort(v, this);
		checkValue(v, value);
	}

	@Test
	final public void testShortArray() {
		final Short[] v = new Short[] { RandomUtils.nextShort() };
		setter.fromShort(v, this);
		checkValue(v[0], value);
	}

	@Test
	final public void testShortArrayEmpty() {
		final Short[] v = new Short[] {};
		setter.fromShort(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testShortArrayOverflow() {
		final Short[] v = new Short[] { RandomUtils.nextShort(), RandomUtils.nextShort() };
		setter.fromShort(v, this);
	}

	@Test
	final public void testShortCollection() {
		final Collection<Short> v = Arrays.asList(RandomUtils.nextShort());
		setter.fromShort(v, this);
		checkValue(v.iterator().next(), value);
	}

	@Test
	final public void testShortCollectionEmpty() {
		final Collection<Short> v = Arrays.asList();
		setter.fromShort(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testShortCollectionOverflow() {
		final Collection<Short> v = Arrays.asList(RandomUtils.nextShort(), RandomUtils.nextShort());
		setter.fromShort(v, this);
	}

	@Test
	public void testShortList() {
		final List<Short> v = Arrays.asList(RandomUtils.nextShort());
		setter.fromShort(v, this);
		checkValue(v.iterator().next(), value);
	}

	@Test
	final public void testShortListEmpty() {
		final List<Short> v = Arrays.asList();
		setter.fromShort(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testShortListOverflow() {
		final List<Short> v = Arrays.asList(RandomUtils.nextShort(), RandomUtils.nextShort());
		setter.fromShort(v, this);
	}

}
