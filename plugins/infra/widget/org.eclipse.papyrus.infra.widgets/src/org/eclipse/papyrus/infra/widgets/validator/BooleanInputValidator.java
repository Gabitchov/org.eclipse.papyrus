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
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.validator;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.papyrus.infra.tools.util.BooleanHelper;
import org.eclipse.papyrus.infra.widgets.messages.Messages;

/**
 * InputValidator for boolean
 * 
 * @author Vincent Lorenzo
 * 
 */
public class BooleanInputValidator implements IInputValidator {



	/**
	 * @see org.eclipse.jface.dialogs.IInputValidator#isValid(java.lang.String)
	 * 
	 * @param newText
	 * @return <code>null</code> if the newText is valid an error message when newText is
	 *         invalid
	 */

	public String isValid(String newText) {
		if(!BooleanHelper.isBoolean(newText)) {
			return Messages.BooleanInputValidator_NotABoolean;
		}
		return null;
	}

}
