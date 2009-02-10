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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * This class encapsulates an <code>org.eclipse.uml2.uml.Behavior</code><BR>
 * 
 * @author Remi SCHNEKENBURGER
 */
public class Behavior extends NamedElement {

	/**
	 * encapsulated uml2 behavior.
	 */
	private org.eclipse.uml2.uml.Behavior uml2Behavior;

	/**
	 * 
	 * 
	 * @param behavior
	 */
	public Behavior(org.eclipse.uml2.uml.Behavior behavior) {
		super(behavior);
		this.uml2Behavior = behavior;
	}

	/**
	 * Get the encapsulated <code>Behavior</code>.
	 * 
	 * @return Returns the uml2Behavior.
	 */
	public org.eclipse.uml2.uml.Behavior getUml2Behavior() {
		return uml2Behavior;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getLabel() {
		return uml2Behavior.getLabel();
	}

	/**
	 * Retrive all the parameters of the operation (including the return parameter).
	 * 
	 * @return A collection of com.cea.papyrus.umlutils.Parameter
	 */
	public Collection<Parameter> getAllParameters() {
		Collection<Parameter> params = new ArrayList<Parameter>();
		Iterator parameterIterator = uml2Behavior.getOwnedParameters().iterator();
		Parameter currentParameter;
		while (parameterIterator.hasNext()) {
			currentParameter = new Parameter((org.eclipse.uml2.uml.Parameter) parameterIterator.next());
			params.add(currentParameter);
		}
		return params;
	}
}
