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
package org.eclipse.papyrus.uml.diagram.navigation;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.gmfdiag.navigation.ExistingNavigableElement;
import org.eclipse.papyrus.infra.gmfdiag.navigation.IModelLinker;
import org.eclipse.papyrus.infra.gmfdiag.navigation.INavigationRule;
import org.eclipse.papyrus.infra.gmfdiag.navigation.NavigableElement;
import org.eclipse.swt.widgets.Shell;
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
				Behavior existing = behavioredClassifier.getClassifierBehavior();
				boolean setCB = true;
				if (existing != null) {
					setCB = MessageDialog.openQuestion(new Shell(), "Overwrite classifier behavior",
						"The classifier <" + behavioredClassifier.getName() + "> already has a classifier behavior (" +
						existing.getName() + "). Do you want to overwrite it with the behavior of the new diagram?");
				}
				if (setCB) {
					behavioredClassifier.setClassifierBehavior((Behavior)toLink);
				}
				else {
					behavioredClassifier.getOwnedBehaviors().add((Behavior)toLink);		
				}
			}
		});

		EStructuralFeature ownedBehaviorFeature = UMLPackage.Literals.BEHAVIORED_CLASSIFIER__OWNED_BEHAVIOR;

		for(Behavior ownedBehavior : behavioredClassifier.getOwnedBehaviors()) {
			if(ownedBehavior != null && !ownedBehavior.equals(classifierBehavior)) {
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
