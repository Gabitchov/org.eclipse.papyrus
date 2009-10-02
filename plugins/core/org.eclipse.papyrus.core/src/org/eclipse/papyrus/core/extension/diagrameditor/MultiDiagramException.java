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
package org.eclipse.papyrus.core.extension.diagrameditor;

/**
 * Root Exception of MultiDiagram exception
 * 
 * @author dumoulin
 * 
 */
@SuppressWarnings("serial")
public class MultiDiagramException extends Exception {

	/**
	 * 
	 */
	public MultiDiagramException() {
	}

	/**
	 * @param arg0
	 */
	public MultiDiagramException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public MultiDiagramException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public MultiDiagramException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
