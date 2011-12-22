/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.tabbed.profile.composite;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Element;

/**
 * Model accessor to modify a property of an element, using its feature id
 */
public class StringPropertyModelAccessor extends StringModelAccessor {

	/** Feature ID */
	final private int featureID;

	/**
	 * Creates a new StringPropertyModelAccessor.
	 * 
	 * @param featureID
	 *            the id of the feature to modify
	 */
	public StringPropertyModelAccessor(int featureID) {
		this.featureID = featureID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTextFromModel(Element element) {
		if (element != null) {
			final EStructuralFeature featureToEdit = element.eClass().getEStructuralFeature(featureID);
			Object o = element.eGet(featureToEdit);
			if (o != null) {
				return o.toString();
			}
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setModelFromText(Element element, String newValue) {
		if (element != null) {
			final EStructuralFeature featureToEdit = element.eClass().getEStructuralFeature(featureID);
			if (featureToEdit != null) {
				element.eSet(featureToEdit, newValue);
			}
		}
	}

}
