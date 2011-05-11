/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.notation.databinding;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.papyrus.properties.uml.databinding.PapyrusObservableValue;


public class GradientObservableValue extends PapyrusObservableValue {

	private ObservableGradientData gradientData;

	public GradientObservableValue(EObject source, EStructuralFeature feature, EditingDomain domain) {
		super(source, feature, domain);
	}

	@Override
	protected Object doGetValue() {
		if(gradientData == null) {
			GradientData data = (GradientData)eObject.eGet(eStructuralFeature);
			gradientData = new ObservableGradientData(this, data);
		}

		return gradientData;
	}

	@Override
	protected void doSetValue(Object value) {
		super.doSetValue(value);
	}
}
