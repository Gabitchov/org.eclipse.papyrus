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
import org.eclipse.papyrus.team.collaborative.ExtendedURI;
import org.eclipse.papyrus.team.collaborative.ICollaborativeManager;
import org.eclipse.papyrus.team.collaborative.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.MatchingURIObject;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.ICollabColors;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.dialogs.PreviewDialog;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.providers.ExtensivePartitionNameLabelProvider;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.utils.UIUtils;
import org.eclipse.papyrus.team.collaborative.participants.version.IReverter;
import org.eclipse.papyrus.team.collaborative.reports.CollabStatus;
import org.eclipse.swt.widgets.Display;


// TODO: Auto-generated Javadoc
/**
 * Handler use for Revert action
 * The revert action will be performe on all the current model.
 * 
 * @author adaussy
 */
public class RevertHandler extends AbstractCollabHandler {


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		//Check that everything is commit
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
		IStatus status = doRevert(uris, resourceSet);
		if(!status.isOK() && status.getCode() == Status.ERROR) {
			UIUtils.errorDialog(status, "Error");
		}

		return null;

	}

	/**
	 * Do revert action
	 * 
	 * @param uris
	 *        the uris about to be reverted
	 * @param resourceSet
	 *        the resource set
	 * @return the {@link IStatus} of the operation
	 * @throws CollabException
	 *         the collab exception
	 */
	public static IStatus doRevert(Set<IExtendedURI> uris, ResourceSet resourceSet) {

		IReverter reverter = ICollaborativeManager.INSTANCE.getReverter(uris, resourceSet);
		if(reverter == null) {
			CollabStatus errorStatus = CollabStatus.createErrorStatus("Unable to find a reverter");
			return errorStatus;
		}

		Set<IExtendedURI> toBeCommitted = reverter.getExtendedSet();
		IStatus status = doRevertFromBuilder(resourceSet, reverter, toBeCommitted);
		return status;

	}

	/**
	 * Do revert using an existing {@link IReverter}s
	 * 
	 * @param resourceSet
	 *        the resource set
	 * @param reverter
	 *        the reverter
	 * @param toBeReverted
	 *        the {@link IExtendedURI} about to be reverted
	 * @return the {@link IStatus} of the operation
	 * @throws CollabException
	 *         the collab exception
	 */
	public static IStatus doRevertFromBuilder(ResourceSet resourceSet, IReverter reverter, Set<IExtendedURI> toBeReverted) {
		ExtensivePartitionNameLabelProvider labelProvider = new ExtensivePartitionNameLabelProvider(new MatchingURIObject(toBeReverted),UIUtils.getModelExplorerLavelProvider());
		labelProvider.setColor(ICollabColors.REVERT_COLLOR);
		PreviewDialog revertDialog = new PreviewDialog(Display.getDefault().getActiveShell(), labelProvider, "Revert Dialog", "Element in yellow will be reverted");
		Collection<EObject> objectsToReveal = UIUtils.getLeafSemanticElement(toBeReverted, resourceSet);
		if(objectsToReveal != null && !objectsToReveal.isEmpty()) {
			revertDialog.setObjectsToReveal(objectsToReveal);
		}
		if(revertDialog.open() == PreviewDialog.OK) {

			//Keep lock force to true. This shall be improve later
			IStatus commitStatus = reverter.revert();
			UIUtils.refreshModelExplorer(toBeReverted, resourceSet);
			UIUtils.reloadEditor();
			return commitStatus;
		} else {
			return Status.CANCEL_STATUS;
		}
	}


}
