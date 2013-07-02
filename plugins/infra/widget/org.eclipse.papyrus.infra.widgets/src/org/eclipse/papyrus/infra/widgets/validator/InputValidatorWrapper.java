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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.validator;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IInputValidator;

/**
 * A Wrapper for IValidator to IInputValidator
 * 
 * @author Camille Letavernier
 */
public class InputValidatorWrapper implements IInputValidator {

	protected IValidator validator;

	public InputValidatorWrapper(IValidator validator) {
		Assert.isNotNull(validator);
		this.validator = validator;
	}

	public String isValid(String newText) {
		IStatus status = validator.validate(newText);
		if(status.isOK()) {
			return null;
		}

		return status.getMessage();
	}

}
