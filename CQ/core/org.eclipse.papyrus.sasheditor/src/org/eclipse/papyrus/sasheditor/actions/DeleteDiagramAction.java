/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
  *****************************************************************************/

package org.eclipse.papyrus.sasheditor.actions;

import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * @deprecated Not use anymore
 * @author dumoulin
 * 
 */
public class DeleteDiagramAction extends WorkbenchPartAction {

	public static String DELETE_DIAGRAM_ID = "DeleteDiagram";

	public static String ACTION_Label = "Delete Diagram";

	public static String ACTION_Tooltip = "Delete Selected Diagram";

	/**
	 * Creates a new DeleteDiagramAction
	 * 
	 * @param part
	 *            the part this action is associated with.
	 */
	public DeleteDiagramAction(IWorkbenchPart part) {
		super(part);
		setText(ACTION_Label);
		setId(DELETE_DIAGRAM_ID);
		setToolTipText(ACTION_Tooltip);
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
		setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD_DISABLED));
		setHoverImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}

	/**
	 * {@inheritDoc}
	 */
	protected boolean calculateEnabled() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		throw new UnsupportedOperationException("not yet implmented");
	}
}
