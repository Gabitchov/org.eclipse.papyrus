/*****************************************************************************
 * Copyright (c) 2012 Cedric Dumoulin.
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

package org.eclipse.papyrus.infra.core.serviceregistry;

import java.util.ArrayList;
import java.util.List;


/**
 * An exception used to gather multi exceptions encountered during declarations reading.
 * 
 * @author cedric dumoulin
 *
 */
public class DeclarationMultiException extends DeclarationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Throwable> errors;
	/**
	 * Constructor.
	 *
	 */
	public DeclarationMultiException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 */
	public DeclarationMultiException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 *
	 * @param cause
	 */
	public DeclarationMultiException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 * @param cause
	 */
	public DeclarationMultiException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DeclarationMultiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * Constructor.
	 *
	 * @param string
	 * @param warnings The warnings used to initialize this object. No clone is per
	 */
	public DeclarationMultiException(String string, List<Throwable> warnings) {
		this.errors = warnings;
	}

	/**
	 * Add a throwable to this list.
	 * 
	 * @param throwable
	 */
	public void addThrowable( Throwable throwable )  {
		if( errors == null) {
			errors = new ArrayList<Throwable>();
		}
		errors.add(throwable);
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if(errors == null) 
			return true;
		
		return errors.isEmpty();
	}
	
	/**
	 * 
	 * @see java.lang.Throwable#toString()
	 *
	 * @return
	 */
	@Override
	public String toString() {
		if( errors == null || errors.size()==0) {
		return super.toString();
		}
		
		StringBuffer buff = new StringBuffer(super.toString());
		for( Throwable error : errors) {
			buff.append("\n").append( error.getMessage() ); 
		}
		
		return buff.toString();
		
		
	}
}
