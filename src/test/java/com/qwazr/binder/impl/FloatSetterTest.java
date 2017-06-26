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
@Suite.SuiteClasses({ FloatSetterTest.FromString.class,
		FloatSetterTest.FromShort.class,
		FloatSetterTest.FromLong.class,
		FloatSetterTest.FromInteger.class,
		FloatSetterTest.FromFloat.class,
		FloatSetterTest.FromDouble.class })
public class FloatSetterTest {

	private static Supplier<String> nextString = () -> Float.toString(RandomUtils.nextFloat());
	private static FloatSetterImpl floatSetter = new FloatSetterImpl(ObjectSetterAbstractTest.getValueField());

	public static class FromString extends FromStringAbstractTest<Float> {

		public FromString() {
			super(nextString, floatSetter);
		}

		@Override
		protected void checkValue(String next, Float value) {
			Assert.assertEquals(Float.valueOf(next), value);
		}
	}

	public static class FromShort extends FromShortAbstractTest<Float> {

		public FromShort() {
			super(floatSetter);
		}

		@Override
		protected void checkValue(Short next, Float value) {
			Assert.assertEquals(next, value.shortValue(), 0);
		}
	}

	public static class FromLong extends FromLongAbstractTest<Float> {

		public FromLong() {
			super(floatSetter);
		}

		@Override
		protected void checkValue(Long next, Float value) {
			Assert.assertEquals(next, value.longValue(), 0);
		}
	}

	public static class FromInteger extends FromIntegerAbstractTest<Float> {

		public FromInteger() {
			super(floatSetter);
		}

		@Override
		protected void checkValue(Integer next, Float value) {
			Assert.assertEquals(next, value.intValue(), 0);
		}
	}

	public static class FromFloat extends FromFloatAbstractTest<Float> {

		public FromFloat() {
			super(floatSetter);
		}

		@Override
		protected void checkValue(Float next, Float value) {
			Assert.assertEquals(next, value, 0);
		}
	}

	public static class FromDouble extends FromDoubleAbstractTest<Float> {

		public FromDouble() {
			super(floatSetter);
		}

		@Override
		protected void checkValue(Double next, Float value) {
			Assert.assertEquals(next.floatValue(), value, 0);
		}
	}

}
