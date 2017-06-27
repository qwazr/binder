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
import org.junit.Ignore;

@Ignore
public class ShortSetterTest extends AbstractSetterTest<Short> {

	public ShortSetterTest() {
		super(new ShortSetterImpl(AbstractSetterTest.getValueField()));
	}

	@Override
	protected String nextString() {
		return Float.toString(RandomUtils.nextShort());
	}

	@Override
	protected void checkValueString(String next, Short value) {
		Assert.assertEquals(Float.valueOf(next), value);
	}

	@Override
	protected void checkValueShort(Short next, Short value) {
		Assert.assertEquals(next, value, 0);
	}

	@Override
	protected void checkValueLong(Long next, Short value) {
		Assert.assertEquals(next, value.longValue(), 0);
	}

	@Override
	protected void checkValueInteger(Integer next, Short value) {
		Assert.assertEquals(next, value.intValue(), 0);
	}

	@Override
	protected void checkValueFloat(Float next, Short value) {
		Assert.assertEquals(next, value.floatValue(), 0);
	}

	@Override
	protected void checkValueDouble(Double next, Short value) {
		Assert.assertEquals(next, value.doubleValue(), 0);
	}

	@Override
	protected void checkValueChar(Character next, Short value) {
		Assert.assertEquals(next, value, 0);
	}

	@Override
	protected void checkValueByte(Byte next, Short value) {
		Assert.assertEquals(next, value.byteValue(), 0);
	}

	@Override
	protected void checkValueBoolean(Boolean next, Short value) {
		Assert.assertEquals(next ? 1 : 0, value, 0);
	}
}
