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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.uml.table.efacet.common.Activator;


public class PasteWarningStatus extends AbstractWarningPasteResultStatus implements IStatus {

	/**
	 * Instantiates a new error in paste status.
	 * 
	 * @param statusMessage
	 *        the status message
	 * @param element
	 *        the element
	 * @param feature
	 *        the feature
	 * @param pastedString
	 *        the pasted string
	 */
	public PasteWarningStatus(final String statusMessage, final EObject element) {
		super(statusMessage, element);
	}
}
