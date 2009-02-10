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

import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.RetargetAction;

/**
 * @deprecated Not use anymore
 * @author dumoulin
 *
 */
public class DeleteDiagramRetargetAction extends RetargetAction {

	/**
	 * Constructs a new DeleteRetargetAction with the default ID, label and image.
	 */
	public DeleteDiagramRetargetAction() {
		super(DeleteDiagramAction.DELETE_DIAGRAM_ID, DeleteDiagramAction.ACTION_Label);
		setToolTipText(DeleteDiagramAction.ACTION_Tooltip);
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
	}

}
