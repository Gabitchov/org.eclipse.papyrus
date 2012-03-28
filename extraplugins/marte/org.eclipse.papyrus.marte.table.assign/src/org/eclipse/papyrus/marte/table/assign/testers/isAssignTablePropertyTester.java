/*****************************************************************************
 * Copyright (c) 2012 ATOS
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Olivier Mélois (ATOS) olivier.melois@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.marte.table.assign.testers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.marte.table.assign.Activator;
import org.eclipse.papyrus.marte.table.assign.editor.AssignTableEditor;
import org.eclipse.ui.IEditorPart;


public class isAssignTablePropertyTester extends PropertyTester {

	/**
	 * Just tests whether the active editor is an assign table.
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (property.equals("isAssignTable")){
			IEditorPart activeEditor = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			if(activeEditor instanceof PapyrusMultiDiagramEditor) {
				PapyrusMultiDiagramEditor multiDiagramEditor = (PapyrusMultiDiagramEditor)activeEditor;
				IEditorPart activeSubEditor = multiDiagramEditor.getActiveEditor();
				return activeSubEditor instanceof AssignTableEditor;
				
			}
		}
		return false;
	}
}
