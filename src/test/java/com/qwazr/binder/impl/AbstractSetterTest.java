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
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public abstract class AbstractSetterTest {

	protected FieldSetterAbstract setter;

	protected AbstractSetterTest(FieldSetterAbstract setter) {
		this.setter = setter;
	}

	protected abstract String nextString();

	protected abstract Number nextNumber();

	final Long nextLong() {
		return nextNumber().longValue();
	}

	final Short nextShort() {
		return nextNumber().shortValue();
	}

	final Integer nextInt() {
		return nextNumber().intValue();
	}

	final Double nextDouble() {
		return nextNumber().doubleValue();
	}

	final Float nextFloat() {
		return nextNumber().floatValue();
	}

	final Byte nextByte() {
		return nextNumber().byteValue();
	}

	final Character nextChar() {
		return (char) (Math.abs(nextNumber().intValue()) % Character.MAX_CODE_POINT);
	}

	final Boolean nextBoolean() {
		return nextNumber().byteValue() != 0;
	}

	protected abstract void checkValueString(String next);

	protected abstract void checkValueShort(Short next);

	protected abstract void checkValueLong(Long next);

	protected abstract void checkValueInteger(Integer next);

	protected abstract void checkValueFloat(Float next);

	protected abstract void checkValueDouble(Double next);

	protected abstract void checkValueChar(Character next);

	protected abstract void checkValueByte(Byte next);

	protected abstract void checkValueBoolean(Boolean next);

	protected abstract void checkValueNull();

	@Test
	final public void testString() {
		final String v = nextString();
		setter.fromString(v, this);
		checkValueString(v);
	}

	@Test
	final public void testStringArray() {
		final String[] v = new String[] { nextString() };
		setter.fromString(v, this);
		checkValueString(v[0]);
	}

	@Test
	final public void testStringArrayEmpty() {
		final String[] v = new String[] {};
		setter.fromString(v, this);
		checkValueNull();
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
		checkValueString(v.iterator().next());
	}

	@Test
	final public void testStringCollectionEmpty() {
		final Collection<String> v = Arrays.asList();
		setter.fromString(v, this);
		checkValueNull();
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
		checkValueString(v.get(0));
	}

	@Test
	final public void testStringListEmpty() {
		final List<String> v = Arrays.asList();
		setter.fromString(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	final public void testStringListOverflow() {
		final List<String> v = Arrays.asList(nextString(), nextString());
		setter.fromString(v, this);
	}

	@Test
	final public void testShortPrimitive() {
		final short v = nextShort();
		setter.fromShort(v, this);
		checkValueShort(v);
	}

	@Test
	final public void testShortPrimitiveArray() {
		final short[] v = new short[] { nextShort() };
		setter.fromShort(v, this);
		checkValueShort(v[0]);
	}

	@Test
	final public void testShortPrimitiveArrayEmpty() {
		final short[] v = new short[] {};
		setter.fromShort(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	final public void testShortPrimitiveArrayOverflow() {
		final short[] v = new short[] { nextShort(), nextShort() };
		setter.fromShort(v, this);
	}

	@Test
	final public void testShort() {
		final Short v = nextShort();
		setter.fromShort(v, this);
		checkValueShort(v);
	}

	@Test
	final public void testShortArray() {
		final Short[] v = new Short[] { nextShort() };
		setter.fromShort(v, this);
		checkValueShort(v[0]);
	}

	@Test
	final public void testShortArrayEmpty() {
		final Short[] v = new Short[] {};
		setter.fromShort(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	final public void testShortArrayOverflow() {
		final Short[] v = new Short[] { nextShort(), nextShort() };
		setter.fromShort(v, this);
	}

	@Test
	final public void testShortCollection() {
		final Collection<Short> v = Arrays.asList(nextShort());
		setter.fromShort(v, this);
		checkValueShort(v.iterator().next());
	}

	@Test
	final public void testShortCollectionEmpty() {
		final Collection<Short> v = Arrays.asList();
		setter.fromShort(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	final public void testShortCollectionOverflow() {
		final Collection<Short> v = Arrays.asList(nextShort(), nextShort());
		setter.fromShort(v, this);
	}

	@Test
	public void testShortList() {
		final List<Short> v = Arrays.asList(nextShort());
		setter.fromShort(v, this);
		checkValueShort(v.iterator().next());
	}

	@Test
	final public void testShortListEmpty() {
		final List<Short> v = Arrays.asList();
		setter.fromShort(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	final public void testShortListOverflow() {
		final List<Short> v = Arrays.asList(nextShort(), nextShort());
		setter.fromShort(v, this);
	}

	@Test
	public void testLongPrimitive() {
		final long v = nextLong();
		setter.fromLong(v, this);
		checkValueLong(v);
	}

	@Test
	public void testLongPrimitiveArray() {
		final long[] v = new long[] { nextLong() };
		setter.fromLong(v, this);
		checkValueLong(v[0]);
	}

	@Test
	public void testLongPrimitiveArrayEmpty() {
		final long[] v = new long[] {};
		setter.fromLong(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	public void testLongPrimitiveArrayOverflow() {
		final long[] v = new long[] { nextLong(), nextLong() };
		setter.fromLong(v, this);
	}

	@Test
	public void testLong() {
		final Long v = nextLong();
		setter.fromLong(v, this);
		checkValueLong(v);
	}

	@Test
	public void testLongArray() {
		final Long[] v = new Long[] { nextLong() };
		setter.fromLong(v, this);
		checkValueLong(v[0]);
	}

	@Test
	public void testLongArrayEmpty() {
		final Long[] v = new Long[] {};
		setter.fromLong(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	public void testLongArrayOverflow() {
		final Long[] v = new Long[] { nextLong(), nextLong() };
		setter.fromLong(v, this);
	}

	@Test
	public void testLongCollection() {
		final Collection<Long> v = Arrays.asList(nextLong());
		setter.fromLong(v, this);
		checkValueLong(v.iterator().next());
	}

	@Test
	public void testLongCollectionEmpty() {
		final Collection<Long> v = Arrays.asList();
		setter.fromLong(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	public void testLongCollectionOverflow() {
		final Collection<Long> v = Arrays.asList(nextLong(), nextLong());
		setter.fromLong(v, this);
	}

	@Test
	public void testLongList() {
		final List<Long> v = Arrays.asList(nextLong());
		setter.fromLong(v, this);
		checkValueLong(v.iterator().next());
	}

	@Test
	public void testLongListEmpty() {
		final List<Long> v = Arrays.asList();
		setter.fromLong(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	public void testLongListOverflow() {
		final List<Long> v = Arrays.asList(nextLong(), nextLong());
		setter.fromLong(v, this);
	}

	@Test
	public void testIntegerPrimitive() {
		final int v = nextInt();
		setter.fromInteger(v, this);
		checkValueInteger(v);
	}

	@Test
	public void testIntegerPrimitiveArray() {
		final int[] v = new int[] { nextInt() };
		setter.fromInteger(v, this);
		checkValueInteger(v[0]);
	}

	@Test
	public void testIntegerPrimitiveArrayEmpty() {
		final int[] v = new int[] {};
		setter.fromInteger(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	public void testIntegerPrimitiveArrayOverflow() {
		final int[] v = new int[] { nextInt(), nextInt() };
		setter.fromInteger(v, this);
	}

	@Test
	public void testInteger() {
		final Integer v = nextInt();
		setter.fromInteger(v, this);
		checkValueInteger(v);
	}

	@Test
	public void testIntegerArray() {
		final Integer[] v = new Integer[] { nextInt() };
		setter.fromInteger(v, this);
		checkValueInteger(v[0]);
	}

	@Test
	public void testIntegerArrayEmpty() {
		final Integer[] v = new Integer[] {};
		setter.fromInteger(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	public void testIntegerArrayOverflow() {
		final Integer[] v = new Integer[] { nextInt(), nextInt() };
		setter.fromInteger(v, this);
	}

	@Test
	public void testIntegerCollection() {
		final Collection<Integer> v = Arrays.asList(nextInt());
		setter.fromInteger(v, this);
		checkValueInteger(v.iterator().next());
	}

	@Test
	public void testIntegerCollectionEmpty() {
		final Collection<Integer> v = Arrays.asList();
		setter.fromInteger(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	public void testIntegerCollectionOverflow() {
		final Collection<Integer> v = Arrays.asList(nextInt(), nextInt());
		setter.fromInteger(v, this);
	}

	@Test
	public void testIntegerList() {
		final List<Integer> v = Arrays.asList(nextInt());
		setter.fromInteger(v, this);
		checkValueInteger(v.iterator().next());
	}

	@Test
	public void testIntegerListEmpty() {
		final List<Integer> v = Arrays.asList();
		setter.fromInteger(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	public void testIntegerListOverflow() {
		final List<Integer> v = Arrays.asList(nextInt(), nextInt());
		setter.fromInteger(v, this);
	}

	@Test
	public void testFloatPrimitive() {
		final float v = nextFloat();
		setter.fromFloat(v, this);
		checkValueFloat(v);
	}

	@Test
	public void testFloatPrimitiveArray() {
		final float[] v = new float[] { nextFloat() };
		setter.fromFloat(v, this);
		checkValueFloat(v[0]);
	}

	@Test
	public void testFloatPrimitiveArrayEmpty() {
		final float[] v = new float[] {};
		setter.fromFloat(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	public void testFloatPrimitiveArrayOverflow() {
		final float[] v = new float[] { nextFloat(), nextFloat() };
		setter.fromFloat(v, this);
	}

	@Test
	public void testFloat() {
		final Float v = nextFloat();
		setter.fromFloat(v, this);
		checkValueFloat(v);
	}

	@Test
	public void testFloatArray() {
		final Float[] v = new Float[] { nextFloat() };
		setter.fromFloat(v, this);
		checkValueFloat(v[0]);
	}

	@Test
	public void testFloatArrayEmpty() {
		final Float[] v = new Float[] {};
		setter.fromFloat(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	public void testFloatArrayOverflow() {
		final Float[] v = new Float[] { nextFloat(), nextFloat() };
		setter.fromFloat(v, this);
	}

	@Test
	public void testFloatCollection() {
		final Collection<Float> v = Arrays.asList(nextFloat());
		setter.fromFloat(v, this);
		checkValueFloat(v.iterator().next());
	}

	@Test
	public void testFloatCollectionEmpty() {
		final Collection<Float> v = Arrays.asList();
		setter.fromFloat(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	public void testFloatCollectionOverflow() {
		final Collection<Float> v = Arrays.asList(nextFloat(), nextFloat());
		setter.fromFloat(v, this);
	}

	@Test
	public void testFloatList() {
		final List<Float> v = Arrays.asList(nextFloat());
		setter.fromFloat(v, this);
		checkValueFloat(v.iterator().next());
	}

	@Test
	public void testFloatListEmpty() {
		final List<Float> v = Arrays.asList();
		setter.fromFloat(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	public void testFloatListOverflow() {
		final List<Float> v = Arrays.asList(nextFloat(), nextFloat());
		setter.fromFloat(v, this);
	}

	@Test
	public void testDoublePrimitive() {
		final double v = nextDouble();
		setter.fromDouble(v, this);
		checkValueDouble(v);
	}

	@Test
	public void testDoublePrimitiveArray() {
		final double[] v = new double[] { nextDouble() };
		setter.fromDouble(v, this);
		checkValueDouble(v[0]);
	}

	@Test
	public void testDoublePrimitiveArrayEmpty() {
		final double[] v = new double[] {};
		setter.fromDouble(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	public void testDoublePrimitiveArrayOverflow() {
		final double[] v = new double[] { nextDouble(), nextDouble() };
		setter.fromDouble(v, this);
	}

	@Test
	public void testDouble() {
		final Double v = nextDouble();
		setter.fromDouble(v, this);
		checkValueDouble(v);
	}

	@Test
	public void testDoubleArray() {
		final Double[] v = new Double[] { nextDouble() };
		setter.fromDouble(v, this);
		checkValueDouble(v[0]);
	}

	@Test
	public void testDoubleArrayEmpty() {
		final Double[] v = new Double[] {};
		setter.fromDouble(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	public void testDoubleArrayOverflow() {
		final Double[] v = new Double[] { nextDouble(), nextDouble() };
		setter.fromDouble(v, this);
	}

	@Test
	public void testDoubleCollection() {
		final Collection<Double> v = Arrays.asList(nextDouble());
		setter.fromDouble(v, this);
		checkValueDouble(v.iterator().next());
	}

	@Test
	public void testDoubleCollectionEmpty() {
		final Collection<Double> v = Arrays.asList();
		setter.fromDouble(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	public void testDoubleCollectionOverflow() {
		final Collection<Double> v = Arrays.asList(nextDouble(), nextDouble());
		setter.fromDouble(v, this);
	}

	@Test
	public void testDoubleList() {
		final List<Double> v = Arrays.asList(nextDouble());
		setter.fromDouble(v, this);
		checkValueDouble(v.iterator().next());
	}

	@Test
	public void testDoubleListEmpty() {
		final List<Double> v = Arrays.asList();
		setter.fromDouble(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	public void testDoubleListOverflow() {
		final List<Double> v = Arrays.asList(nextDouble(), nextDouble());
		setter.fromDouble(v, this);
	}

	@Test
	final public void testCharPrimitive() {
		final char v = nextChar();
		setter.fromChar(v, this);
		checkValueChar(v);
	}

	@Test
	final public void testCharPrimitiveArray() {
		final char[] v = new char[] { nextChar() };
		setter.fromChar(v, this);
		checkValueChar(v[0]);
	}

	@Test
	final public void testCharPrimitiveArrayEmpty() {
		final char[] v = new char[] {};
		setter.fromChar(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	final public void testCharPrimitiveArrayOverflow() {
		final char[] v = new char[] { nextChar(), nextChar() };
		setter.fromChar(v, this);
	}

	@Test
	final public void testChar() {
		final Character v = nextChar();
		setter.fromChar(v, this);
		checkValueChar(v);
	}

	@Test
	final public void testCharArray() {
		final Character[] v = new Character[] { nextChar() };
		setter.fromChar(v, this);
		checkValueChar(v[0]);
	}

	@Test
	final public void testCharArrayEmpty() {
		final Character[] v = new Character[] {};
		setter.fromChar(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	final public void testCharArrayOverflow() {
		final Character[] v = new Character[] { nextChar(), nextChar() };
		setter.fromChar(v, this);
	}

	@Test
	final public void testCharCollection() {
		final Collection<Character> v = Arrays.asList(nextChar());
		setter.fromChar(v, this);
		checkValueChar(v.iterator().next());
	}

	@Test
	final public void testCharCollectionEmpty() {
		final Collection<Character> v = Arrays.asList();
		setter.fromChar(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	final public void testCharCollectionOverflow() {
		final Collection<Character> v = Arrays.asList(nextChar(), nextChar());
		setter.fromChar(v, this);
	}

	@Test
	public void testCharList() {
		final List<Character> v = Arrays.asList(nextChar());
		setter.fromChar(v, this);
		checkValueChar(v.iterator().next());
	}

	@Test
	final public void testCharListEmpty() {
		final List<Character> v = Arrays.asList();
		setter.fromChar(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	final public void testCharListOverflow() {
		final List<Character> v = Arrays.asList(nextChar(), nextChar());
		setter.fromChar(v, this);
	}

	@Test
	final public void testBytePrimitive() {
		final byte v = nextByte();
		setter.fromByte(v, this);
		checkValueByte(v);
	}

	@Test
	final public void testBytePrimitiveArray() {
		final byte[] v = new byte[] { nextByte() };
		setter.fromByte(v, this);
		checkValueByte(v[0]);
	}

	@Test
	final public void testBytePrimitiveArrayEmpty() {
		final byte[] v = new byte[] {};
		setter.fromByte(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	final public void testBytePrimitiveArrayOverflow() {
		final byte[] v = new byte[] { nextByte(), nextByte() };
		setter.fromByte(v, this);
	}

	@Test
	final public void testByte() {
		final Byte v = nextByte();
		setter.fromByte(v, this);
		checkValueByte(v);
	}

	@Test
	final public void testByteArray() {
		final Byte[] v = new Byte[] { nextByte() };
		setter.fromByte(v, this);
		checkValueByte(v[0]);
	}

	@Test
	final public void testByteArrayEmpty() {
		final Byte[] v = new Byte[] {};
		setter.fromByte(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	final public void testByteArrayOverflow() {
		final Byte[] v = new Byte[] { nextByte(), nextByte() };
		setter.fromByte(v, this);
	}

	@Test
	final public void testByteCollection() {
		final Collection<Byte> v = Arrays.asList(nextByte());
		setter.fromByte(v, this);
		checkValueByte(v.iterator().next());
	}

	@Test
	final public void testByteCollectionEmpty() {
		final Collection<Byte> v = Arrays.asList();
		setter.fromByte(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	final public void testByteCollectionOverflow() {
		final Collection<Byte> v = Arrays.asList(nextByte(), nextByte());
		setter.fromByte(v, this);
	}

	@Test
	final public void testByteList() {
		final List<Byte> v = Arrays.asList(nextByte());
		setter.fromByte(v, this);
		checkValueByte(v.iterator().next());
	}

	@Test
	final public void testByteListEmpty() {
		final List<Byte> v = Arrays.asList();
		setter.fromByte(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	final public void testByteListOverflow() {
		final List<Byte> v = Arrays.asList(nextByte(), nextByte());
		setter.fromByte(v, this);
	}

	@Test
	final public void testBooleanPrimitive() {
		final boolean v = nextBoolean();
		setter.fromBoolean(v, this);
		checkValueBoolean(v);
	}

	@Test
	final public void testBooleanPrimitiveArray() {
		final boolean[] v = new boolean[] { nextBoolean() };
		setter.fromBoolean(v, this);
		checkValueBoolean(v[0]);
	}

	@Test
	final public void testBooleanPrimitiveArrayEmpty() {
		final boolean[] v = new boolean[] {};
		setter.fromBoolean(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	final public void testBooleanPrimitiveArrayOverflow() {
		final boolean[] v = new boolean[] { nextBoolean(), nextBoolean() };
		setter.fromBoolean(v, this);
	}

	@Test
	final public void testBoolean() {
		final Boolean v = nextBoolean();
		setter.fromBoolean(v, this);
		checkValueBoolean(v);
	}

	@Test
	final public void testBooleanArray() {
		final Boolean[] v = new Boolean[] { nextBoolean() };
		setter.fromBoolean(v, this);
		checkValueBoolean(v[0]);
	}

	@Test
	final public void testBooleanArrayEmpty() {
		final Boolean[] v = new Boolean[] {};
		setter.fromBoolean(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	final public void testBooleanArrayOverflow() {
		final Boolean[] v = new Boolean[] { nextBoolean(), nextBoolean() };
		setter.fromBoolean(v, this);
	}

	@Test
	final public void testBooleanCollection() {
		final Collection<Boolean> v = Arrays.asList(nextBoolean());
		setter.fromBoolean(v, this);
		checkValueBoolean(v.iterator().next());
	}

	@Test
	final public void testBooleanCollectionEmpty() {
		final Collection<Boolean> v = Arrays.asList();
		setter.fromBoolean(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	final public void testBooleanCollectionOverflow() {
		final Collection<Boolean> v = Arrays.asList(nextBoolean(), nextBoolean());
		setter.fromBoolean(v, this);
	}

	@Test
	final public void testBooleanList() {
		final List<Boolean> v = Arrays.asList(nextBoolean());
		setter.fromBoolean(v, this);
		checkValueBoolean(v.iterator().next());
	}

	@Test
	final public void testBooleanListEmpty() {
		final List<Boolean> v = Arrays.asList();
		setter.fromBoolean(v, this);
		checkValueNull();
	}

	@Test(expected = BinderException.class)
	final public void testBooleanListOverflow() {
		final List<Boolean> v = Arrays.asList(nextBoolean(), nextBoolean());
		setter.fromBoolean(v, this);
	}
}
