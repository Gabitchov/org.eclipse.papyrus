/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Initial API and implementation
 * 	Manuel Giles	 giles.manu@live.fr		 - Initial API and implementation
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Idea of the java generator project & help for the conception 
 *
 *****************************************************************************/

package org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor;

public class JDTVisitorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JDTVisitorException() {
		super();
	}

	public JDTVisitorException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public JDTVisitorException(String arg0) {
		super(arg0);
	}

	public JDTVisitorException(Throwable arg0) {
		super(arg0);
	}

}
