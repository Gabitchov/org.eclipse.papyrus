/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Gregoire Dupe (Mia-Software) - initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.emf.facet.widgets.celleditors;

import org.eclipse.core.runtime.IStatus;

/** Used to validate the value of a cell editor. */
public interface IValidator {
	/**
	 * Validates the given value for the cell editor.
	 * 
	 * @return an {@link IStatus} with a status of {@link IStatus#OK} if the given value is valid,
	 *         or with a status of {@link IStatus#ERROR} otherwise.
	 */
	IStatus validate(Object value);
}
