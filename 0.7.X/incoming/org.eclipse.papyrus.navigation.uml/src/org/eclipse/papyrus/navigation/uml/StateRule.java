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
import org.eclipse.papyrus.navigation.ExistingNavigableElement;
import org.eclipse.papyrus.navigation.IModelLinker;
import org.eclipse.papyrus.navigation.INavigationRule;
import org.eclipse.papyrus.navigation.NavigableElement;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.UMLPackage;


public class StateRule implements INavigationRule {

	public boolean handle(EObject element) {
		return element instanceof State;
	}

	public List<NavigableElement> getNextPossibleElements(NavigableElement currentNavElement) {
		List<NavigableElement> nextPossibleElements = new LinkedList<NavigableElement>();

		final State state = (State)currentNavElement.getElement();

		if(state.getDoActivity() != null) {
			nextPossibleElements.add(new ExistingNavigableElement(state.getDoActivity(), UMLPackage.Literals.STATE__DO_ACTIVITY));
		} else {
			UMLRuleHelper.addBehaviorCreatedNavigableElements(nextPossibleElements, currentNavElement, UMLPackage.Literals.STATE__DO_ACTIVITY, new IModelLinker() {
				
				public void linkToModel(EObject toLink) {
					state.setDoActivity((Behavior)toLink);
				}
			});
		}

		if(state.getEntry() != null) {
			nextPossibleElements.add(new ExistingNavigableElement(state.getEntry(), UMLPackage.Literals.STATE__ENTRY));
		} else {
			UMLRuleHelper.addBehaviorCreatedNavigableElements(nextPossibleElements, currentNavElement, UMLPackage.Literals.STATE__ENTRY, new IModelLinker() {
				
				public void linkToModel(EObject toLink) {
					state.setEntry((Behavior)toLink);
				}
			});
		}

		if(state.getExit() != null) {
			nextPossibleElements.add(new ExistingNavigableElement(state.getExit(), UMLPackage.Literals.STATE__EXIT));
		} else {
			UMLRuleHelper.addBehaviorCreatedNavigableElements(nextPossibleElements, currentNavElement, UMLPackage.Literals.STATE__EXIT, new IModelLinker() {
				
				public void linkToModel(EObject toLink) {
					state.setExit((Behavior)toLink);
				}
			});
		}

		return nextPossibleElements;
	}

}
