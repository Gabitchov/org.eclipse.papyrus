/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.runtime;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.properties.databinding.PapyrusObservableList;
import org.eclipse.papyrus.properties.databinding.PapyrusObservableValue;
import org.eclipse.papyrus.properties.modelelement.EMFModelElement;

public class StereotypeModelElement extends EMFModelElement {

	public StereotypeModelElement(EObject source, EditingDomain domain) {
		super(source, domain);
	}

	@Override
	public IObservable getObservable(String propertyPath) {
		FeaturePath featurePath = getFeaturePath(propertyPath);
		EStructuralFeature feature = getFeature(featurePath);
		if(feature.getUpperBound() != 1) {
			return new PapyrusObservableList(getSource(featurePath), feature, domain);
		}

		return new PapyrusObservableValue(getSource(featurePath), feature, domain);
	}
}
