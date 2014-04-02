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

import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;

/**
 * This Copy handler retarget the Copy action to the GMF action, but now this action is declared using the Eclipse Framework
 * 
 */
public class GraphicalCopyInDiagramHandler extends AbstractDiagramActionHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.menu.handlers.AbstractDiagramActionHandler#getActionId()
	 * 
	 * @return
	 */
	@Override
	protected String getActionId() {
		return GlobalActionId.COPY;
	}

}
