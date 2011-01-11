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
package org.eclipse.papyrus.diagram.common.navigation;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.core.navigation.ExistingNavigableElement;
import org.eclipse.papyrus.core.navigation.IModelLinker;
import org.eclipse.papyrus.core.navigation.INavigationRule;
import org.eclipse.papyrus.core.navigation.NavigableElement;
import org.eclipse.papyrus.core.navigation.NavigableElement.NavigationType;
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

		NavigationType navigationType = NavigationType.BEHAVIORAL;
		EStructuralFeature feature = UMLPackage.Literals.BEHAVIORED_CLASSIFIER__CLASSIFIER_BEHAVIOR;

		final BehavioredClassifier behavioredClassifier = (BehavioredClassifier)currentNavElement.getElement();

		if(behavioredClassifier.getClassifierBehavior() != null) {
			nextPossibleElements.add(new ExistingNavigableElement(behavioredClassifier.getClassifierBehavior(), navigationType, feature));
		}

		RuleHelper.addBehaviorCreatedNavigableElements(nextPossibleElements, currentNavElement, feature, new IModelLinker() {
			
			public void linkToModel(EObject toLink) {
				behavioredClassifier.setClassifierBehavior((Behavior)toLink);
			}
		});

		return nextPossibleElements;
	}

}
