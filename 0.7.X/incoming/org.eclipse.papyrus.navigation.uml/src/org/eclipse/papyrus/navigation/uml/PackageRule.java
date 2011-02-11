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
import org.eclipse.papyrus.navigation.CreatedNavigableElement;
import org.eclipse.papyrus.navigation.ExistingNavigableElement;
import org.eclipse.papyrus.navigation.IModelLinker;
import org.eclipse.papyrus.navigation.INavigationRule;
import org.eclipse.papyrus.navigation.NavigableElement;
import org.eclipse.uml2.uml.Behavior;
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

		EStructuralFeature packagedFeature = UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT;

		final Package pack = (Package)currentNavElement.getElement();

		for(PackageableElement element : pack.getPackagedElements()) {
			if(element instanceof Collaboration) {
				nextPossibleElements.add(new ExistingNavigableElement(element, packagedFeature));
			}
		}

		Collaboration collab = UMLFactory.eINSTANCE.createCollaboration();
		nextPossibleElements.add(new CreatedNavigableElement(collab, currentNavElement, packagedFeature, new IModelLinker() {

			public void linkToModel(EObject toLink) {
				pack.getPackagedElements().add((PackageableElement)toLink);
			}
		}
		, UMLBaseNameSetter.instance));

		// provide the possibility to create behavior in package as structural element : 
		// this allows to easily share behavior between elements using a package as library
		UMLRuleHelper.addBehaviorCreatedNavigableElements(nextPossibleElements, currentNavElement, UMLPackage.Literals.ELEMENT__OWNED_ELEMENT, new IModelLinker() {

			public void linkToModel(EObject toLink) {
				pack.getPackagedElements().add((Behavior)toLink);
			}
		});

		return nextPossibleElements;
	}


}
