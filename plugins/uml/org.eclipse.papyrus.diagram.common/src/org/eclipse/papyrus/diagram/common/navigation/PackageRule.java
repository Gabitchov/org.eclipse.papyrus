package org.eclipse.papyrus.diagram.common.navigation;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.core.navigation.CreatedNavigableElement;
import org.eclipse.papyrus.core.navigation.ExistingNavigableElement;
import org.eclipse.papyrus.core.navigation.IModelLinker;
import org.eclipse.papyrus.core.navigation.INavigationRule;
import org.eclipse.papyrus.core.navigation.NavigableElement;
import org.eclipse.papyrus.core.navigation.NavigableElement.NavigationType;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;


public class PackageRule implements INavigationRule {

	public boolean handle(EObject element) {
		return element instanceof Package;
	}

	public List<NavigableElement> getNextPossibleElements(NavigableElement currentNavElement) {
		List<NavigableElement> nextPossibleElements = new LinkedList<NavigableElement>();

		NavigationType navigationType = NavigationType.STRUCTURAL;
		EStructuralFeature feature = UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT;

		final Package pack = (Package)currentNavElement.getElement();

		for(PackageableElement element : pack.getPackagedElements()) {
			if(element instanceof Collaboration) {
				nextPossibleElements.add(new ExistingNavigableElement(element, navigationType, feature));
			}
		}

		Collaboration collab = UMLFactory.eINSTANCE.createCollaboration();
		nextPossibleElements.add(new CreatedNavigableElement(collab, currentNavElement, navigationType, feature, new IModelLinker() {

			public void linkToModel(EObject toLink) {
				pack.getPackagedElements().add((PackageableElement)toLink);
			}
		}, UMLBaseNameSetter.instance));

		return nextPossibleElements;
	}


}
