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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Modification to match IValidator
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.infra.tools.util.BooleanHelper;
import org.eclipse.papyrus.infra.widgets.messages.Messages;

/**
 * InputValidator for boolean
 * 
 * @author Vincent Lorenzo
 * 
 */
public class BooleanValidator extends AbstractValidator {


	/**
	 * 
	 * @param newValue
	 * @return {@link Status#OK_STATUS} if the newValue is valid and {@link IStatus#ERROR} when newValue is
	 *         invalid
	 */
	public IStatus validate(Object newValue) {
		if(newValue instanceof Boolean) {
			return Status.OK_STATUS;
		}

		if(newValue instanceof String && BooleanHelper.isBoolean((String)newValue)) {
			return Status.OK_STATUS;
		}

		return error(Messages.BooleanInputValidator_NotABoolean);

	}

}
