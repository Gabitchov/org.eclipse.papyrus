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


/**
 * InputValidator for boolean
 * 
 * @author Vincent Lorenzo
 * 
 */
public class BooleanInputValidator extends InputValidatorWrapper {

	public BooleanInputValidator() {
		super(new BooleanValidator());
	}

}
