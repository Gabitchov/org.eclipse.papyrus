/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.edit.utils;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;

/**
 * Utility methods for GMF commands.
 */
public class GMFCommandUtils {

	/**
	 * <pre>
	 * This method return the EObject returned by a command (the first item if the result is a 
	 * Collection), or null if the result contains no value or if the value is not an EObject
	 * @param command the command.
	 * @return the EObject result or null.
	 * </pre>
	 */
	public static EObject getCommandEObjectResult(ICommand command) {

		Object returnValue = command.getCommandResult().getReturnValue();

		if(returnValue instanceof EObject) {
			return (EObject)returnValue;
		}

		if(returnValue instanceof ArrayList<?>) {
			ArrayList<?> returnValues = (ArrayList<?>)returnValue;
			if(!returnValues.isEmpty() && (returnValues.get(0) instanceof EObject)) {
				return (EObject)returnValues.get(0);
			}
		}
		return null;
	}

}
