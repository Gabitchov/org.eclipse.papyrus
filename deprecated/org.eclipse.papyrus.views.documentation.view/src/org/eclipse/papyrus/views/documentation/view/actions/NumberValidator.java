//------------------------------------------------------------------------------
// Copyright (c) 2009 Anyware Technologies and others
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
// Contributors:
//      Anyware Technologies - initial API and implementation
//------------------------------------------------------------------------------
package org.eclipse.papyrus.views.documentation.view.actions;

import org.eclipse.jface.dialogs.IInputValidator;

/**
 * Validates whether the text found in the input field of the
 * dialog forms a positive number.
 */
class NumberValidator implements IInputValidator {

	/*
	 * @see IInputValidator#isValid(String)
	 */
	public String isValid(String input) {

		if (input == null || input.length() == 0)
			return " "; //$NON-NLS-1$

		try {
			int i= Integer.parseInt(input);
			if (i < 0)
				return "Invalid number";

		} catch (NumberFormatException x) {
			return "Not a number";
		}

		return null;
	}
}