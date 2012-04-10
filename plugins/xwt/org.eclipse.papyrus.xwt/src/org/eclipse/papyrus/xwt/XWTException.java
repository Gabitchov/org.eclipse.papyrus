/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt;

public class XWTException extends RuntimeException {

	/**
	 * Copyright (c) 2006, 2010 Soyatec
	 */
	private static final long serialVersionUID = 7568262060419780948L;

	public XWTException(String message, Throwable cause) {
		super(message, cause);
	}

	public XWTException(String message) {
		super(message);
	}

	public XWTException(Throwable cause) {
		super(cause);
	}

	public XWTException() {
	}
}
