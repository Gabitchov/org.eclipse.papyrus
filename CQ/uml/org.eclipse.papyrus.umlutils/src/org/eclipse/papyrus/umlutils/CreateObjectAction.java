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
 * @author Remi SCHNEKENBURGER
 */
public class CreateObjectAction extends ActivityNode {

	/**
     * 
     */
	private org.eclipse.uml2.uml.CreateObjectAction uml2CreateObjectAction;

	/**
	 * 
	 * 
	 * @param createObjectAction
	 */
	public CreateObjectAction(org.eclipse.uml2.uml.CreateObjectAction createObjectAction) {
		super(createObjectAction);
		this.uml2CreateObjectAction = createObjectAction;
	}

	/**
	 * Get the encapsulated <code>CreateObjectAction</code>.
	 * 
	 * @return Returns the uml2createObjectAction.
	 */
	public org.eclipse.uml2.uml.CreateObjectAction getUml2CreateObjectAction() {
		return uml2CreateObjectAction;
	}

	/**
	 * Sets the value of the 'Classifier' attribute for the <code>CreateObjectAction</code>.
	 * 
	 * @param value
	 *            the new value of the 'Classifier'
	 */
	public void setClassifier(org.eclipse.papyrus.umlutils.Class value) {
		uml2CreateObjectAction.setClassifier(value.getUml2Class());
	}

}
