package com.qwazr.binder.setter;

import com.qwazr.binder.BinderException;

/**
 * Created by ekeller on 30/06/2017.
 */
public interface ErrorSetter {

	BinderException error(final String msg, final Object value);

}
