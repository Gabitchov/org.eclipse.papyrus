/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.configuration.ui;

import org.eclipse.emf.ecore.EObject;

/**
 * Represents the validation for the selection of an object
 * @author Laurent Wouters
 */
public interface IModelElementValidator {
	/**
	 * Determines whether the given object pass the represented validation
	 * @param element The element to evaluate
	 * @return <code>null</code> if the object passes the validation, or the notification to be displayed
	 */
	String isSelectable(EObject element);
}
