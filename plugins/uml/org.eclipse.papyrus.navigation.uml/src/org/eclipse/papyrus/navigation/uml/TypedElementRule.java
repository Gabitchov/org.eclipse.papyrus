/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Olivier Mélois (Atos Origin) olivier.melois@atos.net
 *
 *****************************************************************************/

package org.eclipse.papyrus.navigation.uml;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.navigation.ExistingNavigableElement;
import org.eclipse.papyrus.navigation.INavigationRule;
import org.eclipse.papyrus.navigation.NavigableElement;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLPackage;

public class TypedElementRule implements INavigationRule {

	@Override
	public boolean handle(EObject element) {
		return element instanceof TypedElement;
	}

	@Override
	public List<NavigableElement> getNextPossibleElements(NavigableElement currentNavElement) {

		EStructuralFeature feature = UMLPackage.Literals.TYPED_ELEMENT__TYPE;
		final TypedElement element = (TypedElement)(currentNavElement.getElement());

		List<NavigableElement> result = null;

		Type elementType = element.getType();
		if(elementType == null) {
			result = Collections.emptyList();
		} else {
			// From the selected element, we want its type.
			NavigableElement navigableType = new ExistingNavigableElement(element.getType(), feature);
			// Setting the navigation mode.
			if(element instanceof Port || element instanceof Property || element instanceof Pin) {
				((ExistingNavigableElement)navigableType).setNavigationMode(ExistingNavigableElement.CONTAINED_LINKS_MODE);
			}
			result = Arrays.asList(navigableType);
		}
		return result;
	}
}
