/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.solver;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;


public class FeatureValueResolver implements ICrossValueSolver {

	public boolean handles(final Object obj1, final Object obj2) {
		return organizeObject(obj1, obj2).size() == 2;
	}

	public Object getValue(final Object obj1, final Object obj2) {
		final List<EObject> objects = organizeObject(obj1, obj2);
		final EObject eobject = objects.get(0);
		final EStructuralFeature feature = (EStructuralFeature)objects.get(1);
		if(eobject.eClass().getEAllStructuralFeatures().contains(feature)) {
			return eobject.eGet(feature);
		}
		return NOT_AVALAIBLE;
	}

	protected List<EObject> organizeObject(final Object obj1, final Object obj2) {
		final List<EObject> objects = new ArrayList<EObject>();
		if(obj1 instanceof EObject && obj2 instanceof EStructuralFeature) {
			objects.add((EObject)obj1);
			objects.add((EObject)obj2);
		} else if(obj1 instanceof EStructuralFeature && obj2 instanceof EObject) {
			objects.add((EObject)obj2);
			objects.add((EObject)obj1);
		}
		return objects;
	}

}
