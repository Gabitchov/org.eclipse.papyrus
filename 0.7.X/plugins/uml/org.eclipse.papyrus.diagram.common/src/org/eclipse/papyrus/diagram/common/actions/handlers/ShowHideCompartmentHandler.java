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
package org.eclipse.papyrus.diagram.common.actions.handlers;

import org.eclipse.papyrus.diagram.common.actions.ShowHideCompartmentAction;
import org.eclipse.papyrus.diagram.common.editpolicies.ShowHideCompartmentEditPolicy;

/**
 * 
 * Handler for the {@link ShowHideCompartmentAction}
 * 
 */
public class ShowHideCompartmentHandler extends AbstractShowHideHandler {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ShowHideCompartmentHandler() {
		super(new ShowHideCompartmentAction(), ShowHideCompartmentEditPolicy.SHOW_HIDE_COMPARTMENT_POLICY);
	}

}
