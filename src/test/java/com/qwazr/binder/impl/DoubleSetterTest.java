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
@Suite.SuiteClasses({ DoubleSetterTest.FromString.class,
		DoubleSetterTest.FromShort.class,
		DoubleSetterTest.FromLong.class,
		DoubleSetterTest.FromInteger.class,
		DoubleSetterTest.FromFloat.class,
		DoubleSetterTest.FromDouble.class })
public class DoubleSetterTest {

	private static Supplier<String> nextString = () -> Double.toString(RandomUtils.nextDouble());
	private static DoubleSetterImpl doubleSetter = new DoubleSetterImpl(ObjectSetterAbstractTest.getValueField());

	public static class FromString extends FromStringAbstractTest<Double> {

		public FromString() {
			super(nextString, doubleSetter);
		}

		@Override
		protected void checkValue(String next, Double value) {
			Assert.assertEquals(Double.valueOf(next), value);
		}
	}

	public static class FromShort extends FromShortAbstractTest<Double> {

		public FromShort() {
			super(doubleSetter);
		}

		@Override
		protected void checkValue(Short next, Double value) {
			Assert.assertEquals(next, value.shortValue(), 0);
		}
	}

	public static class FromLong extends FromLongAbstractTest<Double> {

		public FromLong() {
			super(doubleSetter);
		}

		@Override
		protected void checkValue(Long next, Double value) {
			Assert.assertEquals(next, value.longValue(), 0);
		}
	}

	public static class FromInteger extends FromIntegerAbstractTest<Double> {

		public FromInteger() {
			super(doubleSetter);
		}

		@Override
		protected void checkValue(Integer next, Double value) {
			Assert.assertEquals(next, value.intValue(), 0);
		}
	}

	public static class FromFloat extends FromFloatAbstractTest<Double> {

		public FromFloat() {
			super(doubleSetter);
		}

		@Override
		protected void checkValue(Float next, Double value) {
			Assert.assertEquals(next, value.floatValue(), 0);
		}
	}

	public static class FromDouble extends FromDoubleAbstractTest<Double> {

		public FromDouble() {
			super(doubleSetter);
		}

		@Override
		protected void checkValue(Double next, Double value) {
			Assert.assertEquals(next, value, 0);
		}
	}

}
