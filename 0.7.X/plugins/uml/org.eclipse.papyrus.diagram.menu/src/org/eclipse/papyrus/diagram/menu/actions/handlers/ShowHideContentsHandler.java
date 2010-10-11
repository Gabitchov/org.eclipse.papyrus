/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.diagram.menu.actions.handlers;

import org.eclipse.papyrus.diagram.common.actions.ShowHideContentsAction;
import org.eclipse.papyrus.diagram.common.actions.handlers.AbstractShowHideHandler;
import org.eclipse.papyrus.diagram.common.editpolicies.ShowHideClassifierContentsEditPolicy;

/**
 * 
 * Handler for the {@link ShowHideContentsAction}
 * 
 */
public class ShowHideContentsHandler extends AbstractShowHideHandler {


	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ShowHideContentsHandler() {
		super(new ShowHideContentsAction(), ShowHideClassifierContentsEditPolicy.SHOW_HIDE_CLASSIFIER_CONTENTS_POLICY);
	}

}
