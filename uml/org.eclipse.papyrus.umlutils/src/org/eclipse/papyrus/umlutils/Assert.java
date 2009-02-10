/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import org.eclipse.core.runtime.AssertionFailedException;

/**
 * <code>Assert</code> is useful for embedding checks in code.
 * 
 * @author Remi SCHNEKENBURGER
 */
public class Assert {

	/* This class is not intended to be instantiated. */
	/**
     * 
     */
	private Assert() {
		// not allowed
	}

	/**
	 * Asserts that the given object is a strict instance of the given class.<br>
	 * Useful for UML2, when user want to check for example that an element is a class and not an activity.
	 * 
	 * @param object
	 *            the object to test
	 * @param class_
	 *            the class to check
	 * 
	 * @return <code>true</code> if the object is a strict instance of class_
	 */
	public static boolean isStrictInstanceOf(Object object, java.lang.Class class_) {
		return object.getClass().equals(class_);
	}

	/**
	 * Asserts that the given string is not empty.
	 * 
	 * @param string
	 *            the string to test
	 */
	public static void isNotEmptyString(String string) {
		isNotEmptyString(string, "");
	}

	/**
	 * Asserts that the given string is not empty The given message is included in that exception, to help debugging.
	 * 
	 * @param string
	 *            the string to test
	 * @param message
	 *            the message to include in the exception
	 */
	public static void isNotEmptyString(String string, String message) {
		if (string.equals("")) {
			throw new AssertionFailedException("empty String: " + message);
		}
	}

	/**
	 * Asserts that the given object is not <code>null</code>. If this is not the case, some kind of unchecked exception is thrown.
	 * 
	 * @param object
	 *            the value to test
	 */
	public static void isNotNull(Object object) {
		isNotNull(object, "");
	}

	/**
	 * Asserts that the given object is not <code>null</code>. If this is not the case, some kind of unchecked exception is thrown. The given message is included in that exception, to aid debugging.
	 * 
	 * @param object
	 *            the value to test
	 * @param message
	 *            the message to include in the exception
	 */
	public static void isNotNull(Object object, String message) {
		if (object == null) {
			throw new AssertionFailedException("null argument:" + message);
		}
	}
}
