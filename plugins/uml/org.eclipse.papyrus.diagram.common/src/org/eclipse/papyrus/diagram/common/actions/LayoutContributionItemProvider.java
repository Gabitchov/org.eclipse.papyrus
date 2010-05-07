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

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContributionItemProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPage;

/**
 * This class is used to replace some GMF actions by ours.
 * The following actions are concerned :
 * <ul>
 * <li>align left for EditParts</li>
 * <li>align center for EditParts</li>
 * <li>align right for EditParts</li>
 * <li>align bottom for EditParts</li>
 * <li>align middle for EditParts</li>
 * <li>align top for EditParts</li>
 * </ul>
 * 
 * Moreover we have removed the initial actions in the plugin.xml and we have replaced them by ours.
 * 
 * @author VL222926
 * 
 */
public class LayoutContributionItemProvider extends DiagramContributionItemProvider {


	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContributionItemProvider#createAction(java.lang.String,
	 *      org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor)
	 * 
	 * @param actionId
	 *        the action identifier
	 * @param partDescriptor
	 *        the workbench part descriptor
	 * @return
	 */
	@Override
	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		IWorkbenchPage workbenchPage = partDescriptor.getPartPage();

		if(GEFActionConstants.ALIGN_LEFT.equals(actionId)) {
			return new CustomAlignAction(workbenchPage, actionId, PositionConstants.LEFT, true);
		} else if(GEFActionConstants.ALIGN_CENTER.equals(actionId)) {
			return new CustomAlignAction(workbenchPage, actionId, PositionConstants.CENTER, true);
		} else if(GEFActionConstants.ALIGN_RIGHT.equals(actionId)) {
			return new CustomAlignAction(workbenchPage, actionId, PositionConstants.RIGHT, true);
		} else if(GEFActionConstants.ALIGN_TOP.equals(actionId)) {
			return new CustomAlignAction(workbenchPage, actionId, PositionConstants.TOP, true);
		} else if(GEFActionConstants.ALIGN_MIDDLE.equals(actionId)) {
			return new CustomAlignAction(workbenchPage, actionId, PositionConstants.MIDDLE, true);
		} else if(GEFActionConstants.ALIGN_BOTTOM.equals(actionId)) {
			return new CustomAlignAction(workbenchPage, actionId, PositionConstants.BOTTOM, true);
		}
		return super.createAction(actionId, partDescriptor);
	}

}
