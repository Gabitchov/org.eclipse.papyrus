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
package org.eclipse.papyrus.infra.gmfdiag.menu.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.papyrus.infra.tools.util.WorkbenchPartHelper;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Abstract class for the actions done on a diagram editor
 * 
 */
public abstract class AbstractDiagramHandler extends AbstractHandler {

	/**
	 * 
	 * @return
	 *         the current diagram workbench part
	 */
	protected final IDiagramWorkbenchPart getDiagramWorkbenchPart() {
		final IWorkbenchPart workbench = WorkbenchPartHelper.getCurrentActiveWorkbenchPart();
		if(workbench != null) {
			return (IDiagramWorkbenchPart)workbench.getAdapter(IDiagramWorkbenchPart.class);
		}
		return null;
	}
}
