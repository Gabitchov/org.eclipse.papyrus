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
 * This class encapsulates an <code>org.eclipse.uml2.uml.Model</code>. It's the entry point to browse the model
 */
public class Model extends Package {

	/**
	 * 
	 */
	private org.eclipse.uml2.uml.Model uml2Model;

	/**
	 * 
	 * 
	 * @param uml2Model
	 */
	public Model(org.eclipse.uml2.uml.Model uml2Model) {
		super(uml2Model);
		this.uml2Model = uml2Model;

	}

	/**
	 * 
	 * 
	 * @return Returns the uml2Model.
	 */
	public org.eclipse.uml2.uml.Model getUml2Model() {
		return uml2Model;
	}

	/**
	 * Retrieve the first package met with the specified stereotype.
	 * 
	 * @param stereotypeName
	 * @param stereotypeName
	 *            , name of the stereotype applied to the package
	 * 
	 * @return the package, or null if not found
	 */
	public org.eclipse.uml2.uml.Package getPackageWithThisStereotype(String stereotypeName) {

		org.eclipse.emf.common.util.EList list = getUml2Model().getOwnedMembers();
		java.util.Iterator i = list.iterator();
		org.eclipse.papyrus.umlutils.Package currentPackage;
		while (i.hasNext()) {
			currentPackage = new org.eclipse.papyrus.umlutils.Package((org.eclipse.uml2.uml.Package) i.next());
			if (currentPackage.hasStereotype(stereotypeName)) {
				return currentPackage.getUml2Package();
			}
		}
		return null;
	}

	/**
	 * Tells if the model can use GLib.
	 * 
	 * @return
	 */
	public boolean useGlib() {
		return !hasStereotype("noGlib");
	}

	/**
	 * Tells if the model can use C99 specific types.
	 * 
	 * @return
	 */
	public boolean useC99() {
		return hasStereotype("c99");
	}

}