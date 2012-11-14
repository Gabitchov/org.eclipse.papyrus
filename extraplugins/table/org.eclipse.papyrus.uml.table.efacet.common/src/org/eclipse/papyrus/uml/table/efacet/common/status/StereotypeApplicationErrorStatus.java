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


/**
 * This status indicates that we have a problem with a stereotype
 */
public class StereotypeApplicationErrorStatus extends AbstractWarningPasteResultStatus implements IStatus {

	/** The pasted string. */
	private final String stereotypeQualifiedName;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param statusMessage
	 *        the message for this status
	 * @param element
	 *        the element on which we have a problem
	 * @param stereotypeQualifiedName
	 *        the qualified name of the stereotype with which we have a problem
	 */
	public StereotypeApplicationErrorStatus(final String statusMessage, final EObject element, final String stereotypeQualifiedName) {
		super(statusMessage, element);
		this.stereotypeQualifiedName = stereotypeQualifiedName;
	}

	/**
	 * Gets the pasted string.
	 * 
	 * @return the pastedString
	 */
	public String getStereotypeQualifiedName() {
		return stereotypeQualifiedName;
	}
}
