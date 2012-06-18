/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.tools.util;

import java.lang.reflect.Method;

/**
 * 
 * This helper provides methods to get methods reflectively
 * It is not the better way to access to method, but sometimes it can be interested to avoid to duplicate
 * lot of code
 * 
 */
public class ReflectHelper {

	/**
	 * 
	 * Should not be instantiated
	 * 
	 */
	private ReflectHelper() {
		// prevents instantiation
	}

	/**
	 * Warning : each call of this method should be tested with a JUnit test, in order to know
	 * when the API has changed
	 * 
	 * @param aClass
	 *        a class
	 * @param methodName
	 *        the name of the method to find
	 * @param parameterTypes
	 *        an array owning the type of the parameters of the called method
	 * @return
	 *         the wanted method
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static Method getMethod(final Class<?> aClass, final String methodName, Class<?>[] parameterTypes) throws SecurityException, NoSuchMethodException {
		Method m = null;
		m = aClass.getDeclaredMethod(methodName, parameterTypes);
		m.setAccessible(true);
		return m;
	}
}
