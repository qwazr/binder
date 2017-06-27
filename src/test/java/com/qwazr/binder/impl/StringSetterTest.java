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

public class StringSetterTest extends AbstractSetterTest<String> {

	public StringSetterTest() {
		super(new StringSetterImpl(AbstractSetterTest.getValueField()));
	}

	@Override
	protected String nextString() {
		return RandomUtils.nextString();
	}

	@Override
	protected Number nextNumber() {
		return RandomUtils.nextDouble();
	}

	@Override
	protected void checkValueString(String next, String value) {
		Assert.assertEquals(next, value);
	}

	@Override
	protected void checkValueShort(Short next, String value) {
		Assert.assertEquals(next, Short.parseShort(value), 0);
	}

	@Override
	protected void checkValueLong(Long next, String value) {
		Assert.assertEquals(next, Long.parseLong(value), 0);
	}

	@Override
	protected void checkValueInteger(Integer next, String value) {
		Assert.assertEquals(next, Integer.parseInt(value), 0);
	}

	@Override
	protected void checkValueFloat(Float next, String value) {
		Assert.assertEquals(next, Float.parseFloat(value), 0);
	}

	@Override
	protected void checkValueDouble(Double next, String value) {
		Assert.assertEquals(next, Double.parseDouble(value), 0);
	}

	@Override
	protected void checkValueChar(Character next, String value) {
		Assert.assertEquals(Character.toString(next), value);
	}

	@Override
	protected void checkValueByte(Byte next, String value) {
		Assert.assertEquals(next, Byte.parseByte(value), 0);
	}

	@Override
	protected void checkValueBoolean(Boolean next, String value) {
		Assert.assertEquals(next, Boolean.parseBoolean(value));
	}

}
