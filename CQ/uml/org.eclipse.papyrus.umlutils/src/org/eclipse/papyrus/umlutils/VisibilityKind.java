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
 *  Yann Tanguy (CEA LIST) Yann.Tanguy@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

/**
 * 
 * 
 * 
 * TODO To change the template for this generated type comment go to Window - Preferences - Java - Code Style - Code Templates
 */
public class VisibilityKind extends NamedElement {

	/**
	 * 
	 */
	private org.eclipse.uml2.uml.VisibilityKind uml2VisibilityKind;

	/**
	 * 
	 * 
	 * @param vk
	 */
	public VisibilityKind(org.eclipse.uml2.uml.VisibilityKind vk) {
		super();
		uml2VisibilityKind = vk;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public org.eclipse.uml2.uml.VisibilityKind getUml2VisibilityKind() {
		return uml2VisibilityKind;
	}

	/*
	 * Retrieve visibility Kind value
	 * 
	 * @Return a String "", "Public", "Private", "Protected"
	 */
	/**
	 * 
	 * 
	 * @return
	 */
	public String getValue() {
		String vKindValue = "";

		if (uml2VisibilityKind.getValue() == org.eclipse.uml2.uml.VisibilityKind.PUBLIC) {
			vKindValue = "public";
		} else if (uml2VisibilityKind.getValue() == org.eclipse.uml2.uml.VisibilityKind.PROTECTED) {
			vKindValue = "protected";
		} else if (uml2VisibilityKind.getValue() == org.eclipse.uml2.uml.VisibilityKind.PRIVATE) {
			vKindValue = "private";
		} // else ""

		return vKindValue;
	}
}
