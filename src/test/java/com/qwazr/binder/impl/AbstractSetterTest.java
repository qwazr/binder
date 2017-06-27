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

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public abstract class AbstractSetterTest<T> {

	protected FieldSetterAbstract setter;
	protected T value;

	protected AbstractSetterTest(FieldSetterAbstract setter) {
		this.setter = setter;
	}

	static public Field getValueField() {
		try {
			return AbstractSetterTest.class.getDeclaredField("value");
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		}
	}

	protected abstract String nextString();

	protected abstract void checkValueString(String next, T value);

	protected abstract void checkValueShort(Short next, T value);

	protected abstract void checkValueLong(Long next, T value);

	protected abstract void checkValueInteger(Integer next, T value);

	protected abstract void checkValueFloat(Float next, T value);

	protected abstract void checkValueDouble(Double next, T value);

	protected abstract void checkValueChar(Character next, T value);

	protected abstract void checkValueByte(Byte next, T value);

	protected abstract void checkValueBoolean(Boolean next, T value);

	@Test
	final public void testString() {
		final String v = nextString();
		setter.fromString(v, this);
		checkValueString(v, value);
	}

	@Test
	final public void testStringArray() {
		final String[] v = new String[] { nextString() };
		setter.fromString(v, this);
		checkValueString(v[0], value);
	}

	@Test
	final public void testStringArrayEmpty() {
		final String[] v = new String[] {};
		setter.fromString(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testStringArrayOverflow() {
		final String[] v = new String[] { nextString(), nextString() };
		setter.fromString(v, this);
	}

	@Test
	final public void testStringCollection() {
		final Collection<String> v = Arrays.asList(nextString());
		setter.fromString(v, this);
		checkValueString(v.iterator().next(), value);
	}

	@Test
	final public void testStringCollectionEmpty() {
		final Collection<String> v = Arrays.asList();
		setter.fromString(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testStringCollectionOverflow() {
		final Collection<String> v = Arrays.asList(nextString(), nextString());
		setter.fromString(v, this);
	}

	@Test
	final public void testStringList() {
		final List<String> v = Arrays.asList(nextString());
		setter.fromString(v, this);
		checkValueString(v.get(0), value);
	}

	@Test
	final public void testStringListEmpty() {
		final List<String> v = Arrays.asList();
		setter.fromString(v, this);
		Assert.assertNull(value);
	}

	@Test(expected = BinderException.class)
	final public void testStringListOverflow() {
		final List<String> v = Arrays.asList(nextString(), nextString());
		setter.fromString(v, this);
	}

	@Test
	final public void testShortPrimitive() {
		final short v = RandomUtils.nextShort();
		setter.fromShort(v, this);
		checkValueShort(v, value);
	}

	@Test
	final public void testShortPrimitiveArray() {
		final short[] v = new short[] { RandomUtils.nextShort() };
		setter.fromShort(v, this);
		checkValueShort(v[0], value);
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
		checkValueShort(v, value);
	}

	@Test
	final public void testShortArray() {
		final Short[] v = new Short[] { RandomUtils.nextShort() };
		setter.fromShort(v, this);
		checkValueShort(v[0], value);
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
		checkValueShort(v.iterator().next(), value);
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
		checkValueShort(v.iterator().next(), value);
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

	@Test
	public void testLongPrimitive() {
		final long v = RandomUtils.nextLong();
		setter.fromLong(v, this);
		checkValueLong(v, value);
	}

	@Test
	public void testLongPrimitiveArray() {
		final long[] v = new long[] { RandomUtils.nextLong() };
		setter.fromLong(v, this);
		checkValueLong(v[0], value);
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
		checkValueLong(v, value);
	}

	@Test
	public void testLongArray() {
		final Long[] v = new Long[] { RandomUtils.nextLong() };
		setter.fromLong(v, this);
		checkValueLong(v[0], value);
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
		checkValueLong(v.iterator().next(), value);
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
		checkValueLong(v.iterator().next(), value);
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
		checkValueInteger(v, value);
	}

	@Test
	public void testIntegerPrimitiveArray() {
		final int[] v = new int[] { RandomUtils.nextInt() };
		setter.fromInteger(v, this);
		checkValueInteger(v[0], value);
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
		checkValueInteger(v, value);
	}

	@Test
	public void testIntegerArray() {
		final Integer[] v = new Integer[] { RandomUtils.nextInt() };
		setter.fromInteger(v, this);
		checkValueInteger(v[0], value);
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
		checkValueInteger(v.iterator().next(), value);
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
		checkValueInteger(v.iterator().next(), value);
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
	public void testFloatPrimitive() {
		final float v = RandomUtils.nextFloat();
		setter.fromFloat(v, this);
		checkValueFloat(v, value);
	}

	@Test
	public void testFloatPrimitiveArray() {
		final float[] v = new float[] { RandomUtils.nextFloat() };
		setter.fromFloat(v, this);
		checkValueFloat(v[0], value);
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
		checkValueFloat(v, value);
	}

	@Test
	public void testFloatArray() {
		final Float[] v = new Float[] { RandomUtils.nextFloat() };
		setter.fromFloat(v, this);
		checkValueFloat(v[0], value);
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
		checkValueFloat(v.iterator().next(), value);
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
		checkValueFloat(v.iterator().next(), value);
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
	public void testDoublePrimitive() {
		final double v = RandomUtils.nextDouble();
		setter.fromDouble(v, this);
		checkValueDouble(v, value);
	}

	@Test
	public void testDoublePrimitiveArray() {
		final double[] v = new double[] { RandomUtils.nextDouble() };
		setter.fromDouble(v, this);
		checkValueDouble(v[0], value);
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
		checkValueDouble(v, value);
	}

	@Test
	public void testDoubleArray() {
		final Double[] v = new Double[] { RandomUtils.nextDouble() };
		setter.fromDouble(v, this);
		checkValueDouble(v[0], value);
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
		checkValueDouble(v.iterator().next(), value);
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
		checkValueDouble(v.iterator().next(), value);
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
	final public void testCharPrimitive() {
		final char v = RandomUtils.nextChar();
		setter.fromChar(v, this);
		checkValueChar(v, value);
	}

	@Test
	final public void testCharPrimitiveArray() {
		final char[] v = new char[] { RandomUtils.nextChar() };
		setter.fromChar(v, this);
		checkValueChar(v[0], value);
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
		checkValueChar(v, value);
	}

	@Test
	final public void testCharArray() {
		final Character[] v = new Character[] { RandomUtils.nextChar() };
		setter.fromChar(v, this);
		checkValueChar(v[0], value);
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
		checkValueChar(v.iterator().next(), value);
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
		checkValueChar(v.iterator().next(), value);
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

	@Test
	final public void testBytePrimitive() {
		final byte v = RandomUtils.nextBytes(1)[0];
		setter.fromByte(v, this);
		checkValueByte(v, value);
	}

	@Test
	final public void testBytePrimitiveArray() {
		final byte[] v = new byte[] { RandomUtils.nextBytes(1)[0] };
		setter.fromByte(v, this);
		checkValueByte(v[0], value);
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
		checkValueByte(v, value);
	}

	@Test
	final public void testByteArray() {
		final Byte[] v = new Byte[] { RandomUtils.nextBytes(1)[0] };
		setter.fromByte(v, this);
		checkValueByte(v[0], value);
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
		checkValueByte(v.iterator().next(), value);
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
		checkValueByte(v.iterator().next(), value);
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

	@Test
	final public void testBooleanPrimitive() {
		final boolean v = RandomUtils.nextBoolean();
		setter.fromBoolean(v, this);
		checkValueBoolean(v, value);
	}

	@Test
	final public void testBooleanPrimitiveArray() {
		final boolean[] v = new boolean[] { RandomUtils.nextBoolean() };
		setter.fromBoolean(v, this);
		checkValueBoolean(v[0], value);
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
		checkValueBoolean(v, value);
	}

	@Test
	final public void testBooleanArray() {
		final Boolean[] v = new Boolean[] { RandomUtils.nextBoolean() };
		setter.fromBoolean(v, this);
		checkValueBoolean(v[0], value);
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
		checkValueBoolean(v.iterator().next(), value);
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
		checkValueBoolean(v.iterator().next(), value);
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
