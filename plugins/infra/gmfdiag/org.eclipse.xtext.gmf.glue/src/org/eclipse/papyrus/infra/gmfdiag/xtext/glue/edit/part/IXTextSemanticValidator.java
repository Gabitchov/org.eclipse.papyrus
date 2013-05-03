/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.xtext.glue.edit.part;

/**
 * Optional interface to be implemented by each client plug-in. The validation is taken into account before
 * closing a textual editor, in order to determine if the model contains semantic errors. If it contains 
 * semantic errors, modifications are not saved in order to avoid corrupting the context UML model.
 * 
 * @author CEA LIST - Initial contribution and API
 */
public interface IXTextSemanticValidator {

	
	/**
	 * 
	 * @return Implementations must return true if the xtext model is semantically valid
	 */
	public boolean validate() ;
	
}
