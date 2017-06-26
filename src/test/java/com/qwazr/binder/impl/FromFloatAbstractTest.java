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

public abstract class FromFloatAbstractTest<T> extends ObjectSetterAbstractTest<T> {

	protected FromFloatAbstractTest(ObjectSetterAbstract setter) {
		super(setter);
	}

	protected abstract void checkValue(Float next, T value);

	@Test
	public void testFloatPrimitive() {
		final float v = RandomUtils.nextFloat();
		setter.fromFloat(v, this);
		checkValue(v, value);
	}

	@Test
	public void testFloatPrimitiveArray() {
		final float[] v = new float[] { RandomUtils.nextFloat() };
		setter.fromFloat(v, this);
		checkValue(v[0], value);
	}

	@Test
	public void testFloatPrimitiveArrayEmpty() {
		final float[] v = new float[] {};
		setter.fromFloat(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testFloatPrimitiveArrayOverflow() {
		final float[] v = new float[] { RandomUtils.nextFloat(), RandomUtils.nextFloat() };
		setter.fromFloat(v, this);
	}

	@Test
	public void testFloat() {
		final Float v = RandomUtils.nextFloat();
		setter.fromFloat(v, this);
		checkValue(v, value);
	}

	@Test
	public void testFloatArray() {
		final Float[] v = new Float[] { RandomUtils.nextFloat() };
		setter.fromFloat(v, this);
		checkValue(v[0], value);
	}

	@Test
	public void testFloatArrayEmpty() {
		final Float[] v = new Float[] {};
		setter.fromFloat(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testFloatArrayOverflow() {
		final Float[] v = new Float[] { RandomUtils.nextFloat(), RandomUtils.nextFloat() };
		setter.fromFloat(v, this);
	}

	@Test
	public void testFloatCollection() {
		final Collection<Float> v = Arrays.asList(RandomUtils.nextFloat());
		setter.fromFloat(v, this);
		checkValue(v.iterator().next(), value);
	}

	@Test
	public void testFloatCollectionEmpty() {
		final Collection<Float> v = Arrays.asList();
		setter.fromFloat(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testFloatCollectionOverflow() {
		final Collection<Float> v = Arrays.asList(RandomUtils.nextFloat(), RandomUtils.nextFloat());
		setter.fromFloat(v, this);
	}

	@Test
	public void testFloatList() {
		final List<Float> v = Arrays.asList(RandomUtils.nextFloat());
		setter.fromFloat(v, this);
		checkValue(v.iterator().next(), value);
	}

	@Test
	public void testFloatListEmpty() {
		final List<Float> v = Arrays.asList();
		setter.fromFloat(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testFloatListOverflow() {
		final List<Float> v = Arrays.asList(RandomUtils.nextFloat(), RandomUtils.nextFloat());
		setter.fromFloat(v, this);
	}

}
