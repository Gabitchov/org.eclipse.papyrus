/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.constraints.constraints;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.constraints.SimpleConstraint;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

/**
 * A Constraint to test whether the selected EObject has a specific EAnnotation
 * 
 * @author Camille Letavernier
 * 
 */
public class HasEAnnotationConstraint extends AbstractConstraint {

	protected String annotationName;

	@Override
	protected boolean equivalent(Constraint constraint) {
		if(constraint instanceof HasEAnnotationConstraint) {
			HasEAnnotationConstraint other = (HasEAnnotationConstraint)constraint;
			return annotationName.equals(other.annotationName);
		}
		return false;
	}

	@Override
	protected void setDescriptor(SimpleConstraint descriptor) {
		super.setDescriptor(descriptor);
		this.annotationName = getValue("annotationName");
	}

	@Override
	protected boolean match(Object selection) {
		EObject eObject = EMFHelper.getEObject(selection);
		if(eObject instanceof EModelElement) {
			EModelElement modelElement = (EModelElement)eObject;
			return modelElement.getEAnnotation(annotationName) != null;
		}

		return false;
	}

}
