/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.gmfdiag.common.utils;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.tools.util.WorkbenchPartHelper;
import org.eclipse.papyrus.infra.tools.util.EditorHelper;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;


public class DiagramPropertyTester extends PropertyTester {

	/** property to test if the selected element are open in the editor */
	public static final String IS_DIAGRAM_EDITOR = "isDiagramEditor"; //$NON-NLS-1$

	/**
	 * 
	 * {@inheritDoc}
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(IS_DIAGRAM_EDITOR.equals(property) && receiver instanceof IStructuredSelection) {
			//FIXME : we should be able to replace the calls to this test in the plugin.xml by : 
			// activeWhen -> with -> activeEditor -> adapt -> IDiagramWorkbenchPart.  unfortunately, this method doesn't work, the adapt test is correct, but the Eclipse handler system
			//find often several handlers actived in the same time and choose one of them (and never the Papyrus handler...)
			boolean answer = isDiagramEditor((IStructuredSelection)receiver);
			return new Boolean(answer).equals(expectedValue);
		}
		return false;
	}

	/**
	 * 
	 * @param selection
	 * @return
	 *         <code>true</code> if the current active part is a Papyrus Diagram
	 */
	private boolean isDiagramEditor(IStructuredSelection selection) {
		final IWorkbenchPart part = WorkbenchPartHelper.getCurrentActiveWorkbenchPart();
		if(part != null) {
			final IDiagramWorkbenchPart diagramPart = (IDiagramWorkbenchPart)part.getAdapter(IDiagramWorkbenchPart.class);
			return diagramPart != null;
		}
		return false;
	}
}
