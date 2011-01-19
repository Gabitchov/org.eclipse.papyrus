/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.widgets.editors;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.conversion.NumberToStringConverter;
import org.eclipse.core.databinding.conversion.StringToNumberConverter;
import org.eclipse.swt.widgets.Composite;

/**
 * An editor representing a float value as a text box
 * 
 * @author Camille Letavernier
 */
public class FloatEditor extends StringEditor {

	private IConverter targetToModelConverter;

	/**
	 * {@inheritDoc}
	 */
	public FloatEditor(Composite parent, int style) {
		super(parent, style);

		targetToModelConverter = StringToNumberConverter.toFloat(true);
		setConverters(targetToModelConverter, NumberToStringConverter.fromFloat(true));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getEditableType() {
		return Float.class;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Float getValue() {
		try {
			return (Float)targetToModelConverter.convert(super.getValue());
		} catch (Exception ex) {
			Activator.log.error(ex);
			return null;
		}
	}
}
