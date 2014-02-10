/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 */
package org.eclipse.emf.facet.efacet.core.internal.exception;

import org.eclipse.emf.facet.efacet.core.exception.FacetManagerException;

/**
 * This exception is raised when an IOException is caught when trying to save a structural feature instance model 
 * @since 0.2
 */
public class SaveStructuralFeatureInstanceModelException extends
		FacetManagerException {
	
	private static final long serialVersionUID = 7024009106572531846L;

	/** 
	* Creates a new instance of UnmatchingExpectedTypeException 
	* with {@link Throwable} the exception at the origin of this exception 
	*/  
	public SaveStructuralFeatureInstanceModelException(final Throwable cause) {  
		super(cause); 
	} 
	
	/** 
	* Creates a new instance of UnmatchingExpectedTypeException 
	* with {@link Throwable} the exception at the origin of this exception 
	*/  
	public SaveStructuralFeatureInstanceModelException(final String message) {  
		super(message); 
	} 
}
