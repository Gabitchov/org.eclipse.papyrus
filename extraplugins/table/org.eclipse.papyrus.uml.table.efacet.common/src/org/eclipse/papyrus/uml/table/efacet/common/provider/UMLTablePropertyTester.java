/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.table.efacet.common.provider;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.uml.table.efacet.common.editor.AbstractUMLTableEFacetEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;


public class UMLTablePropertyTester extends PropertyTester {

	private static final String IS_UML_TABLE = "isUMLTable"; //$NON-NLS-1$

	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		final IWorkbenchPart activePart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		if(IS_UML_TABLE.equals(property) && activePart instanceof IMultiDiagramEditor) {
			final IEditorPart editor = ((IMultiDiagramEditor)activePart).getActiveEditor();
			return expectedValue.equals(new Boolean(editor instanceof AbstractUMLTableEFacetEditor));
		}
		return false;
	}

}
