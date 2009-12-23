/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
package org.eclipse.papyrus.diagram.composite.custom.ui;

import org.eclipse.jface.dialogs.IInputValidator;

/**
 * Used to validate a nameLabel
 * 
 */
public class NameLabelValidator implements IInputValidator {

	private String error;

	public NameLabelValidator(String errorMessage) {
		// TODO Auto-generated constructor stub
		super();
		error = errorMessage;
	}

	public String isValid(String newText) {
		if((newText != null) && (!"".equals(newText))) {
			return null;// OK
		} else {
			return error;
		}

	}
}
