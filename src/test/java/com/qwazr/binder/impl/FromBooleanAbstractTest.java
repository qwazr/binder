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

public abstract class FromBooleanAbstractTest<T> extends ObjectSetterAbstractTest<T> {

	protected FromBooleanAbstractTest(ObjectSetterAbstract setter) {
		super(setter);
	}

	@Test
	final public void testBooleanPrimitive() {
		final boolean v = RandomUtils.nextBoolean();
		setter.fromBoolean(v, this);
		Assert.assertEquals(Boolean.toString(v), value);
	}

	@Test
	final public void testBooleanPrimitiveArray() {
		final boolean[] v = new boolean[] { RandomUtils.nextBoolean() };
		setter.fromBoolean(v, this);
		Assert.assertEquals(Boolean.toString(v[0]), value);
	}

	@Test
	final public void testBooleanPrimitiveArrayEmpty() {
		final boolean[] v = new boolean[] {};
		setter.fromBoolean(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testBooleanPrimitiveArrayOverflow() {
		final boolean[] v = new boolean[] { RandomUtils.nextBoolean(), RandomUtils.nextBoolean() };
		setter.fromBoolean(v, this);
	}

	@Test
	final public void testBoolean() {
		final Boolean v = RandomUtils.nextBoolean();
		setter.fromBoolean(v, this);
		Assert.assertEquals(Boolean.toString(v), value);
	}

	@Test
	final public void testBooleanArray() {
		final Boolean[] v = new Boolean[] { RandomUtils.nextBoolean() };
		setter.fromBoolean(v, this);
		Assert.assertEquals(Boolean.toString(v[0]), value);
	}

	@Test
	final public void testBooleanArrayEmpty() {
		final Boolean[] v = new Boolean[] {};
		setter.fromBoolean(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testBooleanArrayOverflow() {
		final Boolean[] v = new Boolean[] { RandomUtils.nextBoolean(), RandomUtils.nextBoolean() };
		setter.fromBoolean(v, this);
	}

	@Test
	final public void testBooleanCollection() {
		final Collection<Boolean> v = Arrays.asList(RandomUtils.nextBoolean());
		setter.fromBoolean(v, this);
		Assert.assertEquals(Boolean.toString(v.iterator().next()), value);
	}

	@Test
	final public void testBooleanCollectionEmpty() {
		final Collection<Boolean> v = Arrays.asList();
		setter.fromBoolean(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testBooleanCollectionOverflow() {
		final Collection<Boolean> v = Arrays.asList(RandomUtils.nextBoolean(), RandomUtils.nextBoolean());
		setter.fromBoolean(v, this);
	}

	@Test
	final public void testBooleanList() {
		final List<Boolean> v = Arrays.asList(RandomUtils.nextBoolean());
		setter.fromBoolean(v, this);
		Assert.assertEquals(Boolean.toString(v.iterator().next()), value);
	}

	@Test
	final public void testBooleanListEmpty() {
		final List<Boolean> v = Arrays.asList();
		setter.fromBoolean(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testBooleanListOverflow() {
		final List<Boolean> v = Arrays.asList(RandomUtils.nextBoolean(), RandomUtils.nextBoolean());
		setter.fromBoolean(v, this);
	}

}
