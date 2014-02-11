/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.actions;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.team.collaborative.ExtendedURI;
import org.eclipse.papyrus.team.collaborative.ICollaborativeManager;
import org.eclipse.papyrus.team.collaborative.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.MatchingURIObject;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.ICollabColors;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.dialogs.PreviewDialog;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.providers.ExtensivePartitionNameLabelProvider;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.utils.UIUtils;
import org.eclipse.papyrus.team.collaborative.participants.version.IUpdater;
import org.eclipse.papyrus.team.collaborative.reports.CollabStatus;
import org.eclipse.swt.widgets.Display;


/**
 * Handler for Update action in Papyrus
 * The update will be performed in all the current model
 */
public class UpdateHandler extends AbstractCollabHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if(!UIUtils.saveAllDirtyEditor().isOK()) {
			return null;
		}
		ResourceSet resourceSet = getResourceSet();
		if(resourceSet == null) {
			UIUtils.errorDialog(CollabStatus.createErrorStatus("unable to retreive the resource set"), "Collaboratibe error");
			return null;
		}
		Set<IExtendedURI> uris = new HashSet<IExtendedURI>();
		for(Resource r : resourceSet.getResources()) {
			IFile file = WorkspaceSynchronizer.getFile(r);
			if(file != null && file.exists()) {
				uris.add(new ExtendedURI(r.getURI()));
			}
		}
		IStatus status = doUpdate(uris, resourceSet, true);
		if(!status.isOK()) {
			UIUtils.errorDialog(status, "Error");
		}
		return null;

	}

	/**
	 * Do update action
	 * 
	 * @param uris
	 *        the {@link IExtendedURI} to update
	 * @param resourceSet
	 *        the resource set
	 * @throws CollabException
	 *         the collab exception
	 */
	public static IStatus doUpdate(Set<IExtendedURI> uris, ResourceSet resourceSet, boolean preview) {
		IUpdater updater = ICollaborativeManager.INSTANCE.getUpdater(uris, resourceSet);
		if(updater == null) {
			return CollabStatus.createErrorStatus("Unable to find an Updater for: \n" + uris);
		}
		return doUpdateFromUpdater(resourceSet, updater, preview);

	}

	public static IStatus doUpdateFromUpdater(ResourceSet resourceSet, IUpdater updater, boolean preview) {
		Set<IExtendedURI> toUpdate = updater.getExtendedSet();
		if(!toUpdate.isEmpty()) {
			if(preview) {
				ExtensivePartitionNameLabelProvider labelProvider = new ExtensivePartitionNameLabelProvider(new MatchingURIObject(toUpdate),UIUtils.getModelExplorerLavelProvider());
				labelProvider.setColor(ICollabColors.UPDATE_COLLOR);
				PreviewDialog previewDialog = new PreviewDialog(Display.getDefault().getActiveShell(), labelProvider, "Update Preview", "Element in light green will be updated");
				Collection<EObject> objectsToReveal = UIUtils.getLeafSemanticElement(toUpdate, resourceSet);
				if(objectsToReveal != null && !objectsToReveal.isEmpty()) {
					previewDialog.setObjectsToReveal(objectsToReveal);
				}
				if(previewDialog.open() != PreviewDialog.OK) {
					return CollabStatus.createErrorStatus("Canceled by user");
				}
			}
			IStatus updateStatus = updater.update();
			UIUtils.reloadEditor();
			return updateStatus;
		} else {
			MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Nothing to do", "Nothing to update");
			return Status.OK_STATUS;
		}
	}




}
