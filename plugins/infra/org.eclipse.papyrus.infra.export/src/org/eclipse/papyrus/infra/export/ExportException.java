/*******************************************************************************
 * Copyright (c) 2005 Anyware Technologies
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.infra.export;

/**
 * Exception raised during an image export
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ExportException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5787608979737224951L;

	/**
	 * Constructor
	 */
	public ExportException() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public ExportException(String message) {
		super(message);
	}

	/**
	 * Constructor
	 * 
	 * @param cause
	 */
	public ExportException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 * @param cause
	 */
	public ExportException(String message, Throwable cause) {
		super(message, cause);
	}

}
