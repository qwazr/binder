/*
 * Copyright 2016-2017 Emmanuel Keller / QWAZR
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
package com.qwazr.binder;

import com.qwazr.utils.AnnotationsUtils;
import com.qwazr.utils.CollectionsUtils;
import com.qwazr.utils.RandomUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FieldMapWrapperTest {

	private static FieldMapWrappers wrappers;
	private static FieldMapWrapper<Record> wrapper;

	@Test
	public void test100createWrapper() {
		wrappers = new FieldMapWrappers();
		wrapper = wrappers.get(Record.class);
		Assert.assertNotNull(wrapper);
	}

	@Test
	public void test200newMap() {
		Record record = new Record(RandomUtils.nextLong(), RandomUtils.alphanumeric(10), RandomUtils.nextDouble(),
				RandomUtils.alphanumeric(3), RandomUtils.alphanumeric(3));
		Map<String, Object> map = wrapper.newMap(record);
		Assert.assertNotNull(map);
		Assert.assertEquals(record, map);
	}

	@Test
	public void test300newMapCollection() {
		Record record1 = new Record(RandomUtils.nextLong(), RandomUtils.alphanumeric(10), RandomUtils.nextDouble(),
				RandomUtils.alphanumeric(3), RandomUtils.alphanumeric(3));
		Record record2 = new Record(RandomUtils.nextLong(), RandomUtils.alphanumeric(10), RandomUtils.nextDouble(),
				RandomUtils.alphanumeric(3), RandomUtils.alphanumeric(3));
		List<Map<String, Object>> mapCollection = wrapper.newMapCollection(Arrays.asList(record1, record2));
		Assert.assertNotNull(mapCollection);
		Assert.assertEquals(2, mapCollection.size());
		Assert.assertEquals(record1, mapCollection.get(0));
		Assert.assertEquals(record2, mapCollection.get(1));
	}

	@Test
	public void test400newMapArray() {
		Record record = new Record(RandomUtils.nextLong(), RandomUtils.alphanumeric(10), RandomUtils.nextDouble(),
				RandomUtils.alphanumeric(3), RandomUtils.alphanumeric(3));
		Map<String, Object> map = wrapper.newMap(record);
		Assert.assertNotNull(map);
		Assert.assertEquals(record.title, map.get("title"));
		Assert.assertEquals(record.id, map.get("id"));
	}

	private Map<String, Object> getRandom() {
		Map<String, Object> map = new HashMap<>();
		map.put("id", RandomUtils.nextLong());
		map.put("title", RandomUtils.alphanumeric(10));
		map.put("price", RandomUtils.nextDouble());
		return map;
	}

	@Test
	public void test500toRecord() throws ReflectiveOperationException, IOException {
		Map map = getRandom();
		Record record = wrapper.toRecord(map);
		Assert.assertNotNull(record);
		Assert.assertEquals(record, map);
	}

	@Test
	public void test501toRecordStringToCollection() throws ReflectiveOperationException, IOException {
		Map map = getRandom();
		map.put("tags", RandomUtils.alphanumeric(5));
		Record record = wrapper.toRecord(map);
		Assert.assertNotNull(record);
		Assert.assertEquals(record, map);
	}

	@Test
	public void test502toRecordCollectionToCollection() throws ReflectiveOperationException, IOException {
		Map map = getRandom();
		map.put("tags", Arrays.asList(RandomUtils.alphanumeric(5), RandomUtils.alphanumeric(5)));
		Record record = wrapper.toRecord(map);
		Assert.assertNotNull(record);
		Assert.assertEquals(record, map);
	}

	@Test
	public void test503toRecordArrayToCollection() throws ReflectiveOperationException, IOException {
		Map map = getRandom();
		map.put("tags", new String[] { RandomUtils.alphanumeric(5), RandomUtils.alphanumeric(5) });
		Record record = wrapper.toRecord(map);
		Assert.assertNotNull(record);
		Assert.assertEquals(record, map);
	}

	@Test
	public void test600collectionToRecords() throws IOException, ReflectiveOperationException {
		Map<String, Object> map1 = getRandom();
		Map<String, Object> map2 = getRandom();
		List<Record> records = wrapper.toRecords(Arrays.asList(map1, map2));
		Assert.assertNotNull(records);
		Assert.assertEquals(2, records.size());
		Assert.assertEquals(records.get(0), map1);
		Assert.assertEquals(records.get(1), map2);
	}

	@Test
	public void test700arrayToRecords() throws IOException, ReflectiveOperationException {
		Map<String, Object> map1 = getRandom();
		Map<String, Object> map2 = getRandom();
		List<Record> records = wrapper.toRecords(map1, map2);
		Assert.assertNotNull(records);
		Assert.assertEquals(2, records.size());
		Assert.assertEquals(records.get(0), map1);
		Assert.assertEquals(records.get(1), map2);
	}

	@Test
	public void test801cacheClear() {
		Assert.assertEquals(wrapper, wrappers.get(Record.class));
		wrappers.clear();
		Assert.assertNotEquals(wrapper, wrappers.get(Record.class));
	}

	public static class Record {

		final Long id;
		final String title;
		final Double price;
		final LinkedHashSet<String> tags;

		Record(Long id, String title, Double price, String... tags) {
			this.id = id;
			this.title = title;
			this.price = price;
			if (tags == null || tags.length == 0)
				this.tags = null;
			else {
				this.tags = new LinkedHashSet<>();
				Collections.addAll(this.tags, tags);
			}
		}

		public Record() {
			this(null, null, null);
		}

		@Override
		public boolean equals(Object object) {
			if (object == null)
				return false;
			if (object instanceof Record) {
				Record r = (Record) object;
				return Objects.equals(id, r.id) && Objects.equals(title, r.title) && CollectionsUtils.equals(tags,
						r.tags);
			}
			if (object instanceof Map) {
				Map m = (Map) object;
				if (!Objects.equals(id, m.get("id")) && Objects.equals(title, m.get("title")))
					return false;
				Object mtags = m.get("tags");
				if (mtags == null)
					return tags == null || tags.isEmpty();
				if (mtags instanceof Collection)
					return CollectionsUtils.equals(tags, (Collection) mtags);
				if (mtags instanceof String)
					return tags.size() == 1 && tags.iterator().next().equals(mtags);
				return CollectionsUtils.equals(tags, (String[]) mtags);

			}
			return false;
		}

	}

	public static class FieldMapWrappers extends FieldMapWrapper.Cache {

		public FieldMapWrappers() {
			super(new HashMap<>());
		}

		@Override
		protected <C> FieldMapWrapper<C> newFieldMapWrapper(Class<C> objectClass) throws NoSuchMethodException {
			final Map<String, Field> fieldMap = new HashMap<>();
			AnnotationsUtils.browseFieldsRecursive(objectClass, field -> {
				field.setAccessible(true);
				fieldMap.put(field.getName(), field);
			});
			return new FieldMapWrapper<>(fieldMap, objectClass);
		}
	}
}
