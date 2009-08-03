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

import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.ParameterDirectionKind;

public class DirectionCellEditor extends ComboBoxCellEditor {

	private static String[] oursDirectionValues;

	public DirectionCellEditor(Composite parent) {
		super(parent, getValues());
	}

	private static String[] getValues() {
		if (oursDirectionValues == null) {
			ArrayList<String> values = new ArrayList<String>(ParameterDirectionKind.VALUES.size());
			for (ParameterDirectionKind kind : ParameterDirectionKind.VALUES) {
				values.add(kind.getName());
			}
			oursDirectionValues = values.toArray(new String[values.size()]);
		}
		return oursDirectionValues;
	}

	@Override
	protected void doSetValue(Object value) {
		super.doSetValue(ParameterDirectionKind.VALUES.indexOf(value));
	}

	@Override
	protected Object doGetValue() {
		return ParameterDirectionKind.VALUES.get((Integer) super.doGetValue());
	}
}