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
 */
public class Slot extends Element {

	/**
	 * 
	 */
	private org.eclipse.uml2.uml.Slot uml2Slot;

	/**
	 * 
	 * 
	 * @param source
	 */
	public Slot(org.eclipse.uml2.uml.Slot source) {
		super(source);
		uml2Slot = source;
	}

	/**
	 * 
	 * 
	 * @return Returns the uml2InstanceSpecification.
	 */
	public org.eclipse.uml2.uml.Slot getUml2Slot() {
		return uml2Slot;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getLabel() {
		if (uml2Slot.getDefiningFeature() != null) {
			return uml2Slot.getDefiningFeature().getName();
		}

		else
			return "UndefinedSlot";
	}
}
