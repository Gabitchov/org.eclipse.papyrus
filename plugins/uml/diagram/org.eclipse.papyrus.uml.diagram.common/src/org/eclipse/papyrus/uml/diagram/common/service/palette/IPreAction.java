/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *  Philippe ROLAND (Atos) philippe.roland@atos.net - Defined additional methods for Nodes and Connections
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Interface implemented by pre execution actions
 */
public interface IPreAction extends IAspectAction {

	/**
	 * Get the precommand for a node element.
	 * 
	 * @param containerView
	 *        the View corresponding to the parent of the element that is about to created
	 * @return
	 */
	public ICommand getNodePreCommand(View containerView);

	/**
	 * Get the precommand for a connection element.
	 * 
	 * @param sourceView
	 *        the View corresponding to the connection's source
	 * @param targetView
	 *        the View corresponding to the connection's target
	 * @return
	 */
	public ICommand getConnectionPreCommand(View sourceView, View targetView);

}
