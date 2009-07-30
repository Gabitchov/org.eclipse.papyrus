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
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.util;

import org.eclipse.core.runtime.AssertionFailedException;

/**
 * <code>Assert</code> is useful for for embedding runtime sanity checks in code. The predicate
 * methods all test a condition and throw some type of unchecked exception if the condition does not
 * hold.
 * <p>
 * Assertion failure exceptions, like most runtime exceptions, are thrown when something is
 * misbehaving. Assertion failures are invariably unspecified behavior; consequently, clients should
 * never rely on these being thrown (and certainly should not being catching them specifically).
 * </p>
 * <p>
 * This class is not intended to be instantiated or sub-classed by clients.
 * </p>
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
	 * Asserts that the given object is not <code>null</code>. If this is not the case, some kind of
	 * unchecked exception is thrown.
	 * 
	 * @param object
	 *            the value to test
	 */
	public static void isNotNull(Object object) {
		isNotNull(object, "");
	}

	/**
	 * Asserts that the given object is not <code>null</code>. If this is not the case, some kind of
	 * unchecked exception is thrown. The given message is included in that exception, to aid
	 * debugging.
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
