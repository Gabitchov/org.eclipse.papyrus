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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profilefacet.utils;

import java.util.List;

import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.tools.utils.NameResolutionUtils;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * This class provides methods to found the real Property represented by a {@link StereotypePropertyElement}
 * 
 */
public class StereotypePropertyUtils {


	private StereotypePropertyUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param tableContext
	 *        the context of the table
	 * @param el
	 *        a stereotype property element
	 * @return
	 *         the property represented by the {@link StereotypePropertyElement} or <code>null</code> if not found
	 */
	public static final Property findRealStereotypeProperty(final Namespace namespace, final StereotypePropertyElement el) {
		final String propertyQualifiedName = el.getPropertyQualifiedName();
		for(final Profile profile : namespace.getNearestPackage().getAllAppliedProfiles()) {
			final List<NamedElement> properties = NameResolutionUtils.getNamedElements(propertyQualifiedName, profile, UMLPackage.eINSTANCE.getProperty());
			if(properties.size() == 1) {
				return (Property)properties.get(0);
			}
		}
		return null;
	}
}
