/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.paste;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * A structure used to store useful informations about stereotype, property, stereotype application, ...
 * 
 * @author vl222926
 * 
 */
public final class StereotypeApplicationStructure {

	/** The stereotype. */
	private final Stereotype stereotype;

	/** The property. */
	private final Property property;

	/** The stereotype application. */
	private final EObject stereotypeApplication;

	/** The feature. */
	private final EStructuralFeature feature;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param stereotype
	 *        the stereotype
	 * @param stereotypeApplication
	 *        the emf eobject representing the UML stereotype
	 * @param property
	 *        a property of this stereotype
	 * @param feature
	 *        the emf feature representing the UML Property
	 */
	public StereotypeApplicationStructure(final Stereotype stereotype, final EObject stereotypeApplication, final Property property, final EStructuralFeature feature) {
		this.stereotype = stereotype;
		this.property = property;
		this.stereotypeApplication = stereotypeApplication;
		this.feature = feature;
	}


	/**
	 * Gets the stereotype.
	 * 
	 * @return the stereotype
	 */
	public final Stereotype getStereotype() {
		return stereotype;
	}


	/**
	 * Gets the property.
	 * 
	 * @return the property
	 */
	public final Property getProperty() {
		return property;
	}


	/**
	 * Gets the stereotype application.
	 * 
	 * @return the stereotype application
	 */
	public final EObject getStereotypeApplication() {
		return stereotypeApplication;
	}


	/**
	 * Gets the feature.
	 * 
	 * @return the feature
	 */
	public final EStructuralFeature getFeature() {
		return feature;
	}

}
