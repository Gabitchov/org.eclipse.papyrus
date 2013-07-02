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


/**
 * Validator for the UnlimitedNaturalEditor. It accepts "-1", "*" and all integer >=0
 */
public class UnlimitedNaturalInputValidator extends InputValidatorWrapper {

	public UnlimitedNaturalInputValidator() {
		super(new UnlimitedNaturalValidator());
	}

}
