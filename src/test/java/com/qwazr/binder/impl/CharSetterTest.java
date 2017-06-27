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

public class CharSetterTest extends AbstractSetterTest<Character> {

	public CharSetterTest() {
		super(new CharSetterImpl(AbstractSetterTest.getValueField()));
	}

	@Override
	protected String nextString() {
		return Character.toString(RandomUtils.nextChar());
	}

	@Override
	protected Number nextNumber() {
		return (int) RandomUtils.nextChar();
	}

	@Override
	protected void checkValueString(String next, Character value) {
		Assert.assertEquals(next, value.toString());
	}

	@Override
	protected void checkValueShort(Short next, Character value) {
		Assert.assertEquals(next, value, 0);
	}

	@Override
	protected void checkValueLong(Long next, Character value) {
		Assert.assertEquals(next, value, 0);
	}

	@Override
	protected void checkValueInteger(Integer next, Character value) {
		Assert.assertEquals(next, value, 0);
	}

	@Override
	protected void checkValueFloat(Float next, Character value) {
		Assert.assertEquals(next, value, 0);
	}

	@Override
	protected void checkValueDouble(Double next, Character value) {
		Assert.assertEquals(next, value, 0);
	}

	@Override
	protected void checkValueChar(Character next, Character value) {
		Assert.assertEquals(next, value, 0);
	}

	@Override
	protected void checkValueByte(Byte next, Character value) {
		Assert.assertEquals(next, value, 0);
	}

	@Override
	protected void checkValueBoolean(Boolean next, Character value) {
		Assert.assertEquals(next ? 1 : 0, value, 0);
	}
}
