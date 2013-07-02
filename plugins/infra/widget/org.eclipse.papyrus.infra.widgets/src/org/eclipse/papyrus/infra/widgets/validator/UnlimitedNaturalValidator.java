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
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Modification to match IValidator
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.infra.widgets.messages.Messages;

/**
 * Validator for the UnlimitedNaturalEditor. It accepts "-1", "*" and all integer >=0
 */
public class UnlimitedNaturalValidator extends AbstractValidator {


	public static final String INFINITE_STAR = "*"; //$NON-NLS-1$

	public static final String INFINITE_MINUS_ONE = "-1"; //$NON-NLS-1$


	/**
	 * @see org.eclipse.jface.dialogs.IInputValidator#isValid(java.lang.String)
	 * 
	 * @param newText
	 * @return <code>null</code> if the newText is valid an error message when newText is
	 *         invalid
	 */
	public String isValid(String newText) {
		if(INFINITE_STAR.equals(newText) || INFINITE_MINUS_ONE.equals(newText)) {
			return null;
		}
		boolean isValid = true;
		try {
			Integer myUnlimitedNatural = new Integer(newText);
			if(myUnlimitedNatural < -1) {
				isValid = false;
			}
		} catch (NumberFormatException e) {
			isValid = false;
		}

		if(!isValid) {
			return Messages.UnlimitedNaturalInputValidator_NotAnUnlimitedNaturalMessage;
		}
		return null;
	}

	/**
	 * 
	 * @param newValue
	 * @return {@link Status#OK_STATUS} if the newValue is valid and {@link IStatus#ERROR} when newValue is
	 *         invalid
	 */
	public IStatus validate(Object newValue) {
		if(newValue instanceof Integer) {
			int value = (Integer)newValue;
			if(value == -1 || value >= 0) {
				return Status.OK_STATUS;
			}
		}

		if(newValue instanceof String) {
			String newText = (String)newValue;

			if(INFINITE_STAR.equals(newText) || INFINITE_MINUS_ONE.equals(newText)) {
				return null;
			}

			boolean isValid = true;
			try {
				Integer myUnlimitedNatural = Integer.parseInt(newText);
				if(myUnlimitedNatural < -1) {
					isValid = false;
				}
			} catch (NumberFormatException e) {
				isValid = false;
			}

			if(isValid) {
				return Status.OK_STATUS;
			}
		}

		return error(Messages.UnlimitedNaturalInputValidator_NotAnUnlimitedNaturalMessage);
	}


}
