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
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import org.w3c.dom.Node;

/**
 * Factory in charge of changing the display of stereotypes after palette
 * actions
 */
public class ChangeStereotypeDisplayAspectActionProvider extends AbstractAspectActionProvider {

	/** semantic action key */
	public final static String ACTION_KEY = "org.eclipse.papyrus.postaction.changeStereotypeDisplayaction";

	/**
	 * Constructor.
	 */
	public ChangeStereotypeDisplayAspectActionProvider() {
	}

	/**
	 * @{inheritDoc
	 */
	public IAspectAction createAction(Node configurationNode) {
		ChangeStereotypeDisplayPostAction action = new ChangeStereotypeDisplayPostAction();
		action.init(configurationNode, this);
		return action;
	}

	/**
	 * @{inheritDoc
	 */
	public boolean isEnable(IPaletteEntryProxy entryProxy) {
		return true;
	}

}
