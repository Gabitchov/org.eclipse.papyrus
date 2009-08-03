/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.parameter.celleditors;

import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

public class PositiveIntegerCellEditor extends TextCellEditor {

	public PositiveIntegerCellEditor(Composite parent) {
		super(parent);
		setValidator(getIntegerValidator());
	}

	@Override
	protected void doSetValue(Object value) {
		super.doSetValue(((Integer) value).toString());
	}

	@Override
	protected Object doGetValue() {
		return Integer.parseInt((String) super.doGetValue());
	}

	private ICellEditorValidator getIntegerValidator() {
		return new ICellEditorValidator() {

			public String isValid(Object value) {
				if (value instanceof Integer) {
					Integer intValue = (Integer) value;
					return isValid(intValue);
				}
				try {
					Integer intValue = Integer.parseInt((String) value);
					return isValid(intValue);
				} catch (NumberFormatException nfe) {
					return nfe.getMessage();
				}
			}

			private String isValid(Integer intValue) {
				return intValue >= 0 ? null : "Value must be a positive number";
			}
		};
	}
}