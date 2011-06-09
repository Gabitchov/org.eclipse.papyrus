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

public class AddVisibleCommandForChildrenAction implements IObjectActionDelegate {

	protected GenHandlers handlers = null;

	public AddVisibleCommandForChildrenAction() {
	}

	public void run(IAction action) {

		DomainContext domain = (DomainContext)handlers.eContainer();
		ElementTypes types = domain.getElementTypes();

		Iterator<ElementType> it = types.getTypes().iterator();
		while(it.hasNext()) {
			ElementType elementType = it.next();

			if(elementType instanceof MetaClassType) {
				MetaClassType mClassType = (MetaClassType)elementType;

				if(!mClassType.getMetaClass().isAbstract()) {
					handlers.getVisibleCreateChildHandlers().add(elementType);
				}
			}
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			if(((IStructuredSelection)selection).getFirstElement() instanceof GenHandlers) {
				handlers = (GenHandlers)((IStructuredSelection)selection).getFirstElement();
			}
		}

	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {

	}

}
