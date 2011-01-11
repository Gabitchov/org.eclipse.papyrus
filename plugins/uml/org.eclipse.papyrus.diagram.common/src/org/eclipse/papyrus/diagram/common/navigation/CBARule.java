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
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLPackage;


public class CBARule implements INavigationRule {

	public boolean handle(EObject element) {
		return element instanceof CallBehaviorAction;
	}

	public List<NavigableElement> getNextPossibleElements(NavigableElement currentNavElement) {
		List<NavigableElement> nextPossibleElements = new LinkedList<NavigableElement>();

		NavigationType navigationType = NavigationType.BEHAVIORAL;
		EStructuralFeature feature = UMLPackage.Literals.CALL_BEHAVIOR_ACTION__BEHAVIOR;

		final CallBehaviorAction cba = (CallBehaviorAction)currentNavElement.getElement();
		// two cases here :
		// if the behavior is defined we want the possibility to navigate to it
		// otherwise we want the possibility to create either an interaction or an activity as a behavior
		if(cba.getBehavior() != null) {
			nextPossibleElements.add(new ExistingNavigableElement(cba.getBehavior(), navigationType, feature));
		} else {
			RuleHelper.addBehaviorCreatedNavigableElements(nextPossibleElements, currentNavElement, feature, new IModelLinker() {
				
				public void linkToModel(EObject toLink) {
					// TODO ask for container ?
					org.eclipse.uml2.uml.Package owner = cba.getActivity().getNearestPackage();
					owner.getPackagedElements().add((PackageableElement)toLink);
					cba.setBehavior((Behavior)toLink);
				}
			});
		}

		return nextPossibleElements;
	}

}
