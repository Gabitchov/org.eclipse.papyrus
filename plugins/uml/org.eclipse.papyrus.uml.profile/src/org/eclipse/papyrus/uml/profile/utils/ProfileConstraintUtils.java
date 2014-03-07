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
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.utils;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

/**
 * Utils methods for profile constraints validation
 */
public class ProfileConstraintUtils {

	public static boolean isStereotypeProperty(EObject eObject) {
		boolean isStereotypeProperty = false;
		if(eObject instanceof Property) {
			Property property = (Property)eObject;
			if(property.getOwner() instanceof Stereotype) {
				isStereotypeProperty = true;
			}
		}
		return isStereotypeProperty;
	}

	public static boolean hasType(Property property) {
		boolean hasType = false;
		if(property.getType() != null) {
			hasType = true;
		}
		return hasType;
	}

	public static boolean hasDefaultValueRequired(Property property) {
		boolean hasDefaultValueRequired = true;
		if(hasType(property)) {
			Type type = property.getType();

			if((type instanceof PrimitiveType) || (type instanceof Enumeration)) {
				if((property.getLower() != 0) && !(property.getDefaultValue() != null)) {
					hasDefaultValueRequired = false;
				}
			}
		}
		return hasDefaultValueRequired;
	}

	public static boolean hasLowerMultiplicityRequired(Property property) {
		boolean hasDefaultValueRequired = true;
		if(hasType(property)) {
			Type type = property.getType();

			if(!(type instanceof PrimitiveType) && !(type instanceof Enumeration)) {
				if(property.getLower() != 0) {
					if(property.isSetName() && property.getName().length() > 5) {
						if(!"base_".equals(property.getName().substring(0, 5))) {
							hasDefaultValueRequired = false;
						}
					} else {
						hasDefaultValueRequired = false;
					}
				}
			}
		}
		return hasDefaultValueRequired;
	}

	public static boolean hasUniqueName(Property property) {
		boolean hasUniqueName = true;

		if((property.isSetName()) && (!"".equals(property.getName())) && (property.getOwner() instanceof Stereotype)) {
			Stereotype owner = (Stereotype)property.getOwner();
			Iterator<Property> it = owner.getAllAttributes().iterator();
			while(it.hasNext()) {
				Property current = it.next();
				if(current.isSetName() && (current != property) && (current.getName().equals(property.getName()))) {
					hasUniqueName = false;
				}
			}
		}
		return hasUniqueName;
	}
}
