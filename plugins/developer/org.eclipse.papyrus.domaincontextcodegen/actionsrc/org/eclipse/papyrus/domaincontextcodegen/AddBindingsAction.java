/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.domaincontextcodegen;

import java.util.Iterator;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class AddBindingsAction implements IObjectActionDelegate {

	protected ElementTypes eltTypes = null;

	public AddBindingsAction() {
	}

	public void run(IAction action) {

		DomainContext domain = eltTypes.getDomain();
		ElementTypeBindings bindings = domain.getBindings().get(0);

		Iterator<ElementType> it = eltTypes.getTypes().iterator();
		while(it.hasNext()) {
			ElementType elementType = it.next();

			ElementTypeBinding etb = DomaincontextcodegenFactory.eINSTANCE.createElementTypeBinding();
			etb.setRef(elementType);

			bindings.getBindings().add(etb);
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			if(((IStructuredSelection)selection).getFirstElement() instanceof ElementTypes) {
				eltTypes = (ElementTypes)((IStructuredSelection)selection).getFirstElement();
			}
		}

	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {

	}

}
