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
import org.eclipse.papyrus.infra.widgets.validator.UnlimitedNaturalInputValidator;
import org.eclipse.papyrus.infra.widgets.validator.UnlimitedNaturalValidator;
import org.eclipse.swt.widgets.Control;

/**
 * 
 * The factory for UnlimitedNatural
 * 
 */
public class UnlimitedNaturalEditionFactory extends StringEditionFactory {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public UnlimitedNaturalEditionFactory() {
		this(new UnlimitedNaturalInputValidator());
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param title
	 *        The title of the dialog opened by this factory when editing an UnlimitedNatural
	 * @param label
	 *        The Label used to describe the kind of value being edited
	 */
	public UnlimitedNaturalEditionFactory(String title, String label) {
		super(title, label, new UnlimitedNaturalInputValidator());
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param validator
	 *        The InputValidator used to check the entered UnlimitedNatural
	 */
	public UnlimitedNaturalEditionFactory(IInputValidator validator) {
		super(validator);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param title
	 *        The title of the dialog opened by this factory when editing a UnlimitedNatural
	 * @param label
	 *        The Label used to describe the kind of value being edited
	 * @param validator
	 *        The validator used to check the UnlimitedNaturals being edited
	 */
	public UnlimitedNaturalEditionFactory(String title, String label, IInputValidator validator) {
		super(title, label, validator);
	}

	@Override
	public Object createObject(Control widget, Object context) {
		String txt = super.createObject(widget, context).toString();
		if(UnlimitedNaturalValidator.INFINITE_STAR.equals(txt)) {
			txt = UnlimitedNaturalValidator.INFINITE_MINUS_ONE;
		}
		if(txt != null) {
			return Integer.parseInt(txt);
		}
		return null;
	}

}
