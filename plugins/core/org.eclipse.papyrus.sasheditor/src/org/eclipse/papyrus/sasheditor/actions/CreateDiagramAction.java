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
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.sasheditor.extension.ActionBarButtonDescriptor;
import org.eclipse.papyrus.sasheditor.extension.ExtensionMultiDiagramEditor;
import org.eclipse.papyrus.sasheditor.extension.ICreateDiagramAction;
import org.eclipse.papyrus.sasheditor.extension.MultiDiagramSharedObjects;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Basic action for diagram creation
 * 
 * @deprecated Not used anymore
 */
public class CreateDiagramAction extends WorkbenchPartAction {

	/** descriptor of the action bar button */
	protected ActionBarButtonDescriptor editorDescriptor;

	/** eINSTANCE of the create diagram action created */
	protected ICreateDiagramAction createDiagramAction;

	/**
	 * Creates a new CreateDiagramAction
	 * 
	 * @param part
	 *            the workench part this action is associated with.
	 * @param buttonDescriptor
	 *            the descriptor of the action bar button
	 */
	public CreateDiagramAction(IWorkbenchPart part, ActionBarButtonDescriptor buttonDescriptor) {
		super(part);
		this.editorDescriptor = buttonDescriptor;
		setText(buttonDescriptor.getCreateDiagramLabel());
		setId(buttonDescriptor.getActionID());
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

	/**
	 * Get the class owning the shared objects.
	 * 
	 * @return the class owning the shared objects
	 */
	protected MultiDiagramSharedObjects getSharedObjects() {
		return getMultiDiagramEditor().getSharedObjects();
	}

	/**
	 * Get the MultiDiagramEditor eINSTANCE.
	 * 
	 * @return the MultiDiagramEditor eINSTANCE
	 */
	protected ExtensionMultiDiagramEditor getMultiDiagramEditor() {
		return (ExtensionMultiDiagramEditor) getWorkbenchPart();
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
		if (createDiagramAction == null) {
			createDiagramAction = editorDescriptor.getCreateDiagramAction();
		}
		createDiagramAction.run(getSharedObjects());
	}

}
