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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.sasheditor.extension.ActionBarButtonDescriptor;
import org.eclipse.ui.actions.RetargetAction;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Create a retarget action with specified parameters.
 * 
 * @deprecated Not use anymore
 */
public class CreateDiagramRetargetAction extends RetargetAction {

	/**
	 * Creates a new CreateDiagramRetargetAction
	 * 
	 * @param actionID
	 *            ID of this retarget action
	 * @param label
	 *            label of the button
	 * @param tooltip
	 *            tooltip of the button
	 * @param PLUGIN_ID
	 *            ID of the plugin that defines the action
	 * @param image
	 *            image associated to the button
	 * @param disabledImage
	 *            disabled image for the button
	 */
	public CreateDiagramRetargetAction(String actionID, String label, String tooltip, String PLUGIN_ID, String image, String disabledImage) {
		super(actionID, label);
		setToolTipText(tooltip);
		ImageDescriptor imageDescriptor;
		if (image != null) {
			imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, image);
			setImageDescriptor(imageDescriptor);
		}
		if (disabledImage != null) {
			imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, disabledImage);
			setDisabledImageDescriptor(imageDescriptor);
		}
	}

	/**
	 * Creates a new CreateDiagramRetargetAction
	 * 
	 * @param buttonDescriptor
	 *            descriptor of the button
	 */
	public CreateDiagramRetargetAction(ActionBarButtonDescriptor buttonDescriptor) {
		super(buttonDescriptor.getActionID(), buttonDescriptor.getCreateDiagramLabel());
		setToolTipText(buttonDescriptor.getCreateDiagramTooltip());

		String image = buttonDescriptor.getCreateDiagramImage();
		ImageDescriptor imageDescriptor;
		if (image != null) {
			imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(buttonDescriptor.getPluginID(), image);
			setImageDescriptor(imageDescriptor);
		}
		image = buttonDescriptor.getCreateDiagramDisableImage();
		if (image != null) {
			imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(buttonDescriptor.getPluginID(), image);
			setDisabledImageDescriptor(imageDescriptor);
		}
	}

}
