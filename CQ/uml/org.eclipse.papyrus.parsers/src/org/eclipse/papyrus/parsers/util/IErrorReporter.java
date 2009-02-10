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

/**
 * Interface that should be implemented by parsers and lexers that exports error messages to somewhere else the System out stream.
 */
public interface IErrorReporter {

	/**
	 * Reports an error
	 * 
	 * @param error
	 *            the error to report
	 */
	void reportError(String error);
}
