/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Yann Tanguy (CEA LIST) yann.Tanguy@cea.fr - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.umlutils;

/**
 * 
 * 
 * 
 * TODO To change the template for this generated type comment go to Window - Preferences - Java - Code Style - Code Templates
 */
public class Enumeration extends NamedElement {

	/**
	 * 
	 */
	private org.eclipse.uml2.uml.Enumeration uml2Enumeration;

	/**
	 * 
	 * 
	 * @param source
	 */
	public Enumeration(org.eclipse.uml2.uml.Enumeration source) {
		super(source);
		uml2Enumeration = source;
	}

	/**
	 * 
	 * 
	 * @return Returns the uml2Package.
	 */
	public org.eclipse.uml2.uml.Enumeration getUml2Enumeration() {
		return uml2Enumeration;
	}

	/**
	 * Create an owned literal.
	 * 
	 * @param name
	 *            , name of the literal
	 * @param name
	 * 
	 * @return
	 * 
	 * @visibilityValue, kind of visibility
	 */
	public org.eclipse.uml2.uml.EnumerationLiteral createOwnedLiteral(String name) {

		org.eclipse.uml2.uml.EnumerationLiteral literal = getUml2Enumeration().createOwnedLiteral(name);

		// TODO modify the visiblity creation
		// literal.setVisibility(VisibilityKind.get(visibilityValue));
		return literal;
	}
}
