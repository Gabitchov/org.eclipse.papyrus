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
 * 
 * 
 * 
 * TODO To change the template for this generated type comment go to Window - Preferences - Java - Code Style - Code Templates
 */
public class Signal extends NamedElement {

	/**
	 * 
	 */
	private org.eclipse.uml2.uml.Signal uml2Signal;

	/**
	 * 
	 * 
	 * @param source
	 */
	public Signal(org.eclipse.uml2.uml.Signal source) {
		super(source);
		uml2Signal = source;
	}

	/**
	 * 
	 * 
	 * @return Returns the uml2Package.
	 */
	public org.eclipse.uml2.uml.Signal getUml2Signal() {
		return uml2Signal;
	}

}
