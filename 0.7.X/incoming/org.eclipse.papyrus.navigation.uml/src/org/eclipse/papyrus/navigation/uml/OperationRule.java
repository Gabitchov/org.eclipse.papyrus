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
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.UMLPackage;


public class OperationRule implements INavigationRule {

	public boolean handle(EObject element) {
		return element instanceof Operation;
	}

	public List<NavigableElement> getNextPossibleElements(NavigableElement currentNavElement) {
		List<NavigableElement> nextPossibleElements = new LinkedList<NavigableElement>();

		EStructuralFeature feature = UMLPackage.Literals.BEHAVIORAL_FEATURE__METHOD;

		final Operation op = (Operation)currentNavElement.getElement();
		for(Behavior b : op.getMethods()) {
			nextPossibleElements.add(new ExistingNavigableElement(b, feature));
		}

		UMLRuleHelper.addBehaviorCreatedNavigableElements(nextPossibleElements, currentNavElement, feature, new IModelLinker() {
			
			public void linkToModel(EObject toLink) {
				// TODO ask for container ?
				org.eclipse.uml2.uml.Class owner = op.getClass_();
				owner.getOwnedBehaviors().add((Behavior)toLink);
				op.getMethods().add((Behavior)toLink);
			}
		});

		return nextPossibleElements;
	}

}
