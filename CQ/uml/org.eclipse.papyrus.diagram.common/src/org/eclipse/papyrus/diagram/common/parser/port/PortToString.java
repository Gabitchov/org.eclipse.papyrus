/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.papyrus.diagram.common.parser.port;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.diagram.common.parser.AbstractToString;
import org.eclipse.papyrus.diagram.common.parser.ExternalToString.WithReferences;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

public class PortToString extends AbstractToString implements WithReferences {

	public String getToString(EObject object, int flags) {
		Port port = asPort(object);
		StringBuffer result = new StringBuffer();
		appendName(result, port);
		appendType(result, port);
		appendMultiplicity(result, port);
		return result.toString();
	}

	private static final List AFFECTING = Arrays.asList(new EStructuralFeature[] { UMLPackage.eINSTANCE.getNamedElement_Visibility(), UMLPackage.eINSTANCE.getNamedElement_Name(),
			UMLPackage.eINSTANCE.getTypedElement_Type(), UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue(), UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue(),
			UMLPackage.eINSTANCE.getLiteralUnlimitedNatural_Value(), UMLPackage.eINSTANCE.getLiteralInteger_Value(), UMLPackage.eINSTANCE.getLiteralString_Value(), });

	public boolean isAffectingFeature(EStructuralFeature feature) {
		return AFFECTING.contains(feature);
	}

	public List getAdditionalReferencedElements(EObject object) {
		Port port = asPort(object);
		List result = new LinkedList();
		result.add(port);
		ValueSpecification upper = port.getUpperValue();
		if (upper != null) {
			result.add(upper);
		}
		ValueSpecification lower = port.getLowerValue();
		if (lower != null) {
			result.add(lower);
		}
		if (port.getType() != null) {
			result.add(port.getType());
		}
		return result;
	}

	protected Port asPort(EObject object) {
		if (false == object instanceof Port) {
			throw new IllegalStateException("I can not provide toString for: " + object); //$NON-NLS-1$
		}
		return (Port) object;
	}

}
