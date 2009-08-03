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

package org.eclipse.papyrus.diagram.common.parser.instance;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.diagram.common.parser.AbstractToString;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.UMLPackage;

public abstract class InstanceSpecificationToString extends AbstractToString {

	public String getToString(EObject object, int flags) {
		InstanceSpecification instance = asInstanceSpecification(object);
		StringBuffer result = new StringBuffer();
		appendName(result, instance);
		appendType(result, getClassifiers(instance));

		// anonymous unnamed, see 7.3.22 "Notation" at page 85, 06-04-02
		if (result.length() == 0) {
			result.append(":"); //$NON-NLS-1$
		}
		return result.toString();
	}

	protected final String getClassifiers(InstanceSpecification instance) {
		StringBuffer result = new StringBuffer();
		boolean atLeastOneClassifier = false;
		for (Iterator classifiers = instance.getClassifiers().iterator(); classifiers.hasNext();) {
			Classifier next = (Classifier) classifiers.next();
			if (atLeastOneClassifier) {
				result.append(", "); //$NON-NLS-1$
			}
			String nextName = next.getName();
			if (!isEmpty(nextName)) {
				atLeastOneClassifier = true;
				result.append(nextName);
			}
		}
		return result.toString();
	}

	protected InstanceSpecification asInstanceSpecification(EObject object) {
		if (false == object instanceof InstanceSpecification) {
			throw new IllegalStateException("I can not provide toString for: " + object); //$NON-NLS-1$
		}
		return (InstanceSpecification) object;
	}

	public static class EDIT extends InstanceSpecificationToString {

		public boolean isAffectingFeature(EStructuralFeature feature) {
			throw new UnsupportedOperationException("I am edit toString, I am not expected to be asked"); //$NON-NLS-1$
		}
	}

	public static class VIEW extends InstanceSpecificationToString implements WithReferences {

		private static final List AFFECTING = Arrays.asList(new EStructuralFeature[] {
				UMLPackage.eINSTANCE.getNamedElement_Name(),
				UMLPackage.eINSTANCE.getInstanceSpecification_Classifier(), });

		public boolean isAffectingFeature(EStructuralFeature feature) {
			return AFFECTING.contains(feature);
		}

		public List getAdditionalReferencedElements(EObject object) {
			InstanceSpecification instance = asInstanceSpecification(object);
			List result = new LinkedList();
			result.add(instance);
			result.addAll(instance.getClassifiers());
			return result;
		}
	}

}
