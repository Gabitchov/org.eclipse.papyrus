/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Barthelemy HABA (Atos Origin) barthelemy.haba@atosorigin.com - 
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.menu.selection;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.PlatformUI;

/**
 * This class tests if the command can be appear in the menu
 */
public class SelectByTypePropertyTester extends PropertyTester {

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

		if((selection != null) && (SelectByTypeHandler.verifySameTypeOfSelectedElements(selection))) {
			return true;
		}

		if(((StructuredSelection)selection).getFirstElement() instanceof DiagramEditPart) {
			return false;
		}
		return false;
	}

}
