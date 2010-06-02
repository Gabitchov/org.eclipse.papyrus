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
package org.eclipse.papyrus.diagram.common.actions;

import org.eclipse.gmf.runtime.common.ui.action.ActionMenuManager;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.layout.DistributionConstants;

/**
 * the menu manager for the distribution actions
 */
public class DistributeMenuManager extends ActionMenuManager {

	/**
	 * 
	 * An action for this menu
	 * 
	 */
	private static class DistributeMenuAction extends Action {

		public DistributeMenuAction() {
			setText(DistributionConstants.DistributeActionMenu_DistributeMenu);
			setToolTipText(DistributionConstants.DistributeActionMenu_DistributeMenu);
			ImageDescriptor imageDesc = Activator.getImageDescriptor(DistributionConstants.ICON_D_HORIZONTALLY);
			setImageDescriptor(imageDesc);
			setHoverImageDescriptor(imageDesc);
		}
	}

	/**
	 * Creates a new instance of the distribute menu manager
	 */
	public DistributeMenuManager() {
		super(DistributionConstants.MENU_DISTRIBUTE, new DistributeMenuAction(), true);
	}


}
