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

public abstract class FromDoubleAbstractTest<T> extends ObjectSetterAbstractTest<T> {

	protected FromDoubleAbstractTest(ObjectSetterAbstract setter) {
		super(setter);
	}

	protected abstract void checkValue(Double next, T value);

	@Test
	public void testDoublePrimitive() {
		final double v = RandomUtils.nextDouble();
		setter.fromDouble(v, this);
		checkValue(v, value);
	}

	@Test
	public void testDoublePrimitiveArray() {
		final double[] v = new double[] { RandomUtils.nextDouble() };
		setter.fromDouble(v, this);
		checkValue(v[0], value);
	}

	@Test
	public void testDoublePrimitiveArrayEmpty() {
		final double[] v = new double[] {};
		setter.fromDouble(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testDoublePrimitiveArrayOverflow() {
		final double[] v = new double[] { RandomUtils.nextDouble(), RandomUtils.nextDouble() };
		setter.fromDouble(v, this);
	}

	@Test
	public void testDouble() {
		final Double v = RandomUtils.nextDouble();
		setter.fromDouble(v, this);
		checkValue(v, value);
	}

	@Test
	public void testDoubleArray() {
		final Double[] v = new Double[] { RandomUtils.nextDouble() };
		setter.fromDouble(v, this);
		checkValue(v[0], value);
	}

	@Test
	public void testDoubleArrayEmpty() {
		final Double[] v = new Double[] {};
		setter.fromDouble(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testDoubleArrayOverflow() {
		final Double[] v = new Double[] { RandomUtils.nextDouble(), RandomUtils.nextDouble() };
		setter.fromDouble(v, this);
	}

	@Test
	public void testDoubleCollection() {
		final Collection<Double> v = Arrays.asList(RandomUtils.nextDouble());
		setter.fromDouble(v, this);
		checkValue(v.iterator().next(), value);
	}

	@Test
	public void testDoubleCollectionEmpty() {
		final Collection<Double> v = Arrays.asList();
		setter.fromDouble(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testDoubleCollectionOverflow() {
		final Collection<Double> v = Arrays.asList(RandomUtils.nextDouble(), RandomUtils.nextDouble());
		setter.fromDouble(v, this);
	}

	@Test
	public void testDoubleList() {
		final List<Double> v = Arrays.asList(RandomUtils.nextDouble());
		setter.fromDouble(v, this);
		checkValue(v.iterator().next(), value);
	}

	@Test
	public void testDoubleListEmpty() {
		final List<Double> v = Arrays.asList();
		setter.fromDouble(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testDoubleListOverflow() {
		final List<Double> v = Arrays.asList(RandomUtils.nextDouble(), RandomUtils.nextDouble());
		setter.fromDouble(v, this);
	}

}
