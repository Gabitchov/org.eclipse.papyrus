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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.extension.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.core.extension.commands.ICreationCondition;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.Perspective;
import org.eclipse.ui.internal.WorkbenchPage;

public class PerspectiveContextDependence implements ICreationCondition {

	protected String commandID=null;
	public PerspectiveContextDependence() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean create(EObject selectedElement) {
		// Get the perspective
		Perspective perspective = ((WorkbenchPage)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()).getActivePerspective();
		//look for the perspective
		//verify if the commannd has to be displayed
		if(perspective.getHiddenMenuItems().contains(commandID)&& perspective.getHiddenToolbarItems().contains(commandID)){
			return false;
		}
		return true;
	}
	/**
	 * {@inheritDoc}
	 */
	public void setCommand(String commandID) {
		this.commandID=commandID;
	}

}
