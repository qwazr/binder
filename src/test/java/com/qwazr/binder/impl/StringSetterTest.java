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
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by ekeller on 30/05/2017.
 */
public class StringSetterTest {

	String value;

	static StringSetterImpl setter;

	@BeforeClass
	public static void setup() throws NoSuchFieldException {
		setter = new StringSetterImpl(StringSetterTest.class.getDeclaredField("value"));
	}

	@Test
	public void testString() {
		final String v = RandomStringUtils.randomAlphabetic(10);
		setter.fromString(v, this);
		Assert.assertEquals(v, value);
	}

	@Test
	public void testStringArray() {
		final String[] v = new String[] { RandomStringUtils.randomAlphanumeric(10) };
		setter.fromString(v, this);
		Assert.assertEquals(v[0], value);
	}

	@Test
	public void testStringArrayEmpty() {
		final String[] v = new String[] {};
		setter.fromString(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testStringArrayOverflow() {
		final String[] v = new String[] { RandomStringUtils.randomAlphanumeric(10),
				RandomStringUtils.randomAlphanumeric(10) };
		setter.fromString(v, this);
	}

	@Test
	public void testStringCollection() {
		final Collection<String> v = Arrays.asList(RandomStringUtils.randomAlphanumeric(10));
		setter.fromString(v, this);
		Assert.assertEquals(v.iterator().next(), value);
	}

	@Test
	public void testStringCollectionEmpty() {
		final Collection<String> v = Arrays.asList();
		setter.fromString(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testStringCollectionOverflow() {
		final Collection<String> v = Arrays.asList(RandomStringUtils.randomAlphanumeric(10),
				RandomStringUtils.randomAlphanumeric(10));
		setter.fromString(v, this);
	}

	@Test
	public void testStringList() {
		final List<String> v = Arrays.asList(RandomStringUtils.randomAlphanumeric(10));
		setter.fromString(v, this);
		Assert.assertEquals(v.get(0), value);
	}

	@Test
	public void testStringListEmpty() {
		final List<String> v = Arrays.asList();
		setter.fromString(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testStringListOverflow() {
		final List<String> v = Arrays.asList(RandomStringUtils.randomAlphanumeric(10),
				RandomStringUtils.randomAlphanumeric(10));
		setter.fromString(v, this);
	}

	@Test
	public void testDoublePrimitive() {
		final double v = RandomUtils.nextDouble();
		setter.fromDouble(v, this);
		Assert.assertEquals(Double.toString(v), value);
	}

	@Test
	public void testDoublePrimitiveArray() {
		final double[] v = new double[] { RandomUtils.nextDouble() };
		setter.fromDouble(v, this);
		Assert.assertEquals(Double.toString(v[0]), value);
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
		Assert.assertEquals(Double.toString(v), value);
	}

	@Test
	public void testDoubleArray() {
		final Double[] v = new Double[] { RandomUtils.nextDouble() };
		setter.fromDouble(v, this);
		Assert.assertEquals(Double.toString(v[0]), value);
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
		Assert.assertEquals(Double.toString(v.iterator().next()), value);
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
		Assert.assertEquals(Double.toString(v.iterator().next()), value);
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

	@Test
	public void testFloatPrimitive() {
		final float v = RandomUtils.nextFloat();
		setter.fromFloat(v, this);
		Assert.assertEquals(Float.toString(v), value);
	}

	@Test
	public void testFloat() {
		final Float v = RandomUtils.nextFloat();
		setter.fromFloat(v, this);
		Assert.assertEquals(Float.toString(v), value);
	}

	@Test
	public void testLongPrimitive() {
		final long v = RandomUtils.nextLong();
		setter.fromLong(v, this);
		Assert.assertEquals(Long.toString(v), value);
	}

	@Test
	public void testLong() {
		final Long v = RandomUtils.nextLong();
		setter.fromLong(v, this);
		Assert.assertEquals(Long.toString(v), value);
	}

	@Test
	public void testIntegerPrimitive() {
		final int v = RandomUtils.nextInt();
		setter.fromInteger(v, this);
		Assert.assertEquals(Integer.toString(v), value);
	}

	@Test
	public void testInteger() {
		final Integer v = RandomUtils.nextInt();
		setter.fromInteger(v, this);
		Assert.assertEquals(Integer.toString(v), value);
	}

	@Test
	public void testShortPrimitive() {
		final short v = (short) RandomUtils.nextInt(0, Short.MAX_VALUE);
		setter.fromShort(v, this);
		Assert.assertEquals(Short.toString(v), value);
	}

	@Test
	public void testShort() {
		final Short v = (short) RandomUtils.nextInt(0, Short.MAX_VALUE);
		setter.fromShort(v, this);
		Assert.assertEquals(Short.toString(v), value);
	}

	@Test
	public void testCharPrimitive() {
		final char v = RandomStringUtils.randomAlphanumeric(1).charAt(0);
		setter.fromChar(v, this);
		Assert.assertEquals(Character.toString(v), value);
	}

	@Test
	public void testChar() {
		final Character v = RandomStringUtils.randomAlphanumeric(1).charAt(0);
		setter.fromChar(v, this);
		Assert.assertEquals(v.toString(), value);
	}

	@Test
	public void testBytePrimitive() {
		final byte v = RandomUtils.nextBytes(1)[0];
		setter.fromByte(v, this);
		Assert.assertEquals(Byte.toString(v), value);
	}

	@Test
	public void testByte() {
		final Byte v = RandomUtils.nextBytes(1)[0];
		setter.fromByte(v, this);
		Assert.assertEquals(Byte.toString(v), value);
	}

	@Test
	public void testBooleanPrimitive() {
		final boolean v = RandomUtils.nextBoolean();
		setter.fromBoolean(v, this);
		Assert.assertEquals(Boolean.toString(v), value);
	}

	@Test
	public void testBoolean() {
		final Boolean v = RandomUtils.nextBoolean();
		setter.fromBoolean(v, this);
		Assert.assertEquals(Boolean.toString(v), value);
	}
}
