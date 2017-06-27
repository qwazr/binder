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

import com.qwazr.utils.RandomUtils;
import org.junit.Assert;
import org.junit.Ignore;

@Ignore
public class StringCollectionSetterTest extends AbstractCollectionSetterTest<String> {

	public StringCollectionSetterTest() throws NoSuchFieldException {
		super(new StringCollectionSetterImpl(AbstractCollectionSetterTest.class.getDeclaredField("value")));
	}

	@Override
	protected String nextString() {
		return RandomUtils.alphanumeric(10);
	}

	@Override
	protected Number nextNumber() {
		return RandomUtils.nextDouble();
	}

	@Override
	protected void checkValueString(String next) {
		Assert.assertEquals(value.iterator().next(), next);
	}

	@Override
	protected void checkValueShort(Short next) {
		Assert.assertEquals(value.iterator().next(), next.toString());
	}

	@Override
	protected void checkValueLong(Long next) {
		Assert.assertEquals(value.iterator().next(), next.toString());
	}

	@Override
	protected void checkValueInteger(Integer next) {
		Assert.assertEquals(value.iterator().next(), next.toString());
	}

	@Override
	protected void checkValueFloat(Float next) {
		Assert.assertEquals(value.iterator().next(), next.toString());
	}

	@Override
	protected void checkValueDouble(Double next) {
		Assert.assertEquals(value.iterator().next(), next.toString());
	}

	@Override
	protected void checkValueChar(Character next) {
		Assert.assertEquals(value.iterator().next(), next.toString());
	}

	@Override
	protected void checkValueByte(Byte next) {
		Assert.assertEquals(value.iterator().next(), next.toString());
	}

	@Override
	protected void checkValueBoolean(Boolean next) {
		Assert.assertEquals(value.iterator().next(), next.toString());
	}

	@Override
	protected void checkValueNull() {
		Assert.assertNull(value);
	}

	@Override
	protected void checkValuesShort(short... v) {

	}

	@Override
	protected void checkValuesLong(long... v) {

	}

	@Override
	protected void checkValuesInteger(int... v) {

	}

	@Override
	protected void checkValuesFloat(float... v) {

	}

	@Override
	protected void checkValuesDouble(double... v) {

	}

	@Override
	protected void checkValuesChar(char... v) {

	}

	@Override
	protected void checkValuesByte(byte... v) {

	}

	@Override
	protected void checkValuesBoolean(boolean... v) {

	}
}
