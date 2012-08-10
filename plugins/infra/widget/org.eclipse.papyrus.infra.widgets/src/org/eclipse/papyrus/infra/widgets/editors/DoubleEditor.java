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
package org.eclipse.papyrus.infra.widgets.editors;

import java.util.Locale;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.conversion.NumberToStringConverter;
import org.eclipse.core.databinding.conversion.StringToNumberConverter;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.swt.widgets.Composite;

import com.ibm.icu.text.NumberFormat;

/**
 * An editor representing a float value as a text box
 * 
 * @author Camille Letavernier
 */
public class DoubleEditor extends StringEditor {

	private IConverter targetToModelConverter;

	/**
	 * 
	 * Constructs an Editor for a Double value. The widget is a Text field.
	 * 
	 * @param parent
	 *        The Composite in which the editor is created
	 * @param style
	 *        The Text's style
	 */
	public DoubleEditor(Composite parent, int style) {
		super(parent, style);

		targetToModelConverter = StringToNumberConverter.toDouble(NumberFormat.getInstance(Locale.ENGLISH), true);
		setConverters(targetToModelConverter, NumberToStringConverter.fromDouble(NumberFormat.getInstance(Locale.ENGLISH), true));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getEditableType() {
		return Double.class;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double getValue() {
		try {
			return (Double)targetToModelConverter.convert(super.getValue());
		} catch (Exception ex) {
			Activator.log.error(ex);
			return null;
		}
	}
}
