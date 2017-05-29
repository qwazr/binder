/**
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
package com.qwazr.binder.setter;

public interface ObjectSetter {

	void fromString(String value, Object object);

	void fromDouble(Double value, Object object);

	void fromFloat(Float value, Object object);

	void fromLong(Long value, Object object);

	void fromInteger(Integer value, Object object);

	void fromShort(Short value, Object object);

	void fromChar(Character value, Object object);

	void fromByte(Byte value, Object object);

	void fromBoolean(Boolean value, Object object);

}
