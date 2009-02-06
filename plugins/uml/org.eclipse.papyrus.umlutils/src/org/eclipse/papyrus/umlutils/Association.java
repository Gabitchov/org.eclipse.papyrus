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
 * 
 * TODO To change the template for this generated type comment go to Window - Preferences - Java - Code Style - Code Templates
 */
public class Association {

	/**
	 * 
	 */
	org.eclipse.uml2.uml.Association uml2association;

	/**
	 * 
	 * 
	 * @param association
	 */
	public Association(org.eclipse.uml2.uml.Association association) {
		super();
		// TODO Auto-generated constructor stub
		uml2association = association;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public org.eclipse.uml2.uml.Association getUml2Association() {
		return uml2association;
	}

	/**
	 * delete all the owned ends, and delete the uml2 association.
	 */
	public void delete() {
		org.eclipse.uml2.uml.Property property;
		java.util.Iterator i = uml2association.getMemberEnds().iterator();
		while (i.hasNext()) {
			property = (org.eclipse.uml2.uml.Property) i.next();
			property.destroy();
		}
		uml2association.destroy();

	}

	/**
	 * Returns the name of the type, with a lower first letter.
	 * 
	 * @param type
	 *            the type of the element
	 * 
	 * @return the name of the property
	 */
	public String getPropertyNameFromType(org.eclipse.uml2.uml.Type type) {
		if (type == null || type.getName() == null || "".equals(type.getName())) {
			return "prop";
		}
		return type.getName().substring(0, 1).toLowerCase() + type.getName().substring(1, type.getName().length());

	}

}
