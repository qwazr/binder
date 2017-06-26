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

public abstract class FromByteAbstractTest<T> extends ObjectSetterAbstractTest<T> {

	protected FromByteAbstractTest(ObjectSetterAbstract setter) {
		super(setter);
	}

	@Test
	final public void testBytePrimitive() {
		final byte v = RandomUtils.nextBytes(1)[0];
		setter.fromByte(v, this);
		Assert.assertEquals(Byte.toString(v), value);
	}

	@Test
	final public void testBytePrimitiveArray() {
		final byte[] v = new byte[] { RandomUtils.nextBytes(1)[0] };
		setter.fromByte(v, this);
		Assert.assertEquals(Byte.toString(v[0]), value);
	}

	@Test
	final public void testBytePrimitiveArrayEmpty() {
		final byte[] v = new byte[] {};
		setter.fromByte(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testBytePrimitiveArrayOverflow() {
		final byte[] v = RandomUtils.nextBytes(2);
		setter.fromByte(v, this);
	}

	@Test
	final public void testByte() {
		final Byte v = RandomUtils.nextBytes(1)[0];
		setter.fromByte(v, this);
		Assert.assertEquals(Byte.toString(v), value);
	}

	@Test
	final public void testByteArray() {
		final Byte[] v = new Byte[] { RandomUtils.nextBytes(1)[0] };
		setter.fromByte(v, this);
		Assert.assertEquals(Byte.toString(v[0]), value);
	}

	@Test
	final public void testByteArrayEmpty() {
		final Byte[] v = new Byte[] {};
		setter.fromByte(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testByteArrayOverflow() {
		final Byte[] v = new Byte[] { RandomUtils.nextBytes(1)[0], RandomUtils.nextBytes(1)[0] };
		setter.fromByte(v, this);
	}

	@Test
	final public void testByteCollection() {
		final Collection<Byte> v = Arrays.asList(RandomUtils.nextBytes(1)[0]);
		setter.fromByte(v, this);
		Assert.assertEquals(Byte.toString(v.iterator().next()), value);
	}

	@Test
	final public void testByteCollectionEmpty() {
		final Collection<Byte> v = Arrays.asList();
		setter.fromByte(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testByteCollectionOverflow() {
		final Collection<Byte> v = Arrays.asList(RandomUtils.nextBytes(1)[0], RandomUtils.nextBytes(1)[0]);
		setter.fromByte(v, this);
	}

	@Test
	final public void testByteList() {
		final List<Byte> v = Arrays.asList(RandomUtils.nextBytes(1)[0]);
		setter.fromByte(v, this);
		Assert.assertEquals(Byte.toString(v.iterator().next()), value);
	}

	@Test
	final public void testByteListEmpty() {
		final List<Byte> v = Arrays.asList();
		setter.fromByte(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testByteListOverflow() {
		final List<Byte> v = Arrays.asList(RandomUtils.nextBytes(1)[0], RandomUtils.nextBytes(1)[0]);
		setter.fromByte(v, this);
	}

}
