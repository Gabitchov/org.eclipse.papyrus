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
package org.eclipse.papyrus.uml.table.efacet.common.status;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;


/**
 * This status is used for unresolved element during the paste
 */
public class UnresolvedReferenceErrorInPasteStatus extends AbstractWarningPasteResultStatus implements IStatus {

	/** The feature where we can do the set. */
	private final EStructuralFeature feature;

	/**
	 * the string pasted
	 */
	private final String pastedString;

	public UnresolvedReferenceErrorInPasteStatus(String message, EObject element, final EStructuralFeature feature, final String pastedString) {
		super(message, element);
		this.feature = feature;
		this.pastedString = pastedString;

	}

	/**
	 * Gets the feature.
	 * 
	 * @return the feature
	 */
	public EStructuralFeature getFeature() {
		return feature;
	}


	/**
	 * Gets the pasted string.
	 * 
	 * @return the pastedString
	 */
	public String getPastedString() {
		return pastedString;
	}


}
