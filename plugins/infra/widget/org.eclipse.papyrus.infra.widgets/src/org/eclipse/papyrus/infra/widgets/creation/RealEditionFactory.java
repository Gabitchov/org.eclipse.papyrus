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
package org.eclipse.papyrus.infra.widgets.creation;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.papyrus.infra.widgets.validator.RealInputValidator;

/**
 * The factory for real
 * 
 * @author Vincent Lorenzo
 * 
 */
public class RealEditionFactory extends StringEditionFactory {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public RealEditionFactory() {
		this(new RealInputValidator());
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param title
	 *        The title of the dialog opened by this factory when editing a real
	 * @param label
	 *        The Label used to describe the kind of value being edited
	 */
	public RealEditionFactory(String title, String label) {
		this(title, label, new RealInputValidator());
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param validator
	 *        The InputValidator used to check the entered Real
	 */
	public RealEditionFactory(IInputValidator validator) {
		super(validator);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param title
	 *        The title of the dialog opened by this factory when editing a Real
	 * @param label
	 *        The Label used to describe the kind of value being edited
	 * @param validator
	 *        The validator used to check the Reals being edited
	 */
	public RealEditionFactory(String title, String label, IInputValidator validator) {
		super(title, label, validator);
	}



}
