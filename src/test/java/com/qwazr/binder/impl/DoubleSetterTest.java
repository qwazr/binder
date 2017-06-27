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

public class DoubleSetterTest extends AbstractSetterTest<Double> {

	public DoubleSetterTest() {
		super(new DoubleSetterImpl(AbstractSetterTest.getValueField()));
	}

	protected String nextString() {
		return Double.toString(RandomUtils.nextDouble());
	}

	@Override
	protected void checkValueString(String next, Double value) {
		Assert.assertEquals(Double.valueOf(next), value);
	}

	@Override
	protected void checkValueShort(Short next, Double value) {
		Assert.assertEquals(next, value.shortValue(), 0);
	}

	@Override
	protected void checkValueLong(Long next, Double value) {
		Assert.assertEquals(next, value.longValue(), 0);
	}

	@Override
	protected void checkValueInteger(Integer next, Double value) {
		Assert.assertEquals(next, value.intValue(), 0);
	}

	@Override
	protected void checkValueFloat(Float next, Double value) {
		Assert.assertEquals(next, value.floatValue(), 0);
	}

	@Override
	protected void checkValueDouble(Double next, Double value) {
		Assert.assertEquals(next, value, 0);
	}

	@Override
	protected void checkValueChar(Character next, Double value) {
		Assert.assertEquals(next, value, 0);
	}

	@Override
	protected void checkValueByte(Byte next, Double value) {
		Assert.assertEquals(next, value.byteValue(), 0);
	}

	@Override
	protected void checkValueBoolean(Boolean next, Double value) {
		Assert.assertEquals(next ? 1 : 0, value, 0);
	}

}
