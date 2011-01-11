package org.eclipse.papyrus.diagram.common.navigation;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.core.navigation.CreatedNavigableElement;
import org.eclipse.papyrus.core.navigation.IModelLinker;
import org.eclipse.papyrus.core.navigation.NavigableElement;
import org.eclipse.papyrus.core.navigation.NavigableElement.NavigationType;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLFactory;


public class RuleHelper {

	public static void addBehaviorCreatedNavigableElements(List<NavigableElement> navElements, NavigableElement currentNavElement, EStructuralFeature feature, final IModelLinker modelLinker) {

		final Interaction interaction = UMLFactory.eINSTANCE.createInteraction();
		navElements.add(new CreatedNavigableElement(interaction, currentNavElement, NavigationType.BEHAVIORAL, feature, modelLinker, UMLBaseNameSetter.instance));

		final Activity activity = UMLFactory.eINSTANCE.createActivity();
		navElements.add(new CreatedNavigableElement(activity, currentNavElement, NavigationType.BEHAVIORAL, feature, modelLinker, UMLBaseNameSetter.instance));

		final StateMachine sm = UMLFactory.eINSTANCE.createStateMachine();
		final Region region = UMLFactory.eINSTANCE.createRegion();
		sm.getRegions().add(region);

		navElements.add(new CreatedNavigableElement(sm, currentNavElement, NavigationType.BEHAVIORAL, feature, modelLinker, UMLBaseNameSetter.instance));
	}
}
