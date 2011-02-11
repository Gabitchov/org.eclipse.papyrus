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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.navigation.ExistingNavigableElement;
import org.eclipse.papyrus.navigation.IModelLinker;
import org.eclipse.papyrus.navigation.INavigationRule;
import org.eclipse.papyrus.navigation.NavigableElement;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLPackage;


public class TransitionRule implements INavigationRule {

	public boolean handle(EObject element) {
		return element instanceof Transition;
	}

	public List<NavigableElement> getNextPossibleElements(NavigableElement currentNavElement) {
		List<NavigableElement> nextPossibleElements = new LinkedList<NavigableElement>();

		EStructuralFeature feature = UMLPackage.Literals.TRANSITION__EFFECT;

		final Transition transition = (Transition)currentNavElement.getElement();
		// two cases here :
		// if the effect is defined we want the possibility to navigate to it
		// otherwise we want the possibility to create either an interaction or an activity as an effect
		if(transition.getEffect() != null) {
			nextPossibleElements.add(new ExistingNavigableElement(transition.getEffect(), feature));
		} else {
			UMLRuleHelper.addBehaviorCreatedNavigableElements(nextPossibleElements, currentNavElement, feature, new IModelLinker() {
				
				public void linkToModel(EObject toLink) {
					transition.setEffect((Behavior)toLink);
				}
			});
		}

		return nextPossibleElements;
	}

}
