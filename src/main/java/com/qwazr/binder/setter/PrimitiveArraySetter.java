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
package com.qwazr.binder.setter;

public interface PrimitiveArraySetter extends ErrorSetter {

	void fromDouble(double[] values, Object object);

	void fromFloat(float[] values, Object object);

	void fromLong(long[] values, Object object);

	void fromInteger(int[] values, Object object);

	void fromShort(short[] values, Object object);

	void fromChar(char[] values, Object object);

	void fromByte(byte[] values, Object object);

	void fromBoolean(boolean[] values, Object object);

	default void fromPrimitiveArray(Class<?> type, Object values, Object object) {
		if (type == double.class) {
			fromDouble((double[]) values, object);
		} else if (type == float.class) {
			fromFloat((float[]) values, object);
		} else if (type == long.class) {
			fromLong((long[]) values, object);
		} else if (type == int.class) {
			fromInteger((int[]) values, object);
		} else if (type == short.class) {
			fromShort((short[]) values, object);
		} else if (type == char.class) {
			fromChar((char[]) values, object);
		} else if (type == byte.class) {
			fromByte((byte[]) values, object);
		} else if (type == boolean.class) {
			fromBoolean((boolean[]) values, object);
		} else
			throw error("Unsupported primitive type: " + type, values);
	}
}
