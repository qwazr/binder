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

import com.qwazr.binder.setter.FieldSetter;
import com.qwazr.utils.CollectionsUtils;
import com.qwazr.utils.RandomUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractMapSetterTest<K, V> extends AbstractTest {

	protected AbstractMapSetterTest(FieldSetter setter) {
		super(setter);
	}

	@Test
	public void testNull() {
		setter.setValue(this, null);
		Assert.assertNull(getValue());
	}

	@Test
	public void testSetMap() {
		final Map map = getRandomMap();
		setter.setValue(this, map);
		Assert.assertTrue(CollectionsUtils.equals(map, getValue()));
	}

	protected Map<K, V> getRandomMap() {
		final Map<K, V> map = getNewMap();
		for (int i = 2; i < RandomUtils.nextInt(3, 10); i++)
			map.put(getRandomKey(), getRandomValue());
		return map;
	}

	@Test
	public void testSetArray() {
		final Map<K, V> map = getRandomMap();
		final Object[] objects = new Object[map.size() * 2];
		final AtomicInteger i = new AtomicInteger();
		map.forEach((k, v) -> {
			objects[i.getAndIncrement()] = k;
			objects[i.getAndIncrement()] = v;
		});
		setter.setValue(this, objects);
		Assert.assertTrue(CollectionsUtils.equals(map, getValue()));
	}

	@Test
	public void testSetCollection() {
		final Map<K, V> map = getRandomMap();
		final List<Object> objects = new ArrayList<>(map.size() * 2);
		map.forEach((k, v) -> {
			objects.add(k);
			objects.add(v);
		});
		setter.setValue(this, objects);
		Assert.assertTrue(CollectionsUtils.equals(map, getValue()));
	}

	protected abstract Map<K, V> getNewMap();

	protected abstract K getRandomKey();

	protected abstract V getRandomValue();

	protected abstract Map<K, V> getValue();

	@Test
	public void checkIsMapSetter() {
		Assert.assertEquals(MapSetterImpl.class, setter.getClass());
	}

	public static class StringString extends AbstractMapSetterTest<String, String> {

		final Map<String, String> value = null;

		public StringString() throws NoSuchFieldException {
			super(FieldSetter.of(StringString.class.getDeclaredField("value")));
		}

		@Override
		protected Map<String, String> getNewMap() {
			return new HashMap<>();
		}

		@Override
		protected String getRandomKey() {
			return RandomUtils.alphanumeric(5);
		}

		@Override
		protected String getRandomValue() {
			return RandomUtils.alphanumeric(5);
		}

		@Override
		protected Map<String, String> getValue() {
			return value;
		}
	}
}
