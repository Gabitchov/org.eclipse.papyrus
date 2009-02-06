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

package org.eclipse.papyrus.diagram.common.parser.association.name;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.diagram.common.parser.AbstractToString;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.UMLPackage;

public abstract class AssociationNameToString extends AbstractToString {

	public static class EDIT extends AssociationNameToString {

		public boolean isAffectingFeature(EStructuralFeature feature) {
			throw new UnsupportedOperationException("I am edit toString, I am not expected to be asked"); //$NON-NLS-1$
		}

	}

	public static class VIEW extends AssociationNameToString {

		private static final List AFFECTING = Arrays.asList(new EStructuralFeature[] { UMLPackage.eINSTANCE.getAssociation_IsDerived(), UMLPackage.eINSTANCE.getNamedElement_Name(), });

		public boolean isAffectingFeature(EStructuralFeature feature) {
			return AFFECTING.contains(feature);
		}
	}

	public String getToString(EObject object, int flags) {
		Association association = asAssociation(object);
		StringBuffer result = new StringBuffer();
		result.append(getIsDerived(association));
		appendName(result, association);

		return result.toString();
	}

	protected Association asAssociation(EObject object) {
		if (false == object instanceof Association) {
			throw new IllegalStateException("I can not provide toString for: " + object); //$NON-NLS-1$
		}
		return (Association) object;
	}

	protected String getIsDerived(Association association) {
		return association.isDerived() ? "/" : ""; //$NON-NLS-1$ //$NON-NLS-2$
	}

}
