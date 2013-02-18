/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
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

package org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query;

/**
 * Root Exception of the query package
 * 
 * @author cedric dumoulin
 * 
 */
public class QueryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 */
	public QueryException() {
	}

	/**
	 * Constructor.
	 * 
	 * @param arg0
	 */
	public QueryException(String arg0) {
		super(arg0);
	}

	/**
	 * Constructor.
	 * 
	 * @param arg0
	 */
	public QueryException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * Constructor.
	 * 
	 * @param arg0
	 * @param arg1
	 */
	public QueryException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Constructor.
	 * 
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public QueryException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1);//, arg2, arg3);
	}

}
