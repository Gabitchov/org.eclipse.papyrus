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
 * Default implementation for IXtextSemanticValidator.
 * 
 * @author CEA LIST - Initial contribution and API
 */
public class DefaultXtextSemanticValidator implements IXTextSemanticValidator {

	/**
	 * Default implementation. Always returns true.
	 * @return always returns true.
	 */
	public boolean validate() {
		return true;
	}

}
