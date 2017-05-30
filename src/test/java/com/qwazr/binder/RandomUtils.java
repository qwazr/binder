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
package com.qwazr.binder;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtils extends org.apache.commons.lang3.RandomUtils {

	public static String nextString() {
		return RandomStringUtils.randomAlphabetic(nextInt(5, 15));
	}

	public static short nextShort() {
		return (short) nextInt(0, Short.MAX_VALUE);
	}

	public static char nextChar() {
		return RandomStringUtils.randomAlphanumeric(1).charAt(0);
	}
}
