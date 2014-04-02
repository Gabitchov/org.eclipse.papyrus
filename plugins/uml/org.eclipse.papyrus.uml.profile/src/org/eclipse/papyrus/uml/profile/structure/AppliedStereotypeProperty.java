/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.structure;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * this is a data structure to manipulate value of Applied stereotype properties
 *
 * The extension of BasicEObjectImpl is only done, since xtext (context object) expects an EObject.
 */
public class AppliedStereotypeProperty extends BasicEObjectImpl {
	
	protected EObject stereotypeApplication=null;
	protected Property stereotypeProperty=null;
	
	/**
	 * 
	 * Constructor of this data Structure
	 *
	 * @param stereotypeApplication cannot be null
	 * @param stereotypeProperty cannot be null
	 */
	public AppliedStereotypeProperty(EObject stereotypeApplication, Property stereotypeProperty) {
		assert(stereotypeApplication!=null);
		assert(stereotypeProperty!=null);
		this.stereotypeApplication = stereotypeApplication;
		this.stereotypeProperty = stereotypeProperty;
	}

	/**
	 * 
	 * @return the stereotype Application
	 */
	public EObject getStereotypeApplication() {
		return stereotypeApplication;
	}
	
	/**
	 * 
	 * @return the UML element on which a stereotype has been applied
	 */
	public Element getBaseElement(){
		return UMLUtil.getBaseElement(stereotypeApplication);
	}
	
	/**
	 * 
	 * @return the stereotype associated to the property of applied stereotype
	 */
	public Stereotype getStereotype(){
		return UMLUtil.getStereotype(stereotypeApplication);
	}
	
	
	/**
	 * 
	 * @return the property of the stereotype for this application of stereotype
	 */
	public Property getStereotypeProperty() {
		return stereotypeProperty;
	}

}
