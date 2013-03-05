/*****************************************************************************
 * Copyright (c) 2012, 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - support adapter instead of custom resource impl for CSS (CDO)
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.notation;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.css.resource.CSSNotationResource;

/**
 * This helper handles the EAnnotation used to distinguish between an EMF
 * "unset" value and a "default value" (Which cannot be distinguished for
 * mandatory values in the standard EMF implementation).
 * 
 * The CSS support is only activated for properties which don't have a value.
 * The problem is that in GMF, some properties always have a value, which
 * would prevent the CSS from working.
 * 
 * Thus, we distinguish three cases:
 * 
 * - The property has a value different from the default value: isSet = true
 * - The property has a value equal to the default value: isSet = false
 * - The property has a value equal to the default value, and the ForceValue
 * annotation is defined: isSet = true
 * 
 * unsetValue(object, feature) always results in isSet(object, feature) = false
 * (Which is not always the EMF behavior)
 * 
 * In order not to contaminate default GMF Models, these methods are only
 * applied if the resource is a CSSNotationResource. Otherwise, the behavior
 * is the standard EMF/GMF one.
 * 
 * @author Camille Letavernier
 */
//FIXME: The default behavior when undoing a setValue() is set(previous),
//which may result in set(null) or set(default), instead of unset()
//Thus, undoing a modification on a View may result in unexpected behavior 
//(e.g., GMF default appearance instead of CSS style)
//Workaround: Use the "reset style" button to retrieve the correct CSS style
public class ForceValueHelper {

	public static void setValue(View view, EStructuralFeature feature, Object value) {
		if(!isCSSView(view)) {
			//Do not contaminate non-Papyrus models
			return;
		}

		//Adds the annotation which indicates that the value has been forced, if needed

		if(equals(value, feature.getDefaultValue())) {
			//			System.out.println("Forcing default value for " + view);
			String annotationKey = feature.getName();
			EAnnotation eAnnotation = view.getEAnnotation(CSSAnnotations.CSS_FORCE_VALUE);
			if(eAnnotation == null) {
				eAnnotation = EcorePackage.eINSTANCE.getEcoreFactory().createEAnnotation();
				eAnnotation.setEModelElement(view);
				eAnnotation.setSource(CSSAnnotations.CSS_FORCE_VALUE);
			}

			EMap<String, String> details = eAnnotation.getDetails();
			details.put(annotationKey, Boolean.toString(true));
		}
	}

	private static boolean isCSSView(View view) {
		//		return false;
		return view != null && CSSNotationResource.isCSSEnabled(view.eResource());
	}

	private static boolean equals(Object value1, Object value2) {
		if(value1 == null) {
			return value2 == null;
		}
		return value1.equals(value2);
	}

	public static void unsetValue(View view, EStructuralFeature feature) {
		if(feature == null) {
			return;
		}

		if(!isCSSView(view)) {
			//Do not contaminate non-Papyrus models
			return;
		}

		//Remove the annotation which forces the value, if needed

		String annotationKey = feature.getName();
		EAnnotation eAnnotation = view.getEAnnotation(CSSAnnotations.CSS_FORCE_VALUE);
		if(eAnnotation != null) {
			EMap<String, String> details = eAnnotation.getDetails();
			details.remove(annotationKey);
			if(details.isEmpty()) {
				view.getEAnnotations().remove(eAnnotation);
			}
		}
	}

	public static boolean isSet(View view, EStructuralFeature feature, Object value) {
		return isSet(view, view, feature, value);
	}

	public static boolean isSet(View annotationContext, EObject style, EStructuralFeature feature, Object value) {
		if(!isCSSView(annotationContext)) {
			//Do not contaminate non-Papyrus models
			return true;
		}

		//		return false;

		if(equals(value, feature.getDefaultValue())) {
			EAnnotation eAnnotation = annotationContext.getEAnnotation(CSSAnnotations.CSS_FORCE_VALUE);
			if(eAnnotation == null) {
				return false;
			}

			String annotationKey = feature.getName();

			return eAnnotation.getDetails().containsKey(annotationKey);
		}

		return true;
	}
}
