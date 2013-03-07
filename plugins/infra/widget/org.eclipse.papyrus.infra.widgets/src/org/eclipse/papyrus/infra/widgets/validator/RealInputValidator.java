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
package org.eclipse.papyrus.infra.widgets.validator;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.papyrus.infra.widgets.messages.Messages;

/**
 * Validator for the Real
 */
public class RealInputValidator implements IInputValidator {




	/**
	 * @see org.eclipse.jface.dialogs.IInputValidator#isValid(java.lang.String)
	 * 
	 * @param newText
	 * @return <code>null</code> if the newText is valid an error message when newText is
	 *         invalid
	 */

	public String isValid(String newText) {
		try {
			if(newText != null) {
				Double.parseDouble(newText);
			}
		} catch (NumberFormatException e) {
			return Messages.RealInputValidator_NotaRealMessage;
		}
		return null;
	}


}
