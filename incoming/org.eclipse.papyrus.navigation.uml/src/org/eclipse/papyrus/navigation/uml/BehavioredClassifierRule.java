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
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.UMLPackage;


public class BehavioredClassifierRule implements INavigationRule {

	public boolean handle(EObject element) {
		return element instanceof BehavioredClassifier &&
		// forbid Behavior to avoid infinite loop
		!(element instanceof Behavior);
	}

	public List<NavigableElement> getNextPossibleElements(NavigableElement currentNavElement) {
		List<NavigableElement> nextPossibleElements = new LinkedList<NavigableElement>();

		EStructuralFeature classifierBehaviorFeature = UMLPackage.Literals.BEHAVIORED_CLASSIFIER__CLASSIFIER_BEHAVIOR;

		final BehavioredClassifier behavioredClassifier = (BehavioredClassifier)currentNavElement.getElement();

		Behavior classifierBehavior = behavioredClassifier.getClassifierBehavior();
		if(classifierBehavior != null) {
			nextPossibleElements.add(new ExistingNavigableElement(classifierBehavior, classifierBehaviorFeature));
		}

		UMLRuleHelper.addBehaviorCreatedNavigableElements(nextPossibleElements, currentNavElement, classifierBehaviorFeature, new IModelLinker() {
			
			public void linkToModel(EObject toLink) {
				behavioredClassifier.setClassifierBehavior((Behavior)toLink);
			}
		});

		EStructuralFeature ownedBehaviorFeature = UMLPackage.Literals.BEHAVIORED_CLASSIFIER__OWNED_BEHAVIOR;

		for(Behavior ownedBehavior : behavioredClassifier.getOwnedBehaviors()) {
			if (ownedBehavior != null && !ownedBehavior.equals(classifierBehavior)) {
				nextPossibleElements.add(new ExistingNavigableElement(ownedBehavior, ownedBehaviorFeature));	
			}
		}

		UMLRuleHelper.addBehaviorCreatedNavigableElements(nextPossibleElements, currentNavElement, ownedBehaviorFeature, new IModelLinker() {
			
			public void linkToModel(EObject toLink) {
				behavioredClassifier.getOwnedBehaviors().add((Behavior)toLink);
			}
		});

		return nextPossibleElements;
	}

}
