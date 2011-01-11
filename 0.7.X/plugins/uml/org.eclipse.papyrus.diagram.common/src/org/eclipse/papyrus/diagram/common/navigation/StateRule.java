package org.eclipse.papyrus.diagram.common.navigation;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.core.navigation.ExistingNavigableElement;
import org.eclipse.papyrus.core.navigation.IModelLinker;
import org.eclipse.papyrus.core.navigation.INavigationRule;
import org.eclipse.papyrus.core.navigation.NavigableElement;
import org.eclipse.papyrus.core.navigation.NavigableElement.NavigationType;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.UMLPackage;


public class StateRule implements INavigationRule {

	public boolean handle(EObject element) {
		return element instanceof State;
	}

	public List<NavigableElement> getNextPossibleElements(NavigableElement currentNavElement) {
		List<NavigableElement> nextPossibleElements = new LinkedList<NavigableElement>();

		NavigationType navigationType = NavigationType.BEHAVIORAL;

		final State state = (State)currentNavElement.getElement();

		if(state.getDoActivity() != null) {
			nextPossibleElements.add(new ExistingNavigableElement(state.getDoActivity(), navigationType, UMLPackage.Literals.STATE__DO_ACTIVITY));
		} else {
			RuleHelper.addBehaviorCreatedNavigableElements(nextPossibleElements, currentNavElement, UMLPackage.Literals.STATE__DO_ACTIVITY, new IModelLinker() {
				
				public void linkToModel(EObject toLink) {
					state.setDoActivity((Behavior)toLink);
				}
			});
		}

		if(state.getEntry() != null) {
			nextPossibleElements.add(new ExistingNavigableElement(state.getEntry(), navigationType, UMLPackage.Literals.STATE__ENTRY));
		} else {
			RuleHelper.addBehaviorCreatedNavigableElements(nextPossibleElements, currentNavElement, UMLPackage.Literals.STATE__ENTRY, new IModelLinker() {
				
				public void linkToModel(EObject toLink) {
					state.setEntry((Behavior)toLink);
				}
			});
		}

		if(state.getExit() != null) {
			nextPossibleElements.add(new ExistingNavigableElement(state.getExit(), navigationType, UMLPackage.Literals.STATE__EXIT));
		} else {
			RuleHelper.addBehaviorCreatedNavigableElements(nextPossibleElements, currentNavElement, UMLPackage.Literals.STATE__EXIT, new IModelLinker() {
				
				public void linkToModel(EObject toLink) {
					state.setExit((Behavior)toLink);
				}
			});
		}

		return nextPossibleElements;
	}

}
