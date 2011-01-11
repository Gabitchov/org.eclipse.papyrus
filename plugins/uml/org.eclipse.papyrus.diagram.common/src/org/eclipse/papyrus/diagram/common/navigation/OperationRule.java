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
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.UMLPackage;


public class OperationRule implements INavigationRule {

	public boolean handle(EObject element) {
		return element instanceof Operation;
	}

	public List<NavigableElement> getNextPossibleElements(NavigableElement currentNavElement) {
		List<NavigableElement> nextPossibleElements = new LinkedList<NavigableElement>();

		NavigationType navigationType = NavigationType.BEHAVIORAL;
		EStructuralFeature feature = UMLPackage.Literals.BEHAVIORAL_FEATURE__METHOD;

		final Operation op = (Operation)currentNavElement.getElement();
		for(Behavior b : op.getMethods()) {
			nextPossibleElements.add(new ExistingNavigableElement(b, navigationType, feature));
		}

		RuleHelper.addBehaviorCreatedNavigableElements(nextPossibleElements, currentNavElement, feature, new IModelLinker() {
			
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
