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
 *  Yann Tanguy(CEA LIST) Yann Tanguy@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

/**
 * 
 * TODO To change the template for this generated type comment go to Window - Preferences - Java - Code Style - Code Templates Problem : Generalization is not a NamedElement, as such it do not have
 * any Name nor Visibility !!!
 */
public class Generalization extends Element {

	/**
	 * 
	 */
	private org.eclipse.uml2.uml.Generalization uml2Generalization;

	/**
	 * 
	 * 
	 * @param g
	 */
	public Generalization(org.eclipse.uml2.uml.Generalization g) {
		super(g);
		uml2Generalization = g;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public org.eclipse.uml2.uml.Generalization getUml2Generalization() {
		return uml2Generalization;
	}

	/*
	 * Retrieve Class targeted by the generalization
	 * 
	 * @Return a com.cea.papyrus.umlutils.Class
	 */
	/**
	 * 
	 * 
	 * @return
	 */
	public org.eclipse.papyrus.umlutils.Class getTarget() {
		org.eclipse.papyrus.umlutils.Class cTarget = new org.eclipse.papyrus.umlutils.Class(null);

		// Should be one only target
		if (uml2Generalization.getTargets().size() == 1) {
			if (uml2Generalization.getTargets().get(0) instanceof org.eclipse.uml2.uml.Class) {
				cTarget = new org.eclipse.papyrus.umlutils.Class((org.eclipse.uml2.uml.Class) uml2Generalization.getTargets().get(0));
			}
		}

		return cTarget;
	}
}
