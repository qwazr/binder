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

import com.qwazr.binder.RandomUtils;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.util.function.Supplier;

@RunWith(Suite.class)
@Suite.SuiteClasses({ StringSetterTest.FromString.class,
		StringSetterTest.FromShort.class,
		StringSetterTest.FromLong.class,
		StringSetterTest.FromInteger.class,
		StringSetterTest.FromFloat.class,
		StringSetterTest.FromDouble.class,
		StringSetterTest.FromChar.class,
		StringSetterTest.FromByte.class,
		StringSetterTest.FromBoolean.class })
public class StringSetterTest {

	private static Supplier<String> nextString = RandomUtils::nextString;
	private static StringSetterImpl stringSetter = new StringSetterImpl(ObjectSetterAbstractTest.getValueField());

	public static class FromString extends FromStringAbstractTest<String> {

		public FromString() {
			super(nextString, stringSetter);
		}

		@Override
		protected void checkValue(String next, String value) {
			Assert.assertEquals(next, value);
		}
	}

	public static class FromShort extends FromShortAbstractTest<String> {

		public FromShort() {
			super(stringSetter);
		}

		@Override
		protected void checkValue(Short next, String value) {
			Assert.assertEquals(next, Short.parseShort(value), 0);
		}
	}

	public static class FromLong extends FromLongAbstractTest<String> {

		public FromLong() {
			super(stringSetter);
		}

		@Override
		protected void checkValue(Long next, String value) {
			Assert.assertEquals(next, Long.parseLong(value), 0);
		}
	}

	public static class FromInteger extends FromIntegerAbstractTest<String> {

		public FromInteger() {
			super(stringSetter);
		}

		@Override
		protected void checkValue(Integer next, String value) {
			Assert.assertEquals(next, Integer.parseInt(value), 0);
		}
	}

	public static class FromFloat extends FromFloatAbstractTest<String> {

		public FromFloat() {
			super(stringSetter);
		}

		@Override
		protected void checkValue(Float next, String value) {
			Assert.assertEquals(next, Float.parseFloat(value), 0);
		}
	}

	public static class FromDouble extends FromDoubleAbstractTest<String> {

		public FromDouble() {
			super(stringSetter);
		}

		@Override
		protected void checkValue(Double next, String value) {
			Assert.assertEquals(next, Double.parseDouble(value), 0);
		}
	}

	public static class FromChar extends FromCharAbstractTest<String> {

		public FromChar() {
			super(stringSetter);
		}
	}

	public static class FromByte extends FromByteAbstractTest<String> {

		public FromByte() {
			super(stringSetter);
		}
	}

	public static class FromBoolean extends FromBooleanAbstractTest<String> {

		public FromBoolean() {
			super(stringSetter);
		}
	}

}
