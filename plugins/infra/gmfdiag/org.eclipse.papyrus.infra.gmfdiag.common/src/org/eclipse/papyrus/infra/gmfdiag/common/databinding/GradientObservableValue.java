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
package org.eclipse.papyrus.infra.gmfdiag.common.databinding;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.papyrus.infra.emf.databinding.PapyrusObservableValue;

/**
 * An IObservableValue for a Gradient
 * 
 * @author Camille Letavernier
 * 
 */
public class GradientObservableValue extends PapyrusObservableValue {

	private ObservableGradientData gradientData;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param source
	 *        The EObject owning the gradient data
	 * @param feature
	 *        The Feature in which the gradient data is set
	 * @param domain
	 *        The editing domain on which the commands will be executed
	 */
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
