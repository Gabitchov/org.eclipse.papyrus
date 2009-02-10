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
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.core.multidiagram;

/**
 * Root Exception for the SashDiagram model.
 * 
 * @author dumoulin
 * 
 */
public class SashDiagramModelException extends Exception {

	/**
	 * Constructor.
	 */
	public SashDiagramModelException() {
	}

	/**
	 * Constructor.
	 * 
	 * @param message
	 */
	public SashDiagramModelException(String message) {
		super(message);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 */
	public SashDiagramModelException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param message
	 * @param cause
	 */
	public SashDiagramModelException(String message, Throwable cause) {
		super(message, cause);
	}

}
