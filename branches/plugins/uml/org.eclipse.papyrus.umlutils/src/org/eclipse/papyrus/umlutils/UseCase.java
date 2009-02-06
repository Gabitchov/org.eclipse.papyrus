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
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

/**
 * This class encapsulates an <code>org.eclipse.uml2.uml.UseCase</code><BR>
 * 
 * @author Remi SCHNEKENBURGER
 */
public class UseCase extends NamedElement {

	/**
     * 
     */
	private org.eclipse.uml2.uml.UseCase uml2UseCase;

	/**
	 * 
	 * 
	 * @param useCase
	 */
	public UseCase(org.eclipse.uml2.uml.UseCase useCase) {
		super(useCase);
		this.uml2UseCase = useCase;
	}

	/**
	 * Get the encapsulated <code>UseCase</code>.
	 * 
	 * @return Returns the uml2UseCase.
	 */
	public org.eclipse.uml2.uml.UseCase getUml2UseCase() {
		return uml2UseCase;
	}
}
