/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.menu.tester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;


public class TableEditorPropertyTester extends PropertyTester {

	public static final String IS_TABLE = "isTable"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		if(receiver instanceof IMultiDiagramEditor && IS_TABLE.equals(property) && expectedValue instanceof Boolean) {
			INattableModelManager manager = (INattableModelManager)((IMultiDiagramEditor)receiver).getActiveEditor().getAdapter(INattableModelManager.class);
			return (expectedValue.equals(manager != null));
		}
		return false;
	}

}
