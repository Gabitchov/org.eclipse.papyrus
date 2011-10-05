/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.navigation.uml;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.navigation.CreatedNavigableElement;
import org.eclipse.papyrus.navigation.IModelLinker;
import org.eclipse.papyrus.navigation.NavigableElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;


public class UMLRuleHelper {

	private static final EClass[] possibleBehaviors = { UMLPackage.Literals.INTERACTION, UMLPackage.Literals.ACTIVITY, UMLPackage.Literals.STATE_MACHINE };

	public static void addBehaviorCreatedNavigableElements(List<NavigableElement> navElements, NavigableElement currentNavElement, EStructuralFeature feature, final IModelLinker modelLinker) {
		for(EClass behaviorClass : possibleBehaviors) {
			final EObject behavior = UMLFactory.eINSTANCE.create(behaviorClass);
			navElements.add(new CreatedNavigableElement(behavior, currentNavElement, feature, modelLinker, UMLBaseNameSetter.instance));
		}
	}

}
