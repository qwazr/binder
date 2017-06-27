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

public class BooleanSetterTest extends AbstractSetterTest<Boolean> {

	public BooleanSetterTest() {
		super(new BooleanSetterImpl(AbstractSetterTest.getValueField()));
	}

	@Override
	protected String nextString() {
		return Boolean.toString(RandomUtils.nextBoolean());
	}

	@Override
	protected Number nextNumber() {
		return RandomUtils.nextBoolean() ? 1 : 0;
	}

	@Override
	protected void checkValueString(String next, Boolean value) {
		Assert.assertEquals(Boolean.parseBoolean(next), value);
	}

	@Override
	protected void checkValueShort(Short next, Boolean value) {
		Assert.assertEquals(next != 0, value);
	}

	@Override
	protected void checkValueLong(Long next, Boolean value) {
		Assert.assertEquals(next != 0, value);
	}

	@Override
	protected void checkValueInteger(Integer next, Boolean value) {
		Assert.assertEquals(next != 0, value);
	}

	@Override
	protected void checkValueFloat(Float next, Boolean value) {
		Assert.assertEquals(next != 0, value);
	}

	@Override
	protected void checkValueDouble(Double next, Boolean value) {
		Assert.assertEquals(next != 0, value);
	}

	@Override
	protected void checkValueChar(Character next, Boolean value) {
		Assert.assertEquals(next != 0, value);
	}

	@Override
	protected void checkValueByte(Byte next, Boolean value) {
		Assert.assertEquals(next != 0, value);
	}

	@Override
	protected void checkValueBoolean(Boolean next, Boolean value) {
		Assert.assertEquals(next, value);
	}
}
