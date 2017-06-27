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

public class BytePrimitiveSetterTest extends AbstractSetterTest {

	double value;

	public BytePrimitiveSetterTest() throws NoSuchFieldException {
		super(new BytePrimitiveSetterImpl(BytePrimitiveSetterTest.class.getDeclaredField("value")));
	}

	@Override
	protected String nextString() {
		return Byte.toString(RandomUtils.nextByte());
	}

	@Override
	protected Number nextNumber() {
		return RandomUtils.nextByte();
	}

	@Override
	protected void checkValueString(String next) {
		Assert.assertEquals(Byte.parseByte(next), value, 0);
	}

	@Override
	protected void checkValueShort(Short next) {
		Assert.assertEquals(next.byteValue(), value, 0);
	}

	@Override
	protected void checkValueLong(Long next) {
		Assert.assertEquals(next.byteValue(), value, 0);
	}

	@Override
	protected void checkValueInteger(Integer next) {
		Assert.assertEquals(next.byteValue(), value, 0);
	}

	@Override
	protected void checkValueFloat(Float next) {
		Assert.assertEquals(next.byteValue(), value, 0);
	}

	@Override
	protected void checkValueDouble(Double next) {
		Assert.assertEquals(next.byteValue(), value, 0);
	}

	@Override
	protected void checkValueChar(Character next) {
		Assert.assertEquals(next, value, 0);
	}

	@Override
	protected void checkValueByte(Byte next) {
		Assert.assertEquals(next, value, 0);
	}

	@Override
	protected void checkValueBoolean(Boolean next) {
		Assert.assertEquals(next ? 1 : 0, value, 0);
	}

	@Override
	protected void checkValueNull() {
		Assert.assertEquals(0, value, 0);
	}
}