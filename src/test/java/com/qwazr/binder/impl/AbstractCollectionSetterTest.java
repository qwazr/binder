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

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractCollectionSetterTest<T> extends AbstractSetterTest {

	Collection<T> value;

	protected AbstractCollectionSetterTest(FieldSetterAbstract setter) {
		super(setter);
	}
	
	protected abstract void checkValuesShort(short... v);

	protected abstract void checkValuesLong(long... v);

	protected abstract void checkValuesInteger(int... v);

	protected abstract void checkValuesFloat(float... v);

	protected abstract void checkValuesDouble(double... v);

	protected abstract void checkValuesChar(char... v);

	protected abstract void checkValuesByte(byte... v);

	protected abstract void checkValuesBoolean(boolean... v);

	private <V> void checkValuesObject(V... values) {
		Assert.assertEquals(values.length, value.size());
		Iterator<T> iterator = value.iterator();
		for (V v : values)
			Assert.assertEquals(v, iterator.next());
	}

	private <V> void checkValuesObject(Collection<V> values) {
		Assert.assertEquals(values.size(), value.size());
		Iterator<T> iterator = value.iterator();
		for (V v : values)
			Assert.assertEquals(v, iterator.next());
	}

	@Test
	final public void testStringCollectionMultiple() {
		final Collection<String> v = Arrays.asList(nextString(), nextString());
		setter.fromString(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testStringListMultiple() {
		final List<String> v = Arrays.asList(nextString(), nextString());
		setter.fromString(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testShortPrimitiveArrayMultiple() {
		final short[] v = new short[] { nextShort(), nextShort() };
		setter.fromShort(v, this);
		checkValuesShort(v);
	}

	@Test
	final public void testShortArrayMultiple() {
		final Short[] v = new Short[] { nextShort(), nextShort() };
		setter.fromShort(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testShortCollectionMultiple() {
		final Collection<Short> v = Arrays.asList(nextShort(), nextShort());
		setter.fromShort(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testShortListMultiple() {
		final List<Short> v = Arrays.asList(nextShort(), nextShort());
		setter.fromShort(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testLongPrimitiveArrayMultiple() {
		final long[] v = new long[] { nextLong(), nextLong() };
		setter.fromLong(v, this);
		checkValuesLong(v);
	}

	@Test
	final public void testLongArrayMultiple() {
		final Long[] v = new Long[] { nextLong(), nextLong() };
		setter.fromLong(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testLongCollectionMultiple() {
		final Collection<Long> v = Arrays.asList(nextLong(), nextLong());
		setter.fromLong(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testLongListMultiple() {
		final List<Long> v = Arrays.asList(nextLong(), nextLong());
		setter.fromLong(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testIntegerPrimitiveArrayMultiple() {
		final int[] v = new int[] { nextInt(), nextInt() };
		setter.fromInteger(v, this);
		checkValuesInteger(v);
	}

	@Test
	final public void testIntegerArrayMultiple() {
		final Integer[] v = new Integer[] { nextInt(), nextInt() };
		setter.fromInteger(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testIntegerCollectionMultiple() {
		final Collection<Integer> v = Arrays.asList(nextInt(), nextInt());
		setter.fromInteger(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testIntegerListMultiple() {
		final List<Integer> v = Arrays.asList(nextInt(), nextInt());
		setter.fromInteger(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testFloatPrimitiveArrayMultiple() {
		final float[] v = new float[] { nextFloat(), nextFloat() };
		setter.fromFloat(v, this);
		checkValuesFloat(v);
	}

	@Test
	final public void testFloatArrayMultiple() {
		final Float[] v = new Float[] { nextFloat(), nextFloat() };
		setter.fromFloat(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testFloatCollectionMultiple() {
		final Collection<Float> v = Arrays.asList(nextFloat(), nextFloat());
		setter.fromFloat(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testFloatListMultiple() {
		final List<Float> v = Arrays.asList(nextFloat(), nextFloat());
		setter.fromFloat(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testDoublePrimitiveArrayMultiple() {
		final double[] v = new double[] { nextDouble(), nextDouble() };
		setter.fromDouble(v, this);
		checkValuesDouble(v);
	}

	@Test
	final public void testDoubleArrayMultiple() {
		final Double[] v = new Double[] { nextDouble(), nextDouble() };
		setter.fromDouble(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testDoubleCollectionMultiple() {
		final Collection<Double> v = Arrays.asList(nextDouble(), nextDouble());
		setter.fromDouble(v, this);
		checkValuesObject(v);
	}

	final public void testDoubleListMultiple() {
		final List<Double> v = Arrays.asList(nextDouble(), nextDouble());
		setter.fromDouble(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testCharPrimitiveArrayMultiple() {
		final char[] v = new char[] { nextChar(), nextChar() };
		setter.fromChar(v, this);
		checkValuesChar(v);
	}

	@Test
	final public void testCharArrayMultiple() {
		final Character[] v = new Character[] { nextChar(), nextChar() };
		setter.fromChar(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testCharCollectionMultiple() {
		final Collection<Character> v = Arrays.asList(nextChar(), nextChar());
		setter.fromChar(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testCharListMultiple() {
		final List<Character> v = Arrays.asList(nextChar(), nextChar());
		setter.fromChar(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testBytePrimitiveArrayMultiple() {
		final byte[] v = new byte[] { nextByte(), nextByte() };
		setter.fromByte(v, this);
		checkValuesByte(v);
	}

	@Test
	final public void testByteArrayMultiple() {
		final Byte[] v = new Byte[] { nextByte(), nextByte() };
		setter.fromByte(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testByteCollectionMultiple() {
		final Collection<Byte> v = Arrays.asList(nextByte(), nextByte());
		setter.fromByte(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testByteListMultiple() {
		final List<Byte> v = Arrays.asList(nextByte(), nextByte());
		setter.fromByte(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testBooleanPrimitiveArrayMultiple() {
		final boolean[] v = new boolean[] { nextBoolean(), nextBoolean() };
		setter.fromBoolean(v, this);
		checkValuesBoolean(v);
	}

	@Test
	final public void testBooleanArrayMultiple() {
		final Boolean[] v = new Boolean[] { nextBoolean(), nextBoolean() };
		setter.fromBoolean(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testBooleanCollectionMultiple() {
		final Collection<Boolean> v = Arrays.asList(nextBoolean(), nextBoolean());
		setter.fromBoolean(v, this);
		checkValuesObject(v);
	}

	@Test
	final public void testBooleanListMultiple() {
		final List<Boolean> v = Arrays.asList(nextBoolean(), nextBoolean());
		setter.fromBoolean(v, this);
		checkValuesObject(v);
	}
}
