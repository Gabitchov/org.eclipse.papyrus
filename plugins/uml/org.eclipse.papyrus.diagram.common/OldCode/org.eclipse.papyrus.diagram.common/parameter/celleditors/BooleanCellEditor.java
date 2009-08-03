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

import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.swt.widgets.Composite;

public class BooleanCellEditor extends ComboBoxCellEditor {

	public BooleanCellEditor(Composite parent) {
		super(parent, new String[] { Boolean.TRUE.toString(), Boolean.FALSE.toString() });
	}

	@Override
	protected void doSetValue(Object value) {
		if (Boolean.TRUE.equals(value)) {
			super.doSetValue(0);
		} else {
			super.doSetValue(1);
		}
	}

	@Override
	protected Object doGetValue() {
		Object value = super.doGetValue();
		if (Integer.valueOf(0).equals(value)) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}