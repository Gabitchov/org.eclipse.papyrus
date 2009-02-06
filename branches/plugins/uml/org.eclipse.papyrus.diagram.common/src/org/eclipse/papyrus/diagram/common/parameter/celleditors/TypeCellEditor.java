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

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.papyrus.diagram.common.parameter.EditPropertyParametersDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Type;

public class TypeCellEditor extends ComboBoxCellEditor {

	private ArrayList<Type> myTypeValues;

	public TypeCellEditor(Composite parent, Type[] values) {
		super(parent, getValues(values));
		myTypeValues = new ArrayList<Type>(values.length);
		myTypeValues.addAll(Arrays.asList(values));
	}

	private static String[] getValues(Type[] values) {
		String[] stringValues = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			String name = values[i].getName();
			stringValues[i] = name != null ? name : "";
		}
		return stringValues;
	}

	@Override
	protected void doSetValue(Object value) {
		if (value == null) {
			value = EditPropertyParametersDialog.NULL_TYPE;
		}
		super.doSetValue(myTypeValues.indexOf(value));
	}

	@Override
	protected Object doGetValue() {
		return myTypeValues.get((Integer) super.doGetValue());
	}

}
