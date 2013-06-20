/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.transformations;

/**
 * Variant of the transformation exception that extends RuntimeException. This
 * is sometimes useful, since it avoids to declare exceptions specifically
 *
 */
public class TransformationRTException extends RuntimeException {

	public TransformationRTException(String reason) {
		super(reason);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1235L;
	
}
