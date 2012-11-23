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

import java.util.HashMap;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.gmfdiag.navigation.NavigableElement;
import org.eclipse.uml2.uml.UMLPackage;


public class UMLNavigationHelper {

	public static final String BEHAVIORAL_NAVIGATION = "Behavioral";

	public static final String STRUCTURAL_NAVIGATION = "Structural";

	@SuppressWarnings("serial")
	private static HashMap<EStructuralFeature, String> featureNavigationTypeMap = new HashMap<EStructuralFeature, String>() {

		{
			put(UMLPackage.Literals.BEHAVIORED_CLASSIFIER__CLASSIFIER_BEHAVIOR, BEHAVIORAL_NAVIGATION);
			put(UMLPackage.Literals.CALL_BEHAVIOR_ACTION__BEHAVIOR, BEHAVIORAL_NAVIGATION);
			put(UMLPackage.Literals.BEHAVIORAL_FEATURE__METHOD, BEHAVIORAL_NAVIGATION);
			put(UMLPackage.Literals.STATE__ENTRY, BEHAVIORAL_NAVIGATION);
			put(UMLPackage.Literals.STATE__DO_ACTIVITY, BEHAVIORAL_NAVIGATION);
			put(UMLPackage.Literals.STATE__EXIT, BEHAVIORAL_NAVIGATION);
			put(UMLPackage.Literals.TRANSITION__EFFECT, BEHAVIORAL_NAVIGATION);

			put(UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT, STRUCTURAL_NAVIGATION);
			put(UMLPackage.Literals.ELEMENT__OWNED_ELEMENT, STRUCTURAL_NAVIGATION);
			put(UMLPackage.Literals.BEHAVIORED_CLASSIFIER__OWNED_BEHAVIOR, STRUCTURAL_NAVIGATION);
		}
	};

	public static String getNavigationType(NavigableElement navElement) {
		return getNavigationTypeFromFeature(navElement.getFeature());
	}

	public static String getNavigationTypeFromFeature(EStructuralFeature feature) {
		if(feature == null) {
			// no feature specified, report structural
			// because it is the root element
			return STRUCTURAL_NAVIGATION;
		}
		String result = featureNavigationTypeMap.get(feature);
		return result == null ? "" : result;
	}
}
