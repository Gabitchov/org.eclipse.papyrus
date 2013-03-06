package org.eclipse.papyrus.uml.tools.utils.validator;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.papyrus.uml.tools.utils.messages.Messages;


public class IntegerInputValidator implements IInputValidator {




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
				new Integer(newText);
			}
		} catch (NumberFormatException e) {
			return Messages.IntegerInputValidator_NotAnIntegerMessage;
		}
		return null;
	}


}
