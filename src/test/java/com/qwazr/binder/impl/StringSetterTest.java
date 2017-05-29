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
	public void testFloatPrimitiveArray() {
		final float[] v = new float[] { RandomUtils.nextFloat() };
		setter.fromFloat(v, this);
		Assert.assertEquals(Float.toString(v[0]), value);
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
		Assert.assertEquals(Float.toString(v), value);
	}

	@Test
	public void testFloatArray() {
		final Float[] v = new Float[] { RandomUtils.nextFloat() };
		setter.fromFloat(v, this);
		Assert.assertEquals(Float.toString(v[0]), value);
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
		Assert.assertEquals(Float.toString(v.iterator().next()), value);
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
		Assert.assertEquals(Float.toString(v.iterator().next()), value);
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

	@Test
	public void testLongPrimitive() {
		final long v = RandomUtils.nextLong();
		setter.fromLong(v, this);
		Assert.assertEquals(Long.toString(v), value);
	}

	@Test
	public void testLongPrimitiveArray() {
		final long[] v = new long[] { RandomUtils.nextLong() };
		setter.fromLong(v, this);
		Assert.assertEquals(Long.toString(v[0]), value);
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
		Assert.assertEquals(Long.toString(v), value);
	}

	@Test
	public void testLongArray() {
		final Long[] v = new Long[] { RandomUtils.nextLong() };
		setter.fromLong(v, this);
		Assert.assertEquals(Long.toString(v[0]), value);
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
		Assert.assertEquals(Long.toString(v.iterator().next()), value);
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
		Assert.assertEquals(Long.toString(v.iterator().next()), value);
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

	@Test
	public void testIntegerPrimitive() {
		final int v = RandomUtils.nextInt();
		setter.fromInteger(v, this);
		Assert.assertEquals(Integer.toString(v), value);
	}

	@Test
	public void testIntegerPrimitiveArray() {
		final int[] v = new int[] { RandomUtils.nextInt() };
		setter.fromInteger(v, this);
		Assert.assertEquals(Integer.toString(v[0]), value);
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
		Assert.assertEquals(Integer.toString(v), value);
	}

	@Test
	public void testIntegerArray() {
		final Integer[] v = new Integer[] { RandomUtils.nextInt() };
		setter.fromInteger(v, this);
		Assert.assertEquals(Integer.toString(v[0]), value);
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
		Assert.assertEquals(Integer.toString(v.iterator().next()), value);
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
		Assert.assertEquals(Integer.toString(v.iterator().next()), value);
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

	@Test
	public void testShortPrimitive() {
		final short v = (short) RandomUtils.nextInt(0, Short.MAX_VALUE);
		setter.fromShort(v, this);
		Assert.assertEquals(Short.toString(v), value);
	}

	@Test
	public void testShortPrimitiveArray() {
		final short[] v = new short[] { (short) RandomUtils.nextInt(0, Short.MAX_VALUE) };
		setter.fromShort(v, this);
		Assert.assertEquals(Short.toString(v[0]), value);
	}

	@Test
	public void testShortPrimitiveArrayEmpty() {
		final short[] v = new short[] {};
		setter.fromShort(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testShortPrimitiveArrayOverflow() {
		final short[] v = new short[] { (short) RandomUtils.nextInt(0, Short.MAX_VALUE), (short) RandomUtils.nextInt(0,
				Short.MAX_VALUE) };
		setter.fromShort(v, this);
	}

	@Test
	public void testShort() {
		final Short v = (short) RandomUtils.nextInt(0, Short.MAX_VALUE);
		setter.fromShort(v, this);
		Assert.assertEquals(Short.toString(v), value);
	}

	@Test
	public void testShortArray() {
		final Short[] v = new Short[] { (short) RandomUtils.nextInt(0, Short.MAX_VALUE) };
		setter.fromShort(v, this);
		Assert.assertEquals(Short.toString(v[0]), value);
	}

	@Test
	public void testShortArrayEmpty() {
		final Short[] v = new Short[] {};
		setter.fromShort(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testShortArrayOverflow() {
		final Short[] v = new Short[] { (short) RandomUtils.nextInt(0, Short.MAX_VALUE), (short) RandomUtils.nextInt(0,
				Short.MAX_VALUE) };
		setter.fromShort(v, this);
	}

	@Test
	public void testShortCollection() {
		final Collection<Short> v = Arrays.asList((short) RandomUtils.nextInt(0, Short.MAX_VALUE));
		setter.fromShort(v, this);
		Assert.assertEquals(Short.toString(v.iterator().next()), value);
	}

	@Test
	public void testShortCollectionEmpty() {
		final Collection<Short> v = Arrays.asList();
		setter.fromShort(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testShortCollectionOverflow() {
		final Collection<Short> v = Arrays.asList((short) RandomUtils.nextInt(0, Short.MAX_VALUE),
				(short) RandomUtils.nextInt(0, Short.MAX_VALUE));
		setter.fromShort(v, this);
	}

	@Test
	public void testShortList() {
		final List<Short> v = Arrays.asList((short) RandomUtils.nextInt(0, Short.MAX_VALUE));
		setter.fromShort(v, this);
		Assert.assertEquals(Short.toString(v.iterator().next()), value);
	}

	@Test
	public void testShortListEmpty() {
		final List<Short> v = Arrays.asList();
		setter.fromShort(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testShortListOverflow() {
		final List<Short> v = Arrays.asList((short) RandomUtils.nextInt(0, Short.MAX_VALUE),
				(short) RandomUtils.nextInt(0, Short.MAX_VALUE));
		setter.fromShort(v, this);
	}

	@Test
	public void testCharPrimitive() {
		final char v = RandomStringUtils.randomAlphanumeric(1).charAt(0);
		setter.fromChar(v, this);
		Assert.assertEquals(Character.toString(v), value);
	}

	@Test
	public void testCharPrimitiveArray() {
		final char[] v = new char[] { RandomStringUtils.randomAlphanumeric(1).charAt(0) };
		setter.fromChar(v, this);
		Assert.assertEquals(Character.toString(v[0]), value);
	}

	@Test
	public void testCharPrimitiveArrayEmpty() {
		final char[] v = new char[] {};
		setter.fromChar(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testCharPrimitiveArrayOverflow() {
		final char[] v = new char[] { RandomStringUtils.randomAlphanumeric(1).charAt(0),
				RandomStringUtils.randomAlphanumeric(1).charAt(0) };
		setter.fromChar(v, this);
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
	public void testBytePrimitiveArray() {
		final byte[] v = new byte[] { RandomUtils.nextBytes(1)[0] };
		setter.fromByte(v, this);
		Assert.assertEquals(Byte.toString(v[0]), value);
	}

	@Test
	public void testBytePrimitiveArrayEmpty() {
		final byte[] v = new byte[] {};
		setter.fromByte(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testBytePrimitiveArrayOverflow() {
		final byte[] v = RandomUtils.nextBytes(2);
		setter.fromByte(v, this);
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
	public void testBooleanPrimitiveArray() {
		final boolean[] v = new boolean[] { RandomUtils.nextBoolean() };
		setter.fromBoolean(v, this);
		Assert.assertEquals(Boolean.toString(v[0]), value);
	}

	@Test
	public void testBooleanPrimitiveArrayEmpty() {
		final boolean[] v = new boolean[] {};
		setter.fromBoolean(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	public void testBooleanPrimitiveArrayOverflow() {
		final boolean[] v = new boolean[] { RandomUtils.nextBoolean(), RandomUtils.nextBoolean() };
		setter.fromBoolean(v, this);
	}

	@Test
	public void testBoolean() {
		final Boolean v = RandomUtils.nextBoolean();
		setter.fromBoolean(v, this);
		Assert.assertEquals(Boolean.toString(v), value);
	}
}
