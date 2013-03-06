/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.validation.internal.actions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.statushandlers.IStatusAdapterConstants;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * This is the DeleteMarkerAction type. Enjoy.
 */
public class DeleteMarkerAction
		extends AbstractMarkerAction {

	public DeleteMarkerAction(IWorkbenchSite site) {
		super(site, "Delete");

		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
			.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		setDisabledImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
			.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
		setActionDefinitionId(ActionFactory.DELETE.getCommandId());
	}

	@Override
	public void run() {
		for (IPapyrusMarker next : getMarkers()) {
			try {
				next.delete();
			} catch (CoreException e) {
				StatusAdapter adapter = new StatusAdapter(e.getStatus());
				adapter.setProperty(IStatusAdapterConstants.TITLE_PROPERTY,
					"Delete Validation Problem");
				StatusManager.getManager().handle(adapter, StatusManager.SHOW);
			}
		}
	}
}
