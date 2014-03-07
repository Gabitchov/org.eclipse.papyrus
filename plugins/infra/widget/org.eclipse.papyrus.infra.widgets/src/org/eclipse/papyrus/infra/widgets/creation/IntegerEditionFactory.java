/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 402525
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.creation;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.papyrus.infra.widgets.validator.IntegerInputValidator;
import org.eclipse.swt.widgets.Control;


public class IntegerEditionFactory extends StringEditionFactory {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public IntegerEditionFactory() {
		this(new IntegerInputValidator());
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param validator
	 *        The InputValidator used to check the entered Integer
	 */
	public IntegerEditionFactory(IInputValidator validator) {
		super(validator);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param title
	 *        The title of the dialog opened by this factory when editing an Integer
	 * @param label
	 *        The Label used to describe the kind of value being edited
	 * @param validator
	 *        The validator used to check the Integers being edited
	 */

	public IntegerEditionFactory(String title, String label, IInputValidator validator) {
		super(title, label, validator);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param title
	 *        The title of the dialog opened by this factory when editing a Integer
	 * @param label
	 *        The Label used to describe the kind of value being edited
	 */
	public IntegerEditionFactory(String title, String label) {
		this(title, label, new IntegerInputValidator());
	}

	@Override
	public Object createObject(Control widget, Object context) {
		String txt = super.createObject(widget, context).toString();
		if(txt != null) {
			return Integer.parseInt(txt);
		}
		return null;
	}
}